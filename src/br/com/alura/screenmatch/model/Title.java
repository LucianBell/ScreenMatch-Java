package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean includedInThePlan;
    private double sumOfAvaliations;
    private int avaliationsTotal;
    private int minuteLength;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb meuTituloOmdb) {
        this.name = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não conseguiu converter o ano, pois tem mais de 4 caracteres");
        }

        this.releaseYear = Integer.valueOf(meuTituloOmdb.year());
        this.minuteLength = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 3));
    }
    /*Construtores são usados para popular um objeto e trazer para ele informações vitais.*/
    //Muito usados para se defender e para otimizar o uso de memória. É uma discussão de business.

    public int getAvaliationsTotal() {
        return avaliationsTotal;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public boolean isIncludedInThePlan() {
        return includedInThePlan;
    }

    public int getMinuteLength() {
        return minuteLength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setIncludedInThePlan(boolean includedInThePlan) {
        this.includedInThePlan = includedInThePlan;
    }

    public void setMinuteLength(int minuteLength) {
        this.minuteLength = minuteLength;
    }

    public void showData() {
        System.out.println("Title: " + name);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Is included in the plan? " + includedInThePlan);
        System.out.println("Sum of the grades: " + sumOfAvaliations);
        System.out.println("Total grades: " + avaliationsTotal);
        System.out.println("Length: " + minuteLength);
    }

    public void recieveAvaliation(double userAvaliation) {
        sumOfAvaliations += userAvaliation;
        avaliationsTotal++;
    }

    public double giveAvaliationResult() {
        return sumOfAvaliations / avaliationsTotal;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "name ='" + name + '\'' + ", releaseYear = " + releaseYear + "," + " minuteLength = " + minuteLength;
    }
}
