package menu.view;

import menu.converter.Converter;
import menu.domain.Name;
import menu.domain.dto.input.NamesRequest;
import menu.domain.dto.input.NonEdibleMenuRequest;
import menu.domain.dto.output.NamesResponse;
import menu.io.reader.Reader;
import menu.io.writer.Writer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputView {
    private static final String START_MSG = "점심 메뉴 추천을 시작합니다." + System.lineSeparator();
    private static final String INPUT_NAME_MSG = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_MENU_MSG = "(이)가 못 먹는 메뉴를 입력해 주세요.";
    private final Reader reader;
    private final Writer writer;

    public InputView(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public NamesRequest readNames() {
        writer.writeln(START_MSG);
        writer.writeln(INPUT_NAME_MSG);
        String input = reader.readLine();
        List<String> inputNames = Converter.strToList(input);
        return NamesRequest.from(inputNames);
    }

    public NonEdibleMenuRequest readNonEdibleMenu(NamesResponse namesResponse) {
        Map<Name, List<String>> inputNonEdibleMenu = new HashMap<>();
        List<Name> names = namesResponse.getNames();
        for (Name name : names) {
            writer.writef(System.lineSeparator() + name.getName() + INPUT_MENU_MSG + System.lineSeparator());
            String inputMenus = reader.readLine();
            List<String> menus = Converter.strToList(inputMenus);
            inputNonEdibleMenu.put(name, menus);
        }
        return NonEdibleMenuRequest.from(inputNonEdibleMenu);
    }

}
