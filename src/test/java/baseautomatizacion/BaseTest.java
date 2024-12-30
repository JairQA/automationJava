package baseautomatizacion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;

public class BaseTest {
	protected static WebDriver driver ;

	public BaseTest(WebDriver driver) {
		super();
		BaseTest.driver = driver;

	}

	public static WebDriver startdriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:/driver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		return driver;
	}

	public static void click(By locator) {
		driver.findElement(locator).click();
	}

	public static void sendkeys(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public boolean validarElemento(By locator, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static By xpathInteractivo(By locatorBase, String valorDeRemplazo) {
		String jj = locatorBase.toString().replace("{0}", valorDeRemplazo);
		String kk = jj.replace("By.xpath:", "");
		return By.xpath(kk);
	}
	// METODO BOTON ENTER
	public static void enter() throws InterruptedException {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		tiempoEspera(3);
	}

	// METODO PARA REFRESCAR LA PAGINA
	public static void refreshpage() throws InterruptedException {
		driver.navigate().refresh();
		tiempoEspera(3);
	}

	// METODO TIEMPO DE ESPERA
	public static void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo * 1000);
	}
	
	public static void scrollElement(By locator)
			throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(locator);
			executor.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			throw new InterruptedException();
		}
	}
}
