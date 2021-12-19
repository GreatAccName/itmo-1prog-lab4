package lib.enums;

public enum Place {
    HOSPITAL("больница \"Укол-Комарика\""),
    PANTRY("кладовая"),
    ITMO("ИТМО"),
    FOREST("лес"),
    THICKETS("заросли лопуха"),
    VORCHUNs_POCKET("карман Ворчуна"),
    PILULKINs_HOLD("владение Пилюлькина");

    private String title;

    private Place(String t) { title = t; }

    @Override
    public String toString() { return title; }
}