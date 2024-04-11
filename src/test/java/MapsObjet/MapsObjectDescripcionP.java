package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.ClaseBase;

public class MapsObjectDescripcionP extends ClaseBase {

	public MapsObjectDescripcionP(WebDriver driver) {
		super(driver);
		
	}
	
	protected By btnAgregarCarrito = By.xpath("//button[@class='andes-button andes-spinner__icon-base ui-pdp-action--secondary andes-button--quiet']");

}
