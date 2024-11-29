package mk.finki.ukim.mk.lab203078.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidAlbumIdException extends RuntimeException{
    public InvalidAlbumIdException(Long id) {
        super(String.format("Album with id %d was not found",id));
    }
}
