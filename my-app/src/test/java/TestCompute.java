/*import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }
}*/
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompute {

  private Compute c;
  private MessageQueue mq;

  @Before
  public void setup() {
    mq = mock(MessageQueue.class);
    c = new Compute(mq);
  }

  @Test
  public void testQueueEmpty() {
    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences("test"));
  }

  @Test
  public void testElementNotInQueue() {
    when(mq.size()).thenReturn(3);
    when(mq.contains(anyString())).thenReturn(false);
    assertEquals(0, c.countNumberOfOccurrences("test"));
  }

  @Test
  public void testElementInQueueOnce() {
    when(mq.size()).thenReturn(3);
    when(mq.contains("test")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("test");
    when(mq.getAt(1)).thenReturn("not test");
    when(mq.getAt(2)).thenReturn("also not test");
    assertEquals(1, c.countNumberOfOccurrences("test"));
  }

  @Test
  public void testElementInQueueMultipleTimes() {
    when(mq.size()).thenReturn(4);
    when(mq.contains("test")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("test");
    when(mq.getAt(1)).thenReturn("not test");
    when(mq.getAt(2)).thenReturn("test");
    when(mq.getAt(3)).thenReturn("also not test");
    assertEquals(2, c.countNumberOfOccurrences("test"));
  }
}
