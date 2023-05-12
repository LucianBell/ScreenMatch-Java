import br.com.alura.screenmatch.calculator.RecomendationFilter;
import br.com.alura.screenmatch.calculator.TimeCalculator;
import br.com.alura.screenmatch.model.Episodes;
import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Series;

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
    }

}
