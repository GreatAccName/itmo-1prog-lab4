package lib.exceptions;

import java.lang.RuntimeException;

// Попытка вызвать метод от null.
// Может быть выброшен при осмотре,
// если болезнь не назначена
// и если одежда никому не принадлежит.
// Обработка в Story.
public class MyNullCallException extends RuntimeException {
    public MyNullCallException() {
        super(" ////////////////////////////////\n " +
            " Попытка вызова метода от \"null\"\n" +
            " ////////////////////////////////");
    }
}