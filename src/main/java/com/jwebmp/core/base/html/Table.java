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
import com.jwebmp.core.base.html.attributes.TableAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.children.TableChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

import javax.validation.constraints.NotNull;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The table tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The table tag defines an HTML table.<p>
 * <p>
 * An HTML table consists of the table element and one or more tr, th, and td elements.<p>
 * <p>
 * The tr element defines a table row, the th element defines a table header, and the td element defines a table cell.<p>
 * <p>
 * A more complex HTML table may also include caption, col, colgroup, thead, tfoot, and tbody elements. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 only supports the "border" attribute, and its value can be "1" or ""
 * .<p>
 * <p>
 *
 * @param <J>
 *
 * @author Marc Magon
 */
public class Table<J extends Table<J>>
		extends Component<TableChildren, TableAttributes, GlobalFeatures, GlobalEvents, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an Empty Table
	 */
	public Table()
	{
		super(ComponentTypes.Table.getComponentTag(), ComponentTypes.Table, false);
	}

	/**
	 * Returns the cell spacing
	 * <p>
	 *
	 * @return
	 */
	public int getCellSpacing()
	{
		return getAttribute(TableAttributes.CellSpacing, 0);
	}

	/**
	 * Sets the cell spacing
	 * <p>
	 *
	 * @param cellSpacing
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCellSpacing(int cellSpacing)
	{
		addAttribute(TableAttributes.CellSpacing, cellSpacing);
		return (J) this;
	}

	/**
	 * Returns the cell padding
	 * <p>
	 *
	 * @return
	 */
	public int getCellPadding()
	{
		return getAttribute(TableAttributes.CellSpacing, 0);
	}

	/**
	 * Sets the cell padding
	 * <p>
	 *
	 * @param cellPadding
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCellPadding(int cellPadding)
	{
		addAttribute(TableAttributes.CellPadding, cellPadding);
		return (J) this;
	}

}
