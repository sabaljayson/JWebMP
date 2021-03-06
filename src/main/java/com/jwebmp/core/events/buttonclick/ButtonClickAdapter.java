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
package com.jwebmp.core.events.buttonclick;

import com.jwebmp.core.Component;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.utilities.StaticStrings;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * This event is triggered when a button is clicked.
 *
 * @author Marc Magon
 */
@ComponentInformation(name = "Button Event",
		description = "Server Side Event for Button Click Event.",
		url = "https://www.armineasy.com/JWebSwing",
		wikiUrl = "https://github.com/GedMarc/JWebSwing/wiki")
public abstract class ButtonClickAdapter
		extends Event
		implements Serializable
{

	private static final long serialVersionUID = 1L;
	private ButtonClickDirective directive;

	/**
	 * This event is triggered when a button is clicked.
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public ButtonClickAdapter(Component component)
	{
		super(EventTypes.buttonClickEvent, component);
	}

	/**
	 * The method that is fired on call
	 *
	 * @param ajaxObject
	 * 		The component that made the call
	 * @param ajaxReceiver
	 * 		The Response Object Being Returned
	 */
	@Override
	public void fireEvent(AjaxCall ajaxObject, AjaxResponse ajaxReceiver)
	{
		onButtonClick(ajaxObject, ajaxReceiver);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	@Override
	public void preConfigure()
	{
		if (getComponent() != null)
		{
			getComponent().addAttribute(AngularAttributes.ngButtonClick,
			                            StaticStrings.STRING_ANGULAR_EVENT_START + renderVariables() + StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON);
		}

		super.preConfigure();
	}

	/**
	 * Triggers on Activation
	 * <p>
	 *
	 * @param ajaxObject
	 * 		The physical AJAX call
	 * @param ajaxReceiver
	 * 		The physical Ajax Receiver
	 */
	public abstract void onButtonClick(AjaxCall ajaxObject, AjaxResponse ajaxReceiver);

	/**
	 * Returns this directive
	 *
	 * @return
	 */
	@NotNull
	public ButtonClickDirective getDirective()
	{
		if (directive == null)
		{
			setDirective(new ButtonClickDirective());
		}
		return directive;
	}

	/**
	 * Sets this directive
	 *
	 * @param directive
	 */
	public void setDirective(ButtonClickDirective directive)
	{
		this.directive = directive;
	}
}
