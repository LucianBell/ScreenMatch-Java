package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculator.RecomendationFilter;
import br.com.alura.screenmatch.calculator.TimeCalculator;
import br.com.alura.screenmatch.model.Episodes;
import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Series;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.setMinuteLength(210);
        System.out.println("Movie length (in minutes): " +  myMovie.getMinuteLength());

        myMovie.showData();
        myMovie.recieveAvaliation(9);
        myMovie.recieveAvaliation(8);
        myMovie.recieveAvaliation(10);

        System.out.println("Number of avaliations: " + myMovie.getAvaliationsTotal());
        System.out.println(myMovie.giveAvaliationResult());

        Series mySeries = new Series("Lost", 2000);
        mySeries.setSeasons(10);
        mySeries.setEpisodesPerSeason(10);
        mySeries.setMinutesPerEpisode(50);
        System.out.println("Series length (in minutes): " +  mySeries.getMinuteLength());

        Movie differentMovie = new Movie("Top Gun Maverick", 2022);
        differentMovie.setMinuteLength(180);

        TimeCalculator calculator = new TimeCalculator();
        calculator.includeTitle(myMovie);
        calculator.includeTitle(differentMovie);
        calculator.includeTitle(mySeries);

        System.out.println(calculator.getTotalTime());

        RecomendationFilter filter = new RecomendationFilter();

        filter.filter(myMovie);

        Episodes episode = new Episodes();
        episode.setNumber(1);
        episode.setSerie(mySeries);
        episode.setViewTotal(300);

        filter.filter(episode);

        //Variavel referencia é a da esquerda
        var lucysMovie = new Movie("Man with a guitar", 1970);
        //A variavel var faz uma inferência do tipo declarado (new Movie, no exemplo acima)
        //Só funciona a partir da versão 10 do Java
        //O tipo da variável será inferido automaticamente pelo compilador com base no valor atribuído.

        /* A declaração de variáveis com var possui algumas limitações:
            1. O tipo da variável deve ser inferido automaticamente pelo compilador. Isso significa que não é
            possível utilizar var em variáveis cujo tipo não possa ser inferido automaticamente.
            2. Não é possível usar var em variáveis sem valor inicial. É necessário atribuir um valor à variável
             na mesma linha em que ela é declarada.
        */

        lucysMovie.setMinuteLength(200);
        lucysMovie.setName("Man with a guitar");
        lucysMovie.recieveAvaliation(10);

        //ArrayList<tipo dos objetos que serão armazenados na array>
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        movieArrayList.add(lucysMovie);
        movieArrayList.add(myMovie);
        movieArrayList.add(differentMovie);

        System.out.println("Array list size: " + movieArrayList.size());
        System.out.println("First movies name: " + movieArrayList.get(0).getName());

        //Por padrão, vai retornar a representação do objeto em string, com o @ com o endereço de memória do objeto
        System.out.println("toString from movie 1: " + movieArrayList.get(0).toString());
        //Aqui, o metodo toString foi reescrito (e uma boa pratica) para tornar mais acessivel e compreensivel

        //Aqui, ele vai usar o toString da classe dos objetos da array, no caso, movies. Comportamento esperado.
        System.out.println(movieArrayList);

        lucysMovie.toString();
    }

}
