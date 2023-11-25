package menu.domain.dto.output;

import menu.domain.Name;

import java.util.List;

public class NamesResponse {
    private final List<Name> names;

    private NamesResponse(List<Name> names) {
        this.names = names;
    }

    public static NamesResponse from(List<Name> names) {
        return new NamesResponse(names);
    }

    public List<Name> getNames() {
        return names;
    }
}
