
/*
JHeader, a Java library and tools for reading and editing EXIF headers.
Copyright (C) 2005 Matthew Baker

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.

For further information, please contact Matthew Baker on msb@safe-mail.net.
Project home page: www.sourceforge.net/jheader
*/
package net.sourceforge.jheader.enumerations;
import net.sourceforge.jheader.*;

import java.util.*;

public class Canon_EasyShootingMode extends EnumeratedTag
{
    public static final long FULL_AUTO = 0;
    public static final long MANUAL = 1;
    public static final long LANDSCAPE = 2;
    public static final long FAST_SHUTTER = 3;
    public static final long SLOW_SHUTTER = 4;
    public static final long NIGHT = 5;
    public static final long BANDW = 6;
    public static final long SEPIA = 7;
    public static final long PORTRAIT = 8;
    public static final long SPORTS = 9;
    public static final long MACRO = 10;
    public static final long PAN_FOCUS = 11;
    
    static private Object[] data = new Object[] {
	FULL_AUTO, "Full Auto",
	MANUAL, "Manual",
	LANDSCAPE, "Landscape",
	FAST_SHUTTER, "fast Shutter",
	SLOW_SHUTTER, "Slow Shutter",
	NIGHT, "Night",
	BANDW, "B&W",
	SEPIA, "Sepia",
	PORTRAIT, "Portrait",
	SPORTS, "Sports",
	MACRO, "Macro/Close Up",
	PAN_FOCUS, "Pan Focus"
    };

    static
    {
	populate(Canon_EasyShootingMode.class, data);
    }

    
    public Canon_EasyShootingMode(Long value) {super(value);}
    public Canon_EasyShootingMode(String value) throws TagFormatException {super(value);}
}
