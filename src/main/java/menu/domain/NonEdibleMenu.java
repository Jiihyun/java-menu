package menu.domain;

import menu.domain.dto.input.NonEdibleMenuRequest;
import menu.domain.menu.Menu;
import menu.validator.MenuValidator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NonEdibleMenu {
    private final Map<Name, List<Menu>> nonEdibleMenu;

    private NonEdibleMenu(Map<Name, List<Menu>> nonEdibleMenu) {
        this.nonEdibleMenu = nonEdibleMenu;
    }

    public static NonEdibleMenu from(NonEdibleMenuRequest nonEdibleMenuRequest) {
        MenuValidator.validateMenuQuantity(nonEdibleMenuRequest);
        Map<Name, List<Menu>> nonEdibleMenu = nonEdibleMenuRequest.getNonEdibleMenu().entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream().map(Menu::from).collect(Collectors.toList())
                ));
        return new NonEdibleMenu(nonEdibleMenu);
    }

    public Map<Name, List<Menu>> getNonEdibleMenu() {
        return nonEdibleMenu;
    }
}
