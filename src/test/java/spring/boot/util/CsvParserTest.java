package spring.boot.util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.dto.ReviewDto;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CsvParserTest {
    private static String INPUT_TEXT = "1, p1, u1, user, 2, 3, 5, 1219017600, test1, testing";
    private static String NON_CSV = "I am sassy line!";
    private static String WRONG_TYPE_PARAMS = "first, second";

    @Autowired
    private CsvParser<ReviewDto> csvParser;

    @Test
    public void parseOkay() {
        ReviewDto result = csvParser.parseLineToDto(INPUT_TEXT);
        ReviewDto expected = new ReviewDto(1, "p1", "u1", "user", 2, 3,
                5, 1219017600, "test1", "testing");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void parseNotScvLine() {
        assertThrows(RuntimeException.class, () ->
                csvParser.parseLineToDto(NON_CSV));
    }

    @Test
    public void parseWrongTypeInCsv() {
        assertThrows(RuntimeException.class, () ->
                csvParser.parseLineToDto(WRONG_TYPE_PARAMS + INPUT_TEXT.substring(2)));
    }
}