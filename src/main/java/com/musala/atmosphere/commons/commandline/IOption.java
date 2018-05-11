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

package com.musala.atmosphere.commons.commandline;

public interface IOption {
    /**
     * Gets the {@link CommandLineOption Command Line Option} for this {@link IOption}.
     * 
     * @return the {@link CommandLineOption Command Line Option} for this {@link IOption}
     */
    public CommandLineOption getOption();

    /**
     * Gets the {@link CommandLineArgument Command Line Argument} for this {@link IOption}.
     * 
     * @return the {@link CommandLineArgument Command Line Argument} for this {@link IOption}
     */
    public CommandLineArgument getArgument();;

    /**
     * Checks whether this {@link IOption} has a {@link CommandLineArgument Command Line Argument}.
     * 
     * @return <b>true</b> if this {@link IOption} has a {@link CommandLineArgument Command Line Argument}; <b>false</b>
     *         otherwise
     */
    public boolean hasArgument();

}
