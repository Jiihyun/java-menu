package menu.domain.menu;

import static menu.domain.menu.MenuCategories.CHINESE;

public enum ChineseFood {
    KANPOONGGI("깐풍기", CHINESE),
    BOKKEUMMYEON("볶음면", CHINESE),
    DONGPAYUK("동파육", CHINESE),
    JAJANGMYEON("짜장면", CHINESE),
    JJAMPPONG("짬뽕", CHINESE),
    MAPADUBU("마파두부", CHINESE),
    TANGSUYUK("탕수육", CHINESE),
    TOMATOEGGBOKKEUM("토마토 달걀볶음", CHINESE),
    GOCHUJAPCHAE("고추잡채", CHINESE);
    private final String name;
    private final MenuCategories category;

    ChineseFood(String name, MenuCategories category) {
        this.name = name;
        this.category = category;
    }
}
