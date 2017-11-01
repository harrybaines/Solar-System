package com.solarsystem.spaceobjects;

import com.solarsystem.spaceobjects.SpaceObject;

/**
 * This class models a moon object.
 * This class inherits from the SpaceObject superclass which provides move and draw functionality.
 *
 * @author Harry Baines
 */
public class Moon extends SpaceObject {

    /**
     * Calling the SpaceObject superclass constructor initialises member variables for the moon.
     * 
     * @param name The name of the moon.
     * @param colour The colour of the moon.
     * @param diameter The diameter of the moon.
     * @param distance The distance of the moon from the point which it orbits.
     * @param angle The current angle the moon is on its orbit path.
     * @param planetOrbiting The moon about which the moon orbits.
     * @param speed The speed of the moon.
     */
    public Moon(String name, String colour, double diameter, double distance, double angle, Planet planetOrbiting, double speed) {
        super(name, colour, diameter, distance, angle, planetOrbiting, speed);
    }
}