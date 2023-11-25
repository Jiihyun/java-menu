package menu.validator;

import menu.domain.dto.input.NonEdibleMenuRequest;
import menu.exception.ExceptionMessage;

public class MenuValidator {
    private MenuValidator() {
        throw new AssertionError();
    }

    public static void validateMenuQuantity(NonEdibleMenuRequest nonEdibleMenuRequest) {
        if (nonEdibleMenuRequest.getNonEdibleMenu().values().stream().anyMatch(menus -> menus.size() > 2)) {
            throw ExceptionMessage.MENU_QUANTITY.getException();
        }
    }
}
