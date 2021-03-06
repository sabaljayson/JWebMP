package com.jwebmp.core.annotations;

import com.google.inject.Provider;
import com.jwebmp.core.Page;
import com.jwebmp.core.SessionHelper;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.guicedinjection.GuiceContext;
import com.jwebmp.logger.LogFactory;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;

import javax.servlet.http.HttpServletRequest;
import java.util.ServiceLoader;
import java.util.logging.Level;

public class PageProvider
		implements Provider<Page>
{
	private static final java.util.logging.Logger log = LogFactory.getLog("PageProvider");
	private static final ServiceLoader<IPage> pages = ServiceLoader.load(IPage.class);

	/**
	 * Method getPages returns the pages of this PageProvider object.
	 *
	 * @return the pages (type ServiceLoader<IPage>) of this PageProvider object.
	 */
	public static ServiceLoader<IPage> getPages()
	{
		return PageProvider.pages;
	}

	@Override
	public Page get()
	{
		if (!PageProvider.pages.iterator()
		                       .hasNext())
		{
			PageProvider.log.log(Level.WARNING, "Returning blank page since no class was found that extends page or matches the given url");
			return new Page();
		}
		IPage outputPage = null;
		for (IPage page : PageProvider.pages)
		{
			outputPage = findPage(page);
			if (outputPage != null)
			{
				break;
			}
		}
		if (outputPage != null)
		{
			if (!Page.class.isAssignableFrom(outputPage.getClass()))
			{
				PageProvider.log.severe("Page Binding IPage Services must Extend Page.class");
				return new Page();
			}
			return (Page) outputPage;
		}
		return new Page();
	}

	/**
	 * Method findPage ...
	 *
	 * @param next
	 * 		of type IPage
	 *
	 * @return IPage
	 */
	private IPage findPage(IPage next)
	{
		try
		{
			PageConfiguration pc = next.getClass()
			                           .getAnnotation(PageConfiguration.class);
			HttpServletRequest request = GuiceContext.getInstance(HttpServletRequest.class);
			String pathInfo = request.getPathInfo();
			if (pathInfo == null)
			{
				pathInfo = StaticStrings.STRING_FORWARD_SLASH;
			}

			String pcUrl = pc.url();
			if (pathInfo.equalsIgnoreCase(pcUrl) || SessionHelper.getServletUrl()
			                                                     .equalsIgnoreCase(pc.url()))
			{
				IPage page = GuiceContext.inject()
				                         .getInstance(next.getClass());
				String headerInformation = request.getHeader("User-Agent");
				ReadableUserAgent agent = GuiceContext.inject()
				                                      .getInstance(UserAgentStringParser.class)
				                                      .parse(headerInformation);
				page.setUserAgent(agent);
				return page;
			}
			else
			{
				PageProvider.log.log(Level.FINER, "Not the right page, moving on");
			}
		}
		catch (NullPointerException npe)
		{
			PageProvider.log.log(Level.SEVERE, "Unable to process page : " + next + " due to null pointer", npe);
		}
		catch (Exception npe)
		{
			PageProvider.log.log(Level.SEVERE, "Unable to process page : " + next, npe);
		}
		return null;
	}
}
