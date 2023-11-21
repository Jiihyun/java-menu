package menu.exception;

public enum ExceptionMessage {
    NAME_LENGTH("이름은 최소 2글자부터 최대 4글자까지 입력 가능합니다.\n"),
    DUPLICATED_NAME("이미 존재하는 이름입니다.\n"),
    CAPACITY("최소 2명부터 최대 5명까지 수용 가능합니다.\n");
    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public MenuException getException() {
        return new MenuException(this.message);
    }
}
