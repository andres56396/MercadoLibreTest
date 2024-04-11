package PageObjet;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapsObjet.MapsObjectSelectProduct;

public class PagsObjectSelectProduct extends MapsObjectSelectProduct {

	String videncia="Si";
	public PagsObjectSelectProduct(WebDriver driver) {
		super(driver);
		
	}
	
	public void SelectProducto(File rutacarpeta) throws Exception 
	{			
		
	     tiempoEspera(2000);
	     click(liElegirProducto, rutacarpeta, videncia);
	     tiempoEspera(2000);     
	    
	     
	    
			
		
	}

}
