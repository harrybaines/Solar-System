package com.solarsystem.spaceobjects;

import com.solarsystem.spaceobjects.SpaceObject;
import com.solarsystem.spaceobjects.stars.Star;

/**
 * This class models a planet object.
 * This class inherits from the SpaceObject superclass which provides move and draw functionality.
 *
 * @author Harry Baines
 */
public class Planet extends SpaceObject {

    /**
     * Calling the SpaceObject superclass constructor initialises member variables for the planet.
     * 
     * @param name The name of the planet.
     * @param colour The colour of the planet.
     * @param diameter The diameter of the planet.
     * @param distance The distance of the planet from the point which it orbits.
     * @param angle The current angle the planet is on its orbit path.
     * @param starOrbiting The star about which the planet orbits.
     * @param speed The speed of the planet.
     */
    public Planet(String name, String colour, double diameter, double distance, double angle, Star starOrbiting, double speed) {
        super(name, colour, diameter, distance, angle, starOrbiting, speed);
    }
}