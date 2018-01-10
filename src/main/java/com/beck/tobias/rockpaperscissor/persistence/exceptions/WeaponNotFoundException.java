package com.beck.tobias.rockpaperscissor.persistence.exceptions;

/**
 * Exception for NotAWeapon
 */
public class WeaponNotFoundException extends RuntimeException {

    public WeaponNotFoundException() {
        super("Weapon not available");
    }
}
