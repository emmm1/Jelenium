package ru.jelenium.sandbox;

import static java.lang.Math.*;

/**
 * Created by mikhail.evseev on 24.02.2016.
 */
public class Point {
  public double x;
  public double y;
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double distance(Point p2) {
    double dist = sqrt(pow((this.x - p2.x), 2) + pow((this.y - p2.y), 2));
    return dist;
  }

}
