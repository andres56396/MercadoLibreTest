package PageObjet;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjet.MapsObjectCrearCuenta;
import org.junit.Assert;

public class PagsObjectCrearCuenta extends MapsObjectCrearCuenta {

	
	String videncia="Si";
	public PagsObjectCrearCuenta(WebDriver driver) {
		super(driver);
		
	}
	
	public void urlAcceso(String url)
	{
		
		driver.get(url);
		
	}
	
	
	
	public void NuevaCuenta(File rutacarpeta,String MAIL) throws Exception 
	{	
		
	     
		 tiempoEspera(2000);
	     click(btnCrearCuenta, rutacarpeta, videncia);
	     tiempoEspera(2000);
	     tiempoEspera(2000);
	     click(btnCuentaPersonal, rutacarpeta, videncia);
	     tiempoEspera(2000);
	     click(btnAgregar, rutacarpeta, videncia);
	     tiempoEspera(2000);
	     
	     
	     
	     sendKey(MAIL,inputCorreo,rutacarpeta,videncia);
	     tiempoEspera(2000);
	     click(liCorreos, rutacarpeta, videncia);
	     
	     
	     SearchElementPage(inputpolicies,rutacarpeta,videncia);	     
	    
	      
	     
	     Assert.assertEquals(true, isDisplayed(btnContinuar));	
	     
	     System.out.println("Se muestra el Boton Continuar – Assert passed");
		
	}
	
	
	

}
