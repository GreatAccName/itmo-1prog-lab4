package lib.pers;

import lib.enums.*;

public abstract class Personage {
    private String name;
    protected Place place;

    public Personage(String n, Place p) {
        name = n;
        place = p;
    }

    public abstract void setPlace(Place p);

    public String getName() { return name; }
    public Place getPlace() { return place; }
}