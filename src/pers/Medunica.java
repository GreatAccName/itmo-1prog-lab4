package lib.pers;

import lib.enums.*;

final public class Medunica extends Person {
    public Medunica(Place p, Rank r) {
        super("Медуница", p, r);
    }
    public void search(Person pr) {
        System.out.println("Медуница " +
            "долго разыскивает персону " +
            pr.getName());
    }
}