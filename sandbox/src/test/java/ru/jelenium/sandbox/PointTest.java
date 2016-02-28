package ru.jelenium.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by michael on 28.02.2016.
 */
public class PointTest {



  //Создаем вспомогательную функцию вычисления катета из гипотенузы и второго катета дяя проверки математики
  static double tCathetus(double hypothesis, double catehetus) {
    return Math.sqrt(Math.pow(hypothesis, Point.mpower) - Math.pow(catehetus, Point.mpower));
  //Но если сделать округление - return Math.round(Math.sqrt(Math.pow(hypothesis, Point.mpower) - Math.pow(catehetus, Point.mpower))); - то все почему-то сходится.
  }


  @Test
  public void testDistance() {
    //Гоняем тесты, комбинация 1
    Point tp1 = new Point(5,2);
    Point tp2 = new Point(8,6);
    double tdistance = 5.0;

    //Проверка простой подстановкой значения ответа
    Assert.assertEquals(tp1.distance(tp2), tdistance);
    //Проверяем математику, например что значение расстояния от точки 1 до точки 2 равно расстоянию от 2 до 1(а вдруг?), заодно создаем проблему т.к. математически точно значения могут не сойтись.
    Assert.assertEquals(tp1.distance(tp2), tp2.distance(tp1));
    Assert.assertEquals(tCathetus(tp1.distance(tp2), (tp1.x - tp2.x)), Math.abs(tp1.y - tp2.y));

    //Гоняем тесты, комбинация 2
    tp1 = new Point(12,4);
    tp2 = new Point(16,16);
    tdistance = 12.649110640673518;

    //Проверка простой подстановкой значения ответа
    Assert.assertEquals(tp1.distance(tp2), tdistance);
    //Проверяем математику, например что значение расстояния от точки 1 до точки 2 равно расстоянию от 2 до 1(а вдруг?), заодно создаем проблему т.к. математически точно значения могут не сойтись.
    Assert.assertEquals(tp1.distance(tp2), tp2.distance(tp1));
    Assert.assertEquals(tCathetus(tp1.distance(tp2), (tp1.x - tp2.x)), Math.abs(tp1.y - tp2.y));

  }



  @Test
  public void testSqdiff() {
    //Гоняем тесты, комбинация 1
    Point tp1 = new Point(5,2);
    Point tp2 = new Point(8,6);
    double squareDiffX = 9;
    double squareDiffY = 16;
    Assert.assertEquals(Point.sqdiff(tp1.x, tp2.x), squareDiffX);
    Assert.assertEquals(Point.sqdiff(tp1.y, tp2.y), squareDiffY);


    //Гоняем тесты, комбинация 2
    tp1 = new Point(12,4);
    tp2 = new Point(16,16);
    squareDiffX = 16;
    squareDiffY = 144;
    Assert.assertEquals(Point.sqdiff(tp1.x, tp2.x), squareDiffX);
    Assert.assertEquals(Point.sqdiff(tp1.y, tp2.y), squareDiffY);

  }
}