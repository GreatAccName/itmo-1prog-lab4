package lib.pers;

import lib.enums.*;
import lib.additions.Clothes;
import lib.interf.*;
import java.util.Random;
import lib.exceptions.*;

final public class Pilulkin extends Person
implements Pilulkinable, FugitivableDoctor {
    public static final double BAD_INSPECT_PROB = 0.20;
    
    // статический вложенный класс
    public static class InpectionQuality {
        private static Random gen = new Random();

        public static boolean wasBad() {
            if (gen.nextDouble() < BAD_INSPECT_PROB) {
                System.out.println("Пилюлькин старался, " +
                    "но ничего не нашел\nИстории конец, " +
                    "кто слушал - молодец");
                return true;
            }
            else { return false; }
        }

        public static double getBadProb()
            { return BAD_INSPECT_PROB; }
    }

    public Pilulkin(Place p, Rank r) {
        super("Пилюлькин", p, r);
    }
    
    // Pilulkinable
    @Override
    public void inspection(Person pr)
    throws BadInspectionException, MyNullCallException {
        System.out.println("Пилюлькин осматривает " +
            "персону " + pr.getName());

        if (InpectionQuality.wasBad()) {
            throw new BadInspectionException();
        }

        String diseaseName;
        try {
            diseaseName = pr.getDiseaseName();
        } catch (MyNullCallException e) {
            System.out.println(pr.getName() + " здоров");
            throw e;
        }
        
        System.out.print("Результат осмотра: ");
        System.out.println("недуг персоны " +
            pr.getName() +
            " - " + diseaseName);
        pr.setRank(Rank.PATIENT);
    }

    // FugitivableDoctor
    @Override
    public void wannaTeach() {
        System.out.println("Пилюлькин ощущает" +
            " безудержное рвение стать преподавателем");
    }
    @Override
    public void makePlane(Person pr, Place pl) {
        System.out.println("Пилюлькин и " +
            pr.getName() + " придумали план побега" +
            " из места: " + pl.toString());
    }
    @Override
    public void runOut() {
        System.out.println("Пилюлькин сбегает" +
            " в голом виде через окно");
    }
    @Override
    public void hug(Person pr) {
        System.out.println("Пилюлькин бросился" +
            " обнимать персону " + pr.getName());
    }
    @Override
    public void beFriend(Person pr, Place pl) {
        System.out.println("Пилюлькин и " +
            pr.getName() + " сдружились в месте: " +
            pl.toString());
    }
    @Override
    public void getDressed() {
        Clothes[] arrCl = Clothes.getAllClothes();
        boolean isTherePilulkinsClothes = false;
        for (int i = 0; i < arrCl.length && arrCl[i] != null; ++i) {
            if (arrCl[i].getPlace() == Place.PILULKINs_HOLD) {
                isTherePilulkinsClothes = true;
                break;
            }
        }
        if (isTherePilulkinsClothes) {
            System.out.println("Пилюлькин одевается");
        }
        else {
            System.out.println("Пилюлькин хотел одеться, но не смог");
        }
    }
}