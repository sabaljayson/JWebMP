/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.base.interfaces;

import za.co.mmagon.jwebswing.components.bootstrap.Glyphicons;
import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.*;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.SB2ThemeClasses;

/**
 * Defines a component as bootstrap capable
 *
 * @author GedMarc
 * @param <J>
 *
 * @since Oct 10, 2016
 * @version 1.0
 *
 */
public interface IComponentHTMLBootstrapBase<J>
{

    /**
     * Adds a class name to the class list
     * <p>
     * @param blockName The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    J addClass(IBSComponentOptions blockName);

    /**
     * Adds a class name to the class list
     * <p>
     * @param blockName The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    J addClass(SB2ThemeClasses blockName);

    /**
     * Adds the specified column width settings to the class
     *
     * @param blockName
     *
     * @return
     */
    J addClass(BSComponentWidthOptions blockName);

    /**
     * Adds the specified column width settings to the class
     *
     * @param blockName
     *
     * @return
     */
    J addClass(BSComponentResponsiveOptions blockName);

    /**
     * Adds the specified column width settings to the class
     *
     * @param blockName
     *
     * @return
     */
    J addClass(Glyphicons blockName);
}
