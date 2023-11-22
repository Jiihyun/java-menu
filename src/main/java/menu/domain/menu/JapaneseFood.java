package menu.domain.menu;

public enum JapaneseFood {
    GYUDON("규동", MenuCategories.JAPANESE),
    UDON("우동", MenuCategories.JAPANESE),
    MISOSHIRU("미소시루", MenuCategories.JAPANESE),
    SUSHI("스시", MenuCategories.JAPANESE),
    KATSUDON("가츠동", MenuCategories.JAPANESE),
    ONIGIRI("오니기리", MenuCategories.JAPANESE),
    HAYARICE("하이라이스", MenuCategories.JAPANESE),
    RAMEN("라멘", MenuCategories.JAPANESE),
    OKONOMIYAKI("오코노미야끼", MenuCategories.JAPANESE);
    private final String name;
    private final MenuCategories category;

    JapaneseFood(String name, MenuCategories category) {
        this.name = name;
        this.category = category;
    }
}
