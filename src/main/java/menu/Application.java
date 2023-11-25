package menu;

import menu.controller.MenuController;
import menu.domain.CategorySelector;
import menu.io.reader.ConsoleReader;
import menu.io.reader.Reader;
import menu.io.writer.ConsoleWriter;
import menu.io.writer.Writer;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        InputView inputView = new InputView(reader, writer);
        OutputView outputView = new OutputView(writer);
        CategorySelector categorySelector = new CategorySelector();
        MenuController menuController = new MenuController(inputView, outputView, categorySelector);
        menuController.start();
    }
}
