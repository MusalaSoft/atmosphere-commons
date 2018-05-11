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

import com.musala.atmosphere.commons.exceptions.ArgumentParseException;

/**
 * An interface parser for {@link IOption IOptions} passed to the command line.
 * 
 * @see IOption
 * @author yordan.petrov
 * 
 */
public interface IArgumentParser {
    /**
     * Parses the string value of the given {@link IOption}.
     * 
     * @param iOption
     *        - the {@link IOption} the passed string value belongs to
     * @param value
     *        - the value of the {@link IOption option}
     * @return the parsed value of the given {@link IOption option}
     * @throws ArgumentParseException
     *         thrown when the argument parsing fails for some reason
     */
    public abstract Object getOption(IOption iOption, String value) throws ArgumentParseException;
}
