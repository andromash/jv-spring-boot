package spring.boot.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class SystemFileReader implements ReaderService {

    @Override
    public List<String> readData(String dataSource) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dataSource))) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Cannot read data from file with path " + dataSource, e);
        }
    }
}
