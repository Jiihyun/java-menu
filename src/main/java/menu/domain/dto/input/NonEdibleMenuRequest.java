package menu.domain.dto.input;

import menu.domain.Name;

import java.util.List;
import java.util.Map;

public class NonEdibleMenuRequest {
    private final Map<Name, List<String>> inputNonEdibleMenu;

    private NonEdibleMenuRequest(Map<Name, List<String>> inputNonEdibleMenu) {
        this.inputNonEdibleMenu = inputNonEdibleMenu;
    }

    public static NonEdibleMenuRequest from(Map<Name, List<String>> inputNonEdibleMenu) {
        return new NonEdibleMenuRequest(inputNonEdibleMenu);
    }

    public Map<Name, List<String>> getNonEdibleMenu() {
        return inputNonEdibleMenu;
    }
}
