package com.musala.atmosphere.commons.geometry;

import java.io.Serializable;

/**
 * Represent the coordinates of a point in a 2D space.
 * 
 * @author yordan.petrov
 * 
 */
public class Point implements Serializable {
    private static final long serialVersionUID = 1745863697892220078L;

    /**
     * the X coordinate of the point.
     */
    private int x;

    /**
     * The Y coordinate of the point.
     */
    private int y;

    /**
     * Creates a default Point object. The X and Y values are set to 0.
     */
    public Point() {
        x = 0;
        y = 0;
    }

    /**
     * Create point by specified X and Y coordinates.
     * 
     * @param x
     *        - value of the X coordinate.
     * @param y
     *        - value of the Y coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Creates Point object by given Point object. Sets the X and Y values to be equal to the parameter's.
     * 
     * @param point
     *        - a {@link Point} needed for the constructor
     */
    public Point(Point point) {
        this(point.getX(), point.getY());
    }

    /**
     * Gets the X coordinate of the point.
     * 
     * @return - the X coordinate of the point.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the X coordinate of the point.
     * 
     * @param x
     *        - new value for the X coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the value of the Y coordinate.
     * 
     * @return - the value of the Y coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the Y coordinate of the point.
     * 
     * @param y
     *        - new value for the Y coordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Sets the location of the X and Y coordinates.
     * 
     * @param x
     *        - value of the X coordinate.
     * @param y
     *        - value of the Y coordinate.
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the location of the Point object.
     * 
     * @param point
     *        - new location for the point.
     */
    public void setLocation(Point point) {
        setLocation(point.getX(), point.getY());
    }

    /**
     * Returns the 2D distance to a set of given coordinates x and y.
     * 
     * @param toX
     *        - value of the X coordinate to which we find the distance
     * @param toY
     *        - value of the Y coordinate to which we find the distance
     * @return - the 2D distance to the given set of coordinates.
     */
    public double distance(int toX, int toY) {
        double deltaX = toX - x;
        double deltaY = toY - y;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Returns the 2D distance to another point.
     * 
     * @param toPoint
     *        - point to calculate distance to.
     * @return the 2D distance to another point.
     */
    public double distance(Point toPoint) {
        return distance(toPoint.getX(), toPoint.getY());
    }

    /**
     * Calculates the coordinates of a vector with start point A and end point B.
     * 
     * @param pointA
     *        - start point of the vector.
     * @param pointB
     *        - end point of the vector.
     * @return the coordinates of a vector with start point A and end point B.
     */
    public static Point getVector(Point pointA, Point pointB) {
        int vectorX = pointB.getX() - pointA.getX();
        int vectorY = pointB.getY() - pointA.getY();
        Point vector = new Point(vectorX, vectorY);
        return vector;
    }

    /**
     * Checks if the Point represents a zero vector.
     * 
     * @return true if the Point represents a zero vector, false otherwise
     */
    public boolean isZeroVector() {
        return x == 0 && y == 0;
    }

    /**
     * Adds the given vector to the current one.
     * 
     * @param aVector
     *        - vector added to the current one.
     */
    public void addVector(Point aVector) {
        x += aVector.getX();
        y += aVector.getY();
    }

    /**
     * Subtracts the given vector from the current one.
     * 
     * @param aVector
     *        - vector subtracted from the current one.
     */
    public void subtractVector(Point aVector) {
        x -= aVector.getX();
        y -= aVector.getY();
    }

    /**
     * Sets all coordinates of the point to their absolute values.
     */
    public void abs() {
        x = Math.abs(x);
        y = Math.abs(y);
    }

    @Override
    public String toString() {
        return String.format("[X: %d, Y: %d]", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        return x == other.getX() && y == other.getY();
    }
}
