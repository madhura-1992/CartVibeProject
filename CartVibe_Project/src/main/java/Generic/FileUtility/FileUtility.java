package Generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
