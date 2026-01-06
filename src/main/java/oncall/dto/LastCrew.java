package oncall.dto;

public class LastCrew {
    private String lastCrew;

    private LastCrew() {
        this.lastCrew = "";
    }

    public static LastCrew init() {
        return new LastCrew();
    }

    public void setLastCrew(String lastCrew) {
        this.lastCrew = lastCrew;
    }

    public String getLastCrew() {
        return lastCrew;
    }
}
