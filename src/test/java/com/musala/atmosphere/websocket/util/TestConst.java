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

package com.musala.atmosphere.websocket.util;

class TestConst {
    protected static final Long LONG_RESPONSE_DATA = 1L << 60;

    protected static final int DEVICE_API_LEVEL = 23;

    public static final Integer RESOLUTION_X = 1280;

    public static final Integer RESOLUTION_Y = 720;

    protected static final String TEST_PATH = "root/test/path";

    public static final Integer INTEGER_RESPONSE_DATA = 1 << 30;

    public static final float DELTA = 0.001F;

    public static final float FLOAT_DATA = 1 / (float) Math.pow(10, 45);

    public static final Double DOUBLE_DATA = 1 / Math.pow(10, 45);

    public static final String STRING_DATA = "string_data";
}
