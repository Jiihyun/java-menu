package menu.controller;

import menu.domain.*;
import menu.domain.dto.input.NamesRequest;
import menu.domain.dto.input.NonEdibleMenuRequest;
import menu.domain.dto.output.NamesResponse;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CategorySelector categorySelector;

    public MenuController(InputView inputView, OutputView outputView, CategorySelector categorySelector) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.categorySelector = categorySelector;
    }

    public void start() {
        NonEdibleMenu nonEdibleMenu = readNameAndNonEdibleMenu();
        WeekMenuCategories weekMenuCategories = WeekMenuCategories.from(categorySelector);
        Result result = Result.from(weekMenuCategories, nonEdibleMenu);
        outputView.printResult(weekMenuCategories, result);
    }

    private NonEdibleMenu readNameAndNonEdibleMenu() {
        NamesRequest namesRequest = inputView.readNames();
        Names names = Names.from(namesRequest.getInputNames());
        NamesResponse namesResponse = names.toNamesResponse(names);
        NonEdibleMenuRequest nonEdibleMenuRequest = inputView.readNonEdibleMenu(namesResponse);
        return NonEdibleMenu.from(nonEdibleMenuRequest);
    }
}
