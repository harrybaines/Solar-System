package com.solarsystem;

import com.solarsystem.spaceobjects.SpaceObject;
import com.solarsystem.spaceobjects.*;
import com.solarsystem.spaceobjects.stars.*;

import java.util.Vector;

/**
 * This class allows a simple model of the solar system to be displayed.
 * 
 * @author Harry Baines
 */
public class SolarSimulation {

    public static final int WINDOW_SIZE = 950;               /** Size of the window **/
    private SolarSystem system;                              /** SolarSystem instance to display window **/
    private Vector<SpaceObject> spaceObjects;                /** Array to store all orbiting space objects **/
    private SpaceOptionFrame optionFrame;                    /** Space option window containing useful parameters **/

    /**
     * Constructor to initialise member variables and call the method to create all space objects.
     */
    public SolarSimulation() {

        system = new SolarSystem(WINDOW_SIZE, WINDOW_SIZE);
        spaceObjects = new Vector<SpaceObject>();
        optionFrame = new SpaceOptionFrame(325, 150, spaceObjects);
        createSpaceObjects();
    }

    /**
     * Method used to create all the space objects to display in the solar system.
     */
    private void createSpaceObjects() {

        // *** CREATE STARS *** //
        // Create a new sun (doesn't orbit - center point of solar system)
        Sun sun = new Sun("SUN", "YELLOW", 50, 0, 0, null, 0);
        spaceObjects.add(sun);

        // Create distant stars
        createDistantStars(sun.getDiameter() * 1.5, WINDOW_SIZE * 2, sun, 3000);

        // *** CREATE PLANETS *** //
        Planet mercury = new Planet("MERCURY", "GREY", 4, 80, 0, sun, 3);
        spaceObjects.add(mercury);

        Planet venus = new Planet("VENUS", "ORANGE", 6, 100, 10, sun, 2);
        spaceObjects.add(venus);

        Planet earth = new Planet("EARTH", "BLUE", 8, 150, 100, sun, 0.8);
        spaceObjects.add(earth);

        Planet mars = new Planet("MARS", "RED", 7, 200, 200, sun, 0.6);
        spaceObjects.add(mars);

        Planet jupiter = new Planet("JUPITER", "DARKORANGE", 12, 320, 100, sun, 0.4);
        spaceObjects.add(jupiter);

        Planet saturn = new Planet("SATURN", "ORANGE", 11, 380, 270, sun, 0.3);
        spaceObjects.add(saturn);

        Planet uranus = new Planet("URANUS", "LIGHTBLUE", 10, 420, 180, sun, 0.25);
        spaceObjects.add(uranus);

        Planet neptune = new Planet("NEPTUNE", "DARKBLUE", 8, 460, 0, sun, 0.22);
        spaceObjects.add(neptune);

        // *** CREATE MOONS *** //
        spaceObjects.add(new Moon("MOON", "LIGHTGREY", 3, earth.getDistance() + earth.getDiameter() + 10, 0, earth, 2));
        spaceObjects.add(new Moon("PHOBOS", "DARKGREY", 3, mars.getDistance() + mars.getDiameter() + 16, 0, mars, 1));
        spaceObjects.add(new Moon("DEIMOS", "GREY", 2, mars.getDistance() + mars.getDiameter() + 10, 90, mars, 4));
        spaceObjects.add(new Moon("EUROPA", "GREY", 2, jupiter.getDistance() + jupiter.getDiameter() + 5, 0, jupiter, 2));
        spaceObjects.add(new Moon("GANYMEDE", "DARKGREY", 4, jupiter.getDistance() + jupiter.getDiameter() + 10, 90, jupiter, 1.6));
        spaceObjects.add(new Moon("IO", "DARKGREY", 2, jupiter.getDistance() + jupiter.getDiameter() + 7, 180, jupiter, 1.2));
        spaceObjects.add(new Moon("CALLISTO", "GREY", 2, jupiter.getDistance() + jupiter.getDiameter() + 14, 270, jupiter, 0.8));
        spaceObjects.add(new Moon("TITAN", "WHITE", 3, saturn.getDistance() + saturn.getDiameter() + 18, 270, saturn, 1.2));
        spaceObjects.add(new Moon("ENCELADUS", "WHITE", 2, saturn.getDistance() + saturn.getDiameter() + 12, 180, saturn, 1));
        spaceObjects.add(new Moon("TITANIA", "GREY", 3, uranus.getDistance() + uranus.getDiameter() + 8, 180, uranus, 1.6));
        spaceObjects.add(new Moon("TRITON", "GREY", 2, neptune.getDistance() + neptune.getDiameter() + 5, 0, neptune, 1.3));

        // *** CREATE ASTEROID BELTS *** //
        // Main Asteroid Belt
        createAsteroidBelt(sun, mars.getDistance() + mars.getDiameter() * 4, 
                            jupiter.getDistance() - jupiter.getDiameter() * 2, 600, "DARKGREY");
        // Kuiper Belt
        createAsteroidBelt(sun, neptune.getDistance() * 1.1 + neptune.getDiameter(),
                            (neptune.getDistance() * 1.4 + neptune.getDiameter()) , 800, "LIGHTBLUE");

        // Update the window to contain newly created space objects
        drawSpaceObjects();
    }

    /**
     * Method used to create multiple asteroids to form an asteroid belt.
     * Each new asteroid instance is added to the array of space objects.
     *
     * @param objectOrbiting The object about which this asteroid orbits.
     * @param minPoint The minimum boundary for which the belt can be created.
     * @param maxPoint The maximum boundary for which the belt can be created.
     * @param numOfAsteroids The number of asteroids in the belt.
     * @param colour The colour of the asteroids in the belt.
     */
    private void createAsteroidBelt(SpaceObject objectOrbiting, double minPoint, double maxPoint, int numOfAsteroids, String colour) {

        // Create asteroid instances in loop
        for (int i = 0; i < numOfAsteroids; i++) {

            double randDistance = ((minPoint) + (int)(Math.random() * ((maxPoint - minPoint) + 1)));
            double randAngle = Math.random() * 360;
            double randSpeed = 0.05 + Math.random() * 0.1;
            double randSize = Math.random() * 2;

            spaceObjects.add(new Asteroid("ASTEROID"+(i+1), colour, randSize, randDistance, randAngle, objectOrbiting, randSpeed));
        }
    }

    /**
     * Method used to create multiple distant stars in the background of the solar system.
     *
     * @param minPoint The minimum boundary for which the belt can be created.
     * @param maxPoint The maximum boundary for which the belt can be created.
     * @param objectOrbiting The object about which the distant star orbits.
     * @param numOfStars The number of distant stars to create.
     */
    private void createDistantStars(double minPoint, double maxPoint, SpaceObject objectOrbiting, int numOfStars) {

        // Create distant star instances in loop
        for (int i = 0; i < numOfStars; i++) {
            
            double randDistance = Math.random() * maxPoint + minPoint;
            double randAngle = Math.random() * 360;
            double randSize = Math.random() * 0.8 + 0.1;

            spaceObjects.add(new DistantStar(("STAR"+i), "GREY", randSize, randDistance, randAngle, objectOrbiting, 0.01));
        } 
    }
	
    /**
     * Method used to constantly update the window with all created space objects.
     */
    private void drawSpaceObjects() {

        // Draw objects on screen
        while (true) {

            // Draw each space object
            for (SpaceObject obj : spaceObjects) 
                obj.draw(system);
            
            // Update UI
            system.finishedDrawing();
        }
    }
}