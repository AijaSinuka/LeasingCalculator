import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;

public class CommonSteps extends CalculatorObjects {
	
	@Given("Leasing calculator is opened")
	public void leasingCalculatorOpened() {
		openBrowser();
		
		//close cookie banner
		clickOnElement(languageButtonLoc);
		clickOnElement(acceptCookieLoc);
	}
	
	@And("Close banner")
	public void closeBanner() {	
		removeAllThreads();
		closeBrowser();
	}
	
	
}
