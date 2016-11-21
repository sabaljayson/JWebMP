/*
 * Copyright (C) 2016 ged_m
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
package za.co.mmagon.jwebswing.base;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.base.interfaces.*;
import za.co.mmagon.jwebswing.base.references.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.enumerations.*;

/**
 * Enables Events in the Component Tree Hierarchy
 *
 * @author GedMarc
 * @param <F> The Features TYpe
 * @param <E> The Events Type
 * @param <J> This Type
 *
 * @since 23 Apr 2013
 * @version 2.0
 */
public class ComponentEventBase<F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentBase>
        extends ComponentFeatureBase<F, J> implements IComponentEventBase<E, J>
{

    /**
     * Logger for the Component
     */
    @JsonIgnore
    private static final org.apache.log4j.Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("Component");
    /**
     * Serial Version for all Components and their compatibility
     *
     * @version 2 Version 2 - Updated CSS Library and References
     */
    @JsonIgnore
    private static final long serialVersionUID = 2l;

    /**
     * The event of this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    /**
     * A list of all events
     */
    private ArrayList<E> events;

    /**
     * The actual event type
     */
    @JsonIgnore
    private EventTypes eventType;

    /**
     * Sets if this component should be sent on the next call back
     */
    private boolean touched = false;

    /**
     * Constructs a new event for the given component type
     *
     * @param componentType
     */
    public ComponentEventBase(ComponentTypes componentType)
    {
        this(EventTypes.undefined, componentType);
    }

    /**
     * Constructs a new event type for component type
     *
     * @param eventType     The Event Type being applied
     * @param componentType The component type of this component
     */
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
    public IComponentEventBase asEventBase()
    {
        return (ComponentEventBase) this;
    }

    /**
     * Gets all registered events
     * <p>
     * @return A Hash Map containing the event type and the events associated with it
     */
    @Override
    public List<E> getEvents()
    {
        if (events == null)
        {
            events = new ArrayList<>();
        }
        return events;
    }

    /**
     * Adds an event to this object
     * <p>
     * @param event The Event to add
     */
    @Override
    public J addEvent(E event)
    {
        if (!ComponentEventBase.class.cast(event).getComponentType().equals(ComponentTypes.Event))
        {
            LOG.warn("Tried to add a non event to the event collection");
        }
        else if (!getEvents().contains(event))
        {
            getEvents().add(event);
        }
        if (this instanceof ComponentHierarchyBase)
        {
            ComponentHierarchyBase.class.cast(this).getPage().setAngularEnabled(true);
        }
        return (J) this;
    }

    /**
     * Events are types of feature that have server side support. These are referenced using the Ajax Receiver.
     * <p>
     * @param event The event to be removed
     * <p>
     * @return currently false
     * <p>
     */
    @Override
    public J removeEvent(E event)
    {
        getEvents().remove(event);
        return (J) this;
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
            getEvents().stream().forEach(event
                    ->
            {
                if (!ComponentEventBase.class.cast(event).isConfigured())
                {
                    ComponentEventBase.class.cast(event).preConfigure();
                    assignFunctionsToComponent();
                }
            });
        }
        super.preConfigure();

    }

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    @Override
    public List<JavascriptReference> getJavascriptReferencesAll()
    {
        List<JavascriptReference> allJs = super.getJavascriptReferencesAll();
        getEvents().stream().forEach(feature
                ->
        {
            for (Iterator<JavascriptReference> it = ComponentEventBase.class.cast(feature).getJavascriptReferencesAll().iterator(); it.hasNext();)
            {
                JavascriptReference js = it.next();
                if (!allJs.contains(js))
                {
                    allJs.add(js);
                }
            }
        });
        return allJs;
    }

    /**
     * Adds in the JavaScript References for the Features
     *
     * @return
     */
    @Override
    public List<CSSReference> getCssReferencesAll()
    {
        List<CSSReference> allCss = super.getCssReferencesAll();
        getEvents().stream().forEach((E feature)
                ->
        {
            for (Iterator<CSSReference> it = ComponentEventBase.class.cast(feature).getCssReferencesAll().iterator(); it.hasNext();)
            {
                CSSReference css = it.next();
                if (!allCss.contains(css))
                {
                    allCss.add(css);
                }
            }
        });
        return allCss;
    }

    /**
     * In case need to put extra logic here
     *
     * @return
     */
    @Override
    public List<StringBuilder> getQueriesAll()
    {
        return super.getQueriesAll();
    }

    /**
     * Returns the event type for this event
     *
     * @return
     */
    @JsonProperty("eventType")
    @Override
    public EventTypes getEventTypes()
    {
        if (this.eventType == EventTypes.undefined)
        {
            return null;
        }
        else
        {
            return this.eventType;
        }
    }

    /**
     * Returns if this component is needing refresh on next Ajax call
     * <p>
     * @return true if going to be touched
     */
    @Override
    public boolean isTouched()
    {
        return touched;
    }

    /**
     * Mark this component as needing refresh to the Ajax Controller
     * <p>
     * @param touched Whether or not to update on next ajax call
     *
     * @return
     */
    @Override
    public J setTouched(boolean touched)
    {
        this.touched = touched;
        return (J) this;
    }

    /**
     * Returns all the events associated with the given type
     *
     * @param eventType
     *
     * @return
     */
    @Override
    public ArrayList<ComponentEventBase> getEventsFor(EventTypes eventType)
    {
        ArrayList<ComponentEventBase> output = new ArrayList<>();
        for (Iterator<E> iterator = getEvents().iterator(); iterator.hasNext();)
        {
            ComponentEventBase next = (ComponentEventBase) iterator.next();
            if (next.getEventTypes().equals(eventType))
            {
                output.add(next);
            }
        }
        return output;
    }

    /**
     * Returns an event with the given Id
     *
     * @param eventId
     *
     * @return
     */
    public ComponentEventBase getEvent(String eventId)
    {
        for (Iterator<E> iterator = getEvents().iterator(); iterator.hasNext();)
        {
            ComponentEventBase next = (ComponentEventBase) iterator.next();
            if (next.getID().equals(eventId))
            {
                return next;
            }
        }
        return null;
    }

    /**
     * Sets this component and all its children components tiny
     *
     * @param tiny
     *
     * @return
     */
    @Override
    public J setTiny(boolean tiny)
    {

        for (Iterator<E> iterator = getEvents().iterator(); iterator.hasNext();)
        {
            ComponentEventBase next = (ComponentEventBase) iterator.next();
            next.setTiny(tiny);
        }
        return (J) super.setTiny(tiny);
    }

    /**
     * Sets the event type of an event
     *
     * @param eventType
     */
    @Override
    public void setEventType(EventTypes eventType)
    {
        this.eventType = eventType;
    }

    /**
     * Clones the component and all its events
     *
     * @return
     */
    @Override
    public J cloneComponent()
    {
        ComponentEventBase cloned = (ComponentEventBase) super.cloneComponent();

        cloned.events = new ArrayList();
        cloned.events.addAll(getEvents());

        return (J) cloned;
    }
}
