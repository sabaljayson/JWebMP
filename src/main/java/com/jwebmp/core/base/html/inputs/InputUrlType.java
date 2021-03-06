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
import com.jwebmp.core.base.html.attributes.InputTextAttributes;
import com.jwebmp.core.base.html.attributes.InputTypes;
import com.jwebmp.core.base.html.interfaces.children.FormChildren;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

/**
 * @param <J>
 *
 * @author GedMarc
 */
public class InputUrlType<J extends InputUrlType<J>>
		extends Input<InputTextAttributes, J>
		implements ParagraphChildren<IComponentHierarchyBase, J>, FormChildren<IComponentHierarchyBase, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a search type input field
	 */
	public InputUrlType()
	{
		super(InputTypes.Url);
	}
}
