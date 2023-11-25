package menu.domain.dto.input;

import java.util.List;

public class NamesRequest {
    private final List<String> inputNames;

    private NamesRequest(List<String> inputNames) {
        this.inputNames = inputNames;
    }

    public static NamesRequest from(List<String> inputNames) {
        return new NamesRequest(inputNames);
    }

    public List<String> getInputNames() {
        return inputNames;
    }
}
