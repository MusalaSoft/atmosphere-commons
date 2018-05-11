// This file is part of the ATMOSPHERE mobile testing framework.
// Copyright (C) 2016 MusalaSoft
//
// ATMOSPHERE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ATMOSPHERE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ATMOSPHERE.  If not, see <http://www.gnu.org/licenses/>.

package com.musala.atmosphere.commons.util.structure;

import java.util.Collection;

/**
 * Representation of a hierarchical structure of elements with single inheritance.
 * 
 * @author vassil.angelov
 *
 */
public interface Hierarchical {
    /**
     * Retrieve the {@link Hierarchical} parent element of this {@link Hierarchical} element.
     *
     * @param <T>
     *        - the element to retrieve the parent element of
     * @return - the parent {@link Hierarchical} element
     */
    <T extends Hierarchical> T getParent();

    /**
     * Retrieve the {@link Hierarchical} child elements of this {@link Hierarchical} element.
     * 
     * @param <T>
     *        - the element to retrieve the child elements of
     * @return - the list of the {@link Hierarchical} child elements
     */
    <T extends Hierarchical> Collection<T> getChildren();
}
