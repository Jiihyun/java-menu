package menu.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    private static final String REGEX = ",";

    public static List<String> strToList(String names) {
        return Arrays.stream(names.split(REGEX))
                .collect(Collectors.toUnmodifiableList());
    }
}
