package menu.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static menu.domain.menu.MenuCategories.*;

public enum Menu {
    NOME("없음", NONE),

    //JAPANESE
    GYUDON("규동", JAPANESE),
    UDON("우동", JAPANESE),
    MISOSHIRU("미소시루", JAPANESE),
    SUSHI("스시", JAPANESE),
    KATSUDON("가츠동", JAPANESE),
    ONIGIRI("오니기리", JAPANESE),
    HAYARICE("하이라이스", JAPANESE),
    RAMEN("라멘", JAPANESE),
    OKONOMIYAKI("오코노미야끼", JAPANESE),

    //KOREAN
    GIMBAP("김밥", KOREAN),
    KIMCHI_JJIGAE("김치찌개", KOREAN),
    SSAMBAB("쌈밥", KOREAN),
    DOENJANG_JJIGAE("된장찌개", KOREAN),
    BIBIMBAP("비빔밥", KOREAN),
    KALGUKSU("칼국수", KOREAN),
    BULGOGI("불고기", KOREAN),
    TTEOKBOKKI("떡볶이", KOREAN),
    JAEYUK_BOKKEUM("제육볶음", KOREAN),

    //CHINESE
    KANPOONGGI("깐풍기", CHINESE),
    BOKKEUMMYEON("볶음면", CHINESE),
    DONGPAYUK("동파육", CHINESE),
    JAJANGMYEON("짜장면", CHINESE),
    JJAMPPONG("짬뽕", CHINESE),
    MAPADUBU("마파두부", CHINESE),
    TANGSUYUK("탕수육", CHINESE),
    TOMATOEGGBOKKEUM("토마토 달걀볶음", CHINESE),
    GOCHUJAPCHAE("고추잡채", CHINESE),

    //ASIAN
    POTTAI("팟타이", ASIAN),
    KAOPOT("카오 팟", ASIAN),
    NASIGORENG("나시고렝", ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN),
    COM_PHO("쌀국수", ASIAN),
    TOM_YUM_KUNG("똠얌꿍", ASIAN),
    BANH_MI("반미", ASIAN),
    GOI_CUON("월남쌈", ASIAN),
    BUN_CHAO_GA("분짜", ASIAN),

    //WESTERN
    LASAGNA("라자냐", WESTERN),
    GRATIN("그라탱", WESTERN),
    NYOKKI("뇨끼", WESTERN),
    KISHU("끼슈", WESTERN),
    FRENCH_TOAST("프렌치 토스트", WESTERN),
    BAGUETTE("바게트", WESTERN),
    SPAGHETTI("스파게티", WESTERN),
    PIZZA("피자", WESTERN),
    PANINI("파니니", WESTERN),
    ;
    private final static List<Menu> menus = List.of(values());
    private final String name;
    private final MenuCategories category;

    Menu(String name, MenuCategories category) {
        this.name = name;
        this.category = category;
    }

    public static Menu from(String inputName) {
        return menus.stream()
                .filter(menu -> menu.name.equals(inputName))
                .findFirst()
                .orElse(NOME);
    }

    public static List<String> getMenuNames(MenuCategories generatedCategory) {
        return Arrays.stream(values())
                .filter(menu -> menu.category.equals(generatedCategory))
                .map(Menu::name)
                .collect(Collectors.toList());
    }
}
