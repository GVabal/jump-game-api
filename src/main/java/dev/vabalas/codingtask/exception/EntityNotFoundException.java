package dev.vabalas.codingtask.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String text) {
        super(text);
    }
}
