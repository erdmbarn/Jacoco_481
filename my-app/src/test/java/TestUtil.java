/*import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }
}*/
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {

  private Util util;

  @Before
  public void setUp() {
    util = new Util();
  }

  @Test
  public void testSingleElement() {
    assertFalse(util.compute(1));
  }

  @Test
  public void testEvenNumberOfElements() {
    assertFalse(util.compute(1, 2));
  }

  @Test(expected = RuntimeException.class)
  public void testContainsZero() {
    util.compute(3,1, 0);
  }

  @Test
  public void testSumDivisibleByElement() {
    assertTrue(util.compute(2, 4, 6)); // Sum is 12, which is divisible by all elements
  }

  @Test
  public void testSumNotDivisibleByAnyElement() {
    assertFalse(util.compute(2, 4, 7)); // Sum is 13, which is not divisible by any of the elements
  }
}
