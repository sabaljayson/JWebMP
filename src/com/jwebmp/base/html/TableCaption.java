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
package com.jwebmp.base.html;

import com.jwebmp.Component;
import com.jwebmp.base.html.attributes.NoAttributes;
import com.jwebmp.base.html.interfaces.GlobalChildren;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.base.html.interfaces.children.TableChildren;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;caption&gt; tag defines a table caption.
 * <p>
 * The &lt;caption&gt; tag must be inserted immediately after the table tag.
 * <p>
 * Note: You can specify only one caption per table.
 * <p>
 * Tip: By default, a table caption will be center-aligned above a table. However, the CSS properties text-align and caption-side can be used to align and place the caption.
 * Browser Support Element
 * &lt;caption&gt; Yes Yes Yes Yes Yes
 * <p>
 * Differences Between HTML 4.01 and HTML5
 * <p>
 * The align attribute is removed from HTML5.
 * <p>
 *
 * @param <J>
 *
 * @author Marc Magon
 * @since forever
 */
public class TableCaption<J extends TableCaption<J>>
		extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements TableChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new table caption
	 * <p>
	 *
	 * @param caption
	 * 		The caption
	 */
	public TableCaption(String caption)
	{
		super(ComponentTypes.TableCaption);
		setText(caption);
	}
}
