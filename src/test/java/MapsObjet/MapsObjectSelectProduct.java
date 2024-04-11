package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.ClaseBase;

public class MapsObjectSelectProduct extends ClaseBase {

	public MapsObjectSelectProduct(WebDriver driver) {
		super(driver);
		
	}
	
	protected By liElegirProducto = By.xpath("//ol//li[1]//div[@class='ui-search-item__group ui-search-item__group--title']//a[1]");

}
