package br.com.alura.screenmatch.calculator;

public class RecomendationFilter {
    public void filter(Classifiable classifiable) {
        if (classifiable.getClassification() >= 3) {
            System.out.println("We recommend this title");
        } else {
            System.out.println("Looking for something different?");
        }
    }
}
