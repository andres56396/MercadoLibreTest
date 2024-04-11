package com.TestNG;

import org.testng.annotations.Test;

import Base.ClaseBase;
import PageObjet.PagsObjectDescripcionP;
import PageObjet.PagsObjectHome;
import PageObjet.PagsObjectCrearCuenta;
import PageObjet.PagsObjectSelectProduct;

import utilidades.ExcelUtil;
import utilidades.GenerarReportePdf;
import utilidades.MyScreenRecorder;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class RunPruebaNG {
	
	
private WebDriver driver;
	
	PagsObjectCrearCuenta paginaMercadolibre;
	PagsObjectHome paginaHome;
	PagsObjectSelectProduct paginaproductos;
	PagsObjectDescripcionP paginadescripcion;
	PagsObjectCrearCuenta paginacrearcuenta;
	
	Properties propiedades;
	
	ClaseBase claseBase;
	GenerarReportePdf generarReportePdf;
	
	
	public String path;

	@BeforeClass
	  public void beforeClass() throws IOException {
		  
		  //Instanciar archivo Properties de java util
			 propiedades = new Properties();
			 
			 generarReportePdf = new GenerarReportePdf();
			 
			
			
			InputStream entrada= null;
			try {
				entrada = new FileInputStream("./Properties/Properties");
				propiedades.load(entrada);
				
			}catch(FileNotFoundException e){
				
				e.printStackTrace();
				System.out.println(e);
			}
			
			//Instanciar clase PagsObjetHome
			paginaHome = new PagsObjectHome(driver);
			
			//Cargar propiedades del navagador
			driver = paginaHome.chromeDriverConnection();
			
			
			//Instanciar clase PagsObjetForm
			paginaproductos = new PagsObjectSelectProduct(driver);
			
			paginadescripcion = new PagsObjectDescripcionP(driver);
			
			paginacrearcuenta = new PagsObjectCrearCuenta(driver);
			
			claseBase = new ClaseBase(driver);
			
			paginaHome.urlAcceso(propiedades.getProperty("url"));		
			
			path = propiedades.getProperty("filePathExcel");
			
			generarReportePdf.setRutaImagen(propiedades.getProperty("rutaImagenReporte"));
		  
		  
	  }
	
	
	 @DataProvider(name = "excelDataMercadolibre")
		public Object[] datos() throws Exception {
			Object[] arreglo = ExcelUtil.getTableArray(path,"Product");
			return arreglo;
		}
	  
  
  
  @Test(dataProvider = "excelDataMercadolibre")
  public void TestMercadoLibre(String PRODUCTO, String MAIL) throws Exception {  
	  
	//Obtener el nombre del metodo a ejecutar
		 String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
				
		//Crear Carpeta para almacenamieto de imagines
		File rutacarpeta = claseBase.crearCarpeta(propiedades,nomTest);
		
		//Iniciar creacion de resporte pdf		
		generarReportePdf.crearlantilla(nomTest, rutacarpeta);
		
		//Iniciar GRabacion		
		MyScreenRecorder.stratRecording(nomTest,rutacarpeta);
		
		 try {
			 paginaHome.ClickMasTarde(rutacarpeta);
			 paginaHome.Buscarproducto(rutacarpeta, PRODUCTO);
			 paginaproductos.SelectProducto(rutacarpeta);
			 paginadescripcion.AgregaralCarrito(rutacarpeta);		       
			 paginacrearcuenta.NuevaCuenta(rutacarpeta, MAIL);
		        Thread.sleep(3000);
		    } catch (Exception e) {
		    	
		        // Manejar cualquier excepción aquí
		        e.printStackTrace();
		        
		        // Cerrar plantilla de reporte pdf
		        generarReportePdf.cerrarPlantilla();
		        // Detener grabación de pantalla
		        MyScreenRecorder.stopRecording();
		    } finally {
		        // Cerrar plantilla de reporte pdf
		        generarReportePdf.cerrarPlantilla();
		        // Detener grabación de pantalla
		        MyScreenRecorder.stopRecording();
		    }
  }
  
 
  
  
  
  


  @AfterClass
  public void afterClass() {
	  driver.close();
		driver.quit();
	  
  }
  
  
  

}
