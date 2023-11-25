package menu.view;

import menu.domain.Name;
import menu.domain.ResultCategories;
import menu.domain.WeekMenuCategories;
import menu.domain.menu.Menu;
import menu.domain.menu.MenuCategories;
import menu.io.writer.Writer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String FORMAT = "[ %s | %s ]" + System.lineSeparator();
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void printResult(WeekMenuCategories weekMenuCategories, ResultCategories resultCategories) {
        writer.writeln(System.lineSeparator() + "메뉴 추천 결과입니다.");
        writer.writeln("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        String categories = weekMenuCategories.getWeekMenuCategories().stream().map(MenuCategories::getName).collect(Collectors.joining(" | "));
        writer.writef(FORMAT, "카테고리", categories);
        for (Map.Entry<Name, List<Menu>> entry : resultCategories.getMenusPerPerson().entrySet()) {
            String name = entry.getKey().getName();
            String menus = entry.getValue().stream().map(Menu::getName).collect(Collectors.joining(" | "));
            writer.writef(FORMAT, name, menus);
        }
        writer.writeln(System.lineSeparator() + "추천을 완료했습니다.");
    }
}
