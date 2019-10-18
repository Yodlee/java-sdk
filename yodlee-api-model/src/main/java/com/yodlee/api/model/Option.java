/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"displayText", "isSelected", "optionValue"})
public class Option extends AbstractModelComponent {

	@ApiModelProperty(value = "The text that is displayed to the user for that option in the provider site."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("displayText")
	private String displayText;

	@ApiModelProperty(value = "The option that is selected by default in the provider site."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("isSelected")
	private Boolean isSelected;

	@ApiModelProperty(value = "The value that is associated with the option."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("optionValue")
	private String optionValue;

	/**
	 * The text that is displayed to the user for that option in the provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return displayText
	 */
	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	/**
	 * The option that is selected by default in the provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return isSelected
	 */
	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}

	/**
	 * The value that is associated with the option. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return optionValue
	 */
	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	@Override
	public String toString() {
		return "Option [displayText=" + displayText + ", isSelected=" + isSelected + ", optionValue=" + optionValue
				+ "]";
	}
}
