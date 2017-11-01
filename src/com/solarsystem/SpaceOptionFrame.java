package com.solarsystem;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.Hashtable;
import java.util.Vector;

import com.solarsystem.spaceobjects.SpaceObject;

/**
 * This class provides a simple option window which allows the user to alter the parameters of the solar system.
 * Currently, the user can change the speed of the objects and the view of the solar system (distance).
 *
 * @author Harry Baines
 */
public class SpaceOptionFrame extends JFrame implements ChangeListener {

    private Vector<SpaceObject> spaceObjects;       /** The dynamic array reference of space objects **/
    private double previousSpeed;                   /** Tracks the previous speed of space objects for sliders **/
    private double previousView;                    /** Tracks the previous view of space objects for sliders **/
    private final double speedScale = 2;            /** Scale factor for speeds **/
    private final double viewScale = 2;             /** Scale factor for window view **/
    private int[] speedRanges = { 2, 3, 4 };        /** Array for different speed ranges - multipliers **/
    private int[] sizeRanges = { 1, 2, 3 };         /** Array for different speed ranges - multipliers **/

    /**
     * Constructor to initialise a window to display to the user containing options to alter the solar system.
     *
     * @param width The width of the option window.
     * @param height The height of the option window.
     * @param spaceObjects The dynamic array reference of space objects to modify.
     */
    public SpaceOptionFrame(int width, int height, Vector<SpaceObject> spaceObjects) {

        this.spaceObjects = spaceObjects;

        // Init panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel middlePanel = new JPanel();
        mainPanel.add("Center", middlePanel);

        // Change Speed Section
        JLabel speedLbl = new JLabel("Change Speed!");
        middlePanel.add(speedLbl);

        int minSpeed = speedRanges[0];
        int maxSpeed = speedRanges[speedRanges.length - 1];
        previousSpeed = minSpeed;

        JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, minSpeed, maxSpeed, minSpeed);
        speedSlider.setName("SPEED");
        speedSlider.addChangeListener(this);
        speedSlider.setMajorTickSpacing(2);
        speedSlider.setMinorTickSpacing(1);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setFont(new Font("Serif", Font.ITALIC, 15));

        Hashtable<Integer, JLabel> speedTable = new Hashtable<Integer, JLabel>();
        speedTable.put(new Integer(minSpeed), new JLabel("Slow"));
        speedTable.put(new Integer(maxSpeed - minSpeed) + 1, new JLabel("Medium"));
        speedTable.put(new Integer(maxSpeed), new JLabel("Fast"));
        speedSlider.setLabelTable(speedTable);

        middlePanel.add(speedSlider);

        // Change Size Section
        int minView = sizeRanges[0];
        int maxView = sizeRanges[sizeRanges.length - 1];
        previousView = minView;

        JLabel sizeLbl = new JLabel("Change View!");
        middlePanel.add(sizeLbl);

        JSlider viewSlider = new JSlider(JSlider.HORIZONTAL, minView, maxView, minView);
        viewSlider.setName("VIEW");
        viewSlider.addChangeListener(this);
        viewSlider.setMajorTickSpacing(2);
        viewSlider.setMinorTickSpacing(1);
        viewSlider.setPaintTicks(true);
        viewSlider.setPaintLabels(true);
        viewSlider.setFont(new Font("Serif", Font.ITALIC, 15));

        Hashtable<Integer, JLabel> viewTable = new Hashtable<Integer, JLabel>();
        viewTable.put(new Integer(minView), new JLabel("Normal"));
        viewTable.put(new Integer(maxView - minView), new JLabel("Far"));
        viewTable.put(new Integer(maxView), new JLabel("Very Far"));
        viewSlider.setLabelTable(viewTable);

        middlePanel.add(viewSlider);

        // Final window details
        this.add(mainPanel);
        this.setTitle("Space Options");
        this.setSize(width, height);
        this.setLocation(SolarSimulation.WINDOW_SIZE + 20, SolarSimulation.WINDOW_SIZE / 4);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Method to update the speeds of all space objects relevant to user input.
     * @param value The speed value selected by the user.
     */
    private void updateSpeeds(double value) {

        // Update every space object
        for (SpaceObject s : spaceObjects) {

            double origSpeed = s.getSpeed();
            
            if (value < previousSpeed)    // Decreasing
                s.setSpeed(origSpeed / (speedScale * (previousSpeed - value)) );

            else if (value > previousSpeed)     // Increasing 
                s.setSpeed(origSpeed * speedScale * (value - previousSpeed) );  
        }
    }

    /**
     * Method to update the view of the solar system window relevant to user input.
     * @param value The view value selected by the user.
     */
    private void updateView(double value) {

        // Update every space object
        for (SpaceObject s : spaceObjects) {

            double origSize = s.getDiameter();
            double origDistance = s.getDistance();
            
            if (value < previousView) {     // Decreasing  
                s.setDiameter(origSize * (viewScale * (previousView - value)) );
                s.setDistance(origDistance * (viewScale * (previousView - value)) );
            }
            else if (value > previousView) {    // Increasing
                s.setDiameter(origSize / (viewScale * (value - previousView)) );
                s.setDistance(origDistance / (viewScale * (previousView - value)) );
            } 
        }
    }

    /**
     * Method to detect a change in state for a slider on the option window.
     * This method is implemented from the ChangeListener interface.
     *
     * @param e The change event instance.
     */
    @Override
    public void stateChanged(ChangeEvent e) {

        JSlider source = (JSlider) e.getSource();
        
        // Detect slider used
        if (!source.getValueIsAdjusting()) {
            if (source.getName().equals("SPEED")) {
                double currentSpeed = (double) source.getValue();
                updateSpeeds( currentSpeed );
                previousSpeed = currentSpeed;
            }
            else if (source.getName().equals("VIEW")) {
                double currentView = (double) source.getValue();
                updateView( currentView );
                previousView = currentView;
            }
        }
    }
}