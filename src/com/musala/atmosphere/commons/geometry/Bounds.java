package com.musala.atmosphere.commons.geometry;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Class representing bounds as a upper left corner point, width and height.
 *
 * @author yordan.petrov
 *
 */
public class Bounds implements Serializable {
    private static final long serialVersionUID = 2767880624236204841L;

    private Point upperLeftCorner;

    private int width;

    private int height;

    /**
     * Creates new Bounds instance given upper left corner, width and height.
     *
     * @param upperLeftCorner
     *        - the upper left corner of the bounds
     * @param width
     *        - the width of the bounds
     * @param height
     *        - the height of the bounds
     */
    public Bounds(Point upperLeftCorner, int width, int height) {
        this.upperLeftCorner = new Point(upperLeftCorner);
        this.width = width;
        this.height = height;
    }

    /**
     * Creates new Bounds instance given upper left and lower right corners.
     *
     * @param upperLeftCorner
     *        - the upper left corner of the bounds
     * @param lowerRightCorner
     *        - the lower left corner of the bounds
     */
    public Bounds(Point upperLeftCorner, Point lowerRightCorner) {
        int calculatedWidth = lowerRightCorner.getX() - upperLeftCorner.getX();
        int calculatedHeight = lowerRightCorner.getY() - upperLeftCorner.getY();

        this.upperLeftCorner = new Point(upperLeftCorner);
        this.width = calculatedWidth;
        this.height = calculatedHeight;
    }

    /**
     * Gets upper left corner.
     *
     * @return the upper left corner of the bounds
     */
    public Point getUpperLeftCorner() {
        return new Point(upperLeftCorner);
    }

    /**
     * Sets upper left corner.
     *
     * @param upperLeftCorner
     *        - the upper left corner of the bounds
     */
    public void setUpperLeftCorner(Point upperLeftCorner) {
        this.upperLeftCorner = new Point(upperLeftCorner);
    }

    /**
     * Gets upper right corner.
     *
     * @return the upper right corner of the bounds
     */
    public Point getUpperRightCorner() {
        int upperRightCornerX = upperLeftCorner.getX() + width;
        int upperRightCornerY = upperLeftCorner.getY();
        Point upperRightCorner = new Point(upperRightCornerX, upperRightCornerY);
        return upperRightCorner;
    }

    /**
     * Gets lower left corner.
     *
     * @return the lower left corner of the bounds
     */
    public Point getLowerLeftCorner() {
        int lowerLeftCornerX = upperLeftCorner.getX();
        int lowerLeftCornerY = upperLeftCorner.getY() + height;
        Point lowerLeftCorner = new Point(lowerLeftCornerX, lowerLeftCornerY);
        return lowerLeftCorner;
    }

    /**
     * Gets lower right corner.
     *
     * @return the lower right corner of the bounds
     */
    public Point getLowerRightCorner() {
        int lowerRightCornerX = upperLeftCorner.getX() + width;
        int lowerRightCornerY = upperLeftCorner.getY() + height;
        Point lowerRightCorner = new Point(lowerRightCornerX, lowerRightCornerY);
        return lowerRightCorner;
    }

    /**
     * Gets bounds width.
     *
     * @return the width of the bounds
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets bounds width.
     *
     * @param width
     *        - the width of the bounds
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Gets bounds height.
     *
     * @return the height of the bounds
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets bounds height.
     *
     * @param height
     *        - the height of the bounds
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets bounds center.
     *
     * @return the center point of the bounds
     */
    public Point getCenter() {
        int centerX = upperLeftCorner.getX() + width / 2;
        int centerY = upperLeftCorner.getY() + height / 2;
        Point center = new Point(centerX, centerY);
        return center;
    }

    /**
     * Gets bounds diagonal length.
     *
     * @return the diagonal length of the bounds
     */
    public double getDiagonalLength() {
        int diagonalLengthSquare = width * width + height * height;
        double diagonalLength = Math.sqrt(diagonalLengthSquare);
        return diagonalLength;
    }

    /**
     * Check if a {@link Point} is inside the bounds.
     *
     * @param point
     *        - a {@link Point} that needs to be contained in the bounds
     * @return true if the bounds contain the point, false otherwise
     */
    public boolean contains(Point point) {
        Point lowerRightCorner = getLowerRightCorner();
        boolean containsPointX = point.getX() >= upperLeftCorner.getX() && point.getX() <= lowerRightCorner.getX();
        boolean containsPointY = point.getY() >= upperLeftCorner.getY() && point.getY() <= lowerRightCorner.getY();

        return containsPointX && containsPointY;
    }

    /**
     * Check if certain {@link Bounds} parameter is inside the bounds.
     *
     * @param bounds
     *        - a {@link Bounds} parameter that needs to be contained in the bounds
     * @return true if the bounds contain the bounds parameter, false otherwise
     */
    public boolean contains(Bounds bounds) {
        Point boundsUpperLeftCorner = bounds.getUpperLeftCorner();
        int boundsWidth = bounds.getWidth();
        int boundsHeight = bounds.getHeight();
        boolean containsUpperLeftCorner = contains(boundsUpperLeftCorner);
        boolean containsWidth = boundsUpperLeftCorner.getX() + boundsWidth <= upperLeftCorner.getX() + width;
        boolean containsHeight = boundsUpperLeftCorner.getY() + boundsHeight <= upperLeftCorner.getY() + height;

        return containsUpperLeftCorner && containsWidth && containsHeight;
    }

    /**
     * Gets the given point equivalent relative to the bounds upper left corner.
     *
     * @param point
     *        - a {@link Point} for which to get the point equivalent relative to the bounds upper left corner
     * @return the point equivalent relative to the bounds upper left corner
     */
    public Point getRelativePoint(Point point) {
        int relativePointX = point.getX() - upperLeftCorner.getX();
        int relativePointY = point.getY() - upperLeftCorner.getY();
        Point relativePoint = new Point(relativePointX, relativePointY);

        return relativePoint;
    }

    /**
     * Gets the given bounds equivalent relative to the bounds upper left corner;
     *
     * @param bounds
     *        - {@link Bounds} for which to get the relative bounds to the bounds upper left corner
     * @return the bounds equivalent relative to the bounds upper left corner
     */
    public Bounds getRelativeBounds(Bounds bounds) {
        Point boundsUpperLeftCorner = bounds.getUpperLeftCorner();
        int boundsWidth = bounds.getWidth();
        int boundsHeight = bounds.getHeight();
        Point relativeUpperLeftCorner = getRelativePoint(boundsUpperLeftCorner);
        Bounds relativeBounds = new Bounds(relativeUpperLeftCorner, boundsWidth, boundsHeight);

        return relativeBounds;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bounds bounds = (Bounds) obj;

        return new EqualsBuilder().append(upperLeftCorner, bounds.upperLeftCorner)
                                  .append(width, bounds.width)
                                  .append(height, bounds.height)
                                  .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(upperLeftCorner).append(width).append(height).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("Upper left corner", upperLeftCorner)
                                                                          .append("width", width)
                                                                          .append("height", height)
                                                                          .toString();
    }
}
