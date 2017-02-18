package meng.selenium.test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocationDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.bin",
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.baidu.com/");

		// By.id By.name By.className By.tagName
		// driver.findElement(By.id("kw")).sendKeys("selenium");
		// driver.findElement(By.name("wd")).sendKeys("selenium");
		// driver.findElement(By.className("s_ipt")).sendKeys("selenium");

		// By.linkText 定位到内容（完全匹配）
		// driver.findElement(By.linkText("新闻")).click();
		// By.partialLickText 定位到内容（部分匹配）
		// driver.findElement(By.partialLinkText("新")).click();

		// By.xpath 最常用的定位方式
		// driver.findElement(By.xpath(".//*[@id='u1']/a[2]")).click();
		// By.cssSelector
		driver.findElement(By.cssSelector("#kw")).sendKeys("selenium");

		// 延迟3s
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();

		/**
		 * 关键字驱动 数据驱动 混合驱动
		 */
	}

}
