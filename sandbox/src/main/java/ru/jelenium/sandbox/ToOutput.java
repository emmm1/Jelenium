package ru.jelenium.sandbox;

import static java.lang.Math.pow;

public class ToOutput {
  public static void main(String[] args) {
    Point firstPoint = new Point(6, 3);
    Point secondPoint = new Point(2, 6);
    System.out.println("Coordinates of the first point is " + firstPoint.x + ":" + firstPoint.y);
    System.out.println("Coordinates of the second point is " + secondPoint.x + ":" + secondPoint.y);
    System.out.println("Distance between thise two points is " + firstPoint.distance(secondPoint));
  }

  public static double sqdiff (double p1, double p2) {
    // Возвращает квадрат разницы по одной оси
    double sqd = pow((p1 - p2), Point.power);
    return sqd;
  }
}
