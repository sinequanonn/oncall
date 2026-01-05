package oncall.exception;

public enum ErrorMessage {
    INVALID("유효하지 않습니다."),
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    INVALID_CREW_SIZE("근무자는 최소 5명 최대 35명이어야 합니다."),
    INVALID_CREW_NAME_SIZE("근무자 이름은 5글자 이하여야 합니다."),
    INVALID_WEEKEND_CREW_SIZE("평일 근무자와 사원 정보가 동일하지 않습니다."),
    DUPLICATE_CREW("사원의 이름이 중복입니다."),
    INVALID_WEEKEND_CREW("주말 근무자의 사원 정보와 평일 근무자의 사원 정보가 동일하지 않습니다.");

    public static final String ERROR_PREFIX = "[ERROR] ";
    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
