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

  public static int mpower = 2;

  // общая переменная для возведения в квадрат
  public double distance(Point p2) {
    double dist = sqrt(Point.sqdiff(this.x, p2.x) + Point.sqdiff(this.y, p2.y));
    return dist;
  }

  public static double sqdiff(double p1, double p2) {
    // Возвращает квадрат разницы по одной оси
    double sqd = pow((p1 - p2), Point.mpower);
    return sqd;
  }
}
