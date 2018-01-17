package test.ui;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.Main;
import page.Promo;

/**
 * 
 * Тест на навигацию по ссылкам из футера
 *
 */
public class MainFooterNavigationTest {
	
	//для экономии времени не будем имплементировать механизм переиспользования сессии, инстанциируем прямо в тесте
	private WebDriver driver;
	private Main mainPage;
	private Promo promoPage;
	
	@BeforeTest
	public void openMainPage() {
		driver = new ChromeDriver();
		mainPage = Main.init(driver);
		promoPage = Promo.init(driver);
	}
	
	@DataProvider
	public Object[][] testData() {
		return new Object[][] {
			new Object[] {(Supplier<WebElement>) mainPage.getFooter()::getRates,
					(Supplier<WebElement>) promoPage::getContentContainer,
					"Принцип Tender.Pro — экономичность и рациональность тарифов."},
			new Object[] {(Supplier<WebElement>) mainPage.getFooter()::getSafety,
					(Supplier<WebElement>) promoPage::getContentContainer,
					"Строгий контроль безопасности."}
			//дабы не описывать для тестового задания страницы для остальных 9 ссылок остановимся тут
		};
	}
	
	@Test(dataProvider = "testData", description = "Проверка наличия на странице по ссылке из футера заданного текста")
	public void footerLinkNavigationTest(Supplier<WebElement> linkElementGetter, Supplier<WebElement> targetElementGetter, String text) {
		mainPage.open(driver);
		linkElementGetter.get().click();
		Assert.assertTrue(targetElementGetter.get().getText().contains(text), "Страница не содержит ожидаемого текста");
	}
	
	@AfterTest(alwaysRun = true)
	private void cleanUp() {
		driver.quit();
	}

}
