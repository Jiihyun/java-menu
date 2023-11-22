package menu.domain.menu;

import static menu.domain.menu.MenuCategories.WESTERN;

public enum WesternFood {
    LASAGNA("라자냐", WESTERN),
    GRATIN("그라탱", WESTERN),
    NYOKKI("뇨끼", WESTERN),
    KISHU("끼슈", WESTERN),
    FRENCH_TOAST("프렌치 토스트", WESTERN),
    BAGUETTE("바게트", WESTERN),
    SPAGHETTI("스파게티", WESTERN),
    PIZZA("피자", WESTERN),
    PANINI("파니니", WESTERN);

    private final String name;
    private final MenuCategories category;

    WesternFood(String name, MenuCategories category) {
        this.name = name;
        this.category = category;
    }
}
