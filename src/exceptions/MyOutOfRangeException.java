package lib.exceptions;

import java.lang.RuntimeException;

// Массив одежды ограничен размером: 20.
// На всякий случай пропишу исключение.
// Это исключение решил не обрабатывать,
// что сделать могу, т.к. unchecked.
public class MyOutOfRangeException extends RuntimeException {
    public MyOutOfRangeException() {
        super("\n ################################\n" +
            " Выход за предел массива\n" +
            " ################################\n");
    }
}