package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategories;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultCategories {
    private static final int WEEKDAY_SIZE = 5;
    private final List<MenuCategories> weekMenuCategories;
    private final NonEdibleMenu nonEdibleMenu;

    public ResultCategories(List<MenuCategories> weekMenuCategories, NonEdibleMenu nonEdibleMenu) {
        this.weekMenuCategories = weekMenuCategories;
        this.nonEdibleMenu = nonEdibleMenu;
    }

    public static ResultCategories from(CategorySelector categorySelector, NonEdibleMenu nonEdibleMenu) {
        List<MenuCategories> weekMenuCategories = new ArrayList<>();
        while (weekMenuCategories.size() < WEEKDAY_SIZE) {
            MenuCategories category = categorySelector.getCategory();
            if (weekMenuCategories.stream().filter(menuCategories -> menuCategories == category).count() < 2) {
                weekMenuCategories.add(category);
            }
        }
        return new ResultCategories(weekMenuCategories, nonEdibleMenu);
    }

    public Map<Name, List<Menu>> getMenusPerPerson() {
        Map<Name, List<Menu>> weekMenu = new LinkedHashMap<>();
        for (MenuCategories weekMenuCategory : weekMenuCategories) {
            Menu menu = Menu.from(Randoms.shuffle(Menu.getMenuNames(weekMenuCategory)).get(0));
            for (Name name : nonEdibleMenu.getNonEdibleMenu().keySet()) {
                if (weekMenu.get(name).contains(menu) && nonEdibleMenu.getNonEdibleMenu().get(name).contains(menu)) {
                    weekMenu.get(name).add(menu);
                }
            }
        }
        return weekMenu;
    }

    public List<MenuCategories> getWeekMenuCategories() {
        return weekMenuCategories;
    }
}
