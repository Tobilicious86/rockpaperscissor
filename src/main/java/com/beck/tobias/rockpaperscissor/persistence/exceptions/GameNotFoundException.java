package com.beck.tobias.rockpaperscissor.persistence.exceptions;

public class GameNotFoundException extends RuntimeException {
    public GameNotFoundException(Long e) {
        super("Game " + e + " not found!");
    }
}
