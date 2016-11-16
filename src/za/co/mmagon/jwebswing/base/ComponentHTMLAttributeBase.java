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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoClassAttribute;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.ComponentHTMLBase;
import za.co.mmagon.jwebswing.base.interfaces.IComponentHTMLAttributeBase;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.utilities.EnumerationUtils;

/**
 * Denotes a component that has a tag. By default these can add events, features, variables etc
 *
 * @param <A> The allowed local attributes (Separate from Global Attributes)
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
public class ComponentHTMLAttributeBase<A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentBase>
        extends ComponentHTMLBase<F, E, J> implements IComponentHTMLAttributeBase<A, J>
{

    /**
     * Serial Version for all Components and their compatibility
     *
     * @version 2 Version 2 - Updated CSS Library and References
     */
    @JsonIgnore
    private static final long serialVersionUID = 1l; 

    /**
     * Logger for the Component
     */
    @JsonIgnore
    private static final org.apache.log4j.Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("ComponentAttributes");

    /**
     * The SORTED global attribute collection of this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TreeMap<GlobalAttributes, String> attributesGlobal;
    /**
     * The generic list of the attributes that are local to this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TreeMap<A, String> attributesLocal;
    /**
     * The custom list of the attributes that are local to this component
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private TreeMap<String, String> attributesCustom;

    /**
     * The list of class names for this object
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<String> classes;
    /**
     * Specifies if this component should render an ID attribute
     */
    @JsonIgnore
    private boolean renderIDAttibute = true;

    /**
     * Construct a new component that will render a tag
     *
     * @param componentType
     */
    public ComponentHTMLAttributeBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns an Attribute Base interface of this component
     *
     * @return
     */
    public IComponentHTMLAttributeBase asAttributeBase()
    {
        return (ComponentHTMLAttributeBase) this;
    }

    /**
     * Returns the list of global attributes currently assigned
     *
     * @return
     */
    protected Map<GlobalAttributes, String> getAttributesGlobal()
    {
        if (attributesGlobal == null)
        {
            attributesGlobal = new TreeMap<>();
        }
        return attributesGlobal;
    }

    /**
     * Returns the local set of attributes currently assigned
     *
     * @return
     */
    protected Map<A, String> getAttributes()
    {
        if (attributesLocal == null)
        {
            attributesLocal = new TreeMap<>();
        }
        return attributesLocal;
    }

    /**
     * Returns the list of global attributes currently assigned
     *
     * @return
     */
    protected Map<String, String> getAttributesCustom()
    {
        if (attributesCustom == null)
        {
            attributesCustom = new TreeMap<>();
        }
        return attributesCustom;
    }

    /**
     * Adds the ID attribute to the component
     */
    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            if (isRenderIDAttibute())
            {
                addAttribute(GlobalAttributes.ID, getID());
            }
            else
            {
                getAttributesGlobal().remove(GlobalAttributes.ID);
            }
        }
        super.preConfigure();
    }

    /**
     * Returns a complete collection of attributes
     *
     * @return
     */
    @Override
    public Map<Enum, String> getAttributesAll()
    {
        HashMap<Enum, String> allAttributes = new HashMap<>();

        allAttributes.putAll(getAttributesGlobal());
        allAttributes.putAll(getAttributes());

        return allAttributes;
    }

    /**
     * Renders all the Attribute HTML. The All Custom attributes can contain any value=parameter pair
     * <p>
     * @see GlobalAttributes
     * @return The attribute HTML
     */
    @Override
    protected StringBuilder renderAttributes(StringBuilder sb)
    {
        StringBuilder sbClasses = renderClasses();
        if (sbClasses.length() > 0 && !(this instanceof NoClassAttribute))
        {
            getAttributesGlobal().put(GlobalAttributes.Class, sbClasses.toString());
        }
        Map<Enum, String> allAttributes = getAttributesAll();
        ArrayList<Enum> attrib = new ArrayList<>();
        allAttributes.keySet().stream().forEach(attr
                ->
        {
            attrib.add(attr);
        });
        attrib.sort(EnumerationUtils.EnumNameSorter);
        if (!attrib.isEmpty())
        {
            sb.append(" ");
        }
        attrib.stream().forEach((attribute)
                ->
        {
            String value = allAttributes.get(attribute);
            boolean isKey = AttributeDefinitions.class.cast(attribute).isKeyword();
            sb.append(attribute.toString().toLowerCase());
            if (!isKey)
            {
                sb.append("=\"").append(value).append("\" ");
            }
            else
            {
                sb.append(" ");
            }
        });
        if (!attrib.isEmpty())
        {
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }
        return sb;
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     * @param attribute The Global Attribute to apply
     * @param bop       Place Holder for return type boolean
     * <p>
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final Boolean getAttribute(GlobalAttributes attribute, Boolean bop)
    {
        return Boolean.parseBoolean(getAttributesGlobal().get(attribute));
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     * @param attribute The Global Attribute to apply
     * @param bop       Place Holder for return type integer
     * <p>
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final Integer getAttribute(GlobalAttributes attribute, Integer bop)
    {
        try
        {
            return Integer.parseInt(getAttributesGlobal().get(attribute));
        }
        catch (NumberFormatException | NullPointerException nfe)
        {
            LOG.trace("Invalid Global Attribute Reference [" + getClass().getSimpleName() + "] - [" + attribute + "]. Ignoring.",nfe);
            return null;
        }
    }

    /**
     * Returns an enumerated HashMap for ease of access
     * <p>
     * @param attribute The Global Attribute to apply
     * <p>
     * @return HashMap of Attributes with GlobalAttributes Enumeration as Identifier
     */
    @Override
    public final String getAttribute(GlobalAttributes attribute)
    {
        if (getAttributesGlobal().get(attribute) == null)
        {
            getAttributesGlobal().put(attribute, "");
        }

        return getAttributesGlobal().get(attribute);
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     * @return
     */
    @Override
    public final J addAttribute(GlobalAttributes attribute, String value)
    {
        if (value != null && !value.isEmpty())
        {
            if (attribute == GlobalAttributes.Style)
            {
                getAttributesGlobal().put(attribute, getAttributesGlobal().get(attribute) + "" + value);
            }
            getAttributesGlobal().put(attribute, value);
        }
        else
        {
            LOG.trace("Invalid Global Attribute value added [" + getClass().getSimpleName() + "] - [" + attribute + "] - [" + value + "]. Ignoring. Possible duplicate all components run..");
        }
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     * @return
     */
    @Override
    public final J addAttribute(A attribute, String value)
    {
        if (value != null && !value.isEmpty())
        {
            getAttributes().put(attribute, value);
        }
        else
        {
            LOG.trace("Invalid Local Attribute value added [" + getClass().getSimpleName() + "] - [" + attribute + "] - [" + value + "]. Ignoring. Possible duplicate all components run..");
        }
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The GlobalAttribute to set the attribute to
     * @param value     The value of the attribute
     * @return
     */
    @Override
    public final J addAttribute(A attribute, Integer value)
    {
        getAttributes().put(attribute, value.toString());
        return (J) this;
    }

    /**
     * Adds an attribute value to the attribute collection, and marks it with a GlobalAttribute Enumeration.
     * <p>
     * @param attribute The valid Local Attribute to add
     * @param value     The value of the attribute
     * @return
     */
    @Override
    public final J addAttribute(A attribute, Boolean value)
    {
        getAttributes().put(attribute, value.toString());
        return (J) this;
    }

    /**
     * Gets this list of local attribute values
     * <p>
     * @param attributeValue The Valid Local Attribute to Return
     * <p>
     * @return A String of the attribute value currently set
     */
    @Override
    public String getAttribute(A attributeValue)
    {
        String s = getAttributes().get(attributeValue);
        if (s == null)
        {
            s = "";
        }
        return s;
    }

    /**
     * Gets this list of local attribute values
     * <p>
     * @param attributeValue The Valid Local Attribute to Return
     * @param uselessInt     A useless parameter purely to return the type integer
     * <p>
     * @return A HashMap if this components local attributes. Never null
     */
    @Override
    public Integer getAttribute(A attributeValue, Integer uselessInt)
    {
        String s = getAttributes().get(attributeValue);
        if (s == null)
        {
            s = "0";
        }
        return new Integer(s);
    }

    /**
     * Gets this list of local attribute values
     * <p>
     * @param attributeValue The Valid Local Attribute to Return
     * @param uselessInt     A useless parameter purely to return the type Boolean
     * <p>
     * @return A HashMap if this components local attributes. Never null
     */
    @Override
    public Boolean getAttribute(A attributeValue, Boolean uselessInt)
    {
        String s = getAttributes().get(attributeValue);
        if (s == null)
        {
            s = "false";
        }
        return Boolean.valueOf(s);
    }

    /**
     * Sets if this component should render an ID attribute
     * <p>
     * @param renderIDAttibute
     * @return
     */
    protected J setRenderIDAttibute(boolean renderIDAttibute)
    {
        this.renderIDAttibute = renderIDAttibute;
        if (!renderIDAttibute)
        {
            getAttributesGlobal().remove(GlobalAttributes.ID);
        }
        return (J) this;
    }

    /**
     * Returns a complete list of all class names associated with this component
     * <p>
     * @return
     */
    @Override
    public List<String> getClasses()
    {
        if (classes == null)
        {
            classes = new ArrayList<>();
        }
        return classes;
    }

    /**
     * Adds a class name to the class list
     * <p>
     * @param className The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    @Override
    public boolean addClass(String className)
    {
        if (!getClasses().contains(className))
        {
            getClasses().add(className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Removes a class name from this component
     * <p>
     * @param className Class Name to Remove
     * <p>
     * @return True if the class was removed, False if the class was not part of the collection
     */
    @Override
    public boolean removeClass(String className)
    {
        if (getClasses().contains(className))
        {
            getClasses().remove(className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns if this component should render for the ID attribute
     * <p>
     * @return
     */
    protected boolean isRenderIDAttibute()
    {
        if (!renderIDAttibute || (this instanceof NoIDTag))
        {
            return false;
        }
        else
        {
            return renderIDAttibute;
        }
    }

    /**
     * Renders the classes array as an in-line class string
     *
     * @return
     */
    private StringBuilder renderClasses()
    {
        StringBuilder sb = new StringBuilder();
        getClasses().stream().forEach(clazz
                ->
        {
            sb.append(clazz).append(" ");
        });
        if (sb.length() > 0)
        {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb;
    }

    /**
     * Sets the ID and adds the attribute to the global set
     *
     * @param id
     * @return
     */
    @Override
    public J setID(String id)
    {
        getAttributesGlobal().put(GlobalAttributes.ID, id);
        return super.setID(id);
    }

    @Override
    public J cloneComponent()
    {
        ComponentHTMLAttributeBase cloned = (ComponentHTMLAttributeBase) super.cloneComponent();

        cloned.attributesGlobal = new TreeMap();
        cloned.attributesLocal = new TreeMap();
        cloned.attributesGlobal.putAll(getAttributesGlobal());
        cloned.attributesLocal.putAll(getAttributes());

        return (J) cloned;
    }

}
