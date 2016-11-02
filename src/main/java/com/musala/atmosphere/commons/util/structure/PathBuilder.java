package com.musala.atmosphere.commons.util.structure;

/**
 * Class that creates path of an element, that is part of a {@link Hierarchical} structure. The formed path is in the
 * general form of delimiter-separated element representations, omitting the root representation. For example
 * "/elem1/elem2" (where the delimiter is '/') is the formed path for elem2 which is at the 3rd level in the hierarchy.
 * 
 * @author vassil.angelov
 *
 * @param <T>
 *        - the {@link Hierarchical} structure that the path is build upon.
 */
public class PathBuilder<T extends Hierarchical> {

    /**
     * Interface for a class providing string representation of the elements that the {@link PathBuilder} will operate
     * upon.
     * 
     * @author vassil.angelov
     *
     * @param <T>
     *        - the {@link Hierarchical} that the {@link PathBuilder} operates upon.
     */
    public static interface Representer<T> {
        /**
         * Retrieves the path representation of a single element, that will be used by the {@link PathBuilder} to form a
         * path.
         * 
         * @param element
         *        - the element for which a representation is retrieved
         * @return the element`s string representation in a path
         */
        String getPathRepresentation(T element);
    }

    public static final String DEFAULT_DELIMITER = "/";

    public static final class DefaultRepresenter<T> implements Representer<T> {

        @Override
        public String getPathRepresentation(T element) {
            return element.toString();
        }

    }

    private String delimiter;

    private Representer<T> representer;

    /**
     * Creates a new {@link PathBuilder} with a default {@link Representer representer} (using {@link Object#toString()} )
     * {@link #DEFAULT_DELIMITER default delimiter}
     */
    public PathBuilder() {
        this(new DefaultRepresenter<T>());
    }

    /**
     * Creates a new {@link PathBuilder} with the given {@link Representer representer} and a {@link #DEFAULT_DELIMITER
     * default delimiter}
     * 
     * @param representer
     *        - the {@link Representer} to use in this {@link PathBuilder} when creating a path
     */
    public PathBuilder(Representer<T> representer) {
        setRepresenter(representer);
        delimiter = DEFAULT_DELIMITER;
    }

    /**
     * Creates a new {@link PathBuilder} with the given {@link Representer representer} and delimiter. If some of the
     * arguments are null, the corresponding default value is used.
     * 
     * @param representer
     *        - the {@link Representer} to use in this {@link PathBuilder} when creating a path
     * @param delimiter
     *        - the delimiter to be used when creating a path
     */
    public PathBuilder(Representer<T> representer, String delimiter) {
        this(representer);
        setDelimiter(delimiter);
    }

    /**
     * Sets the {@link Representer} associated with this {@link PathBuilder}.
     * 
     * @param representer
     *        - the {@link Representer} to use in this {@link PathBuilder} when creating a path
     */
    public final void setRepresenter(Representer<T> representer) {
        if (representer != null) {
            this.representer = representer;
        } else {
            this.representer = new DefaultRepresenter<T>();
        }
    }

    /**
     * Retrieve the path`s delimiter used between elements.
     * 
     * @return the currently used delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Sets the path`s delimiter to be used between elements.
     * 
     * @param delimeter
     *        - the new delimiter to use
     */
    public final void setDelimiter(String delimeter) {
        if (delimeter != null) {
            this.delimiter = delimeter;
        }
    }

    /**
     * Retrieve the path (as string) of the provided {@link Hierarchical}, using the current {@link Representer} and
     * delimiter.
     * 
     * @param element
     *        - the element to which to form a path
     * @return the path to the element in the hierarchy
     */
    public String getPath(T element) {
        StringBuilder sb = new StringBuilder();
        while (element.getParent() != null) {
            sb.insert(0, representer.getPathRepresentation(element)).insert(0, delimiter);
            element = element.getParent();
        }

        return sb.toString();
    }
}
