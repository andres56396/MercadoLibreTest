package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.ClaseBase;

public class MapsObjectHome extends ClaseBase {

	public MapsObjectHome(WebDriver driver) {
		super(driver);
		
	}

	protected By btnMarTarde = By.xpath("//button[@class='onboarding-cp-button andes-button andes-button--transparent andes-button--small']");
	protected By inputbuscarProducto = By.xpath("//input[@placeholder='Buscar productos, marcas y más…']");
}
