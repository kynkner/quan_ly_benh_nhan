package utilities;


import java.util.List;
import java.util.function.Function;

public interface DataReadable {
    <T> List<T> readDataFromFile(String fileName, Function<String, T> mapper);
}
