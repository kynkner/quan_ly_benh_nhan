package utilities;

import entity.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CSVUtils<T extends CSVEntity> implements DataReadable, DataWritable<T>{
    private static CSVUtils csvUtils;

    private CSVUtils() {
    }

    public static CSVUtils getInstance() {
        if(csvUtils == null) {
            csvUtils = new CSVUtils();
        }
        return csvUtils;
    }
    // doc file
    @Override
    public <T> List<T> readDataFromFile(String fileName, Function<String, T> mapper) {
        String filePath = String.join(File.separator, System.getProperty("user.dir"), "data", fileName);
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        List<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                list.add(mapper.apply(line)); // convert String -> T
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    // ghi file
    @Override
    public void witeDataToFile(List<T> data, String fileName) {
        String filePath = String.join(File.separator, System.getProperty("user.dir"), "data", fileName);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            if(data == null || data.isEmpty()) return;

            // ghi header
            bw.write(data.get(0).getCSVHeader());
            bw.newLine();

            //ghi tung object
            for (T obj : data){
                bw.write(obj.toCSV());
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
