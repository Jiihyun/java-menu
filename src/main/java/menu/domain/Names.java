package menu.domain;

import menu.domain.dto.output.NamesResponse;
import menu.validator.NameValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names from(List<String> inputNames) {
        NameValidator.validateCapacity(inputNames);
        NameValidator.validateDuplicatedName(inputNames);
        List<Name> names = inputNames.stream()
                .map(Name::from)
                .collect(Collectors.toUnmodifiableList());
        return new Names(names);
    }

    public NamesResponse toNamesResponse(Names names) {
        return NamesResponse.from(names.names);
    }
}
