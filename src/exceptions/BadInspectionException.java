package lib.exceptions;

import java.lang.Exception;

// Пилюлькин не смог ничего найти,
// хотя болезнь у персоны есть.
// Причина такого поведения остается загадкой.
// Обработка в Story.
public class BadInspectionException extends Exception {
    public BadInspectionException() {
        super(" ::::::::::::::::::::::::::::::::\n" +
            " Плохой осмотр\n" +
            " ::::::::::::::::::::::::::::::::");
    }
}