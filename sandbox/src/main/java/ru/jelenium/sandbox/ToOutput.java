package ru.jelenium.sandbox;

public class ToOutput {
  public static void main(String[] args) {
//    System.out.println("Hello, world!");
    Point firstPoint = new Point(6, 3);
    Point secondPoint = new Point(2, 6);
    System.out.println("Coordinates of the first point is " + firstPoint.x + ":" + firstPoint.y);
    System.out.println("Coordinates of the second point is " + secondPoint.x + ":" + secondPoint.y);
    System.out.println("Distance between thise two points is " + distance(firstPoint, secondPoint));
//    distance(firstPoint,secondPoint);
  }

  public static double distance(Point p1, Point p2) {
    double dist = Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
//    System.out.println(dist);
    return dist;
  }

}
