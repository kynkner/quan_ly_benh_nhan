package utilities;

import java.io.IOException;
import java.util.List;

public interface DataWritable<T> {
    void witeDataToFile(List<T> data, String fileName) throws IOException;
}
