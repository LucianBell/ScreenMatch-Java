package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Series;
import br.com.alura.screenmatch.model.Title;

import java.util.*;

public class MainWithArrays {
    public static void main(String[] args) {
        Movie myMovie = new Movie("The Godfather", 1970);
        myMovie.recieveAvaliation(10);
        Movie differentMovie = new Movie("Top Gun Maverick", 2022);
        differentMovie.recieveAvaliation(7);
        var lucysMovie = new Movie("Man with a guitar", 1970);
        lucysMovie.recieveAvaliation(10);
        Series mySeries = new Series("Lost", 2000);
        mySeries.recieveAvaliation(6);
        //Quando falamos de listas e collections, o melhor é se referir de maneira generica. Tratar tudo como list.
        //Assim, você coloca List, e depois instancia colocando new e a classe específica que implementa list
        //no caso, LinedList.
        List<Title> movieList = new LinkedList<>();

        //Isso NÃO está criando um novo objeto ou copiando um objeto já existente. Quando falamos de objetos de classe
        //em Java, fazer isso é REFERENCIAR um objeto de classe já existente na memória.
        Movie f1 = myMovie;
        //OBJETO NOVO SÓ É CRIADO COM NEW. Aqui nós só estamos trabalhando com variaveis de referência. O que usamos
        //para chegar em um objeto de classe.

        movieList.add(lucysMovie);
        movieList.add(myMovie);
        movieList.add(differentMovie);

        movieList.add(mySeries);

        System.out.println("Títulos da lista:");

        for (Title item: movieList) {
            System.out.println(item.getName());
            if (item instanceof Movie) {
                //esse instanceof é usado para ver se o item, além de titulo, é uma instancia de filme
                //não é elegante, mas pode aparecer
                Movie movie = (Movie) item;
                System.out.println("Classificação: " + movie.getClassification());
            }
        }

        ArrayList<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Loyd Barret");
        searchByArtist.add("Krech Bechinham");

        System.out.println(searchByArtist);
        Collections.sort(searchByArtist);
        System.out.println("Depois da ordenação...");
        System.out.println(searchByArtist);

        Collections.sort(movieList);
        System.out.println("Lista de títulos ordenados:");
        System.out.println(movieList);

        //Sort é um COMPARATOR, ele SABE comparar e pede qual a maneira de comparar
        movieList.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println("Lista odenada por ano de lançamento:");
        System.out.println(movieList);
    }
}
