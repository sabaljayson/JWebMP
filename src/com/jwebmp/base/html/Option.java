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
import com.jwebmp.base.html.attributes.OptionAttributes;
import com.jwebmp.base.html.interfaces.*;
import com.jwebmp.base.html.interfaces.children.DataListChildren;
import com.jwebmp.base.html.interfaces.children.SelectChildren;
import com.jwebmp.base.html.interfaces.events.NoEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;option&lt; tag defines an option in a select list.<p>
 * <p>
 * &gt;option&lt; elements go inside a &gt;select&lt; or &gt;datalist&lt; element. Browser Support Element<p>
 * &gt;option&lt; Yes Yes Yes Yes Yes Tips and Notes<p>
 * <p>
 * Note: The &gt;option&lt; tag can be used without any attributes, but you usually need the value attribute, which indicates what is sent
 * to the server.<p>
 * <p>
 * Tip: If you have a long list of options, you can group related options with the &gt;optgroup&lt; tag.<p>
 *
 * @param <J>
 *
 * @author GedMarc
 */
public class Option<J extends Option<J>>
		extends Component<GlobalChildren, OptionAttributes, NoFeatures, NoEvents, J>
		implements DataListChildren, SelectChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, DisplayObjectType
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new Option tag
	 * <p>
	 *
	 * @param optionValue
	 */
	public Option(String optionValue)
	{
		super(ComponentTypes.Option);
		setInlineClosingTag(false);
		addAttribute(OptionAttributes.Value, optionValue);
		addAttribute(OptionAttributes.Label, optionValue);
		setText(optionValue);
	}

	/**
	 * Returns the label
	 * <p>
	 *
	 * @return
	 */
	public String getLabel()
	{
		return getAttribute(OptionAttributes.Label);
	}

	/**
	 * Sets the label of this option tag
	 * <p>
	 *
	 * @param label
	 *
	 * @return
	 */
	public J setLabel(String label)
	{
		addAttribute(OptionAttributes.Label, label);
		return (J) this;
	}

	/**
	 * Returns the label
	 * <p>
	 *
	 * @return
	 */
	public String getValue()
	{
		return getAttribute(OptionAttributes.Value);
	}

	/**
	 * Sets the value of this option
	 * <p>
	 *
	 * @param value
	 *
	 * @return
	 */
	public J setValue(String value)
	{
		addAttribute(OptionAttributes.Value, value);
		return (J) this;
	}
}
