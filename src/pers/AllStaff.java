package lib.pers;

import lib.enums.*;
import lib.additions.Clothes;
import lib.pers.Person;
import java.util.ArrayList;

final public class AllStaff extends Personage {
    public AllStaff(Place p) {
        super("Весь персонал", p);
        System.out.println(getName() +
            " прибывает в место: " + p.toString());
    }

    @Override
    public void setPlace(Place p) {
        place = p;
        System.out.println("Весь персонал" +
            " прибывает в место: " + p.toString());
    }

    public void run(Person pr) {
        System.out.println("Весь персонал" +
            " бросается в погоню за персоной "+
            pr.getName());
    }
    public void detectEscape(Person pr) {
        System.out.println("Весь персонал" +
            " обнаруживает исчезновение" +
            " персоны " + pr.getName());
    }
    public int detectClothesIn(Place pl) {
        int cnt = 0;
        ArrayList<Person> arrPr = new ArrayList<Person>();
        Clothes[] arrCl = Clothes.getAllClothes();
        for (int i = 0;
        i < arrCl.length && arrCl[i] != null; ++i) {
            if (pl == arrCl[i].getPlace()) {
                ++cnt;
                arrPr.add(arrCl[i].getPerson());
            }
        }
        System.out.println("Весь персонал" +
            " обнаруживает одежду" +
            " в количестве " + cnt);
        System.out.print(" Принадлежность одежды:");
        for (Person pr : arrPr) {
            System.out.print(" " + pr.getName());
        }
        System.out.println();
        return cnt;
    }
}