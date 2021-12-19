package lib.interf;

import lib.enums.*;
import lib.pers.*;
import lib.exceptions.*;

public interface Pilulkinable {
    public abstract void inspection(Person pr)
        throws BadInspectionException;
}