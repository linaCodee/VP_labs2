package mk.ukim.finki.wpaud.model.exception;

import mk.ukim.finki.wpaud.repository.InMemoryUserRepository;

public class InvalidUserCredentialsException extends RuntimeException{

    public InvalidUserCredentialsException(){
        super("Invalid user credentials exception");
    }
}
