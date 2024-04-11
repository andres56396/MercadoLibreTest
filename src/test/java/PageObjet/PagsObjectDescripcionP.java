package PageObjet;

import java.io.File;

import org.openqa.selenium.WebDriver;

import MapsObjet.MapsObjectDescripcionP;

public class PagsObjectDescripcionP extends MapsObjectDescripcionP {

	String videncia="Si";
	public PagsObjectDescripcionP(WebDriver driver) {
		super(driver);
		
	}
	
	
	public void AgregaralCarrito(File rutacarpeta) throws Exception 
	{	
		
	     
	     tiempoEspera(2000);
	     click(btnAgregarCarrito, rutacarpeta, videncia);
	     
	    
			
		
	}

}
