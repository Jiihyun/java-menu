package menu.domain.menu;

import static menu.domain.menu.MenuCategories.ASIAN;

public enum AsianFood {
    POTTAI("팟타이", ASIAN),
    KAOPOT("카오 팟", ASIAN),
    NASIGORENG("나시고렝", ASIAN),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥", ASIAN),
    COM_PHO("쌀국수", ASIAN),
    TOM_YUM_KUNG("똠얌꿍", ASIAN),
    BANH_MI("반미", ASIAN),
    GOI_CUON("월남쌈", ASIAN),
    BUN_CHAO_GA("분짜", ASIAN);
    private final String name;

    private final MenuCategories category;

    AsianFood(String name, MenuCategories category) {
        this.name = name;
        this.category = category;
    }
}
