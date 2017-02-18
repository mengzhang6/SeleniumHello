package meng.selenium.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDemo {

	public static void main(String[] args) {
		// Chrome需要使用chromedriver插件
		// chromedriver.exe建议与chrome.exe放在同一目录下，方便识别
		System.setProperty("webdriver.chrome.driver",
				"D:\\GoogleChromePortable\\App\\Google Chrome\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("http://www.baidu.com/");
		// driver.quit();
	}

}
