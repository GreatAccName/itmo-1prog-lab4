package lib.additions;

import lib.enums.*;
import lib.pers.*;
import lib.exceptions.*;

final public class Clothes {
    private static final int MAX_IND = 20;
    private static Clothes[] allClothes = new Clothes[MAX_IND];
    private static int ind = 0;

    private Place place;
    private Person person;

    public Clothes() throws MyOutOfRangeException {
        place = null;
        person = null;
        if (ind == MAX_IND) {
            throw new MyOutOfRangeException();
        }
        else { allClothes[ind++] = this; }
    }

    public Clothes(Place pl, Person pr)
    throws MyOutOfRangeException {
        place = pl;
        person = pr;
        if (ind == MAX_IND) {
            throw new MyOutOfRangeException();
        }
        else { allClothes[ind++] = this; }
        System.out.println("Одежда персоны " + 
            pr.getName() + " попадает в " + 
            "место: " + pl.toString());
    }

    public void setPlace(Place pl) {
        place = pl;
        System.out.println("Одежда персоны " + 
            person.getName() + " попадает в " + 
            "место: " + place.toString());
    }

    public void setPerson(Person pr) {
        System.out.println("Одежда переходит" +
            " от персоны " + person.getName() +
            " к персоне " + pr.getName());
        person = pr;
    }

    public static Clothes[] getAllClothes() { return allClothes; }
    public Place getPlace() { return place; }
    public Person getPerson() { return person; }
    public static int getArrSize() { return ind; }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj instanceof Clothes) ) {
            return false;
        }
        if (place != ((Clothes)obj).getPlace()) {
            return false;
        }
        if (person != ((Clothes)obj).getPerson()) {
            return false;
        }
        return true;
    }
}