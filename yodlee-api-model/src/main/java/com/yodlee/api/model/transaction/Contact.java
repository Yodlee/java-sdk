/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Contact {

	@ApiModelProperty(value = "Phone number of the merchant"//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard,investment,loan<br>"//
	)
	@JsonProperty("phone")
	private String phone;

	@ApiModelProperty(value = "Email Id of the merchant"//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bank,creditCard,investment,loan<br>"//
	)
	@JsonProperty("email")
	private String email;

	/**
	 * Phone number of the merchant <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,loan<br>
	 * 
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Email id of the merchant <br>
	 * <br>
	 * <b>Applicable containers</b>: bank,creditCard,investment,loan<br>
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [phone=" + phone + ", email=" + email + "]";
	}
}
