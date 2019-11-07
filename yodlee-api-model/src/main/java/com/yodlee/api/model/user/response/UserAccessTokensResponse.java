/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.user.response;

import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccessTokensResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("user")
	private UserAccessToken userAccessTokens;

	@JsonProperty("user")
	public UserAccessToken getUser() {
		return userAccessTokens;
	}

	@Override
	public String toString() {
		return "UserAccessTokenResponse [user = " + userAccessTokens + "]";
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public static final class UserAccessToken extends AbstractModelComponent {

		@JsonProperty("accessTokens")
		private List<AccessTokens> accessTokens;

		@JsonProperty("accessTokens")
		public List<AccessTokens> getAccessTokens() {
			return accessTokens == null ? null : Collections.unmodifiableList(accessTokens);
		}

		@Override
		public String toString() {
			return "UserAccessToken [accessTokens = " + accessTokens + "]";
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({"appId", "value", "url"})
	public static final class AccessTokens extends AbstractModelComponent {

		@ApiModelProperty(value = "The identifier of the application for which the access token is generated."//
				+ "<br><br>"//
				+ "<b>Endpoints</b>:"//
				+ "<ul>"//
				+ "<li>GET user/accessTokens</li>"//
				+ "</ul>")
		@NotNull(message = "appId cannot be null")
		@JsonProperty("appId")
		private String appId;

		@ApiModelProperty(value = "Access token value used to invoke the widgets/apps."//
				+ "<br><br>"//
				+ "<b>Endpoints</b>:"//
				+ "<ul>"//
				+ "<li>GET user/accessTokens</li>"//
				+ "</ul>")
		@NotNull(message = "appId cannot be null")
		@JsonProperty("value")
		private String value;

		@ApiModelProperty(value = "Base URL using which the application is accessed."//
				+ "<br><br>"//
				+ "<b>Endpoints</b>:"//
				+ "<ul>"//
				+ "<li>GET user/accessTokens</li>"//
				+ "</ul>")
		@NotNull(message = "appId cannot be null")
		@JsonProperty("url")
		private String url;

		/**
		 * The identifier of the application for which the access token is generated. <br>
		 * <br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>GET user/accessTokens</li>
		 * </ul>
		 * 
		 * @return appId
		 */
		public String getAppId() {
			return appId;
		}

		/**
		 * Access token value used to invoke the widgets/apps. <br>
		 * <br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>GET user/accessTokens</li>
		 * </ul>
		 * 
		 * @return value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * Base URL using which the application is accessed. <br>
		 * <br>
		 * <b>Endpoints</b>:
		 * <ul>
		 * <li>GET user/accessTokens</li>
		 * </ul>
		 * 
		 * @return url
		 */
		public String getUrl() {
			return url;
		}

		@Override
		public String toString() {
			return "AccessTokens [appId = " + appId + ", value = " + value + ", url = " + url + "]";
		}
	}
}
