package com.beck.tobias.rockpaperscissor.persistence.exceptions;

public class WeaponException extends Exception {

    public WeaponException(String e) {
        super("Waffe " + e + " ist nicht verfügbar!");
    }
}
