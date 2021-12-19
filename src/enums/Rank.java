package lib.enums;

public enum Rank {
    DOCTOR("доктор"),
    FRESHMAN("малыш-первач"),
    PATIENT("пациент"),
    NURSE("медсестра"),
    FUGITIVE("беглец"),
    TEACHER("преподаватель");

    private String title;

    private Rank(String t) { title = t; }

    @Override
    public String toString() { return title; }
}