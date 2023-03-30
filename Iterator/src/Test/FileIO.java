package Test;

import java.io.IOException;

/**
 * @author xiaolanhe
 * @version V1.0
 * @Package Test
 * @date 2023/3/30 15:00
 */
public interface FileIO {
    public void readFromFile(String filename) throws IOException;

    public void writeToFile(String filename) throws IOException;

    public void setValue(String key, String value);

    public String getValue(String key);
}
