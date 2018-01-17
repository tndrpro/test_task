package dto;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Company {

	@SerializedName("address_legal")
	private String addressLegal;

	@SerializedName("title_full")
	private String titleFull;

	@SerializedName("anno_short")
	private String annoShort;

	private String rating;

	@SerializedName("is_seller_producer")
	private Integer isSellerProducer;

	@SerializedName("country_id")
	private Integer countryId;

	private String fax;

	@SerializedName("is_type_seller")
	private Integer isTypeSeller;

	private String address;

	private Integer id;

	private String anno;
	
	@SerializedName("type_name")
	private String typeName;
	
	@SerializedName("country_name")
	private String countryName;
	
	@SerializedName("phone")
	private String phone;
	
	@SerializedName("seller_type_name")
	private String sellerTypeName;

	private String kpp;

	private String inn;

	private String site;

	private String title;

}