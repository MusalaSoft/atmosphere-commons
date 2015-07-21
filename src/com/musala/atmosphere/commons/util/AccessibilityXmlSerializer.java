package com.musala.atmosphere.commons.util;

import org.apache.commons.lang3.StringEscapeUtils;

import com.musala.atmosphere.commons.geometry.Bounds;
import com.musala.atmosphere.commons.geometry.Point;
import com.musala.atmosphere.commons.ui.tree.AccessibilityElement;
import com.musala.atmosphere.commons.util.structure.tree.Node;
import com.musala.atmosphere.commons.util.structure.tree.Tree;

/**
 * Utility that generates xml compatible with android`s ui automator view hierarchy from {@link AccessibilityElement
 * accessibility elements} hierarchy.
 * 
 * @author vassil.angelov
 * 
 */
public class AccessibilityXmlSerializer {

    private static final String HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    private static final String OFFSET_STEP = "   ";

    private StringBuilder xmlBuilder;

    private StringBuilder offset;

    private boolean openedTag;

    /**
     * Produces XML representation of the provided {@link AccessibilityElement accessibility elements} hierarchy,
     * compatible with the Android`s AccessibilityNodeInfo XML dump (and the screen dump as it is the same thing).
     * 
     * @param hierarchy
     *        - the hierarchy of {@link AccessibilityElement elements} as a tree
     * @return the hierarchy as an XML document
     */
    public static String serialize(Tree<AccessibilityElement> hierarchy) {
        AccessibilityXmlSerializer serializer = new AccessibilityXmlSerializer();
        serializer.startTag("hierarchy");

        // if the hierarchy starts to contain information about the rotation this should be changed
        serializer.addAttribute("rotation", "0");
        serialize(hierarchy.getRoot(), serializer);
        serializer.endTag("hierarchy");

        return serializer.xmlBuilder.toString();
    }

    private AccessibilityXmlSerializer() {
        xmlBuilder = new StringBuilder();
        offset = new StringBuilder();

        xmlBuilder.append(HEADER);
        newLine();
    }

    private void addAttribute(String name, String value) {
        xmlBuilder.append(' ').append(name).append("=\"").append(value).append("\"");
    }

    private void newLine() {
        xmlBuilder.append(System.getProperty("line.separator"));
    }

    private void startTag(String tag) {
        if (openedTag) {
            offset.append(OFFSET_STEP);
            xmlBuilder.append(" >");
            newLine();
        }
        xmlBuilder.append(offset).append('<').append(tag);
        openedTag = true;
    }

    private void endTag(String tag) {
        if (openedTag) {
            // self-closing
            xmlBuilder.append(" />");
        } else {
            if (offset.length() >= OFFSET_STEP.length()) {
                offset.delete(0, OFFSET_STEP.length());
            }
            xmlBuilder.append(offset).append("</").append(tag).append(">");
        }
        newLine();
        openedTag = false;
    }

    private static void serialize(Node<AccessibilityElement> node, AccessibilityXmlSerializer xmlBuilder) {
        AccessibilityElement element = node.getData();

        // null or non-visible node
        if (element == null) {
            return;
        }

        xmlBuilder.startTag("node");

        xmlBuilder.addAttribute("index", Integer.toString(element.getIndex()));
        xmlBuilder.addAttribute("text", StringEscapeUtils.escapeXml10(safeCharSeqToString(element.getText())));
        xmlBuilder.addAttribute("class", StringEscapeUtils.escapeXml10(safeCharSeqToString(element.getClassName())));
        xmlBuilder.addAttribute("resource-id",
                                StringEscapeUtils.escapeXml10(safeCharSeqToString(element.getResourceId())));
        xmlBuilder.addAttribute("package", StringEscapeUtils.escapeXml10(safeCharSeqToString(element.getPackageName())));
        xmlBuilder.addAttribute("content-desc",
                                StringEscapeUtils.escapeXml10(safeCharSeqToString(element.getContentDescriptor())));
        xmlBuilder.addAttribute("checkable", Boolean.toString(element.isCheckable()));
        xmlBuilder.addAttribute("checked", Boolean.toString(element.isChecked()));
        xmlBuilder.addAttribute("clickable", Boolean.toString(element.isClickable()));
        xmlBuilder.addAttribute("enabled", Boolean.toString(element.isEnabled()));
        xmlBuilder.addAttribute("focusable", Boolean.toString(element.isFocusable()));
        xmlBuilder.addAttribute("focused", Boolean.toString(element.isFocused()));
        xmlBuilder.addAttribute("scrollable", Boolean.toString(element.isScrollable()));
        xmlBuilder.addAttribute("long-clickable", Boolean.toString(element.isLongClickable()));
        xmlBuilder.addAttribute("password", Boolean.toString(element.isPassword()));
        xmlBuilder.addAttribute("selected", Boolean.toString(element.isSelected()));
        xmlBuilder.addAttribute("bounds", boundsToString(element.getBounds()));

        for (Node<AccessibilityElement> child : node.getChildren()) {
            serialize(child, xmlBuilder);
        }

        xmlBuilder.endTag("node");
    }

    private static String boundsToString(Bounds bounds) {
        Point upperLeftCorner = bounds.getUpperLeftCorner();
        Point bottomRightCorner = bounds.getLowerRightCorner();
        return pointToString(upperLeftCorner).concat(pointToString(bottomRightCorner));
    }

    private static String pointToString(Point point) {
        return String.format("[%d,%d]", point.getX(), point.getY());
    }

    private static String safeCharSeqToString(CharSequence cs) {
        if (cs == null)
            return "";
        else {
            return stripInvalidXMLChars(cs);
        }
    }

    private static String stripInvalidXMLChars(CharSequence cs) {
        StringBuffer ret = new StringBuffer();
        char ch;
        /*
         * http://www.w3.org/TR/xml11/#charsets [#x1-#x8], [#xB-#xC], [#xE-#x1F], [#x7F-#x84], [#x86-#x9F],
         * [#xFDD0-#xFDDF], [#x1FFFE-#x1FFFF], [#x2FFFE-#x2FFFF], [#x3FFFE-#x3FFFF], [#x4FFFE-#x4FFFF],
         * [#x5FFFE-#x5FFFF], [#x6FFFE-#x6FFFF], [#x7FFFE-#x7FFFF], [#x8FFFE-#x8FFFF], [#x9FFFE-#x9FFFF],
         * [#xAFFFE-#xAFFFF], [#xBFFFE-#xBFFFF], [#xCFFFE-#xCFFFF], [#xDFFFE-#xDFFFF], [#xEFFFE-#xEFFFF],
         * [#xFFFFE-#xFFFFF], [#x10FFFE-#x10FFFF].
         */
        for (int i = 0; i < cs.length(); i++) {
            ch = cs.charAt(i);

            if ((ch >= 0x1 && ch <= 0x8) || (ch >= 0xB && ch <= 0xC) || (ch >= 0xE && ch <= 0x1F)
                    || (ch >= 0x7F && ch <= 0x84) || (ch >= 0x86 && ch <= 0x9f) || (ch >= 0xFDD0 && ch <= 0xFDDF)
                    || (ch >= 0x1FFFE && ch <= 0x1FFFF) || (ch >= 0x2FFFE && ch <= 0x2FFFF)
                    || (ch >= 0x3FFFE && ch <= 0x3FFFF) || (ch >= 0x4FFFE && ch <= 0x4FFFF)
                    || (ch >= 0x5FFFE && ch <= 0x5FFFF) || (ch >= 0x6FFFE && ch <= 0x6FFFF)
                    || (ch >= 0x7FFFE && ch <= 0x7FFFF) || (ch >= 0x8FFFE && ch <= 0x8FFFF)
                    || (ch >= 0x9FFFE && ch <= 0x9FFFF) || (ch >= 0xAFFFE && ch <= 0xAFFFF)
                    || (ch >= 0xBFFFE && ch <= 0xBFFFF) || (ch >= 0xCFFFE && ch <= 0xCFFFF)
                    || (ch >= 0xDFFFE && ch <= 0xDFFFF) || (ch >= 0xEFFFE && ch <= 0xEFFFF)
                    || (ch >= 0xFFFFE && ch <= 0xFFFFF) || (ch >= 0x10FFFE && ch <= 0x10FFFF))
                ret.append(".");
            else
                ret.append(ch);
        }
        return ret.toString();
    }
}
