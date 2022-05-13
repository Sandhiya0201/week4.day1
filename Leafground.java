package week4.day1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafground {
	public static void main(String[]args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		int tablecount = driver.findElements(By.xpath("(//table)")).size();
		System.out.println("Total number of tables in the page is - "+tablecount);
		System.out.println("-------------------------------------------------");
		for(int i= 1;i<=tablecount;i++) {
		   int table1rowcount = driver.findElements(By.xpath("(//table)["+i+"]//tr")).size();
		   System.out.println("The total rows in the table in table "+i+" is - "+table1rowcount);
		   int table1colcount = driver.findElements(By.xpath("(//table)["+i+"]//th")).size();
		   System.out.println("The total column in the table "+i+" is - "+table1colcount);
		   System.out.println("-------------------------------------------------");
		   driver.findElement(By.xpath("//table[@class='even']//tr")).getText();
		   driver.findElement(By.xpath("//input[@name='vital']//td")).getText();
			for(int j=2;j<tablecount+1;j++) {
			    String val = driver.findElement(By.xpath("//table//tr["+j+"]//td[2]")).getText();
				if(val.equals(val)) {
				   driver.findElement(By.xpath("//table//tr["+j+"]//td[3]")).click();
				   if(driver.findElement(By.xpath("//table//tr["+j+"]//input")).isSelected()){
						System.out.println("The vital task for the least completed progress is selected");
					}
				}
			}
			driver.close();

		}

	}


}
