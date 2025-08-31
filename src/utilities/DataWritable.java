package utilities;


import java.util.List;

public interface DataWritable<T> {
    void writeDataFile(List<T> data, String filename);
}
