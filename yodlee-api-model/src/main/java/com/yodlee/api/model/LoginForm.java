/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.enums.LoginFormTypes;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "forgetPasswordURL", "loginHelp", "formType", "row", "help", "mfaInfoTitle", "mfaInfoText",
		"mfaInfoText"})
public class LoginForm extends AbstractModelComponent {

	@ApiModelProperty(value = "The identifier of the login form."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(value = "The forget password URL of the provider site."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("forgetPasswordURL")
	private String forgetPasswordURL;

	@ApiModelProperty(readOnly = true,
					  value = "The help that can be displayed to the customer in the login form."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("loginHelp")
	private String loginHelp;

	@ApiModelProperty(value = "The type of the forms for which the user information is required."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>"//
			+ "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("formType")
	private LoginFormTypes formType;

	@ApiModelProperty(value = "This indicates one row in the form. The row will have one label. But it may have single or multiple fields."//
			+ "<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul>"//
			+ "<li>GET providerAccounts/{providerAccountId}</li>"//
			+ "<li>GET providers/{providerId}</li>"//
			+ "</ul>")
	@JsonProperty("row")
	private List<Row> rows;

	//
	@ApiModelProperty(readOnly = true,
					  value = "The help that can be displayed to the customer in the login form."//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("help")
	private String help;

	@ApiModelProperty(readOnly = true,
					  value = "The title for the MFA information demanded from the user.This is the title displayed in the provider site.This field is applicable for MFA form types only. "//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("mfaInfoTitle")
	private String mfaInfoTitle;

	@ApiModelProperty(readOnly = true,
					  value = "The text displayed in the provider site while requesting the user's MFA information. This field is applicable for MFA form types only. "//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "</ul>")
	@JsonProperty("mfaInfoText")
	private String mfaInfoText;

	@ApiModelProperty(readOnly = true,
					  value = "The amount of time before which the user is expected to provide MFA information. This field is applicable for MFA form types only. This would be an useful information that could be displayed to the users. "//
							  + "<br><br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET providerAccounts/{providerAccountId}</li>"//
							  + "<li>GET providers/{providerId}</li>"//
							  + "</ul>")
	@JsonProperty("mfaTimeout")
	private Long mfaTimeout;

	/**
	 * The forget password URL of the provider site. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return forgetPasswordURL
	 */
	public String getForgetPasswordURL() {
		return forgetPasswordURL;
	}

	public void setForgetPasswordURL(String forgetPasswordURL) {
		this.forgetPasswordURL = forgetPasswordURL;
	}

	/**
	 * The identifier of the login form. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * The type of the forms for which the user information is required. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return formType
	 */
	public LoginFormTypes getFormType() {
		return formType;
	}

	public void setFormType(LoginFormTypes formType) {
		this.formType = formType;
	}

	/**
	 * The help that can be displayed to the customer in the login form. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return loginHelp
	 */
	public String getLoginHelp() {
		return loginHelp;
	}

	public void setLoginHelp(String loginHelp) {
		this.loginHelp = loginHelp;
	}

	/**
	 * This indicates one row in the form. The row will have one label. But it may have single or multiple fields. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return row
	 */
	@JsonProperty("row")
	public List<Row> getRows() {
		return rows == null ? null : Collections.unmodifiableList(rows);
	}

	@JsonProperty("row")
	public void setRows(List<Row> rows) {
		if (this.rows == null) {
			this.rows = new ArrayList<>();
		}
		this.rows.clear();
		this.rows.addAll(rows);
	}

	public void addRow(Row row) {
		if (this.rows == null) {
			this.rows = new ArrayList<>();
		}
		this.rows.add(row);
	}

	public boolean removeRow(Row row) {
		return this.rows != null ? this.rows.remove(row) : null;
	}

	public void clearRow() {
		if (rows != null) {
			rows.clear();
		}
	}

	/**
	 * The help that can be displayed to the customer in the login form. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return help
	 */
	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	/**
	 * The title for the MFA information demanded from the user.This is the title displayed in the provider site.This
	 * field is applicable for MFA form types only. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return mfaInfoTitle
	 */
	public String getMfaInfoTitle() {
		return mfaInfoTitle;
	}

	public void setMfaInfoTitle(String mfaInfoTitle) {
		this.mfaInfoTitle = mfaInfoTitle;
	}

	/**
	 * The text displayed in the provider site while requesting the user's MFA information. This field is applicable for
	 * MFA form types only. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * </ul>
	 * 
	 * @return mfaInfoText
	 */
	public String getMfaInfoText() {
		return mfaInfoText;
	}

	public void setMfaInfoText(String mfaInfoText) {
		this.mfaInfoText = mfaInfoText;
	}

	/**
	 * The amount of time before which the user is expected to provide MFA information. This field is applicable for MFA
	 * form types only. This would be an useful information that could be displayed to the users. <br>
	 * <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET providerAccounts/{providerAccountId}</li>
	 * <li>GET providers/{providerId}</li>
	 * </ul>
	 * 
	 * @return mfaTimeout
	 */
	public Long getMfaTimeout() {
		return mfaTimeout;
	}

	public void setMfaTimeout(Long mfaTimeout) {
		this.mfaTimeout = mfaTimeout;
	}

	@Override
	public String toString() {
		return "LoginForm [id=" + id + ", forgetPasswordURL=" + forgetPasswordURL + ", loginHelp=" + loginHelp
				+ ", formType=" + formType + ", rows=" + rows + ", help=" + help + ", mfaInfoTitle=" + mfaInfoTitle
				+ ", mfaInfoText=" + mfaInfoText + ", mfaTimeout=" + mfaTimeout + "]";
	}
}
