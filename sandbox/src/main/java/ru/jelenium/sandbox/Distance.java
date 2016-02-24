package ru.jelenium.sandbox;

/**
 * Created by mikhail.evseev on 24.02.2016.
 */
public class Distance {
  public static double distance(Point firstPoint, Point secondPoint){
    System.out.println("Coordinates of the first point is " + firstPoint.x + ":" + firstPoint.y);
    System.out.println("Coordinates of the second point is " + secondPoint.x + ":" + secondPoint.y);
    double distance = Math.sqrt(Math.pow((firstPoint.x - secondPoint.x),2) + Math.pow((firstPoint.y - secondPoint.y),2));
    return distance;
        }
}
