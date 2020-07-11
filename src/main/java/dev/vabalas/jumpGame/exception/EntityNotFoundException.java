package dev.vabalas.jumpGame.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String text) {
        super(text);
    }
}
