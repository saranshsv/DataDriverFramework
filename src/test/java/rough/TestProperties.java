package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		Properties OR = new Properties();
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

		// driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		System.out.println(config.getProperty("browser"));
		System.out.println(OR.getProperty("bmlBtn"));
	}

}
