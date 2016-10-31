import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ahomia on 31.10.2016.
 */
public class DistanceTest {
    @Test
    public void testDistance(){
        Point p1=new Point(4,3);
        Point p2=new Point(0,0);
        Assert.assertEquals(p1.distance(p2),5.0);

    }
}
