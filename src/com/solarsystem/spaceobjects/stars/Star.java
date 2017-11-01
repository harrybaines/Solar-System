package com.solarsystem.spaceobjects.stars;

import com.solarsystem.spaceobjects.SpaceObject;

/**
 * This class models a star object.
 * This class inherits from the SpaceObject superclass.
 * This class provides all behaviours relevant for stars.
 *
 * @author Harry Baines
 */
public abstract class Star extends SpaceObject {

    /**
     * Calling the SpaceObject superclass constructor initialises member variables for the star.
     * 
     * @param name The name of the star.
     * @param colour The colour of the star.
     * @param diameter The diameter of the star.
     * @param distance The distance of the star from the point which it orbits.
     * @param angle The current angle the star is on its orbit path.
     * @param objectOrbiting The object about which the star orbits.
     * @param speed The speed of the star.
     */
    public Star(String name, String colour, double diameter, double distance, double angle, SpaceObject objectOrbiting, double speed) {
        super(name, colour, diameter, distance, angle, objectOrbiting, speed);
    }
}