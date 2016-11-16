package za.co.mmagon.jwebswing.base.html;

import java.io.Serializable;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.client.HTMLVersions;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineBeforeClosingTag;
import za.co.mmagon.jwebswing.base.html.interfaces.NoNewLineForRawText;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.HtmlChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;acronym&gt; tag is not supported in HTML5. Use the &lt;abbr&gt; tag
 * instead.<p>
 * <p>
 * The &lt;acronym&gt; tag defines an acronym.<p>
 * <p>
 * An acronym can be spoken as if it were a word, example NATO, NASA, ASAP,
 * GUI.<p>
 * <p>
 * By marking up acronyms you can give useful information to browsers, spell
 * checkers, translation systems and search-engine indexers. Browser Support
 * Element<p>
 * &lt;acronym&gt; All Browsers<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: The title attribute can be used to show the full version of the acronym
 * when you mouse over it. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;acronym&gt; tag is not supported in HTML5.<p>
 * <p>
 * The &lt;acronym&gt; tag is not supported in HTML5.
 * Use the &lt;abbr&gt; tag
 * instead.<p>
 *
 * @since 2014 09 22
 * @version 1.0
 * @author MMagon
 *
 * @deprecated
 *
 */
public class Acronym extends Component<NoChildren, NoAttributes, NoFeatures, NoEvents, Acronym>
        implements NoNewLineBeforeClosingTag, NoNewLineForRawText, HtmlChildren, BodyChildren, Serializable, NoIDTag
{

    /**
     * Logger for the Component
     */
    private static final org.apache.log4j.Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("Acronym");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    /**
     * Constructs an Acronym
     * <p>
     * @param text
     */
    public Acronym(String text)
    {
        super(ComponentTypes.Acronym.getComponentTag(), ComponentTypes.Acronym);
        setText(text);
    }

    /**
     * Differences Between HTML and HTML 5
     * <p>
     * The &gt;acronym&lt; tag is not supported in HTML5. Use the &gt;abbr&lt;
     * tag instead.
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        try
        {
            if (getPage().getBrowser().getHtmlVersion() == HTMLVersions.HTML5)
            {
                setTag("abbr");
            }
        }
        catch (Exception e)
        {
            LOG.trace("Unable to determine whether HTML or HTML5. Document type not set?",e);
        }
    }
}
