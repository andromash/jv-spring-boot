package spring.boot.util;

import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SystemFileReaderTest {
    private static final String PATH = "src/test/resources";
    private static final String FILE_NAME = "/test.csv";
    private static final String EMPTY_FILE_NAME = "/emptyfile.csv";
    private static final String WRONG_PATH = "/magic.csv";

    @Autowired
    private ReaderService readerService;

    @Test
    public void readFileOk() {
        List<String> expected = List.of("1, test, superb, no logic here, just reading",
                "2, test2, super, no logic here, just reading");
        List<String> result = readerService.readData(PATH + FILE_NAME);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void readEmptyFile() {
        List<String> result = readerService.readData(PATH + EMPTY_FILE_NAME);
        Assert.assertEquals(List.of(), result);
    }

    @Test
    public void readWrongPath() {
        assertThrows(RuntimeException.class, () -> {
            readerService.readData(WRONG_PATH);
        });
    }
}
