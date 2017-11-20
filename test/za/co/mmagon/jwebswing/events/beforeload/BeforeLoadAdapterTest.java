package za.co.mmagon.jwebswing.events.beforeload;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.co.mmagon.jwebswing.BaseTestClass;
import za.co.mmagon.jwebswing.base.ajax.AjaxCall;
import za.co.mmagon.jwebswing.base.ajax.AjaxResponse;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.DivSimple;

public class BeforeLoadAdapterTest extends BaseTestClass
{
	@Test
	public void test()
	{
		Div test = new DivSimple<>();
		test.setID("test");
		BeforeLoadAdapter aa = new BeforeLoadAdapter(test)
		{
			@Override
			public void onBeforeLoad(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		Assertions.assertEquals("<div id=\"test\" ng-before-load=\"jwCntrl.perform($event,[],'za_co_mmagon_jwebswing_events_beforeload_BeforeLoadAdapterTest$1','za.co.mmagon.jwebswing.events.beforeload.BeforeLoadAdapterTest$1');\"></div>", test.toString(0));
	}

	@Test
	public void testDirective()
	{
		Div test = new DivSimple<>();
		test.getPage().getAngular().getAngularDirectives().clear();
		test.setID("test");
		BeforeLoadAdapter aa = new BeforeLoadAdapter(test)
		{
			@Override
			public void onBeforeLoad(AjaxCall call, AjaxResponse response)
			{

			}
		};
		System.out.println(test.toString(0));
		System.out.println(test.getPage().getAngular().getAngularDirectives());
		Assertions.assertEquals(1, test.getPage().getAngular().getAngularDirectives().size());
	}
}