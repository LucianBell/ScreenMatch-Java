import br.com.alura.screenmatch.model.Movie;
import br.com.alura.screenmatch.model.Series;

public class Main {

    public static void main(String[] args) {
        Movie myMovie = new Movie();
        myMovie.setName("The Godfather");
        myMovie.setReleaseYear(1970);
        myMovie.setMinuteLength(210);

        myMovie.showData();
        myMovie.recieveAvaliation(9);
        myMovie.recieveAvaliation(8);
        myMovie.recieveAvaliation(10);

        System.out.println("Number of avaliations: " + myMovie.getAvaliationsTotal());
        System.out.println(myMovie.giveAvaliationResult());

        Series mySeries = new Series();
        mySeries.setName("Lost");
        mySeries.setReleaseYear(2000);
        mySeries.setSeasons(7);
        mySeries.setEpisodesPerSeason(10);
        mySeries.showData();
    }

}
