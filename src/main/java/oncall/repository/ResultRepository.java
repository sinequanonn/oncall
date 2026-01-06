package oncall.repository;

import oncall.domain.Month;
import oncall.domain.OnCall;
import java.util.ArrayList;
import java.util.List;

public class ResultRepository {
    private Month month;
    private List<OnCall> onCalls = new ArrayList<>();

    public void saveMonth(oncall.domain.Month month) {
        this.month = month;
    }

    public Month getMonth() {
        return month;
    }

    public void addOnCall(OnCall onCall) {
        onCalls.add(onCall);
    }
}
