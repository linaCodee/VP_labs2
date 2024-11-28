package mk.finki.ukim.mk.lab203078.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab203078.model.Artist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataHolder {
    public static List<Artist> artist=new ArrayList<>();

    @PostConstruct
    public void init(){
        artist.add(new Artist(1L,"Ariana","Grande","singer"));
        artist.add(new Artist(2L,"Justin","Bieber","singer"));
        artist.add(new Artist(3L,"Demi","Lovato","singer"));
        artist.add(new Artist(4L,"Taylor","Swift","singer"));
        artist.add(new Artist(5L,"Bruno","Mars","singer"));
    }

}
