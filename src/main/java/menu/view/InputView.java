package menu.view;

import menu.converter.Converter;
import menu.io.reader.Reader;
import menu.io.writer.Writer;

import java.util.List;

public class InputView {
    private static final String START_MSG = "점심 메뉴 추천을 시작합니다.";
    private static final String INPUT_NAME_MSG = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_MENU_MSG = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> readNames() {
        writer.writeln(START_MSG);
        writer.writeln(INPUT_NAME_MSG);
        String names = reader.readLine();
        return Converter.strToList(names);
    }

    public List<String> readNonEdibleMenu(String name) {
        writer.writef(name + INPUT_MENU_MSG + System.lineSeparator());
        String menus = reader.readLine();
        return Converter.strToList(menus);
    }

}
