/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.holdings;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "cusip", "symbol", "description", "type", "style", "issueTypeMultiplier", "agencyFactor",
		"shareClass", "cdscFundFlag", "fundFamily", "closedFlag", "sAndPRating", "moodyRating", "firmEligible",
		"issueDate", "maturityDate", "callDate", "callPrice", "sector", "subSector", "lastModifiedDate", "interestRate",
		"accrualMethod", "statTaxableCode", "federalTaxable", "exchangeCode", "tradeCurrency", "couponFrequency",
		"isin", "sedol", "firstCouponDate", "lastCouponDate", "minimumPurchase", "incomeCurrency", "isDummySecurity",
		"stateTaxable", "tradeCurrencyCode", "frequency", "isSyntheticSecurity", "isEnvestnetDummySecurity",
		"gicsSector", "stockExchangeDetails"})
public class Security extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The unique identifier of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("id")
	private Long id;

	@ApiModelProperty(readOnly = true,
					  value = "A CUSIP is a nine-character alphanumeric code that identifies a North American financial security for the purposes of facilitating clearing and settlement of trades."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("cusip")
	private String cusip;

	@ApiModelProperty(readOnly = true,
					  value = "The description (name) of the security. For example, Cisco Systems."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("description")
	private String description;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the type of security like stocks, mutual fund, etc. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("type")
	private String type;

	@ApiModelProperty(readOnly = true,
					  value = "Classification of the style for the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("style")
	private String style;

	@ApiModelProperty(readOnly = true,
					  value = "Price units corresponding to the security style. This is used to derive actual price of the security from market value."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("issueTypeMultiplier")
	private Double issueTypeMultiplier;

	@ApiModelProperty(readOnly = true,
					  value = "Agency factor of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("agencyFactor")
	private Double agencyFactor;

	@ApiModelProperty(readOnly = true,
					  value = "Share class of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("shareClass")
	private String shareClass;

	@ApiModelProperty(readOnly = true,
					  value = "cdsc fund flag of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("cdscFundFlag")
	private Boolean cdscFundFlag;

	@ApiModelProperty(readOnly = true,
					  value = "Mutual Fund Family Name."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("fundFamily")
	private String fundFamily;

	@ApiModelProperty(readOnly = true,
					  value = "<b>true</b>:Closed for all investors , <b>false</b>: Open to all investors."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("closedFlag")
	private Boolean closedFlag;

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for S&P rating on Envestnet platform."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("sAndPRating")
	private String sAndPRating;

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for Moody rating on Envestnet platform."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("moodyRating")
	private String moodyRating;

	@ApiModelProperty(readOnly = true,
					  value = "<b>1</b>- indicates Eligible,<b>0</b>- indicates firm is not eligible."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("firmEligible")
	private String firmEligible;

	@ApiModelProperty(readOnly = true,
					  value = "Issue date of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("issueDate")
	private String issueDate;

	@ApiModelProperty(readOnly = true,
					  value = "Maturity date of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("maturityDate")
	private String maturityDate;

	@ApiModelProperty(readOnly = true,
					  value = "Next call date of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("callDate")
	private String callDate;

	@ApiModelProperty(readOnly = true,
					  value = "Next call price of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("callPrice")
	private Double callPrice;

	@ApiModelProperty(readOnly = true,
					  value = "Identifier of the sector to which the security belongs to."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("sector")
	private String sector;

	@ApiModelProperty(readOnly = true,
					  value = "GICS sector ID to which the security belongs to."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("subSector")
	private String subSector;

	@ApiModelProperty(readOnly = true,
					  value = "The last updated date of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("lastModifiedDate")
	private String lastModifiedDate;

	@ApiModelProperty(readOnly = true,
					  value = "The rate of interest paid annually, expressed as a percentage of the bond's par or face value."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("interestRate")
	private Double interestRate;

	@ApiModelProperty(readOnly = true,
					  value = "The method in which interest is accrued or earned."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("accrualMethod")
	private String accrualMethod;

	@ApiModelProperty(readOnly = true,
					  value = "Flag indicating federal taxable."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("federalTaxable")
	private Boolean federalTaxable;

	@ApiModelProperty(readOnly = true,
					  value = "The International Securities Identification Number (ISIN) is used worldwide to identify specific securities. It is equivalent to CUSIP for international markets."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("isin")
	private String isin;

	@ApiModelProperty(readOnly = true,
					  value = "The Stock Exchange Daily Official List (SEDOL) is a set of security identifiers used in the United Kingdom and Ireland for clearing purposes."
							  + "<br><b>Note</b>: The SEDOL field is only applicable to the trade related transactions."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("sedol")
	private String sedol;

	@ApiModelProperty(readOnly = true,
					  value = "First coupon date of security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("firstCouponDate")
	private String firstCouponDate;

	@ApiModelProperty(readOnly = true,
					  value = "Last coupon date of security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("lastCouponDate")
	private String lastCouponDate;

	@ApiModelProperty(readOnly = true,
					  value = "Minimum purchase of security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("minimumPurchase")
	private Integer minimumPurchase;

	@ApiModelProperty(readOnly = true,
					  value = "ISO 4217 currency code indicating income currency of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("incomeCurrency")
	private String incomeCurrency;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates whether the security is a dummy security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("isDummySecurity")
	private Boolean isDummySecurity;

	//
	@ApiModelProperty(readOnly = true,
					  value = "The state in which the security is taxed."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("stateTaxable")
	private Boolean stateTaxable;

	@ApiModelProperty(readOnly = true,
					  value = "ISO 4217 currency code indicating trading currency of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("tradeCurrencyCode")
	private String tradeCurrencyCode;

	@ApiModelProperty(readOnly = true,
					  value = "Coupon Frequency."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("frequency")
	private Integer frequency;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates whether the security is a simulated security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("isSyntheticSecurity")
	private Boolean isSyntheticSecurity;

	@ApiModelProperty(readOnly = true,
					  value = "Flag indicating a dummy security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("isEnvestnetDummySecurity")
	private Boolean isEnvestnetDummySecurity;

	@ApiModelProperty(readOnly = true,
					  value = "GICS Sector is a categorization the S&P assigns to all publically traded companies. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("gicsSector")
	private String gicsSector;

	@ApiModelProperty(readOnly = true,
					  value = "Securities exchange provide the securities information at the corresponding exchanges. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("stockExchangeDetails")
	private List<StockExchangeDetail> stockExchangeDetails;

	/**
	 * Identifier of the sector to which the security belongs to. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * Share class of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return shareClass
	 */
	public String getShareClass() {
		return shareClass;
	}

	/**
	 * GICS sector ID to which the security belongs to. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return subSector
	 */
	public String getSubSector() {
		return subSector;
	}

	/**
	 * The Stock Exchange Daily Official List (SEDOL) is a set of security identifiers used in the United Kingdom and
	 * Ireland for clearing purposes. <br>
	 * <b>Note</b>: The SEDOL field is only applicable to the trade related transactions. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return sedol
	 */
	public String getSedol() {
		return sedol;
	}

	/**
	 * Indicates the type of security like stocks, mutual fund, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * <b>1</b>- indicates Eligible,<b>0</b>- indicates firm is not eligible. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return firmEligible
	 */
	public String getFirmEligible() {
		return firmEligible;
	}

	/**
	 * Last coupon date of security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return lastCouponDate
	 */
	public String getLastCouponDate() {
		return lastCouponDate;
	}

	/**
	 * ISO 4217 currency code indicating income currency of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return incomeCurrency
	 */
	public String getIncomeCurrency() {
		return incomeCurrency;
	}

	/**
	 * Classification of the style for the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * The description (name) of the security. For example, Cisco Systems. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Unique identifier for Moody rating on Envestnet platform. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return moodyRating
	 */
	public String getMoodyRating() {
		return moodyRating;
	}

	/**
	 * Maturity date of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return maturityDate
	 */
	public String getMaturityDate() {
		return maturityDate;
	}

	/**
	 * The method in which interest is accrued or earned. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return accrualMethod
	 */
	public String getAccrualMethod() {
		return accrualMethod;
	}

	/**
	 * Issue date of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return issueDate
	 */
	public String getIssueDate() {
		return issueDate;
	}

	/**
	 * Next call date of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return callDate
	 */
	public String getCallDate() {
		return callDate;
	}

	/**
	 * First coupon date of security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return firstCouponDate
	 */
	public String getFirstCouponDate() {
		return firstCouponDate;
	}

	/**
	 * Mutual Fund Family Name. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return fundFamily
	 */
	public String getFundFamily() {
		return fundFamily;
	}

	/**
	 * The last updated date of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return lastModifiedDate
	 */
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * A CUSIP is a nine-character alphanumeric code that identifies a North American financial security for the
	 * purposes of facilitating clearing and settlement of trades. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return cusip
	 */
	public String getCusip() {
		return cusip;
	}

	/**
	 * The International Securities Identification Number (ISIN) is used worldwide to identify specific securities. It
	 * is equivalent to CUSIP for international markets. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return isin
	 */
	public String getIsin() {
		return isin;
	}

	/**
	 * ISO 4217 currency code indicating trading currency of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return tradeCurrencyCode
	 */
	public String getTradeCurrencyCode() {
		return tradeCurrencyCode;
	}

	/**
	 * GICS Sector is a categorization the S{@literal &}P assigns to all publically traded companies. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return gicsSector
	 */
	public String getGicsSector() {
		return gicsSector;
	}

	/**
	 * The unique identifier of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Price units corresponding to the security style. This is used to derive actual price of the security from market
	 * value. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return issueTypeMultiplier
	 */
	public Double getIssueTypeMultiplier() {
		return issueTypeMultiplier;
	}

	/**
	 * Agency factor of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return agencyFactor
	 */
	public Double getAgencyFactor() {
		return agencyFactor;
	}

	/**
	 * cdsc fund flag of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return cdscFundFlag
	 */
	public Boolean getCdscFundFlag() {
		return cdscFundFlag;
	}

	/**
	 * <b>true</b>:Closed for all investors , <b>false</b>: Open to all investors. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return closedFlag
	 */
	public Boolean getClosedFlag() {
		return closedFlag;
	}

	/**
	 * Next call price of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return callPrice
	 */
	public Double getCallPrice() {
		return callPrice;
	}

	/**
	 * The rate of interest paid annually, expressed as a percentage of the bond's par or face value. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return interestRate
	 */
	public Double getInterestRate() {
		return interestRate;
	}

	/**
	 * Flag indicating federal taxable. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return federalTaxable
	 */
	public Boolean getFederalTaxable() {
		return federalTaxable;
	}

	/**
	 * Minimum purchase of security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return minimumPurchase
	 */
	public Integer getMinimumPurchase() {
		return minimumPurchase;
	}

	/**
	 * Indicates whether the security is a dummy security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return isDummySecurity
	 */
	public Boolean getIsDummySecurity() {
		return isDummySecurity;
	}

	/**
	 * The state in which the security is taxed. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return stateTaxable
	 */
	public Boolean getStateTaxable() {
		return stateTaxable;
	}

	/**
	 * Coupon Frequency. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return frequency
	 */
	public Integer getFrequency() {
		return frequency;
	}

	/**
	 * Indicates whether the security is a simulated security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return isSyntheticSecurity
	 */
	public Boolean getIsSyntheticSecurity() {
		return isSyntheticSecurity;
	}

	/**
	 * Flag indicating a dummy security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return isEnvestnetDummySecurity
	 */
	public Boolean getIsEnvestnetDummySecurity() {
		return isEnvestnetDummySecurity;
	}

	/**
	 * Unique identifier for S{@literal &}P rating on Envestnet platform. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return sAndPRating
	 */
	public String getsAndPRating() {
		return sAndPRating;
	}

	/**
	 * Securities exchange provide the securities information at the corresponding exchanges. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return stockExchangeDetails
	 */
	public List<StockExchangeDetail> getStockExchangeDetails() {
		return stockExchangeDetails == null ? null : Collections.unmodifiableList(stockExchangeDetails);
	}

	@Override
	public String toString() {
		return "Security [id=" + id + ", cusip=" + cusip + ", description=" + description + ", type=" + type
				+ ", style=" + style + ", issueTypeMultiplier=" + issueTypeMultiplier + ", agencyFactor=" + agencyFactor
				+ ", shareClass=" + shareClass + ", cdscFundFlag=" + cdscFundFlag + ", fundFamily=" + fundFamily
				+ ", closedFlag=" + closedFlag + ", sAndPRating=" + sAndPRating + ", moodyRating=" + moodyRating
				+ ", firmEligible=" + firmEligible + ", issueDate=" + issueDate + ", maturityDate=" + maturityDate
				+ ", callDate=" + callDate + ", callPrice=" + callPrice + ", sector=" + sector + ", subSector="
				+ subSector + ", lastModifiedDate=" + lastModifiedDate + ", interestRate=" + interestRate
				+ ", accrualMethod=" + accrualMethod + ", federalTaxable=" + federalTaxable + ", isin=" + isin
				+ ", sedol=" + sedol + ", firstCouponDate=" + firstCouponDate + ", lastCouponDate=" + lastCouponDate
				+ ", minimumPurchase=" + minimumPurchase + ", incomeCurrency=" + incomeCurrency + ", isDummySecurity="
				+ isDummySecurity + ", stateTaxable=" + stateTaxable + ", tradeCurrencyCode=" + tradeCurrencyCode
				+ ", frequency=" + frequency + ", isSyntheticSecurity=" + isSyntheticSecurity
				+ ", isEnvestnetDummySecurity=" + isEnvestnetDummySecurity + ", gicsSector=" + gicsSector
				+ ", stockExchangeDetails=" + stockExchangeDetails + "]";
	}
}
