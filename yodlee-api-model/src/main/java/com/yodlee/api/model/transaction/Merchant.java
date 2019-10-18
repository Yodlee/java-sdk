/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.account.AccountAddress;
import com.yodlee.api.model.transaction.enums.TransactionMerchantSource;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "source", "address", "categoryLabel", "name", "coordinates", "contact", "website"})
public class Merchant extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Identifier of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("id")
	private String id;

	@ApiModelProperty(readOnly = true,
					  value = "The source through which merchant information is retrieved."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("source")
	private TransactionMerchantSource source;

	@ApiModelProperty(readOnly = true,
					  value = "The address of the merchant associated with the transaction is populated in the merchant address field."
							  + "<br><b>Note</b>: The merchant address field is not available by default and customers will have to specifically request the merchant's address (that includes city, state, and ZIP of the merchant). The merchant address field is available only for merchants in the United States."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard<br>"//
	)
	@JsonProperty("address")
	private AccountAddress address;

	@ApiModelProperty(readOnly = true,
					  value = "The business categories of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("categoryLabel")
	private List<String> categoryLabel;

	@ApiModelProperty(readOnly = true,
					  value = "The name of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>"//
	)
	@JsonProperty("name")
	private String name;

	@ApiModelProperty(value = "The merchant geolocation coordinates like latitude and longitude."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard,loan<br>"//
	)
	@JsonProperty("coordinates")
	private Coordinates coordinates;
	

	@ApiModelProperty(value = "The merchant contact information like phone and email."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard,investment,loan<br>"//
	)
	@JsonProperty("contact")
	private Contact contact;

	@ApiModelProperty(readOnly = true,
					  value = "The website of the merchant."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,investment,loan<br>"//
	)
	@JsonProperty("website")
	private String website;

	/**
	 * Identifier of the merchant. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * The source through which merchant information is retrieved. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return source
	 */
	public TransactionMerchantSource getSource() {
		return source;
	}

	/**
	 * The address of the merchant associated with the transaction is populated in the merchant address field. <br>
	 * <b>Note</b>: The merchant address field is not available by default and customers will have to specifically
	 * request the merchant's address (that includes city, state, and ZIP of the merchant). The merchant address field
	 * is available only for merchants in the United States. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard<br>
	 * 
	 * @return address
	 */
	public AccountAddress getAddress() {
		return address;
	}

	/**
	 * The business categories of the merchant. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return categoryLabel
	 */
	@JsonProperty("categoryLabel")
	public List<String> getCategoryLabel() {
		return categoryLabel == null ? null : Collections.unmodifiableList(categoryLabel);
	}

	/**
	 * The name of the merchant. <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,insurance,loan<br>
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The Coordinates of merchant which includes merchant longitude and latitude information <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return coordinates
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}
	

	/**
	 * The Contact information of merchant which includes phone number and email id information <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return contact
	 */
	public Contact getContact() {
		return contact;
	}

	

	/**
	 * The website of the merchant<br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,loan<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return website
	 */
	public String getWebsite() {
		return website;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", source=" + source + ", address=" + address + ", categoryLabel=" + categoryLabel
				+ ", name=" + name + ", coordinates=" + coordinates + ", contact=" + contact + ", website=" + website
				+ "]";
	}
}
