package com.solarsystem;

/**
 * This class models a point in space.
 * A point is a composition of a distance and an angle.
 *
 * @author Harry Baines
 */
public abstract class PointInSpace {

    private double distance;        /** The distance component of the point of the object **/
    private double angle;           /** The angle component of the point of the object **/

    /**
     * Constructor used to initialise distance and angle member variables for the point.
     *
     * @param distance The distance component of the point of the object.
     * @param angle The angle component of the point of the object.
     */
    public PointInSpace(double distance, double angle) {
        this.distance = distance;
        this.angle = angle;
    }

    /**
     * Returns the distance of the space object from it's orbiting point.
     * @return The space object's distance.
     */
    public double getDistance() {
        return this.distance;
    }

    /**
     * Sets the distance of the space object to the new distance.
     * @param distance The distance component of the point of the object.
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Returns the angle of the space object on it's orbit path.
     * @return The space object's angle.
     */
    public double getAngle() {
        return this.angle;
    }

    /**
     * Sets the angle of the space object to the new angle.
     * @param angle The angle component of the point of the object.
     */
    public void setAngle(double angle) {
        this.angle = angle;
    }
}