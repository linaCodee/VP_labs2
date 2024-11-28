package mk.finki.ukim.mk.lab203078.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab203078.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder2 {
    public static List<Song> songs=new ArrayList<>();
    @PostConstruct
    public void init(){
        songs.add(new Song("1","Santa Tell Me","Pop",2014));
        songs.add(new Song("2","Mistletoe","Pop",2011));
        songs.add(new Song("3","Let it go","Pop",2013));
        songs.add(new Song("4","Shake it off","Pop",2014));
        songs.add(new Song("5","Grenade","Pop",2010));
    }
}
