package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menu.MenuCategories;

public class CategorySelector {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 5;

    public MenuCategories getCategory() {
        int number = generateCategoryNumber();
        return MenuCategories.from(number);
    }

    private int generateCategoryNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
