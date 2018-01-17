package service.api;

import dto.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ICompanyService {

	@GET("api/_company.info_public.json")
	Call<Response> getCompanyInfo(@Query("id") Integer id);
}
