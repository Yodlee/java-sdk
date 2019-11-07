/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.derived;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AssetClassification;
import com.yodlee.api.model.holdings.AbstractHolding;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "accountId", "providerAccountId", "costBasis", "cusipNumber", "securityType", "matchStatus",
		"description", "holdingType", "price", "quantity", "symbol", "value", "assetClassification", "isin", "sedol",
		"isShort", "unvestedQuantity", "unvestedValue", "vestedQuantity", "vestedSharesExercisable", "vestedValue",
		"vestingDate", "contractQuantity", "couponRate", "exercisedQuantity", "expirationDate", "grantDate",
		"interestRate", "maturityDate", "optionType", "spread", "strikePrice", "term", "accruedInterest",
		"accruedIncome", "createdDate", "lastUpdated"})
public class DerivedHolding extends AbstractHolding {

	@ApiModelProperty(readOnly = true,
					  value = "Asset classification applied to the holding. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("assetClassification")
	private AssetClassification assetClassifications;

	/**
	 * Asset classification applied to the holding. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return assetClassification
	 */
	public AssetClassification getAssetClassifications() {
		return assetClassifications;
	}

	@Override
	public String toString() {
		return "DerivedHolding [assetClassifications=" + assetClassifications + ", id=" + id + ", accountId="
				+ accountId + ", providerAccountId=" + providerAccountId + ", costBasis=" + costBasis + ", cusipNumber="
				+ cusipNumber + ", securityType=" + securityType + ", matchStatus=" + matchStatus + ", description="
				+ description + ", price=" + price + ", quantity=" + quantity + ", symbol=" + symbol + ", value="
				+ value + ", isin=" + isin + ", sedol=" + sedol + ", isShort=" + isShort + ", unvestedQuantity="
				+ unvestedQuantity + ", unvestedValue=" + unvestedValue + ", vestedQuantity=" + vestedQuantity
				+ ", vestedSharesExercisable=" + vestedSharesExercisable + ", vestedValue=" + vestedValue
				+ ", vestingDate=" + vestingDate + ", contractQuantity=" + contractQuantity + ", couponRate="
				+ couponRate + ", exercisedQuantity=" + exercisedQuantity + ", expirationDate=" + expirationDate
				+ ", grantDate=" + grantDate + ", interestRate=" + interestRate + ", maturityDate=" + maturityDate
				+ ", optionType=" + optionType + ", spread=" + spread + ", strikePrice=" + strikePrice + ", term="
				+ term + ", accruedInterest=" + accruedInterest + ", accruedIncome=" + accruedIncome + ", createdDate="
				+ createdDate + ", lastUpdated=" + lastUpdated + ", holdingType=" + holdingType + "]";
	}
}
