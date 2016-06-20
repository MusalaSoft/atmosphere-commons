package com.musala.atmosphere.commons;

/**
 * Holds different screen orientations.
 * 
 * @author nikola.taushanov
 * 
 */
public enum ScreenOrientation {
    LANDSCAPE(1),
    PORTRAIT(0),
    UPSIDE_DOWN_LANDSCAPE(3),
    UPSIDE_DOWN_PORTRAIT(2);

    private int orientationNumber;

    private ScreenOrientation(int orientationNumber) {
        this.orientationNumber = orientationNumber;
    }

    public int getOrientationNumber() {
        return orientationNumber;
    }

    public static ScreenOrientation getValueOfInt(int orientationNumber) {
        for (ScreenOrientation currentOrientation : ScreenOrientation.values()) {
            if (currentOrientation.getOrientationNumber() == orientationNumber) {
                return currentOrientation;
            }
        }
        return null;
    }
}
