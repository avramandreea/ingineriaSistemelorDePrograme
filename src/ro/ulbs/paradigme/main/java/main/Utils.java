package ro.ulbs.paradigme.main.java.main;

import ro.ulbs.paradigme.main.java.dataprocessing.BasicStepCountStrategy;
import ro.ulbs.paradigme.main.java.dataprocessing.FilteredStepCountStrategy;
import ro.ulbs.paradigme.main.java.dataprocessing.StepCountStrategy;
import ro.ulbs.paradigme.main.java.storage.DataRepository;

public class Utils {
    public static final String BASIC_STRATEGY = "basic";
    public static final String FILTERED_STRATEGY = "filtered";

    public static int getClientId() {
        return 42;
    }

    public static StepCountStrategy getStrategy(String strategyType, DataRepository dataRepository) {
        if (FILTERED_STRATEGY.equalsIgnoreCase(strategyType)) {
            return new FilteredStepCountStrategy(dataRepository);
        } else if (BASIC_STRATEGY.equalsIgnoreCase(strategyType)) {
            return new BasicStepCountStrategy();
        } else {
            System.out.println("Strategie necunoscută. Se folosește strategia basic ca fallback.");
            return new BasicStepCountStrategy(); // fallback
        }
    }
}
