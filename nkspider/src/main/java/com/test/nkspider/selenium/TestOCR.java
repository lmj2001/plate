package com.test.nkspider.selenium;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;


public class TestOCR {
    public static void main(String[] args) throws TesseractException {
        // 手动配置环境变量
        System.setProperty("webdriver.chrome.driver", "/Users/limingjie/Documents/WebDriver/chromedriver");
//        ChromeOptions chromeOptions =new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        WebDriver browser=new ChromeDriver(chromeOptions);
        WebDriver browser = new ChromeDriver();
        String urlStr = "https://maoyan.com/films/1230121";
        browser.get(urlStr);
        WebElement element = browser.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/div[2]/div/span[1]"));
        TakesScreenshot takesScreenshot = (TakesScreenshot)element;
        File screenshotAs = takesScreenshot.getScreenshotAs(OutputType.FILE);
        browser.quit();
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("/Users/limingjie/plate/nkspider/tessdata");
        String result = tesseract.doOCR(screenshotAs);
        System.out.println(result);
    }
}
/*
public class TestOCR {
    public static void main(String[] args) throws TesseractException {
        System.setProperty("webdriver.chrome.driver", "c:/Dev/WebDriver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver browser = new ChromeDriver(chromeOptions);
//        WebDriver browser = new ChromeDriver();
        String urlStr = "https://maoyan.com/films/1230121";
        // 票房元素 XPath: /html/body/div[3]/div/div[2]/div[3]/div[2]/div/span[1]
        browser.get(urlStr);
        WebElement element = browser.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/div[2]/div/span[1]"));
        TakesScreenshot takesScreenshot = (TakesScreenshot) element;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        browser.close();
        ITesseract instance = new Tesseract();
        instance.setDatapath("c:/Dev/tessdata");
        String result = instance.doOCR(srcFile);
        System.out.println(result);
    }
}
 */
