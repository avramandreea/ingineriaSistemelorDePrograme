package src.main.java.storage;

import dataprocessing.StepCountStrategy;
import ro.ulbs.paradigme.main.java.storage.DataRepository;

public class DataAggregator  {
    private StepCountStrategy strategy;
    public DataAggregator(StepCountStrategy strategy) {
        this.strategy = strategy;
    }
    public void receive(DataRepository repo) {
        repo.getRecords().forEach(r -> strategy.consumeMessage(r));
    }

    public String getResults() {
        return String.format("Strategy %s: stepsCount=%d", strategy.getStrategyDescription(), strategy.getTotalSteps());
    }
}
