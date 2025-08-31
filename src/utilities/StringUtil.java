package utilities;

public class StringUtil {

    public static boolean isNullOrEmpty(String filePath) {
        return DataUtil.isNullOrEmty(filePath) || filePath.trim().isEmpty();
    }
}
