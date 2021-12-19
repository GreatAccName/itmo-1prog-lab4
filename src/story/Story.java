package lib.story;

import lib.enums.*;
import lib.pers.*;
import lib.additions.*;
import lib.interf.Happyable;
import lib.exceptions.*;
import java.util.Random;

import java.lang.reflect.*;

public class Story {
    public static final double OK_PROB = 0.75;
    public static void main(String[] args) {
        System.out.println("--------------------");
        Random gen = new Random();

        // выброс ислючения без обработки
        if (gen.nextDouble() > OK_PROB) {
            checkUnchecked();
        }

        AllStaff als = new AllStaff(Place.HOSPITAL);
        Pilulkin pil = new Pilulkin(Place.HOSPITAL, Rank.DOCTOR);
        Medunica med = new Medunica(Place.HOSPITAL, Rank.NURSE);
        Bulka blk = new Bulka(Place.HOSPITAL, Rank.PATIENT);
        Clothes clPil = new Clothes(Place.PANTRY, pil);
        Clothes clBlk = new Clothes(Place.PANTRY, blk);
        Vorchun vrc = new Vorchun(Place.ITMO, Rank.FRESHMAN);

        // если болезнь не будет установлена,
        // то выбрасывается исключение
        if (gen.nextDouble() < OK_PROB) {
            vrc.setBadHealth();
            vrc.grumble();
        }

        System.out.println();
        // осмотр может выбросить 2 исключения
        vrc.setPlace(Place.HOSPITAL);
        try {
            pil.inspection(vrc);
        } catch(BadInspectionException e) {
            System.out.println(e.getMessage());
            return;
        } catch(MyNullCallException e) {
            System.out.println(e.getMessage());
        }
        Clothes clVrc = new Clothes(Place.PANTRY, vrc);
        System.out.println();

        pil.wannaTeach();
        vrc.feelAddSession();
        pil.makePlane(vrc, Place.HOSPITAL);
        System.out.println();

        pil.setRank(Rank.FUGITIVE);
        vrc.setRank(Rank.FUGITIVE);
        pil.runOut();
        pil.setPlace(Place.FOREST);
        als.run(pil);
        vrc.setPlace(Place.PANTRY);

        // поля в классе Clothes инициализируется null
        // unchecked => если не писать try-catch,
        // компилятор ошибки не выдает
        if (gen.nextDouble() < OK_PROB) {
            vrc.stealClothes(clVrc, clPil);
        }
        else {
            try {
                Clothes cl = new Clothes();
                vrc.stealClothes(cl);
            }
            catch(MyNullCallException e) {
                System.out.println(e.getMessage());
            }
        }

        vrc.runOut();
        vrc.setPlace(Place.FOREST);
        System.out.println();

        als.setPlace(Place.PANTRY);
        als.detectEscape(vrc);
        als.detectClothesIn(Place.PANTRY);
        System.out.println();

        med.search(vrc);
        vrc.setPlace(Place.THICKETS);
        vrc.seat();
        vrc.look();
        vrc.beHappy();
        vrc.promise(Place.HOSPITAL);
        System.out.println();

        vrc.look(med, Place.HOSPITAL);
        vrc.standUp();
        vrc.setPlace(Place.FOREST);
        vrc.found(pil);
        vrc.giveClothes(clPil, pil, Place.PILULKINs_HOLD);
        System.out.println();

        pil.hug(vrc);
        pil.beFriend(vrc, Place.HOSPITAL);
        pil.getDressed();
        pil.setRank(Rank.TEACHER);
        vrc.setRank(Rank.FRESHMAN);
        pil.setPlace(Place.ITMO);
        vrc.setPlace(Place.ITMO);
        System.out.println();

        Avoska avs = new Avoska(Place.ITMO, Rank.FRESHMAN);
        Vintik vnt = new Vintik(Place.ITMO, Rank.FRESHMAN);
        Rasteryajka rsk = new Rasteryajka(Place.ITMO, Rank.FRESHMAN);
        // локальный, анонимный класс
        Happyable happy = new Happyable() {
            @Override
            public void surround(Person prTo, Person... arrPr) {
                System.out.print(arrPr[0].getName());
                for (int i = 1; i < arrPr.length; ++i) {
                    System.out.print(", " +
                        arrPr[i].getName());
                }
                System.out.println(" окружили и поздравили" +
                    " с возвращением персону " + prTo.getName());
            }
            @Override
            public void impressed(Person prTo, Person... arrPr) {
                System.out.print(arrPr[0].getName());
                for (int i = 1; i < arrPr.length; ++i) {
                    System.out.print(", " +
                        arrPr[i].getName());
                }
                System.out.println(" удивлены веселым видом" +
                    " персоны " + prTo.getName());
            }
        };
        happy.surround(vrc, avs, rsk, vnt);
        happy.impressed(vrc, avs, rsk, vnt);

        System.out.println("--------------------");

        // вложенный класс
        System.out.println("\n       innerClass:\t"+
            Person.Disease.class.getName() +"\n");
        // статический класс
        System.out.println("staticNestedClass:\t"+
            Pilulkin.InpectionQuality.class.getName() +"\n");
        // локальный, анонимный класс
        System.out.println("locAnonymousClass:\t"+
            happy.getClass().getName() +"\n");
    }

    public static void checkUnchecked() {
        final int tempSize = 19;
        Clothes[] tempArrCl = new Clothes[tempSize];
        for (int i = 0; i < tempSize; ++i) {
            tempArrCl[i] = new Clothes(
                Place.THICKETS,
                new Avoska(Place.ITMO, Rank.FRESHMAN)
            );
        }
        System.out.println("\nClothes size: " +
            Clothes.getArrSize()  + "\n");
    }
}