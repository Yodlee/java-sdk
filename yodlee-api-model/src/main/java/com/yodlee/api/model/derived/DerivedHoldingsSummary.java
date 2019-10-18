/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.derived;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"classificationType", "classificationValue", "links", "value", "account", "holding"})
public class DerivedHoldingsSummary extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The classification type of the security. The supported asset classification type and the values are provided in the /holdings/assetClassificationList."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("classificationType")
	private String classificationType;

	@ApiModelProperty(readOnly = true,
					  value = "The classification value that corresponds to the classification type of the holding. The supported asset classification type and the values are provided in the /holdings/assetClassificationList."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("classificationValue")
	private String classificationValue;

	@ApiModelProperty(readOnly = true,
					  value = "Summary value of the securities."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("value")
	private Money value;

	@ApiModelProperty(readOnly = true,
					  value = "Accounts that contribute to the classification. "
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("account")
	private List<DerivedHoldingsAccount> accounts;

	@ApiModelProperty(readOnly = true,
					  value = "Securities that belong to the asset classification type and contributed to the summary value."
							  + "<br><b>Required Feature Enablement</b>: Asset classification feature."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("holding")
	private List<DerivedHolding> holdings;

	/**
	 * Accounts that contribute to the classification. <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return account
	 */
	@JsonProperty("account")
	public List<DerivedHoldingsAccount> getAccount() {
		return accounts == null ? null : Collections.unmodifiableList(accounts);
	}

	/**
	 * Securities that belong to the asset classification type and contributed to the summary value. <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return holding
	 */
	@JsonProperty("holding")
	public List<DerivedHolding> getHolding() {
		return holdings == null ? null : Collections.unmodifiableList(holdings);
	}

	/**
	 * The classification value that corresponds to the classification type of the holding. The supported asset
	 * classification type and the values are provided in the /holdings/assetClassificationList. <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return classificationValue
	 */
	public String getClassificationValue() {
		return classificationValue;
	}

	/**
	 * The classification type of the security. The supported asset classification type and the values are provided in
	 * the /holdings/assetClassificationList. <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return classificationType
	 */
	public String getClassificationType() {
		return classificationType;
	}

	/**
	 * Summary value of the securities. <br>
	 * <b>Required Feature Enablement</b>: Asset classification feature. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return value
	 */
	public Money getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "DerivedHoldingsSummary [classificationType=" + classificationType + ", classificationValue="
				+ classificationValue + ", value=" + value + ", account=" + accounts + ", holding=" + holdings + "]";
	}
}
