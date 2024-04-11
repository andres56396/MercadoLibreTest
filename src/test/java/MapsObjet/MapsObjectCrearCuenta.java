package MapsObjet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ClaseBase;

public class MapsObjectCrearCuenta extends ClaseBase {

	public MapsObjectCrearCuenta(WebDriver driver) {
		super(driver);
		
	}
	
	
	protected By btnCrearCuenta = By.id("registration-link");
	
	protected By btnCuentaPersonal = By.id("first-button");
	
	protected By btnAgregar = By.id("hub-item-button");
	
	protected By inputCorreo = By.xpath("//input[@type='email']");
	
	protected By inputpolicies = By.xpath("//input[@id='policies']");
	
	protected By liCorreos = By.xpath("//ul[@id='email-without-android-listbox']//li[@id='email-without-android-listbox-option-0']");
	
	protected By btnContinuar = By.id(":R1td9:");
	
	protected WebElement btncontinuar = driver.findElement(btnContinuar);
	
	
	



}
