package utilities;

import entity.Patient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileUtil<T> implements DataReadable, DataWritable<T>{
    private static FileUtil fileUtil;
    private FileUtil() {

    }

    public static FileUtil getInstance() {
       if (fileUtil == null ){
           fileUtil = new FileUtil();
       }
       return fileUtil;
    }

    @Override
    public void writeDataFile(List<T> data, String filename) {
        String filePath = String.join(File.separator, System.getProperty("user.dir"), "data",filename);
        if(StringUtil.isNullOrEmpty(filePath)){
            return;
        }
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Object readFataFile(String fileName) {
        return null;
    }
}
