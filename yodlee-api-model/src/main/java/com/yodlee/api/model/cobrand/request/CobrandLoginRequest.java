/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.cobrand.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Request;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CobrandLoginRequest extends AbstractModelComponent implements Request {

	@NotNull(message = "{cobrand.required}")
	@Valid
	@JsonProperty("cobrand")
	private Cobrand cobrand;

	public Cobrand getCobrand() {
		return cobrand;
	}

	public void setCobrand(Cobrand cobrand) {
		this.cobrand = cobrand;
	}

	@Override
	public String toString() {
		return "CobrandLoginRequest [cobrand=" + cobrand + "]";
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"cobrandLogin", "cobrandPassword", "locale"})
	public static final class Cobrand extends AbstractModelComponent {

		@NotEmpty(message = "{cobrand.loginName.required}")
		@JsonProperty("cobrandLogin")
		private String cobrandLogin;

		@NotEmpty(message = "{cobrand.password.required}")
		@JsonProperty("cobrandPassword")
		private String cobrandPassword;

		@ApiModelProperty(value = "The customer's locale that will be considered for the localization functionality."//
				+ "<br><br>"//
				+ "<b>Endpoints</b>:"//
				+ "<ul>"//
				+ "<li>POST cobrand/login</li>"//
				+ "</ul>")
		@Pattern(regexp = "[a-z]{2}_[A-Z]{2}", message = "{cobrand.locale.invalid}")
		@JsonProperty("locale")
		private String locale;

		/**
		 * The customer's locale that will be considered for the localization functionality. <br>
		 * <br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>POST cobrand/login</li>
		 * </ul>
		 * 
		 * @return customer's locale
		 */
		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}

		public String getCobrandLogin() {
			return cobrandLogin;
		}

		public void setCobrandLogin(String cobrandLogin) {
			this.cobrandLogin = cobrandLogin;
		}

		public String getCobrandPassword() {
			return cobrandPassword;
		}

		public void setCobrandPassword(String cobrandPassword) {
			this.cobrandPassword = cobrandPassword;
		}

		@Override
		public String toString() {
			return "Cobrand [cobrandLogin=" + cobrandLogin + ", cobrandPassword=" + cobrandPassword + ", locale="
					+ locale + "]";
		}
	}
}
