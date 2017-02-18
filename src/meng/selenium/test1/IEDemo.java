package meng.selenium.test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDemo {

	public static void main(String[] args) {
		WebDriver driver;
		// IE需要使用IEDriverServer插件
		System.setProperty("webdriver.ie.driver",
				"D:\\mengzhang6\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://www.baidu.com/");
		// driver.quit();
	}

}
