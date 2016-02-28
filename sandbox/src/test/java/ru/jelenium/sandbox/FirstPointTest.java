package ru.jelenium.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mikhail.evseev on 26.02.2016.
 */
public class FirstPointTest {
  @Test
  public void testDistance() {
    Point p = new Point(3, 8);
    Point p2 = new Point(6, 12);
    Assert.assertEquals(p.distance(p2), 5.0);
    Assert.assertEquals(p.x, 3.0);
    Assert.assertEquals(p.y, 8.0);
    Assert.assertEquals(Point.sqdiff(p.x, p2.x), 9.0);
  }
}
