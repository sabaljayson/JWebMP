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
package com.jwebmp;

import com.jwebmp.core.Feature;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This Class
 *
 * @author GedMarc
 * @since 13 Jan 2016
 */
public class BaseTestClass
{

	public BaseTestClass()
	{

	}

	@BeforeAll
	public static void beforeAll()
	{
		System.out.println("Reseting Instance");
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
	}

	public Page getInstance()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		return resetInstance();
	}

	public Page resetInstance()
	{
		soutDivider();
		Page page = new Page();
		Body body = new Body(page);
		page.setID("Page");
		body.setID("Body");
		page.getOptions()
		    .setDynamicRender(false);
		return page;
	}

	public void soutDivider()
	{
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<===============================================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	public Page getPage()
	{
		JQueryPageConfigurator.setRequired(false);
		AngularPageConfigurator.setRequired(false);
		return resetInstance();
	}

	protected void writeValuesToFile(String expected, String rendered)
	{
		try (FileWriter fw = new FileWriter("c:/temp/equalsText.txt"))
		{
			fw.write(rendered);
			fw.write("\n\n-----\n\n");
			fw.write(expected);
		}
		catch (IOException ex)
		{
			System.out.println("Couldn't write to file");
		}
	}

	public Feature getFeature()
	{
		Feature f = new Feature("Test Feature")
		{
			@Override
			public void assignFunctionsToComponent()
			{
				addQuery(new StringBuilder("Query Added"));
			}
		};
		f.setID("featureTest");
		return f;
	}
}
