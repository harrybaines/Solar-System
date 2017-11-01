package com.solarsystem.spaceobjects.stars;

import com.solarsystem.SolarSystem;
import com.solarsystem.spaceobjects.SpaceObject;

/**
 * This class models a sun object.
 * This class inherits from the Star superclass.
 *
 * @author Harry Baines
 */
public class Sun extends Star {

    /**
     * Calling the Star superclass constructor initialises member variables for the sun.
     * 
     * @param name The name of the sun.
     * @param colour The colour of the sun.
     * @param diameter The diameter of the sun.
     * @param distance The distance of the sun from the point which it orbits.
     * @param angle The current angle the sun is on its orbit path.
     * @param objectOrbiting The object about which the sun orbits.
     * @param speed The speed of the sun.
     */
    public Sun(String name, String colour, double diameter, double distance, double angle, SpaceObject objectOrbiting, double speed) {
        super(name, colour, diameter, distance, angle, objectOrbiting, speed);
    }

    /**
     * Draw method used to call the drawSolarObject in the SolarSystem class.
     * This method simplifies the main method when drawing each space object in the loop. 
     * Sun's don't move - only draw the sun in the solar system, without moving.
     *
     * @param system The solar system to draw objects in.
     */
    @Override
    public void draw(SolarSystem system) {
        system.drawSolarObject(this.getDistance(), this.getAngle(), this.getDiameter(), this.getColour()); 
    }
}