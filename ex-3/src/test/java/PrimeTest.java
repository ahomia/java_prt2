import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by ahomia on 27.11.2016.
 */
public class PrimeTest {
    @Test
    public void testPrime(){
        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));

    }
    @Test
    public void testNonPrime(){
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));

    }
@Test
    public void testPrimeWhile(){
        Assert.assertTrue(Primes.isPrimeWhile(Integer.MAX_VALUE));

    }
    @Test
    public void testNonPrimeWhile(){
        Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE-2));

    }
}
