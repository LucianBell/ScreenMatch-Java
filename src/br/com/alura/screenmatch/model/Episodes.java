package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.calculator.Classifiable;

public class Episodes implements Classifiable {
    private int number;
    private String name;
    private Series serie;
    private int viewTotal;

    public int getViewTotal() {
        return viewTotal;
    }

    public void setViewTotal(int viewTotal) {
        this.viewTotal = viewTotal;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSerie() {
        return serie;
    }

    public void setSerie(Series serie) {
        this.serie = serie;
    }

    @Override
    public int getClassification() {
        if (viewTotal > 100) {
            return 5;
        } else {
            return 2;
        }
    }
}
