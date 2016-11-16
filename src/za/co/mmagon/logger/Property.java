package za.co.mmagon.logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Property")
public class Property
{

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "value", required = true)
    protected String value;

    /**
     * Gets the value of the name property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the value of the value property.
     *
     * @return
     *         possible object is
     *         {@link String }
     *
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *              allowed object is
     *              {@link String }
     *
     */
    public void setValue(String value)
    {
        this.value = value;
    }

}
