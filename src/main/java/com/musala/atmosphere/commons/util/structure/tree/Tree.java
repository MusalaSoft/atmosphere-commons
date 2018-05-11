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

package com.musala.atmosphere.commons.util.structure.tree;

import java.io.Serializable;

/**
 * A serializable tree representation. The tree is represented by a generic root {@link Node node}.
 * 
 * @author yordan.petrov
 * 
 * @param <T>
 *        - a class that specifies the generic data of the node
 */
public class Tree<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -6345462724031897482L;

    protected Node<T> root;

    /**
     * Initializes a {@link Tree tree} by a given root data. The data will be used to initialize a root {@link Node
     * node}.
     * 
     * @param rootData
     *        - data for the root {@link Node node}
     */
    public Tree(T rootData) {
        root = new Node<T>(rootData);
    }

    /**
     * Initializes a {@link Tree tree} by a given root {@link Node node}.
     * 
     * @param root
     *        - the root {@link Node node} of the tree.
     */
    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
