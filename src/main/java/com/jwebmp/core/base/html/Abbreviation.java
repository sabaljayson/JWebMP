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

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.AbbreviationAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.AbbreviationChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The &lt;abbr&gt; tag indicates an abbreviation or an acronym, like "WWW" or "NATO".
 * <p>
 * By marking up abbreviations you can give useful information to browsers, spell checkers, translation systems and search-engine indexers. Browser Support Element &lt;abbr&gt; Yes
 * Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: The global title attribute can be used in the &gt;abbr&lt; tag to show the full version of the abbreviation/acronym when you mouse over the &lt;abbr&gt; element.
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * NONE. Global Attributes
 * <p>
 * The &lt;abbr&gt; tag also supports the Global Attributes in HTML. Event Attributes
 * <p>
 * The &lt;abbr&gt; tag also supports the Event Attributes in HTML.
 * <p>
 * Default CSS Settings
 * <p>
 * None.
 * <p>
 *
 * @param <J>
 *
 * @author MMagon
 * 		<p>
 * @since Forever
 */
public class Abbreviation<J extends Abbreviation<J>>
		extends Component<AbbreviationChildren, AbbreviationAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoNewLineBeforeClosingTag, NoNewLineForRawText
{
	/**
	 * Serial Version for all Components and their compatibility
	 */
	private static final long serialVersionUID = 1l;

	/**
	 * Constructs a new Abbreviation Tag
	 */
	public Abbreviation()
	{
		super(ComponentTypes.Abbreviation.getComponentTag(), ComponentTypes.Abbreviation);
	}
}
