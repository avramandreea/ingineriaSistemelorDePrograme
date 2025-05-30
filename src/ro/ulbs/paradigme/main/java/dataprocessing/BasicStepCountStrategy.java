package ro.ulbs.paradigme.main.java.dataprocessing;

import ro.ulbs.paradigme.main.java.storage.SensorData;

public class BasicStepCountStrategy implements StepCountStrategy {
    private int totalSteps=0;

    @Override
    public void consumeMessage(SensorData sample){
        totalSteps+= sample.getStepsCount();
    }
    @Override
    public int getTotalSteps() {
        return totalSteps;
    }
    @Override
    public String getStrategyDescription() {
        return "Strategie care returneaza toti pasii";
    }
}
