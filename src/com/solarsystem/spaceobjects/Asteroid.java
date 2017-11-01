package com.solarsystem.spaceobjects;

import com.solarsystem.spaceobjects.SpaceObject;
import com.solarsystem.spaceobjects.stars.Star;

import java.util.Vector;

/**
 * This class models an asteroid object.
 * This class inherits from the SpaceObject superclass which provides move and draw functionality.
 *
 * @author Harry Baines
 */
public class Asteroid extends SpaceObject {

    /**
     * Calling the SpaceObject superclass constructor initialises member variables for the asteroid.
     * 
     * @param name The name of the asteroid.
     * @param colour The colour of the asteroid.
     * @param diameter The diameter of the asteroid.
     * @param distance The distance of the asteroid from the point which it orbits.
     * @param angle The current angle the asteroid is on its orbit path.
     * @param objectOrbiting The object about which the asteroid orbits.
     * @param speed The speed of the asteroid.
     */
    public Asteroid(String name, String colour, double diameter, double distance, double angle, SpaceObject objectOrbiting, double speed) {
        super(name, colour, diameter, distance, angle, objectOrbiting, speed);
    }
}