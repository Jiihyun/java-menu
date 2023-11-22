package menu.domain;

import menu.domain.menu.MenuCategories;

import java.util.ArrayList;
import java.util.List;

public class ResultCategories {
    private static final int WEEKDAY_SIZE = 5;
    private final List<MenuCategories> weekMenuCategories;

    private ResultCategories(List<MenuCategories> weekMenuCategories) {
        this.weekMenuCategories = weekMenuCategories;
    }

    public static ResultCategories from(CategorySelector categorySelector) {
        List<MenuCategories> weekMenuCategories = new ArrayList<>();
        while (weekMenuCategories.size() < WEEKDAY_SIZE) {
            MenuCategories category = categorySelector.getCategory();
            if (weekMenuCategories.stream().filter(menuCategories -> menuCategories == category).count() == 2) {
                break;
            }
            weekMenuCategories.add(category);
        }
        return new ResultCategories(weekMenuCategories);
    }
}
