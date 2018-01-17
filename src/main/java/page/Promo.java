package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;

@Data
public class Promo {
	
	@FindBy(id = "ajax")
	private WebElement contentContainer;
	
	public static Promo init(WebDriver driver) {
		return PageFactory.initElements(driver, Promo.class);
	}

}
