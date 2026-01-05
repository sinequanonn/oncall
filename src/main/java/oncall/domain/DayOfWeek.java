package oncall.domain;

public enum DayOfWeek {
    SUN("일"),
    MON("월"),
    TUE("화"),
    WED("수"),
    THUR("목"),
    FRI("금"),
    SAT("토"),
    ;

    private final String dayOfWeek;

    DayOfWeek(final String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }


}
