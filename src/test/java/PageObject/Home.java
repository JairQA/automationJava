package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import baseautomatizacion.*;

public class Home extends BaseTest{

	public Home(WebDriver driver) {
		super(driver);
	
	}
	public Home urlAcceso(String url, WebDriver driver) {
		driver.get(url);
		return new Home(driver);
	}
	protected By popup = By.xpath("(//button[@class='modal-close is-large'])[1]");
	protected By btnlupa = By.xpath("//a[@class='icon']");
	protected By txt = By.name("searchTerms");
	protected By convenios = By.linkText("Convenios");
	
	public void accion(String name) throws Exception {
		if(validarElemento(popup,3)==true) {
		click(popup); 
		tiempoEspera(1);
		click(btnlupa); 
		sendkeys(name, txt);
		enter();
		tiempoEspera(2);
		scrollElement(convenios);
		tiempoEspera(2);
		}
	}
}
