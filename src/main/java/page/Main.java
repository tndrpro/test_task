package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import page.block.FooterBlock;

@Data
@Log4j2
public class Main {
	
	//без декораторов
	private FooterBlock footer;
	
	public static Main init(WebDriver driver) {
		Main result = PageFactory.initElements(driver, Main.class);
		result.setFooter(PageFactory.initElements(driver, FooterBlock.class));
		return result;
	}
	
	public void open(WebDriver driver) {
		log.info("Открываем http://www.tender.pro/");
		driver.get("http://www.tender.pro/");
	}
}
