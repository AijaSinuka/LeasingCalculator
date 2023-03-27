
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.text.*;

public class CalculatorFunctionalitySteps extends CalculatorObjects {
	
	
	@And("User enters invalid data to purchase field")
	public void userEntersInvalidData() {
		switchToFieldset();
		insertPurchaseValue("./$#");
	}
	
	@When("User enters MIN valid data")
	public void userEntersMinValidData() {
		//MIN values set
		//MIN values set as example, to be taken from requirements
		int purchaseVal = 10000;
		int interestVal = 1;
		int installmentVal = 10;
		int termVal = 1;
		
		//Insert data
		switchToFieldset();
		insertPurchaseValue(Integer.toString(purchaseVal));
		insertInterestRateValue(Integer.toString(interestVal));
		insertFirstInstallmentValue(Integer.toString(installmentVal));
		paymentTermSelected(termVal);
		
		//Values saved for future calculations
		purchase.set(purchaseVal);
		interest.set(interestVal);
		installment.set(installmentVal);
		term.set(termVal);
	}
	
	@And("User clicks on Calculate button")
	public void userClicksOncalculateButton() {
		clickOnCalculateBtn();
	}
	
	//Assertions (soft)
	
	@Then("All calculations are valid") 
	public void calculationAssertions() {
		DecimalFormat formatter = new DecimalFormat("#.00");
		
		double firstInstallment = purchase.get() * installment.get() / 100.0;
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(findElementText(calculatedInstallmentValueLoc).replace(" ", ""), formatter.format(firstInstallment).replace(",", "."));
		softAssert.assertEquals(findElementText(feeLoc), formatter.format(200).replace(",", "."));//hard coded as standard fee
		softAssert.assertEquals(findElementText(calculatedMonthlyPaymentLoc), formatter.format(754.07).replace(",", "."));//hard coded by now - proper leasing formula to be provided
		softAssert.assertAll();
	}
	
	@And("Error appearing as per requirements$")
	public void errorsAppearing() {

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(findElementText(errorText), "Wrong data format. The number must be greater than 0!");
		softAssert.assertEquals(Color.fromString(getElementColor(errorText, "color")), errorRedColor);
		softAssert.assertAll();
	}

}
