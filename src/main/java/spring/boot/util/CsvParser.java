package spring.boot.util;

public interface CsvParser<T> {

    T parseLineToDto(String line);
}
