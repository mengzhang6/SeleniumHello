package meng.selenium.test3;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class APITest {

	/**
	 * Firefox最好使用版本27-32
	 */
	public static void main(String[] args) {
		WebDriver driver;

		// 设置webdriver.firefox.bin
		System.setProperty("webdriver.firefox.bin",
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

		// FirefoxDriver
		driver = new FirefoxDriver();

		// 打开网页
		String url = "http://www.baidu.com/";
		driver.get(url);
		// driver.navigate().to(url);

		// 获取当前网页标题
		System.out.println(driver.getTitle());
		// 获取当前网页url
		System.out.println(driver.getCurrentUrl());
		// 获取当前网页源码
		// System.out.println(driver.getPageSource());

		// 窗口最大化
		driver.manage().window().maximize();
		// driver.manage().window().getSize();

		driver.navigate().to("http://www.qq.com/");
		// 设置延迟
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// 刷新当前网页
		driver.navigate().refresh();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//后退到百度
		driver.navigate().back();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//前进到腾讯
		driver.navigate().forward();
		
		//获取Cookie
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie : cookies){
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getName());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getExpiry());
			System.out.println("----------------");
		}
		//删除cookie
		driver.manage().deleteAllCookies();
		
		//执行js语句，先将driver转换成js的对象
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("alert('hello selenium');");
		
		try {
			// 截图
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\test.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		driver.get("http://www.baidu.com/");
		// 根据id查找元素
		WebElement webElement  = driver.findElement(By.id("kw"));
		//输入内容
		webElement.sendKeys("selenium");
		//获取内容
		System.out.println(webElement.getText());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//清除内容
		webElement.clear();
		
		driver.get("http://www.baidu.com/");
		//根据xpath查找元素
		webElement  = driver.findElement(By.xpath(".//*[@id='u1']/a[6]"));
		//点击操作
		webElement.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// 停止浏览器
		// driver.quit();
		driver.close();
	}

}
