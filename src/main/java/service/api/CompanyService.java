package service.api;

import java.io.IOException;

import dto.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompanyService {
	
	private ICompanyService serviceImpl = new Retrofit.Builder()
			.baseUrl("http://www.tender.pro")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(ICompanyService.class);
	
	public static CompanyService getInstance() {
		return new CompanyService();
	}
	
	private CompanyService() {}

	public Response getInfo(Integer id) throws IOException {
		return serviceImpl.getCompanyInfo(id).execute().body();
	}
}
