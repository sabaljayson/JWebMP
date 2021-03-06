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
package com.jwebmp.core.base.html.inputs;

import com.jwebmp.core.base.html.Input;
import com.jwebmp.core.base.html.attributes.InputFileTypeAttributes;
import com.jwebmp.core.base.html.attributes.InputTypes;

/**
 * @param <J>
 *
 * @author GedMarc
 */
public class InputFileType<J extends InputFileType<J>>
		extends Input<InputFileTypeAttributes, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new file type input
	 */
	public InputFileType()
	{
		super(InputTypes.File);

	}
}
