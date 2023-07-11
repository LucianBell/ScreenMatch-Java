import br.com.alura.screenmatch.calculator.RecomendationFilter;
import br.com.alura.screenmatch.calculator.TimeCalculator;
import br.com.alura.screenmatch.model.Episodes;
import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Series;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.setName("The Godfather");
        myMovie.setReleaseYear(1970);
        myMovie.setMinuteLength(210);
        System.out.println("Movie length (in minutes): " +  myMovie.getMinuteLength());

        myMovie.showData();
        myMovie.recieveAvaliation(9);
        myMovie.recieveAvaliation(8);
        myMovie.recieveAvaliation(10);

        System.out.println("Number of avaliations: " + myMovie.getAvaliationsTotal());
        System.out.println(myMovie.giveAvaliationResult());

        Series mySeries = new Series();
        mySeries.setName("Lost");
        mySeries.setReleaseYear(2000);
        mySeries.setSeasons(10);
        mySeries.setEpisodesPerSeason(10);
        mySeries.setMinutesPerEpisode(50);
        System.out.println("Series length (in minutes): " +  mySeries.getMinuteLength());

        Movie differentMovie = new Movie();
        differentMovie.setName("Top Gun Maverick");
        differentMovie.setReleaseYear(2022);
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
        var lucysMovie = new Movie();
        //A variavel var faz uma inferência do tipo declarado (new Movie, no exemplo acima)

        lucysMovie.setMinuteLength(200);
        lucysMovie.setName("Man with a guitar");
        lucysMovie.setReleaseYear(1970);
        lucysMovie.recieveAvaliation(10);

        //ArrayList<tipo dos objetos que serão armazenados na array>
        ArrayList<Movie> movieArrayList = new ArrayList<>();

        movieArrayList.add(lucysMovie);
        movieArrayList.add(myMovie);
        movieArrayList.add(differentMovie);

        System.out.println("Array list size: " + movieArrayList.size());
        System.out.println("First movies name: " + movieArrayList.get(0).getName());
    }

}
