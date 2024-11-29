package mk.finki.ukim.mk.lab203078.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Song {
    private Long trackId;
    private String title;
    private String genre;
    private Integer releaseYear;
    private List<Artist> performers=new ArrayList<>();
    private Album album;

    public Song(String title, String genre, Integer releaseYear,Album album) {
        this.trackId=(long)(Math.random()*1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album=album;
    }

    public void addArtist(Artist performer){
        performers.add(performer);
    }


}
