/*
 * Copyright (C) 2017 GedMarc
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
package za.co.mmagon.jwebswing.components.bootstrap.buttons.toolbars;

import za.co.mmagon.jwebswing.components.bootstrap.componentoptions.IBSComponentOptions;

/**
 * Button toolbar
 * <p>
 * Combine sets of button groups into button toolbars for more complex components.
 *
 * @author GedMarc
 * @since 01 Jan 2017
 * @version 1.0
 *
 */
public enum BSComponentButtonToolbarOptions implements IBSComponentOptions
{
    /**
     * Button toolbar
     * <p>
     * Combine sets of button groups into button toolbars for more complex components.
     */
    Btn_Toolbar;

    @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }
}