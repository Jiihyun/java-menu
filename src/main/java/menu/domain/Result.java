package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategories;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final WeekMenuCategories weekMenuCategories;
    private final NonEdibleMenu nonEdibleMenu;

    public Result(WeekMenuCategories weekMenuCategories, NonEdibleMenu nonEdibleMenu) {
        this.weekMenuCategories = weekMenuCategories;
        this.nonEdibleMenu = nonEdibleMenu;
    }

    public static Result from(WeekMenuCategories weekMenuCategories, NonEdibleMenu nonEdibleMenu) {
        return new Result(weekMenuCategories, nonEdibleMenu);
    }

    public Map<Name, List<Menu>> getMenusPerPerson() {
        Map<Name, List<Menu>> resultRecommendMenus = new LinkedHashMap<>();
        Map<Name, List<Menu>> nonEdibleMenuPerPerson = nonEdibleMenu.getNonEdibleMenu();

        for (Name name : nonEdibleMenuPerPerson.keySet()) {
            resultRecommendMenus.put(name, new ArrayList<>());
        }
        for (MenuCategories weekMenuCategory : weekMenuCategories.getWeekMenuCategories()) {
            for (Name name : nonEdibleMenu.getNonEdibleMenu().keySet()) {
                Menu menu = Menu.from(Randoms.shuffle(Menu.getMenuNames((weekMenuCategory))).get(0));
                while (nonEdibleMenuPerPerson.get(name).contains(menu) || resultRecommendMenus.get(name).contains(menu)) {
                    menu = Menu.from(Randoms.shuffle(Menu.getMenuNames(weekMenuCategory)).get(0));
                }
                resultRecommendMenus.get(name).add(menu);
            }
        }
        return resultRecommendMenus;
    }
}
