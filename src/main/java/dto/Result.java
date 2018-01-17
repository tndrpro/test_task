package dto;

import java.util.Map;

import lombok.Data;

@Data
public class Result {

	private Args args;
	private Map<String, String> data;
}