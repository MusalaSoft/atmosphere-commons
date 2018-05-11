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

package com.musala.atmosphere.commons.gesture;

import java.util.LinkedList;

/**
 * Class that represents a single finger gesture. Contains a sequence of {@link Anchor Anchor} points that the current
 * pointer will traverse.
 * 
 * @author georgi.gaydarov
 * 
 */
public class Timeline extends LinkedList<Anchor> {
    private static final long serialVersionUID = 4037933611110545542L;
}
