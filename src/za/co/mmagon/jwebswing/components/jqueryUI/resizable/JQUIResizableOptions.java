/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqueryUI.resizable;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.interfaces.CssClass;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.generics.CompassPoints;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since Mar 15, 2015
 * @version 1.0
 * <p>
 * <p>
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JQUIResizableOptions extends JavaScriptPart
{

    /**
     * One or more elements to resize synchronously with the resizable element.
     */
    private String alsoSize;

    /**
     * Animates to the final size after resizing.
     */
    private Boolean animate;
    /**
     * How long to animate when using the animate option.
     */
    private Integer animateDuration;
    /**
     * Which easing to apply when using the animate option.
     */
    private EasingEffects animationEffect;
    /**
     * Sets the resize to always preserve aspect ratio
     */
    private Boolean preserveAspectRatio;
    /**
     * Whether the handles should hide when the user is not hovering over the element.
     */
    private Boolean autoHide;
    /**
     * Prevents resizing from starting on specified elements.
     */
    private final ArrayList<CssClass> cancel = new ArrayList<>();
    /**
     * Constrains resizing to within the bounds of the specified element or region.
     */
    private Component containment;
    /**
     * Tolerance, in milliseconds, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond duration. This can help prevent unIntegerended resizing when
     * clicking on an element.
     */
    private Integer delay;
    /**
     * Tolerance, in pixels, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond distance. This can help prevent unIntegerended resizing when
     * clicking
     * on an element.
     */
    private Integer distance;
    /**
     * If set to true, a semi-transparent helper element is shown for resizing.
     */
    private Boolean ghost;
    /**
     * Snaps the resizing element to a grid, every x and y pixels. Array values: [ x, y ]
     */
    private Integer[] grid;
    /**
     * Which handles can be used for resizing. Multiple types supported:
     *
     * String: A comma delimited list of any of the following: n, e, s, w, ne, se, sw, nw, all. The necessary handles will be auto-generated by the plugin. Object:
     *
     * The following keys are supported: { n, e, s, w, ne, se, sw, nw }. The value of any specified should be a jQuery selector matching the child element of the resizable to use as that handle. If
     * the handle is not a child of the resizable, you can pass in the DOMElement or a valid jQuery object directly.
     *
     * Note: When generating your own handles, each handle must have the ui-resizable-handle class, as well as the appropriate ui-resizable-{direction} class, .e.g., ui-resizable-s.
     *
     */
    private final ArrayList<CompassPoints> handles = new ArrayList<>();
    /**
     * A class name that will be added to a proxy element to outline the resize during the drag of the resize handle. Once the resize is complete, the original element is sized.
     */
    private String helper;
    /**
     * Sets the minimum width of the component
     */
    private Integer minimumWidth;
    /**
     * Sets the maximum width of the component
     */
    private Integer maximumWidth;
    /**
     * Sets the minimum height of the component
     */
    private Integer minimumHeight;
    /**
     * sets the maximum height of the component
     */
    private Integer maximumHeight;

    /**
     *
     */
    public JQUIResizableOptions()
    {

    }

    /**
     * One or more elements to resize synchronously with the resizable element.
     *
     * @return The component that must also be resized
     */
    public String getAlsoSize()
    {
        return alsoSize;
    }

    /**
     * Sets the component that must resize with this component
     *
     * @param alsoSize The component
     */
    public void setAlsoSize(Component alsoSize)
    {
        this.alsoSize = alsoSize.getID(true);
    }

    /**
     * Animates to the final size after resizing.
     *
     * @return True or False
     */
    public Boolean isAnimate()
    {
        return animate;
    }

    /**
     * Animates to the final size after resizing.
     *
     * @param animateType True of False
     */
    public void setAnimate(Boolean animateType)
    {
        this.animate = animateType;
    }

    /**
     * How long to animate when using the animate option.
     *
     * @return Number of milliseconds
     */
    public Integer getAnimateDuration()
    {
        return animateDuration;
    }

    /**
     * How long to animate when using the animate option.
     *
     * @param animateDuration The animation duration to use
     */
    public void setAnimateDuration(Integer animateDuration)
    {
        this.animateDuration = animateDuration;
    }

    /**
     * Which easing to apply when using the animate option.
     *
     * @return The Animation Effect
     */
    public EasingEffects getAnimationEffect()
    {
        return animationEffect;
    }

    /**
     * Which easing to apply when using the animate option.
     *
     * @param animationEffect The easing effect for the resizable
     */
    public void setAnimationEffect(EasingEffects animationEffect)
    {
        this.animationEffect = animationEffect;
    }

    /**
     * Whether the handles should hide when the user is not hovering over the element.
     *
     * @return Whether the handles should hide when the user is not hovering over the element.
     */
    public Boolean isAutoHide()
    {
        return autoHide;
    }

    /**
     * Whether the handles should hide when the user is not hovering over the element.
     *
     * @param autoHide Whether the handles should hide when the user is not hovering over the element.
     */
    public void setAutoHide(Boolean autoHide)
    {
        this.autoHide = autoHide;
    }

    /**
     * Prevents resizing from starting on specified elements
     *
     * @return An ArrayList of CSS Classes to exclude
     */
    public ArrayList<CssClass> getCancel()
    {
        return cancel;
    }

    /**
     * Constrains resizing to within the bounds of the specified element or region.
     *
     * @return Constrains resizing to within the bounds of the specified element or region.
     */
    public Component getContainment()
    {
        return containment;
    }

    /**
     * Constrains resizing to within the bounds of the specified element or region.
     *
     * @param containment Constrains resizing to within the bounds of the specified element or region.
     */
    public void setContainment(Component containment)
    {
        this.containment = containment;
    }

    /**
     * Tolerance, in milliseconds, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond duration. This can help prevent unIntegerended resizing when
     * clicking on an element.
     *
     * @return The delay in milliseconds
     */
    public Integer getDelay()
    {
        return delay;
    }

    /**
     * Tolerance, in milliseconds, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond duration. This can help prevent unIntegerended resizing when
     * clicking on an element.
     *
     * @param delay The delay in milliseconds
     */
    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }

    /**
     * Tolerance, in pixels, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond distance. This can help prevent unIntegerended resizing when
     * clicking
     * on an element.
     *
     * @return The distance in pixels
     */
    public Integer getDistance()
    {
        return distance;
    }

    /**
     * Tolerance, in pixels, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond distance. This can help prevent unIntegerended resizing when
     * clicking
     * on an element.
     *
     * @param distance The distance in pixels
     */
    public void setDistance(Integer distance)
    {
        this.distance = distance;
    }

    /**
     * If set to true, a semi-transparent helper element is shown for resizing.
     *
     * @return Ghosting
     */
    public Boolean isGhost()
    {
        return ghost;
    }

    /**
     * If set to true, a semi-transparent helper element is shown for resizing.
     *
     * @param ghost True or False
     */
    public void setGhost(Boolean ghost)
    {
        this.ghost = ghost;
    }

    /**
     * Snaps the resizing element to a grid, every x and y pixels. Array values: [ x, y ]
     *
     * @param x The X Axis
     * @param y The Y Axis
     */
    public void setGrid(Integer x, Integer y)
    {
        this.grid = new Integer[]
        {
            x, y
        };
    }

    /**
     * Snaps the resizing element to a grid, every x and y pixels. Array values: [ x, y ]
     *
     * @return [x,y]
     */
    public Integer[] getGrid()
    {
        return grid;
    }

    /**
     * Which handles can be used for resizing. Multiple types supported:
     *
     * String: A comma delimited list of any of the following: n, e, s, w, ne, se, sw, nw, all. The necessary handles will be auto-generated by the plugin. Object:
     *
     * The following keys are supported: { n, e, s, w, ne, se, sw, nw }. The value of any specified should be a jQuery selector matching the child element of the resizable to use as that handle. If
     * the handle is not a child of the resizable, you can pass in the DOMElement or a valid jQuery object directly.
     *
     * Note: When generating your own handles, each handle must have the ui-resizable-handle class, as well as the appropriate ui-resizable-{direction} class, .e.g., ui-resizable-s.
     *
     * @return The list of resize handles attached with this feature
     */
    public ArrayList<CompassPoints> getHandles()
    {
        return handles;
    }

    /**
     * A class name that will be added to a proxy element to outline the resize during the drag of the resize handle. Once the resize is complete, the original element is sized.
     *
     * @return The class name
     */
    public String getHelper()
    {
        return helper;
    }

    /**
     * A class name that will be added to a proxy element to outline the resize during the drag of the resize handle. Once the resize is complete, the original element is sized.
     *
     * @param helper The class name
     */
    public void setHelper(String helper)
    {
        this.helper = helper;
    }

    /**
     * The minimum width the resizable should be allowed to resize to.
     *
     * @return The min width
     */
    public Integer getMinimumWidth()
    {
        return minimumWidth;
    }

    /**
     * The minimum width the resizable should be allowed to resize to.
     *
     * @param minimumWidth The minimum width
     */
    public void setMinimumWidth(Integer minimumWidth)
    {
        this.minimumWidth = minimumWidth;
    }

    /**
     * The maximum width the resizable should be allowed to resize to.
     *
     * @return The maximum width the resizable should be allowed to resize to.
     */
    public Integer getMaximumWidth()
    {
        return maximumWidth;
    }

    /**
     * The maximum width the resizable should be allowed to resize to.
     *
     * @param maximumWidth The maximum width the resizable should be allowed to resize to.
     */
    public void setMaximumWidth(Integer maximumWidth)
    {
        this.maximumWidth = maximumWidth;
    }

    /**
     * The maximum height the resizable should be allowed to resize to
     *
     * @return The height
     */
    public Integer getMinimumHeight()
    {
        return minimumHeight;
    }

    /**
     * The minimum height the resizable should be allowed to resize to.
     *
     * @param minimumHeight The minimum height the resizable should be allowed to resize to.
     */
    public void setMinimumHeight(Integer minimumHeight)
    {
        this.minimumHeight = minimumHeight;
    }

    /**
     * The maximum height the resizable should be allowed to resize to.
     *
     * @return The maximum height the resizable should be allowed to resize to.
     */
    public Integer getMaximumHeight()
    {
        return maximumHeight;
    }

    /**
     * The maximum height the resizable should be allowed to resize to.
     *
     * @param maximumHeight The maximum height the resizable should be allowed to resize to.
     */
    public void setMaximumHeight(Integer maximumHeight)
    {
        this.maximumHeight = maximumHeight;
    }

    /**
     * Whether the element should be constrained to its original ratio
     *
     * @return Whether the element should be constrained to a specific aspect ratio.
     */
    public Boolean isPreserveAspectRatio()
    {
        return preserveAspectRatio;
    }

    /**
     * Whether the element should be constrained to a specific aspect ratio.
     *
     * @param preserveAspectRatio
     */
    public void setPreserveAspectRatio(Boolean preserveAspectRatio)
    {
        this.preserveAspectRatio = preserveAspectRatio;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
