package lib.interf;

import lib.enums.*;
import lib.pers.*;
import lib.additions.Clothes;
import lib.exceptions.*;

public interface FugitivablePatient {
    public abstract void feelAddSession();
    public abstract void stealClothes(Clothes... arrCl)
        throws MyNullCallException;
    public abstract void runOut();
    public abstract void seat();
    public abstract void look(); // тут локальный класс
    public abstract void promise(Place pl);
    public abstract void look(Person pr, Place pl);
    public abstract void standUp();
    public abstract void found(Person pr);
    public abstract void giveClothes(Clothes cl, Person pr, Place pl);
}