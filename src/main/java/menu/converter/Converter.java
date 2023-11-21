package menu.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static final String REGEX = ",";

    public static List<String> strToList(String input) {
        return Arrays.stream(input.split(REGEX))
                .collect(Collectors.toUnmodifiableList());
    }
}
