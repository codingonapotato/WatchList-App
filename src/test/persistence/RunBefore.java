package persistence;

import model.Media;

public class RunBefore {
    protected Media movie;
    protected Media tv;

    public void runBefore() {
        movie = new Media();
        movie.setTitle("ponyo");
        movie.setReleaseDate(2000,12,31);
        movie.setRating(57.5);
        movie.setGenre("anime");
        movie.setMovie(true); // So, this is a movie now!
        tv = new Media();
        tv.setTitle("Jujutsu Kaisen");
        tv.setReleaseDate(2020,4,27);
        tv.setRating(100.0);
        tv.setGenre("anime");
        tv.setTVShow(true); // So, this is a TV show now!
    }
}
