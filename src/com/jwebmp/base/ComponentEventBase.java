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
package com.jwebmp.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.interfaces.IComponentEventBase;
import com.jwebmp.base.references.CSSReference;
import com.jwebmp.base.references.JavascriptReference;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.logger.LogFactory;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;

import static com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes.*;

/**
 * Enables Events in the Component Tree Hierarchy
 *
 * @param <F>
 * 		The Features TYpe
 * @param <E>
 * 		The Events Type
 * @param <J>
 * 		This Type
 *
 * @author GedMarc
 * @version 2.0
 * @since 23 Apr 2013
 */
public class ComponentEventBase<F extends GlobalFeatures & Serializable, E extends GlobalEvents, J extends ComponentEventBase<F, E, J>>
		extends ComponentFeatureBase<F, J>
		implements IComponentEventBase<E, J>
{

	/**
	 * Logger for the Component
	 */
	@JsonIgnore
	private static final java.util.logging.Logger LOG = LogFactory.getInstance()
	                                                              .getLogger("ComponentEventBase");
	/**
	 * Serial Version for all Components and their compatibility
	 *
	 * @version 2 Version 2 - Updated CSS Library and References
	 */
	@JsonIgnore
	private static final long serialVersionUID = 2L;

	/**
	 * The event of this component
	 */
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<E> events;

	/**
	 * The actual event type
	 */
	@JsonIgnore
	private EventTypes eventType;

	/**
	 * Constructs a new event for the given component type
	 *
	 * @param componentType
	 */
	public ComponentEventBase(ComponentTypes componentType)
	{
		this(undefined, componentType);
	}

	/**
	 * Constructs a new event type for component type
	 *
	 * @param eventType
	 * 		The Event Type being applied
	 * @param componentType
	 * 		The component type of this component
	 */
	@SuppressWarnings("all")
	public ComponentEventBase(EventTypes eventType, ComponentTypes componentType)
	{
		super(componentType);
		this.eventType = eventType;
	}

	/**
	 * Returns an Attribute Base interface of this component
	 *
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	public IComponentEventBase asEventBase()
	{
		return this;
	}

	/**
	 * Adds an event to this object
	 * <p>
	 *
	 * @param event
	 * 		The Event to add
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J addEvent(@NotNull E event)
	{
		if (!ComponentEventBase.class.cast(event)
		                             .getComponentType()
		                             .equals(ComponentTypes.Event))
		{
			LOG.log(Level.WARNING, "Tried to add a non event to the event collection");
		}
		else
		{
			getEvents().add(event);
		}
		return (J) this;
	}

	/**
	 * Returns the event type for this event
	 *
	 * @return
	 */
	@Override
	@NotNull
	@JsonIgnore
	public EventTypes getEventTypes()
	{
		if (eventType == undefined)
		{
			return undefined;
		}
		else
		{
			return eventType;
		}
	}

	/**
	 * Gets all registered events
	 * <p>
	 *
	 * @return A Hash Map containing the event type and the events associated with it
	 */
	@Override
	@NotNull
	public Set<E> getEvents()
	{
		if (events == null)
		{
			events = new LinkedHashSet<>();
		}
		return events;
	}

	/**
	 * Returns all the events associated with the given type
	 *
	 * @param eventType
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<ComponentEventBase> getEventsFor(@NotNull EventTypes eventType)
	{
		Set<ComponentEventBase> output = new LinkedHashSet<>();
		for (E e : getEvents())
		{
			ComponentEventBase next = (ComponentEventBase) e;
			if (next.getEventTypes()
			        .equals(eventType))
			{
				output.add(next);
			}
		}
		return output;
	}

	/**
	 * Events are types of feature that have server side support. These are referenced using the Ajax Receiver.
	 * <p>
	 *
	 * @param event
	 * 		The event to be removed
	 * 		<p>
	 *
	 * @return currently false
	 * 		<p>
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J removeEvent(@Nullable E event)
	{
		getEvents().remove(event);
		return (J) this;
	}

	/**
	 * Sets the event type of an event
	 *
	 * @param eventType
	 *
	 * @return
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J setEventType(@NotNull EventTypes eventType)
	{
		this.eventType = eventType;
		return (J) this;
	}

	/**
	 * Returns an event with the given Id
	 *
	 * @param eventId
	 *
	 * @return
	 */
	@Override
	@Nullable
	public ComponentEventBase findEvent(@NotNull String eventId)
	{
		for (E e : getEvents())
		{
			ComponentEventBase next = (ComponentEventBase) e;
			if (next.getID()
			        .equals(eventId))
			{
				return next;
			}
		}
		return null;
	}

	/**
	 * Returns the event type for this event
	 *
	 * @return
	 */
	@JsonProperty("eventType")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@Nullable
	@SuppressWarnings("unused")
	private EventTypes getEventTypesJSON()
	{
		if (eventType == undefined)
		{
			return null;
		}
		else
		{
			return eventType;
		}
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<CSSReference> getCssReferencesAll()
	{
		Set<CSSReference> allCss = super.getCssReferencesAll();
		getEvents().forEach((E feature) ->
		                    {
			                    for (Object css : ComponentEventBase.class.cast(feature)
			                                                              .getCssReferencesAll())
			                    {
				                    allCss.add(CSSReference.class.cast(css));
			                    }
		                    });
		return allCss;
	}

	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Set<JavascriptReference> getJavascriptReferencesAll()
	{
		Set<JavascriptReference> allJs = super.getJavascriptReferencesAll();
		getEvents().forEach(feature ->
		                    {
			                    for (Object js : ComponentEventBase.class.cast(feature)
			                                                             .getJavascriptReferencesAll())
			                    {
				                    allJs.add(JavascriptReference.class.cast(js));
			                    }
		                    });
		return allJs;
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
	public void destroy()
	{
		if (events != null)
		{
			events.clear();
			events = null;
		}
		super.destroy();
	}

	/**
	 * Sets this component and all its children components tiny
	 *
	 * @param tiny
	 *
	 * @return
	 */
	@Override
	@NotNull
	public J setTiny(boolean tiny)
	{
		for (E e : getEvents())
		{
			ComponentEventBase next = (ComponentEventBase) e;
			next.setTiny(tiny);
		}
		return super.setTiny(tiny);
	}

	/**
	 * Run all Assign Function To Components and Pre Configures for all Events
	 */
	@Override
	public void preConfigure()
	{
		if (!isInitialized())
		{
			init();
		}
		if (!isConfigured())
		{
			getEvents().forEach(event ->
			                    {
				                    ComponentEventBase.class.cast(event)
				                                            .preConfigure();
				                    assignFunctionsToComponent();
			                    });
		}
		super.preConfigure();

	}

	/**
	 * Clones the component and all its events
	 *
	 * @return
	 */
	@Override
	@NotNull
	@SuppressWarnings("unchecked")
	public J cloneComponent()
	{
		ComponentEventBase cloned = super.cloneComponent();
		cloned.events = new LinkedHashSet();
		cloned.events.addAll(getEvents());
		return (J) cloned;
	}


}
