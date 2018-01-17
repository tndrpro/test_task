package test.api;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import dto.Company;
import dto.Response;
import service.api.CompanyService;
import utils.GsonUtils;

/**
 *  
 *  Позитивные проверки метода company.info_public
 *
 */
public class CompanyTest {
	
	private Response companyInfoResponse;
	private Company referenceCompany;
	
	@BeforeTest
	public void loadReferenceCompany() {
		//здесь создаём эталонную компанию либо получаем её из-какого либо источника
		//в целях экономии времени я её просто захардкодаю
		String json = "{\n" + 
				"         \"address_legal\" : \"141070, Россия, Московская область, г. Королев,, ул Циолковского, 14/16, , офис VI\",\n" + 
				"         \"title_full\" : \"ООО УК \\\"МЕТАЛЛОИНВЕСТ\\\"\",\n" + 
				"         \"anno_short\" : \" \",\n" + 
				"         \"rating\" : \"2.000\",\n" + 
				"         \"is_seller_producer\" : 1,\n" + 
				"         \"country_id\" : 1,\n" + 
				"         \"fax\" : \"\",\n" + 
				"         \"is_type_seller\" : 0,\n" + 
				"         \"address\" : \"309500, Белгородская область, Старый Оскол, ст. Котел, промузел,, площадка «Складская»,, проезд Ш-6, № 2а,  Рожков Дмитрий, (925) 006-40-12\",\n" + 
				"         \"id\" : 154463,\n" + 
				"         \"anno\" : \"Мировой лидер в производстве товарного горячебрикетированного железа (ГБЖ), ведущий производитель и поставщик железорудной и метализованной продукции, один из региональных производителей высококачественной стали. \",\n" + 
				"         \"type_name\" : \"организатор\",\n" + 
				"         \"country_name\" : \"Россия\",\n" + 
				"         \"phone\" : \"+7(495)981-55-55\",\n" + 
				"         \"seller_type_name\" : \"производитель\",\n" + 
				"         \"kpp\" : \"501801001\",\n" + 
				"         \"inn\" : \"5018108484\",\n" + 
				"         \"site\" : \"http://www.metalloinvest.com\",\n" + 
				"         \"title\" : \"УК МЕТАЛЛОИНВЕСТ\"\n" + 
				"      }";
		referenceCompany = new Gson().fromJson(json, Company.class);
	}
	
	@BeforeTest(dependsOnMethods = "loadReferenceCompany")
	public void getCompanyInfo() throws IOException {
		companyInfoResponse = CompanyService.getInstance().getInfo(referenceCompany.getId());
	}
	
	@Test(description = "Проверка что success = true")
	public void companyInfoSuccessTest() {
		Assert.assertTrue(companyInfoResponse.getSuccess(), "Получен ответ с success не равному false");
	}
	
	@Test(description = "Проверка что id полученной компании и id в блоке args одинаковы")
	public void companyInfoArgsMatchTest() {
		Integer companyId = GsonUtils.convert(Company.class, companyInfoResponse.getResult().getData())
				.getId();
		Integer argsId = companyInfoResponse.getResult().getArgs()
				.getId();
		Assert.assertEquals(argsId, companyId, "Id полученной компании не соответствует id в блоке args");
	}
	
	@Test(description = "Проверка что id полученной компании соответствует запрашиваемому")
	public void companyInfoIdMatchTest() {
		Company actualCompany = GsonUtils.convert(Company.class, companyInfoResponse.getResult().getData());
		Assert.assertEquals(actualCompany.getId(), referenceCompany.getId(), "Id полученной компании не соответствует запрашиваемому");
	}
	
	@Test(description = "Проверка что информация в блоке data соответсвует ожидаемой")
	public void companyInfoDataTest() {
		Company actual = GsonUtils.convert(Company.class, companyInfoResponse.getResult().getData());
		Assert.assertEquals(actual, referenceCompany, "Одно или несколько значений атрибутов компании не соответствует ожидаемому");
	}
}
