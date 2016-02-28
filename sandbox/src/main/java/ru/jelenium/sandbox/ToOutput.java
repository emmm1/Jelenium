package ru.jelenium.sandbox;

import static java.lang.Math.pow;

public class ToOutput {
  public static void main(String[] args) {
    Point firstPoint = new Point(12, 4);
    Point secondPoint = new Point(16, 16);
    System.out.println("Coordinates of the first point is " + firstPoint.x + ":" + firstPoint.y);
    System.out.println("Coordinates of the second point is " + secondPoint.x + ":" + secondPoint.y);
    System.out.println("Distance between thise two points is " + firstPoint.distance(secondPoint));
  }



}
