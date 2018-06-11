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
import com.jwebmp.base.html.interfaces.NoFeatures;
import com.jwebmp.base.html.interfaces.events.NoEvents;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;output&gt; tag represents the result of a calculation (like one performed by a script). Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element. Element<p>
 * &lt;output&gt; 10.0 Not supported 4.0 5.1 11.0 Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;output&gt; tag is new in HTML5.<p>
 * <p>
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * @since Mar 1, 2015
 * 		<p>
 * 		No support in I.E. - can't be used, the results are not compatible - may make as a server function but the point is client side.
 */
public class Output<J extends Output<J>>
		extends Component<GlobalChildren, NoAttributes, NoFeatures, NoEvents, J>
{

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public Output()
	{
		super(ComponentTypes.Output);
	}
}
