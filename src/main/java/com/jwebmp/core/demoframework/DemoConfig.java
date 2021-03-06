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
package com.jwebmp.core.demoframework;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.lang.annotation.*;

/**
 * @author Marc Magon
 * @since 04 Apr 2017
 */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE, ElementType.PACKAGE, ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DemoConfig
{

	/**
	 * A class that can be instantiated with Guice that constructs a demonstration page
	 *
	 * @return
	 */
	Class<? extends DemoPanel> demoPanel();

	/**
	 * A class that can be instantiated
	 *
	 * @return
	 */
	Class<? extends JavaScriptPart> optionsObject();

	/**
	 * If the demo allows for CSS Entries
	 *
	 * @return
	 */
	boolean cssCapable() default true;

}
