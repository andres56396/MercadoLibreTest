package PageObjet;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjet.MapsObjectHome;

public class PagsObjectHome extends MapsObjectHome {

	
	String videncia="Si";
	public PagsObjectHome(WebDriver driver) {
		super(driver);
		
	}
	
	public void urlAcceso(String url)
	{
		
		driver.get(url);
		
	}
	
	public void ClickMasTarde(File rutacarpeta) throws Exception 
	{	
		
		tiempoEspera(2000);
	    
	    // Verificar si el botón "Más tarde" está presente
	    List<WebElement> botonesMasTarde = driver.findElements(btnMarTarde);
	    
	    if (!botonesMasTarde.isEmpty()) {
	        // El botón "Más tarde" está presente, haz clic en él
	        click(btnMarTarde, rutacarpeta, videncia);
	        tiempoEspera(2000);
	    } else {
	        // El botón "Más tarde" no está presente, realiza alguna acción alternativa
	        System.out.println("El botón 'Más tarde' no está presente.");
	        
	    }
		
	}
	
	public void Buscarproducto(File rutacarpeta,String PRODUCTO) throws InterruptedException {
		
		tiempoEspera(2000);    
		sendKey(PRODUCTO,inputbuscarProducto,rutacarpeta,videncia);
		submit(inputbuscarProducto,rutacarpeta,videncia);
		
	}

}
