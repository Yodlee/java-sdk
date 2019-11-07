/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.holdings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.enums.HoldingType;
import com.yodlee.api.model.enums.OptionType;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractHolding extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for the security added in the system. This is the primary key of the holding resource."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("id")
	protected Long id;

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier of the account to which the security is linked."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("accountId")
	protected Long accountId;

	@ApiModelProperty(readOnly = true,
					  value = "Unique identifier for the user's association with the provider."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("providerAccountId")
	protected Long providerAccountId;

	@ApiModelProperty(readOnly = true,
					  value = "In a one-off security purchase, the cost basis is the quantity acquired multiplied by the price per unit paid plus any commission paid. In case, the same position is acquired in different lots on different days at different prices, the sum total of the cost incurred is divided by the total units acquired to arrive at the average cost basis."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("costBasis")
	protected Money costBasis;

	@ApiModelProperty(readOnly = true,
					  value = "The CUSIP (Committee on Uniform Securities Identification Procedures) identifies most the financial instruments in the United States and Canada."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("cusipNumber")
	protected String cusipNumber;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the security type of holding identified through the security service."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("securityType")
	protected String securityType;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the security match status id of the investment option identified during security normalization."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("matchStatus")
	protected String matchStatus;

	@ApiModelProperty(readOnly = true,
					  value = "The description (name) for the holding (E.g., Cisco Systems)"
							  + "<br>For insurance container, the field is only applicable for insurance annuity and variable life insurance types. "//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("description")
	protected String description;

	@ApiModelProperty(readOnly = true,
					  value = "The current price of the security."
							  + "<br><b>Note</b>: Only for bonds the price field indicates the normalized price and not the price aggregated from the site. For insurance container, the field is only applicable for insurance annuity and variable life insurance types."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("price")
	protected Money price;

	@ApiModelProperty(readOnly = true,
					  value = "The quantity held for the holding."
							  + "<br><b>Note</b>: Only for bonds the quantity field indicates the normalized quantity and not the quantity aggregated from the site. The quantity field is only applicable to restricted stock units/awards, performance units, currency, and commodity."
							  + "<br>For insurance container, the field is only applicable for insurance annuity and variable life insurance types."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("quantity")
	protected Double quantity;

	@ApiModelProperty(readOnly = true,
					  value = "The symbol of the security."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("symbol")
	protected String symbol;

	@ApiModelProperty(readOnly = true,
					  value = "The total market value of the security. For insurance container, the field is only applicable for insurance annuity and variable life insurance types."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("value")
	protected Money value;

	//
	@ApiModelProperty(readOnly = true,
					  value = "The ISIN (International Securities Identification Number) is used worldwide to identify specific securities. It is equivalent to CUSIP for international markets.<br>"
							  + "<br><b>Note</b>: The ISIN field is only applicable to the trade related transactions"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("isin")
	protected String isin;

	@ApiModelProperty(readOnly = true,
					  value = "The SEDOL (Stock Exchange Daily Official List) is a set of security identifiers used in the United Kingdom and Ireland for clearing purposes."
							  + "<br><b>Note</b>: The SEDOL field is only applicable to the trade related transactions"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("sedol")
	protected String sedol;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates that the holding is a short trading."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("isShort")
	protected Boolean isShort;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the number of unvested quantity or units."
							  + "<br><b>Note</b>: The unvested quantity field is only applicable to employee stock options, restricted stock units/awards, performance units, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("unvestedQuantity")
	protected Double unvestedQuantity;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the estimated market value of the unvested units."
							  + "<br><b>Note</b>: FIs usually calculates the unvested value as the market price unvested quantity. The unvested value field is only applicable to employee stock options, restricted stock units/awards, performance units, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("unvestedValue")
	protected Money unvestedValue;

	@ApiModelProperty(readOnly = true,
					  value = "The quantity of units or shares that are already vested on a vest date."
							  + "<br><b>Note</b>: The vested quantity field is only applicable to employee stock options, restricted stock units/awards, performance units, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("vestedQuantity")
	protected Double vestedQuantity;

	@ApiModelProperty(readOnly = true,
					  value = "The number of vested shares that can be exercised by the employee. It is usually equal to the vested quantity."
							  + "<br><b>Note</b>: The vested shares exercisable field is only applicable to employee stock options, restricted stock units/awards, performance units, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("vestedSharesExercisable")
	protected Double vestedSharesExercisable;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the estimated market value of the vested units."
							  + "<br><b>Note</b>: FIs usually calculates the vested value as the market price vested quantity. The vested value field is only applicable to employee stock options, restricted stock units/awards, performance units, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("vestedValue")
	protected Money vestedValue;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which a RSU, RSA, or an employee stock options become vested."
							  + "<br><b>Note</b>: The vesting date field is only applicable to employee stock options, restricted stock units/awards, performance units, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("vestingDate")
	protected String vestingDate;

	@ApiModelProperty(readOnly = true,
					  value = "The quantity of tradeable units in a contract."
							  + "<br><b>Note</b>: The contract quantity field is only applicable to commodity and currency."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("contractQuantity")
	protected Double contractQuantity;

	@ApiModelProperty(readOnly = true,
					  value = "The stated interest rate for a bond."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("couponRate")
	protected Double couponRate;

	@ApiModelProperty(readOnly = true,
					  value = "The quantity of the employee stock options that are already exercised or bought by the employee."
							  + "<br><b>Note</b>: Once the employee stock options is exercised, they are either converted to cash value or equity positions depending on the FI. The exercised quantity field is only applicable to employee stock options."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("exercisedQuantity")
	protected Double exercisedQuantity;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which an option, right or warrant expires."
							  + "<br><b>Note</b>: The expiration date field is only applicable to options and employee stock options."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("expirationDate")
	protected String expirationDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which equity awards like ESOP, RSU, etc., are issued or granted."
							  + "<br><b>Note</b>: The grant date field is only applicable to employee stock options, restricted stock units/awards, performance units, etc."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("grantDate")
	protected String grantDate;

	@ApiModelProperty(readOnly = true,
					  value = "The interest rate on a CD."
							  + "<br><b>Note</b>: The interest rate field is only applicable to CD."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("interestRate")
	protected Double interestRate;

	@ApiModelProperty(readOnly = true,
					  value = "The stated maturity date of a bond or CD."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("maturityDate")
	protected String maturityDate;

	@ApiModelProperty(readOnly = true,
					  value = "The type of the option position (i.e., put or call)."
							  + "<br><b>Note</b>: The option type field is only applicable to options."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("optionType")
	protected OptionType optionType;

	@ApiModelProperty(readOnly = true,
					  value = "The difference between the current market value of a stock and the strike price of the employee stock option, when the market value of the shares are greater than the stock price."
							  + "<br><b>Note</b>: The spread field is only applicable to employee stock options."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("spread")
	protected Money spread;

	@ApiModelProperty(readOnly = true,
					  value = "The strike (exercise) price for the option position."
							  + "<br><b>Note</b>: The strike price field is only applicable to options and employee stock options."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("strikePrice")
	protected Money strikePrice;

	@ApiModelProperty(readOnly = true,
					  value = "The fixed duration for which the bond or CD is issued."
							  + "<br><b>Note</b>: The term field is only applicable to CD."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("term")
	protected String term;

	@ApiModelProperty(readOnly = true,
					  value = "The accruedInterest of the  holding."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("accruedInterest")
	protected Money accruedInterest;

	@ApiModelProperty(readOnly = true,
					  value = "The accruedIncome of the  holding."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
	)
	@JsonProperty("accruedIncome")
	protected Money accruedIncome;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the holding is created in the Yodlee system."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("createdDate")
	protected String createdDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date when the information was last updated in the system."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("lastUpdated")
	protected String lastUpdated;

	@ApiModelProperty(readOnly = true,
					  value = "Type of holding"//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: investment, insurance<br>"//
	)
	@JsonProperty("holdingType")
	protected HoldingType holdingType;

	/**
	 * The CUSIP (Committee on Uniform Securities Identification Procedures) identifies most the financial instruments
	 * in the United States and Canada. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return cusipNumber
	 */
	public String getCusipNumber() {
		return cusipNumber;
	}

	/**
	 * The symbol of the security. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * The current price of the security. <br>
	 * <b>Note</b>: Only for bonds the price field indicates the normalized price and not the price aggregated from the
	 * site. For insurance container, the field is only applicable for insurance annuity and variable life insurance
	 * types. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return price
	 */
	public Money getPrice() {
		return price;
	}

	/**
	 * Indicates the security type of holding identified through the security service. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return securityType
	 */
	public String getSecurityType() {
		return securityType;
	}

	/**
	 * The description (name) for the holding (E.g., Cisco Systems) <br>
	 * For insurance container, the field is only applicable for insurance annuity and variable life insurance types.
	 * <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Indicates the security match status id of the investment option identified during security normalization. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return matchStatus
	 */
	public String getMatchStatus() {
		return matchStatus;
	}

	/**
	 * The total market value of the security. For insurance container, the field is only applicable for insurance
	 * annuity and variable life insurance types. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return value
	 */
	public Money getValue() {
		return value;
	}

	/**
	 * In a one-off security purchase, the cost basis is the quantity acquired multiplied by the price per unit paid
	 * plus any commission paid. In case, the same position is acquired in different lots on different days at different
	 * prices, the sum total of the cost incurred is divided by the total units acquired to arrive at the average cost
	 * basis. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return costBasis
	 */
	public Money getCostBasis() {
		return costBasis;
	}

	/**
	 * Unique identifier for the security added in the system. This is the primary key of the holding resource. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Unique identifier of the account to which the security is linked. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * Unique identifier for the user's association with the provider. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return providerAccountId
	 */
	public Long getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * The quantity held for the holding. <br>
	 * <b>Note</b>: Only for bonds the quantity field indicates the normalized quantity and not the quantity aggregated
	 * from the site. The quantity field is only applicable to restricted stock units/awards, performance units,
	 * currency, and commodity. <br>
	 * For insurance container, the field is only applicable for insurance annuity and variable life insurance types.
	 * <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return quantity
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * The ISIN (International Securities Identification Number) is used worldwide to identify specific securities. It
	 * is equivalent to CUSIP for international markets.<br>
	 * <br>
	 * <b>Note</b>: The ISIN field is only applicable to the trade related transactions <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return isin
	 */
	public String getIsin() {
		return isin;
	}

	/**
	 * The SEDOL (Stock Exchange Daily Official List) is a set of security identifiers used in the United Kingdom and
	 * Ireland for clearing purposes. <br>
	 * <b>Note</b>: The SEDOL field is only applicable to the trade related transactions <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return sedol
	 */
	public String getSedol() {
		return sedol;
	}

	/**
	 * Indicates that the holding is a short trading. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return isShort
	 */
	public Boolean getIsShort() {
		return isShort;
	}

	/**
	 * Indicates the number of unvested quantity or units. <br>
	 * <b>Note</b>: The unvested quantity field is only applicable to employee stock options, restricted stock
	 * units/awards, performance units, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return unvestedQuantity
	 */
	public Double getUnvestedQuantity() {
		return unvestedQuantity;
	}

	/**
	 * Indicates the estimated market value of the unvested units. <br>
	 * <b>Note</b>: FIs usually calculates the unvested value as the market price unvested quantity. The unvested value
	 * field is only applicable to employee stock options, restricted stock units/awards, performance units, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return unvestedValue
	 */
	public Money getUnvestedValue() {
		return unvestedValue;
	}

	/**
	 * The quantity of units or shares that are already vested on a vest date. <br>
	 * <b>Note</b>: The vested quantity field is only applicable to employee stock options, restricted stock
	 * units/awards, performance units, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return vestedQuantity
	 */
	public Double getVestedQuantity() {
		return vestedQuantity;
	}

	/**
	 * The number of vested shares that can be exercised by the employee. It is usually equal to the vested quantity.
	 * <br>
	 * <b>Note</b>: The vested shares exercisable field is only applicable to employee stock options, restricted stock
	 * units/awards, performance units, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return vestedSharesExercisable
	 */
	public Double getVestedSharesExercisable() {
		return vestedSharesExercisable;
	}

	/**
	 * Indicates the estimated market value of the vested units. <br>
	 * <b>Note</b>: FIs usually calculates the vested value as the market price vested quantity. The vested value field
	 * is only applicable to employee stock options, restricted stock units/awards, performance units, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return vestedValue
	 */
	public Money getVestedValue() {
		return vestedValue;
	}

	/**
	 * The date on which a RSU, RSA, or an employee stock options become vested. <br>
	 * <b>Note</b>: The vesting date field is only applicable to employee stock options, restricted stock units/awards,
	 * performance units, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return vestingDate
	 */
	public String getVestingDate() {
		return vestingDate;
	}

	/**
	 * The quantity of tradeable units in a contract. <br>
	 * <b>Note</b>: The contract quantity field is only applicable to commodity and currency. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return contractQuantity
	 */
	public Double getContractQuantity() {
		return contractQuantity;
	}

	/**
	 * The stated interest rate for a bond. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return couponRate
	 */
	public Double getCouponRate() {
		return couponRate;
	}

	/**
	 * The quantity of the employee stock options that are already exercised or bought by the employee. <br>
	 * <b>Note</b>: Once the employee stock options is exercised, they are either converted to cash value or equity
	 * positions depending on the FI. The exercised quantity field is only applicable to employee stock options. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return exercisedQuantity
	 */
	public Double getExercisedQuantity() {
		return exercisedQuantity;
	}

	/**
	 * The date on which an option, right or warrant expires. <br>
	 * <b>Note</b>: The expiration date field is only applicable to options and employee stock options. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * The date on which equity awards like ESOP, RSU, etc., are issued or granted. <br>
	 * <b>Note</b>: The grant date field is only applicable to employee stock options, restricted stock units/awards,
	 * performance units, etc. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return grantDate
	 */
	public String getGrantDate() {
		return grantDate;
	}

	/**
	 * The interest rate on a CD. <br>
	 * <b>Note</b>: The interest rate field is only applicable to CD. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return interestRate
	 */
	public Double getInterestRate() {
		return interestRate;
	}

	/**
	 * The stated maturity date of a bond or CD. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return maturityDate
	 */
	public String getMaturityDate() {
		return maturityDate;
	}

	/**
	 * The type of the option position (i.e., put or call). <br>
	 * <b>Note</b>: The option type field is only applicable to options. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return optionType
	 */
	public OptionType getOptionType() {
		return optionType;
	}

	/**
	 * The difference between the current market value of a stock and the strike price of the employee stock option,
	 * when the market value of the shares are greater than the stock price. <br>
	 * <b>Note</b>: The spread field is only applicable to employee stock options. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return spread
	 */
	public Money getSpread() {
		return spread;
	}

	/**
	 * The strike (exercise) price for the option position. <br>
	 * <b>Note</b>: The strike price field is only applicable to options and employee stock options. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return strikePrice
	 */
	public Money getStrikePrice() {
		return strikePrice;
	}

	/**
	 * The fixed duration for which the bond or CD is issued. <br>
	 * <b>Note</b>: The term field is only applicable to CD. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * The accruedInterest of the holding. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return accruedInterest
	 */
	public Money getAccruedInterest() {
		return accruedInterest;
	}

	/**
	 * The accruedIncome of the holding. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment<br>
	 * 
	 * @return accruedIncome
	 */
	public Money getAccruedIncome() {
		return accruedIncome;
	}

	/**
	 * The date on which the holding is created in the Yodlee system. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * The date when the information was last updated in the system. <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Type of holding <br>
	 * <br>
	 * <b>Applicable containers</b>: investment, insurance<br>
	 * 
	 * @return holdingType
	 */
	public HoldingType getHoldingType() {
		return holdingType;
	}
}
