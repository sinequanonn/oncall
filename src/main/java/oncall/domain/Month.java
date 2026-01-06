package oncall.domain;

import oncall.exception.ErrorMessage;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31),
    ;

    private final int month;
    private final int lastDay;

    Month(final int month, final int lastDay) {
        this.month = month;
        this.lastDay = lastDay;
    }

    public static Month of(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
        }
        return Month.values()[month - 1];
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return lastDay;
    }
}
