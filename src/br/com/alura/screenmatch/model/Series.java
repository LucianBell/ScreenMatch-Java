package br.com.alura.screenmatch.model;

public class Series extends Title {
    private int seasons;
    private  boolean isRunning;
    private int episodesPerSeason;
    private  int minutesPerEpisode;

    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }

    @Override
    public int getMinuteLength() {
        return seasons * episodesPerSeason * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + "(" + this.getReleaseYear() + ")";
    }
}
