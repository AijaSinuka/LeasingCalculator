import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorObjects extends CommonMethods {
	
	//thread locals
	public static ThreadLocal<Integer> purchase = ThreadLocal.withInitial(() -> 0);
	public static ThreadLocal<Integer> interest = ThreadLocal.withInitial(() -> 0);
	public static ThreadLocal<Integer> installment = ThreadLocal.withInitial(() -> 0);
	public static ThreadLocal<Integer> term = ThreadLocal.withInitial(() -> 0);
	
	//locators
	protected final String purchaseValueFieldLoc = "input[name='summa']";
	protected final String interestRateFieldLoc = "input[name='likme']";
	protected final String paymentTermDropDownLoc = ".form div:nth-child(3) .w100";
	protected final static String paymentTermValueLoc = "option[value='%d']";
	protected final String firstInstallmentFieldLoc = "input[name='maksa']";
	protected final String calculateBtnLoc = ".btn-dark";
	protected final String calculatedMonthlyPaymentLoc = ".js-results-info .row:nth-child(4) .calc-result";
	protected final String calculatedInstallmentValueLoc = ".js-results-info .row:nth-child(6) .calc-result";
	protected final String feeLoc = ".js-results-info .row:nth-child(5) .calc-result";
	protected final String languageButtonLoc = ".language-switcher-cookie-message .en";
	protected final String acceptCookieLoc = ".accept-selected";
	protected final String errorText = "label.error";
	
	//colors
	protected final Color errorRedColor = Color.fromString("rgba(216, 26, 26, 1)");
	

	//methods
	public static String getPaymentTermsLoc(int value) {
		return String.format(paymentTermValueLoc, value);
	}
	
	public void clickOnCalculateBtn() {
		clickOnElement(calculateBtnLoc);
	}
	
	public void insertPurchaseValue(String value) {
		insertStringIntoField(purchaseValueFieldLoc, value);
	}
	
	public void insertInterestRateValue(String value) {
		insertStringIntoField(interestRateFieldLoc, value);
	}
	
	public void insertFirstInstallmentValue(String value) {
		insertStringIntoField(firstInstallmentFieldLoc, value);
	}
	
	public void paymentTermSelected(int value) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(paymentTermDropDownLoc)));
		int termInMonths = value*12;
		clickOnElement(paymentTermDropDownLoc);
		clickOnElement(getPaymentTermsLoc(termInMonths));
	}
	
	public static void removeAllThreads() {
		purchase.remove();
		interest.remove();
		installment.remove();
		term.remove();
	}
	

}
