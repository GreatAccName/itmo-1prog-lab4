package lib.pers;

import lib.enums.*;
import lib.exceptions.*;

public class Person extends Personage {
    protected Rank rank;

    // вложенный класс
    public enum Disease {
        MELANCHOLY("меланхолия");
        private String title;
        private Disease(String t) { title = t; }
        @Override
        public String toString() { return title; }
    }

    private Disease disease = null;

    public Person(String n, Place p, Rank r) {
        super(n, p);
        System.out.println(getName() +
            " прибывает в место: " + p.toString());
        rank = r;
        System.out.println(getName() +
            " - " + r.toString());
    }

    @Override
    public void setPlace(Place p) {
        place = p;
        System.out.println(getName() +
            " прибывает в место: " + p.toString());
    }

    public void setRank(Rank r) {
        rank = r;
        System.out.println(getName() + " - " + r.toString());
    }

    protected void setDisease() { disease = Disease.MELANCHOLY; }
    protected void removeDisease() { disease = null; }

    public Rank getRank() { return rank; }

    public String getDiseaseName()
    throws MyNullCallException {
        if (disease == null) {
            throw new MyNullCallException();
        }
        return disease.toString();
    }
}