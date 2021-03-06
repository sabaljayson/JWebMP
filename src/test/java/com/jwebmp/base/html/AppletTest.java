/*
 * Copyright (C) 2017 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.core.base.html;

import com.jwebmp.core.base.html.attributes.AppletAttributes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ged_m
 */
public class AppletTest
{

	public AppletTest()
	{
	}

	@Test
	public void testApplet()
	{
		Applet applet = new Applet();
		applet.setID("id");
		System.out.println(applet.toString(true));
		Assertions.assertEquals("<applet id=\"id\"></applet>", applet.toString(true));

		applet.addAttribute(AppletAttributes.Object, "applet object");
		applet.addAttribute(AppletAttributes.Align, "left");
		applet.addAttribute(AppletAttributes.CodeBase, "classFile");

		System.out.println(applet.toString(true));
		Assertions.assertEquals("<applet align=\"left\" codebase=\"classFile\" id=\"id\" object=\"applet object\"></applet>", applet.toString(true));
	}

}
