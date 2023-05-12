package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.calculator.Classifiable;

public class Movie extends Title implements Classifiable {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    @Override
    public int getClassification() {
        return (int) giveAvaliationResult() / 2;
    }
}
