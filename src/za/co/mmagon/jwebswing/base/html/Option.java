/*
 * Copyright (C) 2014 GedMarc
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

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.OptionAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.DisplayObjectType;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.DataListChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.SelectChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryUI.selectmenu.JQUISelectMenuChildren;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;option&lt; tag defines an option in a select list.<p>
 * <p>
 * &gt;option&lt; elements go inside a &gt;select&lt; or &gt;datalist&lt; element. Browser Support Element<p>
 * &gt;option&lt; Yes Yes Yes Yes Yes Tips and Notes<p>
 * <p>
 * Note: The &gt;option&lt; tag can be used without any attributes, but you usually need the value attribute, which indicates what is sent to the server.<p>
 * <p>
 * Tip: If you have a long list of options, you can group related options with the &gt;optgroup&lt; tag.<p>
 *
 * @author GedMarc
 */
public class Option extends Component<NoChildren, OptionAttributes, NoFeatures, NoEvents, Option> implements DataListChildren, SelectChildren, NoNewLineBeforeClosingTag, NoNewLineForRawText, DisplayObjectType, JQUISelectMenuChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new Option tag
     * <p>
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
     * Sets the value of this option
     * <p>
     * @param value
     */
    public void setValue(String value)
    {
        addAttribute(OptionAttributes.Value, value);
    }

    /**
     * Sets the label of this option tag
     * <p>
     * @param label
     */
    public void setLabel(String label)
    {
        addAttribute(OptionAttributes.Label, label);
    }

    /**
     * Returns the label
     * <p>
     * @return
     */
    public String getLabel()
    {
        return getAttribute(OptionAttributes.Label);
    }

    /**
     * Returns the label
     * <p>
     * @return
     */
    public String getValue()
    {
        return getAttribute(OptionAttributes.Value);
    }
}
