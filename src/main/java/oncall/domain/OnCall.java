package oncall.domain;

public class OnCall {
    private final int day;
    private final String dayOfWeek;
    private final String crew;
    private final boolean holiday;

    public OnCall(int day, String dayOfWeek, String crew, boolean holiday) {
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.crew = crew;
        this.holiday = holiday;
    }
}
