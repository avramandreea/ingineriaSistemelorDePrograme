package ro.ulbs.paradigme.main.java.storage;


import java.util.ArrayList;
import java.util.List;

/**
 * Persists sensor data.
 */
// TODO make this class singleton
public class DataRepository {
    private static DataRepository instance;
    private DataRepository() {
    }
    public static DataRepository getInstance() {
        if (instance == null) {
            instance=new DataRepository();
        }
        return instance;
    }
    private List<SensorData> dataRecords=new ArrayList<>();
    public void addData(SensorData dataRecord){
        dataRecords.add(dataRecord);
    }

    // TODO implement a method to get the stored data (needed by the strategies)
    public List<SensorData> getRecords() {
        return dataRecords;
    }

    public List<SensorData> getSensorData() {
        return List.of();
    }
}


