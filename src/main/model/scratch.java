import model.Movie;
import model.ReleaseDate;

import java.util.ArrayList;

class Scratch {
    public static void main(String[] args) {
        Movie myMovie = new Movie("Princess Mononoke", new ReleaseDate(1,1,1), "bob");
        System.out.println("Testing this is correct?");
        System.out.println(myMovie.getRating());
    }
}