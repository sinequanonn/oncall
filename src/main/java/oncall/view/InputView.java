package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String INPUT_START = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    public static final String INPUT_WEEKDAY_CREWS = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    public static final String INPUT_WEEKEND_CREWS = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public String input() {
        return Console.readLine();
    }

    public String inputMonthAndDayOfWeek() {
        System.out.print(INPUT_START);
        return Console.readLine();
    }

    public String inputWeekdayCrews() {
        System.out.print(INPUT_WEEKDAY_CREWS);
        return Console.readLine();
    }
}
