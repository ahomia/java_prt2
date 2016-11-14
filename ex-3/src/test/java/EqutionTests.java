import org.junit.Assert;
import org.testng.annotations.Test;


/**
 * Created by ahomia on 14.11.2016.
 */
public class EqutionTests {

    @Test
    public void test0(){
        Equation e=new Equation(1,1,1);
        Assert.assertEquals(e.rootNumber(),0);
    }
}
