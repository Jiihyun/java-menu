package menu.domain.menu;

import java.util.List;
import java.util.function.Predicate;

public enum MenuCategories {
    NONE("없음", 0),
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5);
    private static final List<MenuCategories> MenuCategories = List.of(values());
    private final String name;
    private final int number;

    MenuCategories(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static MenuCategories from(int number) {
        return MenuCategories.stream().filter(isSameNumberWith(number))
                .findFirst()
                .orElse(NONE);
    }

    private static Predicate<MenuCategories> isSameNumberWith(int number) {
        return category -> category.number == number;
    }

    public String getName() {
        return name;
    }
}
