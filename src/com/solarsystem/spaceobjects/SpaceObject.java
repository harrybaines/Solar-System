package com.solarsystem.spaceobjects;

import com.solarsystem.PointInSpace;
import com.solarsystem.SolarSystem;

/**
 * This class models a space object. 
 * This class provides properties and behaviours relevant for all inheriting child space object classes.
 * A space object is a specialisation of a point in space.
 *
 * @author Harry Baines
 */
public abstract class SpaceObject extends PointInSpace {
    
    private String name;                    /** The name of the space object **/
    private String colour;                  /** The colour of the space object **/
    private double diameter;                /** The diameter of the space object **/
    private SpaceObject objectOrbiting;     /** The object about which this object orbits **/
    private double speed;                   /** The speed of the space object **/

    /**
     * Constructor used to initialise member variables for the space object.
     * 
     * @param name The name of the space object.
     * @param colour The colour of the space object.
     * @param diameter The diameter of the space object.
     * @param distance The distance of the object from the point which it orbits.
     * @param angle The current angle the object is on its orbit path.
     * @param objectOrbiting The object about which this object orbits.
     * @param speed The speed of the space object.
     */
    public SpaceObject(String name, String colour, double diameter, double distance, double angle, SpaceObject objectOrbiting, double speed) {
        super(distance, angle);
        this.name = name;
        this.colour = colour;
        this.diameter = diameter;
        this.objectOrbiting = objectOrbiting;
        this.speed = speed;
    }

    /**
     * Method used to draw the space object and the object about which it orbits.
     * This method simplifies the main method when drawing each space object in the loop. 
     * By default, all drawn objects move about an orbiting object.
     *
     * @param system The solar system to draw objects in.
     */
    public void draw(SolarSystem system) {
        system.drawSolarObjectAbout(this.objectOrbiting.getDistance(), this.objectOrbiting.getAngle(), this.getDiameter(), 
                                    this.getColour(), this.getDistance() - this.objectOrbiting.getDistance(), this.getAngle());
        this.move(system);
    }

    /**
     * Updates the current angle of the space object according to it's speed.
     * Default behaviour for this method is creating a circular orbital path.
     * Sub-classes can choose to override this method for a custom moving implementation.
     * 
     * @param system The solar system to draw the object in.
     */
    public void move(SolarSystem system) {
        if (this.getAngle() > 360)
            this.setAngle(0);
        else
            this.setAngle(this.getSpeed() + this.getAngle());
    } 

    /**
     * Returns the space object that the object is orbiting.
     * @return The orbiting space object instance.
     */
    public SpaceObject getObjectOrbiting() {
        return this.objectOrbiting;
    }

    /**
     * Returns the name of the space object.
     * @return The space object's name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the colour of the space object.
     * @return The space object's colour.
     */
    public String getColour() {
        return this.colour;
    }
    
    /**
     * Returns the diameter of the space object.
     * @return The space object's diameter.
     */
    public double getDiameter() {
        return this.diameter;
    }

    /**
     * Sets the diameter of the space object.
     * @param diameter The new diameter of the space object.
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * Returns the space object's speed.
     * @return The speed of the object.
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Sets the speed of the space object.
     * @param speed The new speed of the space object.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
}