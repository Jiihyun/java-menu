package menu.domain;

import menu.domain.menu.MenuCategories;

import java.util.ArrayList;
import java.util.List;


public class WeekMenuCategories {
    private static final int WEEKDAY_SIZE = 5;
    private final List<MenuCategories> weekMenuCategories;

    private WeekMenuCategories(List<MenuCategories> weekMenuCategories) {
        this.weekMenuCategories = weekMenuCategories;
    }

    public static WeekMenuCategories from(CategorySelector categorySelector) {
        List<MenuCategories> weekMenuCategories = new ArrayList<>();
        while (weekMenuCategories.size() < WEEKDAY_SIZE) {
            MenuCategories category = categorySelector.getCategory();
            if (weekMenuCategories.stream().filter(menuCategories -> menuCategories == category).count() < 2) {
                weekMenuCategories.add(category);
            }
        }
        return new WeekMenuCategories(weekMenuCategories);
    }

    public List<MenuCategories> getWeekMenuCategories() {
        return weekMenuCategories;
    }
}
