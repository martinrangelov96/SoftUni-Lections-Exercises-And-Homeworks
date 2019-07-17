package mostwanted.util;

import java.io.*;

public class FileUtilImpl implements FileUtil {

    @Override
    public String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
