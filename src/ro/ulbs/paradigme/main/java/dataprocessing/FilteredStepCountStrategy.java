package ro.ulbs.paradigme.main.java.dataprocessing;

import ro.ulbs.paradigme.main.java.storage.DataRepository;
import ro.ulbs.paradigme.main.java.storage.SensorData;

import java.util.List;

public class FilteredStepCountStrategy implements StepCountStrategy {
    private final DataRepository dataRepository;

    public FilteredStepCountStrategy(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void consumeMessage(SensorData sample) {

    }

    @Override
    public int getTotalSteps() {
        List<SensorData> dataList = dataRepository.getSensorData();
        int total = 0;

        for (int i = 0; i < dataList.size(); i++) {
            SensorData current = dataList.get(i);
            if (current.getStepsCount() <= 0) {
                continue;
            }

            int recentSteps = 0;
            long currentTime = current.getTimestamp();

            for (int j = 0; j < dataList.size(); j++) {
                SensorData other = dataList.get(j);
                if (other == current) continue;

                long timeDiff = currentTime - other.getTimestamp();
                if (timeDiff > 0 && timeDiff <= 60000) { // 60 seconds
                    recentSteps += other.getStepsCount();
                }
            }

            if (recentSteps <= 1000) {
                total += current.getStepsCount();
            }
        }

        return total;
    }

    @Override
    public String getStrategyDescription() {
        return "Strategie care returnează doar pașii ...";
    }
}