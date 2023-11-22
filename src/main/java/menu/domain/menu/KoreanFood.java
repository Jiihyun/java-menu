package menu.domain.menu;

import static menu.domain.menu.MenuCategories.KOREAN;

public enum KoreanFood {
    GIMBAP("김밥", KOREAN),
    KIMCHI_JJIGAE("김치찌개", KOREAN),
    SSAMBAB("쌈밥", KOREAN),
    DOENJANG_JJIGAE("된장찌개", KOREAN),
    BIBIMBAP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    JAEYUK_BOKKEUM("제육볶음", KOREAN);
    private final String name;
    private final MenuCategories category;

    KoreanFood(String name, MenuCategories category) {
        this.name = name;
        this.category = category;
    }
}
