package ru.jelenium.sandbox;

public class ToPrint {
  public static void main(String[] args) {
//    System.out.println("Hello, world!");
    Point firstPoint = new Point();
    firstPoint.x = 2;
    firstPoint.y = 3;
    Point secondPoint = new Point();
    secondPoint.x = 13;
    secondPoint.y = 8;
    System.out.println("Coordinates of the first point is " + firstPoint.x + ":" + firstPoint.y);
    System.out.println("Coordinates of the second point is " + secondPoint.x + ":" + secondPoint.y);
  }
}