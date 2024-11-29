package mk.finki.ukim.mk.lab203078.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab203078.model.Album;
import mk.finki.ukim.mk.lab203078.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder2 {
    public static List<Song> songs=new ArrayList<>();
    public static List<Album> albums=new ArrayList<>();
    @PostConstruct
    public void init(){
        Album album1=new Album("Christmas & Chill","pop",2015);
        albums.add(album1);
        Album album2=new Album("Under the Mistletoe","pop",2011);
        albums.add(album2);
        Album album3=new Album("Demi","pop",2013);
        albums.add(album3);
        Album album4=new Album("1989","pop",2014);
        albums.add(album4);
        Album album5=new Album("Doo-Wops & Hooligans","pop",2010);
        albums.add(album5);
        songs.add(new Song("Santa Tell Me","Pop",2014,album1));
        songs.add(new Song("Mistletoe","Pop",2011,album2));
        songs.add(new Song("Let it go","Pop",2013,album3));
        songs.add(new Song("Shake it off","Pop",2014,album4));
        songs.add(new Song("Grenade","Pop",2010,album5));


    }
}
