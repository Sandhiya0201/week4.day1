package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		//set up the driver and create ChromeDriver Instance
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//1. Launch the URL https://www.chittorgarh.com/
		driver.get("https://www.chittorgarh.com/");
		//2. click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		//3. click on NSE Bulk Deals
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		//4. Get all the Security names
		//create a list to store the names
		List<String> securitynamelist = new ArrayList<String>();
		//get the table
		WebElement table2 = driver.findElement(By.id("//div//table[@class='table table-bordered table-condensed table-striped']"));
		//get the rows count
		List<WebElement> rowvalues = table2.findElements(By.xpath("//tr"));
		//use a for loop to find the header name
		for(int i =1;i<=rowvalues.size()-1;i++) {
			WebElement findElement = rowvalues.get(i).findElement(By.xpath("//th["+i+"]"));
			//put an if condition where the hear name is Securityname
			if(findElement.getText().equals("Security Name")) {
				//use a for loop to get the values under the Security name tab
				for(int j =1;j<=rowvalues.size()-i;j++) {
				String securitynameval = table2.findElement(By.xpath("//tr["+j+"]//td["+i+"]")).getText();
			//add the values to the list
			  securitynamelist.add(securitynameval);
			  
				}
				System.out.println(securitynamelist);
				//convert the list to a set
				Set<String> targetSet = new TreeSet<String>(securitynamelist);
				System.out.println(targetSet);
				//ensure there are duplicates  by comparing the size of list and the set
				if(targetSet.size()<securitynamelist.size()) {
					System.out.println("Yes the list contains duplicate Security names");
				}
				//break the loop
				break;
		
			
		}
	
	}
		
	driver.close();	

 }

}
