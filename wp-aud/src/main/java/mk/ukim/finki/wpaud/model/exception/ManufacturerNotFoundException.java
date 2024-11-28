package mk.ukim.finki.wpaud.model.exception;

import mk.ukim.finki.wpaud.model.Manufacturer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ManufacturerNotFoundException extends RuntimeException{
    public ManufacturerNotFoundException(Long id){
        super(String.format("Manufacturer with id %d was not found",id));
    }
}
