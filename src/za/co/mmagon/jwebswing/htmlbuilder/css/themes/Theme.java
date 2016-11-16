package za.co.mmagon.jwebswing.htmlbuilder.css.themes;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;

/**
 * Base class for defining a Theme Includes an icon image for Pretties sake
 *
 * @author Marc Magon
 * @version 2.0
 * @since 2.0 on 20140705
 *
 */
public abstract class Theme implements ITheme, Comparator<Theme>
{

    private final String name;
    private final String cssClassName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<CSSReference> cssRefs;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private ArrayList<JavascriptReference> javascriptRefs;
    private final String icon30;
    private final String icon60;
    private final String icon90;
    private boolean renderClassName = true;

    /**
     * Loads a theme with the default icons. This cannot be changed later on
     *
     * @param name         The Theme Name
     * @param cssClassName The CSS Class Associated with the Theme as generated
     *                     by Theme Roller
     */
    protected Theme(String name, String cssClassName)
    {
        this(name, cssClassName, null, null, null);
    }

    /**
     * Constructs a new theme object with all specified lines if available
     *
     * @param name         The Theme Name
     * @param cssClassName The CSS Class Associated with the Theme as generated
     *                     by Theme Roller
     * @param icon30       The location of the size 30 icon for the theme
     * @param icon60       The location of the size 60 icon for the theme
     * @param icon90       The location of the size 90 icon for the theme
     */
    public Theme(String name, String cssClassName, String icon30, String icon60, String icon90)
    {
        this.name = name;
        this.cssClassName = cssClassName;
        this.icon30 = icon30;
        this.icon60 = icon60;
        this.icon90 = icon90;
    }

    /**
     * Returns this theme's class name
     *
     * @return
     */
    @Override
    public final String getClassName()
    {
        return cssClassName;
    }

    /**
     * Returns this object Java class name
     *
     * @return
     */
    @Override
    public final String toString()
    {
        return getName();
    }

    /**
     * Returns the CSS Class name for this theme
     *
     * @return
     */
    @Override
    public final String getName()
    {
        return name;
    }

    /**
     * Compares themes via their name
     *
     * @param o1 Theme 1
     * @param o2 Theme 2
     * @return -1 to 1 on sorting
     */
    @Override
    public int compare(Theme o1, Theme o2)
    {
        return o1.getName().compareTo(o2.getName());
    }

    /**
     * Returns all the CSS References used by this theme
     * <p>
     * @return
     */
    @Override
    public final ArrayList<CSSReference> getCssReferences()
    {
        if (cssRefs == null)
        {
            cssRefs = new ArrayList<>();
        }
        return cssRefs;
    }

    /**
     * Returns all JavaScript references used by this theme
     * <p>
     * @return
     */
    @Override
    public final ArrayList<JavascriptReference> getJavascriptReferences()
    {
        if (javascriptRefs == null)
        {
            javascriptRefs = new ArrayList<>();
        }
        return javascriptRefs;
    }

    /**
     * Returns a size 30x30 icon if present
     * <p>
     * @return
     */
    @Override
    public final String getSize30Icon()
    {
        return this.icon30;
    }

    /**
     * Returns a size 60x60 icon if present
     * <p>
     * @return
     */
    @Override
    public final String getSize60Icon()
    {
        return this.icon60;
    }

    /**
     * Returns a size 90x90 icon if present
     * <p>
     * @return
     */
    @Override
    public final String getSize90Icon()
    {
        return this.icon90;
    }

    /**
     * Sets if the class name should be rendered
     *
     * @return
     */
    public boolean isRenderClassName()
    {
        return renderClassName;
    }

    /**
     * Sets if the class name should be rendered
     *
     * @param renderClassName
     */
    public void setRenderClassName(Boolean renderClassName)
    {
        this.renderClassName = renderClassName;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.cssRefs);
        hash = 53 * hash + Objects.hashCode(this.javascriptRefs);
        hash = 53 * hash + (this.renderClassName ? 1 : 0);
        return hash;
    }

    /**
     * Equals for themes
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Theme other = (Theme) obj;
        if (this.renderClassName != other.renderClassName)
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.cssRefs, other.cssRefs))
        {
            return false;
        }
        if (!Objects.equals(this.javascriptRefs, other.javascriptRefs))
        {
            return false;
        }
        return true;
    }

}
