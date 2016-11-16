package za.co.mmagon.jwebswing.components.jqxWidgets.splitter;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jqxWidgets.JQXReferencePool;

/**
 * Adds on a ToolTip, String for custom text using header theme, Div for custom contents
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class JQXSplitterFeature extends Feature<JQXSplitterOptions, JQXSplitterFeature> implements JQXSplitterFeatures, GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQXSplitter forComponent;
    private JQXSplitterOptions options;

    /**
     * Constructs a new Tooltip ComponentFeatureBase for a component. Adds the tooltip text as the Title attribute to the component
     * <p>
     * @param forComponent
     */
    public JQXSplitterFeature(JQXSplitter forComponent)
    {
        super("JQXSplitterFeature");
        this.forComponent = forComponent;
        getJavascriptReferences().add(JQXReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQXReferencePool.Splitter.getJavaScriptReference());
        getCssReferences().add(JQXReferencePool.Core.getCssReference());
    }

    /**
     * Returns all the tooltip options
     * <p>
     * @return
     */
    @Override
    public JQXSplitterOptions getOptions()
    {
        if (options == null)
        {
            options = new JQXSplitterOptions();
        }
        return options;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        String requiredString = forComponent.getJQueryID() + "jqxSplitter(";
        requiredString += getOptions().toString();
        requiredString += ");" + getNewLine();
        addQuery(requiredString);

    }
}
