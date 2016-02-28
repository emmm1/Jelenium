package ru.jelenium.sandbox;

/**
 * Created by michael on 28.02.2016.
 */
public class ToCheckTest {
  //Создаем вспомогательную функцию вычисления катета из гипотенузы и второго катета дяя проверки математики
  public static double tCathetus(double hypothesis, double cathetus) {
//    double cath2 = Math.sqrt(Math.pow(hypothesis, Point.mpower) - Math.abs(Math.pow(cathetus, Point.mpower)));
    double sqhyp = Math.pow(hypothesis, Point.mpower);
    double sqcath = Math.pow(cathetus, Point.mpower);
    double diffhc = sqhyp - sqcath;
    double cath2 = Math.sqrt(diffhc);
    return Math.round(cath2);
    //Но если сделать округление - return Math.round(Math.sqrt(Math.pow(hypothesis, Point.mpower) - Math.pow(catehetus, Point.mpower))); - то все почему-то сходится.
  }
}
