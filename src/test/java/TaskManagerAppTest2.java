import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TaskManagerAppTest2 {
    public static void main (String[] args){
        System.setProperty("webdriver.chrome.driver" , "D:\\Getting started with Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qataskmanager.ccbp.tech/");

        Actions action = new Actions(driver);

        WebElement srcEl = driver.findElement(By.id("task1"));
        WebElement targetEl = driver.findElement(By.id("done"));

        action.dragAndDrop(srcEl , targetEl).perform();

        List<WebElement> taskElements = driver.findElements(By.xpath("//section[@id='done']//div[contains(@class, 'task')]"));

        if(taskElements.size()==1){
            System.out.println("Task is moved to done stage");
        }
        else{
            System.out.println("Task is not moved to done stage");
        }

        driver.quit();
    }
}
