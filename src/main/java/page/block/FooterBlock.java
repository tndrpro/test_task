package page.block;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;

@Data
public class FooterBlock {
	
	private final static String CONTAINER_XPATH = "//*[@class='infoblock']";
	
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Тарифы')]")
	private WebElement rates;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Безопасность')]")
	private WebElement safety;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Партнерам')]")
	private WebElement partners;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Справка')]")
	private WebElement help;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Мероприятия')]")
	private WebElement events;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Сотрудникам')]")
	private WebElement employees;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'API')]")
	private WebElement api;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Маркетинг')]")
	private WebElement marketing;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Каталогизация')]")
	private WebElement cataloging;
	@FindBy(xpath = CONTAINER_XPATH + "//a[contains(text(),'Разработка ПО	')]")
	private WebElement development;
	@FindBy(xpath = CONTAINER_XPATH + "//*[contains(text(),'Пресс-Центр')]")
	private WebElement pressCenter;
	@FindBy(xpath = CONTAINER_XPATH + "//*[@class='contact-list']//a")
	private WebElement phone;
	
}
