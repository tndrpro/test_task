package utils;

import java.util.Map;

import com.google.gson.Gson;

public class GsonUtils {
	
	public static <T> T convert(Class<T> clazz, Map<String, String> data) {
		String resultString = new Gson().toJson(data);
		T result = new Gson().fromJson(resultString, clazz);
		return result;
	}

}
