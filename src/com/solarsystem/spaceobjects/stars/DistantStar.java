package com.solarsystem.spaceobjects.stars;

import com.solarsystem.*;
import com.solarsystem.spaceobjects.SpaceObject;

import java.util.Vector;

/**
 * This class models a distant star object.
 * This class inherits from the Star superclass to inherit star properties and behaviours.
 *
 * @author Harry Baines
 */
public class DistantStar extends Star {

    /**
     * Calling the Star superclass constructor initialises member variables for the distant star.
     * 
     * @param name The name of the distant star.
     * @param colour The colour of the distant star.
     * @param diameter The diameter of the distant star.
     * @param distance The distance of the distant star from the point which it orbits.
     * @param angle The current angle the distant star is on its orbit path.
     * @param objectOrbiting The object about which the distant star orbits.
     * @param speed The speed of the distant star.
     */
    public DistantStar(String name, String colour, double diameter, double distance, double angle, SpaceObject objectOrbiting, double speed) {
        super(name, colour, diameter, distance, angle, objectOrbiting, speed);
    }

    /**
     * Updates the current angle of the distant star according to it's speed.
     * 
     * @param system The solar system to draw the object in.
     */
    @Override
    public void move(SolarSystem system) {
        this.setAngle(this.getSpeed() * (Math.random() * 2 + 1) + this.getAngle());
    }
}