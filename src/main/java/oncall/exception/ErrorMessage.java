package oncall.exception;

public enum ErrorMessage {
    INVALID("유효하지 않습니다."),
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
