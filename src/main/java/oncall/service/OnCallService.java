package oncall.service;

import oncall.repository.ResultRepository;

public class OnCallService {
    private final ResultRepository resultRepository;

    public OnCallService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public void saveMonth(String month) {

    }
}
