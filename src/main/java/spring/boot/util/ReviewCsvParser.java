package spring.boot.util;

import com.opencsv.CSVParser;
import java.io.IOException;
import org.springframework.stereotype.Component;
import spring.boot.dto.ReviewDto;

@Component
public class ReviewCsvParser implements CsvParser<ReviewDto> {

    @Override
    public ReviewDto parseLineToDto(String csvLine) {
        ReviewDto reviewDto = new ReviewDto();
        CSVParser csvParser = new CSVParser();
        try {
            String[] parsedLine = csvParser.parseLine(csvLine);
            reviewDto.setId(Integer.parseInt(parsedLine[0].trim()));
            reviewDto.setProductId(parsedLine[1].trim());
            reviewDto.setUserId(parsedLine[2].trim());
            reviewDto.setProfileName(parsedLine[3].trim());
            reviewDto.setHelpfulnessNumerator(Integer.parseInt(parsedLine[4].trim()));
            reviewDto.setHelpfulnessDenominator(Integer.parseInt(parsedLine[5].trim()));
            reviewDto.setScore(Integer.parseInt(parsedLine[6].trim()));
            reviewDto.setTime(Integer.parseInt(parsedLine[7].trim()));
            reviewDto.setSummary(parsedLine[8].trim());
            reviewDto.setText(parsedLine[9].trim());
            return reviewDto;
        } catch (IOException e) {
            throw new RuntimeException("Cannot parse the line " + csvLine, e);
        }
    }
}
