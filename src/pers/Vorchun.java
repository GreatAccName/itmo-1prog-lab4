package lib.pers;

import lib.enums.*;
import lib.additions.Clothes;
import lib.interf.*;
import lib.exceptions.*;

final public class Vorchun extends Person
implements Vorchunable, FugitivablePatient {
    public Vorchun(Place p, Rank r) {
        super("Ворчун", p, r);
    }

    // анонимный класс
    private Sickable health = new Sickable() {
        @Override
        public void sick() {
            setDisease();
            System.out.println(getName() + " чем-то болеет");
        }

        @Override
        public void feelGood() {
            removeDisease();
            System.out.println(getName() +
                " чувствует себя здорово");
        }
    };

    public void setBadHealth() { health.sick(); }
    public void setGoodHealth() { health.feelGood(); }

    // Vorchunable
    @Override
    public void grumble() {
        System.out.println(getName() +
            " порой ворчит");
    }
    @Override
    public void beHappy() {
        System.out.println(getName() +
            " обрел счастье и улыбается");
    }

    // FugitivablePatient
    @Override
    public void feelAddSession() {
        System.out.println(getName() +
            " ощущает приближение допсы");
    }
    @Override
    public void stealClothes(Clothes... arrCl)
    throws MyNullCallException {
        if (arrCl.length == 0) {
            System.out.println(getName() + " одежды " +
                "не нашел, но искал и хотел укарсть");
            return;
        }
        for (Clothes cl : arrCl) {
            if (cl.getPerson()==null || cl.getPlace()==null) {
                throw new MyNullCallException();
            }
            System.out.println(getName() +
                " похищает одежду персоны " +
                cl.getPerson().getName());
            cl.setPlace(Place.VORCHUNs_POCKET);
        }
    }
    @Override
    public void runOut() {
        System.out.println(getName() + " сбегает спокойно");
    }
    @Override
    public void seat() {
        System.out.println(getName() + " сидит, притаившись");
    }
    @Override
    public void look() {
        final String sky = "прозрачное синее небо";
        final String grass = "свежую зеленую травку";
        
        // локальный класс
        class ToLook {
            public String onSmth() {
                return new String(" с наслаждением" +
                    " глядит на " + sky +
                    ", на " + grass);
            }
        }

        System.out.println(getName() + (new ToLook()).onSmth());
    }
    @Override
    public void promise(Place pl) {
        System.out.println(getName() + " дал клятву" +
            " никогда не ворчать и быть счастливым,\n"
            + " если только не попадет в место: " +
            pl.toString());
    }
    @Override
    public void look(Person pr, Place pl) {
        System.out.println(getName() +
            " видит, что персона " +
            pr.getName() + " скрывается в месте " +
            pl.toString());
    }
    @Override
    public void standUp() {
        System.out.println(getName() +
            " потихоньку выходит из засады");
    }
    @Override
    public void found(Person pr) {
        System.out.println(getName() +
            " разыскал персону " +
            pr.getName());
    }
    @Override
    public void giveClothes(Clothes cl, Person pr, Place pl) {
        Clothes[] arrCl = Clothes.getAllClothes();
        boolean isThereClothes = false;
        for (int i = 0; i < arrCl.length && arrCl[i] != null; ++i) {
            if (arrCl[i].getPlace() == Place.VORCHUNs_POCKET &&
            cl == arrCl[i]) {
                isThereClothes = true;
                break;
            }
        }
        if (isThereClothes) {
            System.out.println(getName() +
                " отдал одежду персоны " +
                cl.getPerson().getName() +
                " персоне " + pr.getName());
            cl.setPlace(pl);
        }
        else {
            System.out.println("Пилюлькин хотел одеться, но не смог");
        }
    }
}