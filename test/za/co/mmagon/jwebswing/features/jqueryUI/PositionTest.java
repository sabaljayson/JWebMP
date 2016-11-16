package za.co.mmagon.jwebswing.features.jqueryUI;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.base.html.Area;
import za.co.mmagon.jwebswing.components.jqImageMap.imagemap.JQImageMap;
import za.co.mmagon.jwebswing.components.jqueryUI.position.Position;
import za.co.mmagon.jwebswing.components.jqueryUI.position.PositionLocationHorizontal;
import za.co.mmagon.jwebswing.components.jqueryUI.position.PositionLocationVertical;

/**
 *
 * @author MMagon
 */
public class PositionTest extends BaseTestClass
{

    public PositionTest()
    {
    }

    /**
     * Test of getMyString method, of class Position.
     */
    @Test
    public void testGetMyString()
    {
        System.out.println("getMyString");
        Area area = new Area(JQImageMap.ImageMapAreaShapes.Default, "0,0,0,0");
        area.setID("of");
        Position instance = new Position(PositionLocationHorizontal.left, PositionLocationVertical.top, PositionLocationHorizontal.left, PositionLocationVertical.top, area);
        System.out.println(instance.toString());
        String expResult = "{\n"
                + "  myX : \"left\",\n"
                + "  myY : \"top\",\n"
                + "  atX : \"left\",\n"
                + "  atY : \"top\",\n"
                + "  of : \"#of\"\n"
                + "}"
                + "";
        String result = instance.toString();
        super.writeValuesToFile(expResult, result);
        assertEquals(expResult, result);
    }

}
