package mk.finki.ukim.mk.lab203078.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Album {
    private Long id;
    private String name;
    private String genre;
    private Integer releaseYear;

    public Album(String name, String genre, Integer releaseYear) {
        this.id=(long)(Math.random()*1000);
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
