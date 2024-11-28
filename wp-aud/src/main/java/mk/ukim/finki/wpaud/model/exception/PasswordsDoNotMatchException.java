package mk.ukim.finki.wpaud.model.exception;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException(){
        super("Passwords do not match");
    }
}
