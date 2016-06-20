package com.musala.atmosphere.commons.ui.selector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;

/**
 * Manages some of the UiElement Bounds functionality like parsing String of Bounds into Bounds pair.
 * 
 * @author georgi.gaydarov
 * 
 */
public class UiElementBoundsParser {
    private static final Logger LOGGER = Logger.getLogger(UiElementBoundsParser.class);

    /**
     * Converts a UI element bounds in the format <b>[startX,startY][endX,endY]</b> (fetched from the UI XML file) to a
     * Pair&lt;Point, Point;&gt; format.
     * 
     * @param bounds
     *        String containing UiElement bounds to be parsed.
     * @return Bounds pair containing the UiElement bounds.
     */
    public static Bounds parse(String bounds) {
        final String BOUNDS_STRING_PATTERN = "\\[(-*\\d+),(-*\\d+)\\]\\[(-*\\d+),(-*\\d+)\\]";
        final Pattern BOUNDS_PATTERN = Pattern.compile(BOUNDS_STRING_PATTERN);
        final Matcher BOUNDS_MATCHER = BOUNDS_PATTERN.matcher(bounds);

        if (BOUNDS_MATCHER.find()) {
            int firstPointX = Integer.parseInt(BOUNDS_MATCHER.group(1));
            int firstPointY = Integer.parseInt(BOUNDS_MATCHER.group(2));
            Point first = new Point(firstPointX, firstPointY);

            int secondPointX = Integer.parseInt(BOUNDS_MATCHER.group(3));
            int secondPointY = Integer.parseInt(BOUNDS_MATCHER.group(4));
            Point second = new Point(secondPointX, secondPointY);

            Bounds result = new Bounds(first, second);
            return result;
        } else {
            String message = String.format("' %s ' is not in the required bounds format.", bounds);
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
    }
}
