package menu.domain;

import menu.validator.NameValidator;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        NameValidator.validateNameLength(name);
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}
