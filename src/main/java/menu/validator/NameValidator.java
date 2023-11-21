package menu.validator;

import menu.exception.ExceptionMessage;

import java.util.List;

public class NameValidator {
    private static final int MINUMUM_NUMBER_OF_PEOPLE = 2;
    private static final int MAXIMUM_NUMBER_OF_PEOPLE = 5;
    private static final int MINUMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;

    public static void validateCapacity(List<String> inputNames) {
        if (isOutOfCapacityRange(inputNames)) {
            throw ExceptionMessage.CAPACITY.getException();
        }
    }

    private static boolean isOutOfCapacityRange(List<String> inputNames) {
        return inputNames.size() < MINUMUM_NUMBER_OF_PEOPLE || inputNames.size() > MAXIMUM_NUMBER_OF_PEOPLE;
    }

    public static void validateNameLength(String name) {
        if (isNotRightNameLengthRange(name)) {
            throw ExceptionMessage.NAME_LENGTH.getException();
        }
    }

    private static boolean isNotRightNameLengthRange(String name) {
        return name.length() < MINUMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH;
    }

    public static void validateDuplicatedName(List<String> inputNames) {
        if (isDuplicated(inputNames)) {
            throw ExceptionMessage.DUPLICATED_NAME.getException();
        }
    }

    private static boolean isDuplicated(List<String> inputNames) {
        return inputNames.stream().distinct().count() != inputNames.size();
    }
}

