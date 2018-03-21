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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.utilities.TextUtilities;

/**
 * Defines a basic comment line
 *
 * @author GedMarc
 */
public class Comment<J extends Comment<J>>
		extends ComponentHierarchyBase<NoChildren, NoAttributes, NoFeatures, NoEvents, J>
		implements HtmlChildren, HeadChildren, ImageMapChildren, BodyChildren, GlobalChildren, PageChildren
{

	private static final long serialVersionUID = 1L;

	/**
	 * Adds the specified comment in a comment block for HTML
	 * <p>
	 *
	 * @param comment
	 */
	public Comment(String comment)
	{
		super(ComponentTypes.Comment);
		setText(comment);
	}

	/**
	 * Over-rides the render HTML tag
	 * <p>
	 *
	 * @param tabCount
	 * 		The specified tab count
	 * 		<p>
	 *
	 * @return A customized string for comments
	 */
	@Override
	protected StringBuilder renderHTML(int tabCount)
	{
		if (getText(0).length() == 0)
		{
			return new StringBuilder();
		}
		return !isTiny() ? new StringBuilder(TextUtilities.getTabString(tabCount) + "<!-- " + getText(0) + " -->") : new StringBuilder();
	}
}
