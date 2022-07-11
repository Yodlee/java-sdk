/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.enums.AccountLatestBalanceContainer;
import com.yodlee.api.model.account.enums.AccountLatestBalanceFailedReason;
import com.yodlee.api.model.account.enums.AccountLatestBalanceRefreshStatus;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"CONTAINER", "providerId", "providerAccountId", "accountId", "providerName", "accountType",
		"accountNumber", "accountName", "availableBalance", "currentBalance", "balance", "totalBalance", "cash",
		"lastUpdated", "refreshStatus", "failedReason"})
public class AccountLatestBalance extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The type of service. E.g., Bank, Investment <br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("CONTAINER")
	protected AccountLatestBalanceContainer container;

	@ApiModelProperty(readOnly = true,
					  value = "Identifier of the provider site. The primary key of provider resource. "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("providerId")
	protected String providerId;

	@ApiModelProperty(readOnly = true,
					  value = "The primary key of the provider account resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("providerAccountId")
	protected Long providerAccountId;

	@ApiModelProperty(readOnly = true,
					  value = "The primary key of the provider account resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("accountId")
	protected Long accountId;

	@ApiModelProperty(readOnly = true,
					  value = "Service provider or institution name where the account originates. This belongs to the provider resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("providerName")
	protected String providerName;

	@ApiModelProperty(readOnly = true,
					  value = "The type of account that is aggregated, i.e., savings, checking, charge, HELOC, etc. "
							  + "The account type is derived based on the attributes of the account. " //
							  + "<br><b>Valid Values:</b>"//
							  + "<br><b>Aggregated Account Type</b>"//
							  + "<br><b>bank</b>"//
							  + "<ul>"//
							  + "<li>CHECKING</li>"//
							  + "<li>SAVINGS</li>"//
							  + "<li>CD</li>"//
							  + "<li>PPF</li>"//
							  + "<li>RECURRING_DEPOSIT</li>"//
							  + "<li>FSA</li>"//
							  + "<li>MONEY_MARKET</li>"//
							  + "<li>IRA</li>"//
							  + "<li>PREPAID</li>"//
							  + "</ul>"//
							  + "<b>investment (SN 1.0)</b>"//
							  + "<ul>" + "<li>BROKERAGE_MARGIN</li>"//
							  + "<li>HSA</li>"//
							  + "<li>IRA</li>"//
							  + "<li>BROKERAGE_CASH</li>"//
							  + "<li>401K</li>"//
							  + "<li>403B</li>"//
							  + "<li>TRUST</li>"//
							  + "<li>ANNUITY</li>"//
							  + "<li>SIMPLE</li>"//
							  + "<li>CUSTODIAL</li>"//
							  + "<li>BROKERAGE_CASH_OPTION</li>"//
							  + "<li>BROKERAGE_MARGIN_OPTION</li>"//
							  + "<li>INDIVIDUAL</li>"//
							  + "<li>CORPORATE</li>"//
							  + "<li>JTTIC</li>"//
							  + "<li>JTWROS</li>"//
							  + "<li>COMMUNITY_PROPERTY</li>"//
							  + "<li>JOINT_BY_ENTIRETY</li>"//
							  + "<li>CONSERVATORSHIP</li>"//
							  + "<li>ROTH</li>"//
							  + "<li>ROTH_CONVERSION</li>"//
							  + "<li>ROLLOVER</li>"//
							  + "<li>EDUCATIONAL</li>"//
							  + "<li>529_PLAN</li>"//
							  + "<li>457_DEFERRED_COMPENSATION</li>"//
							  + "<li>401A</li>"//
							  + "<li>PSP</li>"//
							  + "<li>MPP</li>"//
							  + "<li>STOCK_BASKET</li>"//
							  + "<li>LIVING_TRUST</li>"//
							  + "<li>REVOCABLE_TRUST</li>"//
							  + "<li>IRREVOCABLE_TRUST</li>"//
							  + "<li>CHARITABLE_REMAINDER</li>"//
							  + "<li>CHARITABLE_LEAD</li>"//
							  + "<li>CHARITABLE_GIFT_ACCOUNT</li>"//
							  + "<li>SEP</li>"//
							  + "<li>UTMA</li>"//
							  + "<li>UGMA</li>"//
							  + "<li>ESOPP</li>"//
							  + "<li>ADMINISTRATOR</li>"//
							  + "<li>EXECUTOR</li>"//
							  + "<li>PARTNERSHIP</li>"//
							  + "<li>SOLE_PROPRIETORSHIP</li>"//
							  + "<li>CHURCH</li>"//
							  + "<li>INVESTMENT_CLUB</li>"//
							  + "<li>RESTRICTED_STOCK_AWARD</li>"//
							  + "<li>CMA</li>"//
							  + "<li>EMPLOYEE_STOCK_PURCHASE_PLAN</li>"//
							  + "<li>PERFORMANCE_PLAN</li>"//
							  + "<li>BROKERAGE_LINK_ACCOUNT</li>"//
							  + "<li>MONEY_MARKET</li>"//
							  + "<li>SUPER_ANNUATION</li>"//
							  + "<li>REGISTERED_RETIREMENT_SAVINGS_PLAN</li>"//
							  + "<li>SPOUSAL_RETIREMENT_SAVINGS_PLAN</li>"//
							  + "<li>DEFERRED_PROFIT_SHARING_PLAN</li>"//
							  + "<li>NON_REGISTERED_SAVINGS_PLAN</li>"//
							  + "<li>REGISTERED_EDUCATION_SAVINGS_PLAN</li>"//
							  + "<li>GROUP_RETIREMENT_SAVINGS_PLAN</li>"//
							  + "<li>LOCKED_IN_RETIREMENT_SAVINGS_PLAN</li>"//
							  + "<li>RESTRICTED_LOCKED_IN_SAVINGS_PLAN</li>"//
							  + "<li>LOCKED_IN_RETIREMENT_ACCOUNT</li>"//
							  + "<li>REGISTERED_PENSION_PLAN</li>"//
							  + "<li>TAX_FREE_SAVINGS_ACCOUNT</li>"//
							  + "<li>LIFE_INCOME_FUND</li>"//
							  + "<li>REGISTERED_RETIREMENT_INCOME_FUND</li>"//
							  + "<li>SPOUSAL_RETIREMENT_INCOME_FUND</li>"//
							  + "<li>LOCKED_IN_REGISTERED_INVESTMENT_FUND</li>"//
							  + "<li>PRESCRIBED_REGISTERED_RETIREMENT_INCOME_FUND</li>"//
							  + "<li>GUARANTEED_INVESTMENT_CERTIFICATES</li>"//
							  + "<li>REGISTERED_DISABILITY_SAVINGS_PLAN</li>"//
							  + "<li>DIGITAL_WALLET</li>"//
							  + "<li>OTHER</li>"//
							  + "</ul>"//
							  + "<b>investment (SN 2.0)</b>"//
							  + "<ul>"//
							  + "<li>BROKERAGE_CASH</li>"//
							  + "<li>BROKERAGE_MARGIN</li>"//
							  + "<li>INDIVIDUAL_RETIREMENT_ACCOUNT_IRA</li>"//
							  + "<li>EMPLOYEE_RETIREMENT_ACCOUNT_401K</li>"//
							  + "<li>EMPLOYEE_RETIREMENT_SAVINGS_PLAN_403B</li>"//
							  + "<li>TRUST</li>"//
							  + "<li>ANNUITY</li>"//
							  + "<li>SIMPLE_IRA</li>"//
							  + "<li>CUSTODIAL_ACCOUNT</li>"//
							  + "<li>BROKERAGE_CASH_OPTION</li>"//
							  + "<li>BROKERAGE_MARGIN_OPTION</li>"//
							  + "<li>INDIVIDUAL</li>"//
							  + "<li>CORPORATE_INVESTMENT_ACCOUNT</li>"//
							  + "<li>JOINT_TENANTS_TENANCY_IN_COMMON_JTIC</li>"//
							  + "<li>JOINT_TENANTS_WITH_RIGHTS_OF_SURVIVORSHIP_JTWROS</li>"//
							  + "<li>JOINT_TENANTS_COMMUNITY_PROPERTY</li>"//
							  + "<li>JOINT_TENANTS_TENANTS_BY_ENTIRETY</li>"//
							  + "<li>CONSERVATOR</li>"//
							  + "<li>ROTH_IRA</li>"//
							  + "<li>ROTH_CONVERSION</li>"//
							  + "<li>ROLLOVER_IRA</li>"//
							  + "<li>EDUCATIONAL</li>"//
							  + "<li>EDUCATIONAL_SAVINGS_PLAN_529</li>"//
							  + "<li>DEFERRED_COMPENSATION_PLAN_457</li>"//
							  + "<li>MONEY_PURCHASE_RETIREMENT_PLAN_401A</li>"//
							  + "<li>PROFIT_SHARING_PLAN</li>"//
							  + "<li>MONEY_PURCHASE_PLAN</li>"//
							  + "<li>STOCK_BASKET_ACCOUNT</li>"//
							  + "<li>LIVING_TRUST</li>"//
							  + "<li>REVOCABLE_TRUST</li>"//
							  + "<li>IRREVOCABLE_TRUST</li>"//
							  + "<li>CHARITABLE_REMAINDER_TRUST</li>"//
							  + "<li>CHARITABLE_LEAD_TRUST</li>"//
							  + "<li>CHARITABLE_GIFT_ACCOUNT</li>"//
							  + "<li>SEP_IRA</li>"//
							  + "<li>UNIFORM_TRANSFER_TO_MINORS_ACT_UTMA</li>"//
							  + "<li>UNIFORM_GIFT_TO_MINORS_ACT_UGMA</li>"//
							  + "<li>EMPLOYEE_STOCK_OWNERSHIP_PLAN_ESOP</li>"//
							  + "<li>ADMINISTRATOR</li>"//
							  + "<li>EXECUTOR</li>"//
							  + "<li>PARTNERSHIP</li>"//
							  + "<li>PROPRIETORSHIP</li>"//
							  + "<li>CHURCH_ACCOUNT</li>"//
							  + "<li>INVESTMENT_CLUB</li>"//
							  + "<li>RESTRICTED_STOCK_AWARD</li>"//
							  + "<li>CASH_MANAGEMENT_ACCOUNT</li>"//
							  + "<li>EMPLOYEE_STOCK_PURCHASE_PLAN_ESPP</li>"//
							  + "<li>PERFORMANCE_PLAN</li>"//
							  + "<li>BROKERAGE_LINK_ACCOUNT</li>"//
							  + "<li>MONEY_MARKET_ACCOUNT</li>"//
							  + "<li>SUPERANNUATION</li>"//
							  + "<li>REGISTERED_RETIREMENT_SAVINGS_PLAN_RRSP</li>"//
							  + "<li>SPOUSAL_RETIREMENT_SAVINGS_PLAN_SRSP</li>"//
							  + "<li>DEFERRED_PROFIT_SHARING_PLAN_DPSP</li>"//
							  + "<li>NON_REGISTERED_SAVINGS_PLAN_NRSP</li>"//
							  + "<li>REGISTERED_EDUCATION_SAVINGS_PLAN_RESP</li>"//
							  + "<li>GROUP_RETIREMENT_SAVINGS_PLAN_GRSP</li>"//
							  + "<li>LOCKED_IN_RETIREMENT_SAVINGS_PLAN_LRSP</li>"//
							  + "<li>RESTRICTED_LOCKED_IN_SAVINGS_PLAN_RLSP</li>"//
							  + "<li>LOCKED_IN_RETIREMENT_ACCOUNT_LIRA</li>"//
							  + "<li>REGISTERED_PENSION_PLAN_RPP</li>"//
							  + "<li>TAX_FREE_SAVINGS_ACCOUNT_TFSA</li>"//
							  + "<li>LIFE_INCOME_FUND_LIF</li>"//
							  + "<li>REGISTERED_RETIREMENT_INCOME_FUND_RIF</li>"//
							  + "<li>SPOUSAL_RETIREMENT_INCOME_FUND_SRIF</li>"//
							  + "<li>LOCKED_IN_REGISTERED_INVESTMENT_FUND_LRIF</li>"//
							  + "<li>PRESCRIBED_REGISTERED_RETIREMENT_INCOME_FUND_PRIF</li>"//
							  + "<li>GUARANTEED_INVESTMENT_CERTIFICATES_GIC</li>"//
							  + "<li>REGISTERED_DISABILITY_SAVINGS_PLAN_RDSP</li>"//
							  + "<li>DEFINED_CONTRIBUTION_PLAN</li>"//
							  + "<li>DEFINED_BENEFIT_PLAN</li>"//
							  + "<li>EMPLOYEE_STOCK_OPTION_PLAN</li>"//
							  + "<li>NONQUALIFIED_DEFERRED_COMPENSATION_PLAN_409A</li>"//
							  + "<li>KEOGH_PLAN</li>"//
							  + "<li>EMPLOYEE_RETIREMENT_ACCOUNT_ROTH_401K</li>"//
							  + "<li>DEFERRED_CONTINGENT_CAPITAL_PLAN_DCCP</li>"//
							  + "<li>EMPLOYEE_BENEFIT_PLAN</li>"//
							  + "<li>EMPLOYEE_SAVINGS_PLAN</li>"//
							  + "<li>HEALTH_SAVINGS_ACCOUNT_HSA</li>"//
							  + "<li>COVERDELL_EDUCATION_SAVINGS_ACCOUNT_ESA</li>"//
							  + "<li>TESTAMENTARY_TRUST</li>"//
							  + "<li>ESTATE</li>"//
							  + "<li>GRANTOR_RETAINED_ANNUITY_TRUST_GRAT</li>"//
							  + "<li>ADVISORY_ACCOUNT</li>"//
							  + "<li>NON_PROFIT_ORGANIZATION_501C</li>"//
							  + "<li>HEALTH_REIMBURSEMENT_ARRANGEMENT_HRA</li>"//
							  + "<li>INDIVIDUAL_SAVINGS_ACCOUNT_ISA</li>"//
							  + "<li>CASH_ISA</li>"//
							  + "<li>STOCKS_AND_SHARES_ISA</li>"//
							  + "<li>INNOVATIVE_FINANCE_ISA</li>"//
							  + "<li>JUNIOR_ISA</li>"//
							  + "<li>EMPLOYEES_PROVIDENT_FUND_ORGANIZATION_EPFO</li>"//
							  + "<li>PUBLIC_PROVIDENT_FUND_PPF</li>"//
							  + "<li>EMPLOYEES_PENSION_SCHEME_EPS</li>"//
							  + "<li>NATIONAL_PENSION_SYSTEM_NPS</li>"//
							  + "<li>INDEXED_ANNUITY</li>"//
							  + "<li>ANNUITIZED_ANNUITY</li>"//
							  + "<li>VARIABLE_ANNUITY</li>"//
							  + "<li>ROTH_403B</li>"//
							  + "<li>SPOUSAL_IRA</li>"//
							  + "<li>SPOUSAL_ROTH_IRA</li>"//
							  + "<li>SARSEP_IRA</li>"//
							  + "<li>SUBSTANTIALLY_EQUAL_PERIODIC_PAYMENTS_SEPP</li>"//
							  + "<li>OFFSHORE_TRUST</li>"//
							  + "<li>IRREVOCABLE_LIFE_INSURANCE_TRUST</li>"//
							  + "<li>INTERNATIONAL_TRUST</li>"//
							  + "<li>LIFE_INTEREST_TRUST</li>"//
							  + "<li>EMPLOYEE_BENEFIT_TRUST</li>"//
							  + "<li>PRECIOUS_METAL_ACCOUNT</li>"//
							  + "<li>INVESTMENT_LOAN_ACCOUNT</li>"//
							  + "<li>GRANTOR_RETAINED_INCOME_TRUST</li>"//
							  + "<li>PENSION_PLAN</li>"//
							  + "<li>DIGITAL_WALLET</li>"//
							  + "<li>OTHER</li>"//
							  + "</ul>"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("accountType")
	protected String accountType;

	@ApiModelProperty(readOnly = true,
					  value = "The account number as it appears on the site. (The POST accounts service response return this field as number)<br>"
							  + "<b>Additional Details</b>:<b> Bank / Investment</b>:<br>"
							  + " The account number for the bank account as it appears at the site.<br>"
							  + "In most cases, the site does not display the full account number in the account summary page "
							  + "and additional navigation is required to aggregate it.<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("accountNumber")
	protected String accountNumber;

	@ApiModelProperty(readOnly = true,
					  value = "The account name as it appears at the site.<br>"//
							  + "(The POST accounts service response return this field as name)<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("accountName")
	protected String accountName;

	@ApiModelProperty(readOnly = true,
					  value = "The balance in the account that is available for spending. "
							  + "For checking accounts with overdraft, available balance may include "
							  + "overdraft amount, if end site adds overdraft balance to available balance.<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("availableBalance")
	protected Money availableBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The balance in the account that is available at the beginning of the "
							  + "business day; it is equal to the ledger balance of the account.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("currentBalance")
	protected Money currentBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The total account value. " + "<br><b>Additional Details:</b>"
							  + "<br><b>Bank:</b> available balance or current balance."
							  + "<br><b>Investment:</b> The total balance of all the investment account, as it appears on the FI site."
							  + "<b>Applicable containers</b>: bank, investment <br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("balance")
	protected Money balance;

	@ApiModelProperty(readOnly = true,
					  value = "The total account value. " + "<br><b>Additional Details:</b>"
							  + "<br><b>Investment:</b> The total balance of all the investment account, as it appears on the FI site."
							  + "<b>Applicable containers</b>: investment <br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("totalBalance")
	protected Money totalBalance;
	
	@ApiModelProperty(readOnly = true,
					  value = "The date time the account information was last retrieved from the provider site and updated in the Yodlee system.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("lastUpdated")
	protected String lastUpdated;

	@ApiModelProperty(readOnly = true,
					  value = "The amount that is available for immediate withdrawal or the total amount available to purchase securities in a brokerage or investment account."
							  + "<br><b>Note:</b> The cash balance field is only applicable to brokerage related accounts.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts/latestBalances</li>"//
							  + "</ul>")
	@JsonProperty("cash")
	protected Money cash;

	@ApiModelProperty(readOnly = true, value = "The status of the account balance refresh request."//
	)
	@JsonProperty("refreshStatus")
	protected AccountLatestBalanceRefreshStatus refreshStatus;

	@ApiModelProperty(readOnly = true, value = "The reason the account balance refresh failed.")//
	@JsonProperty("failedReason")
	protected AccountLatestBalanceFailedReason failedReason;

	/**
	 * The type of service. E.g., Bank, Investment,.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return CONTAINER
	 */
	@JsonProperty("CONTAINER")
	public AccountLatestBalanceContainer getContainer() {
		return container;
	}

	/**
	 * Identifier of the provider site. The primary key of provider resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * The primary key of the provider account resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return providerAccountId
	 */
	public Long getProviderAccountId() {
		return providerAccountId;
	}

	/**
	 * The primary key of the provider account resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * Service provider or institution name where the account originates. This belongs to the provider resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * The type of account that is aggregated, i.e., savings, checking, charge, HELOC, etc. The account type is derived
	 * based on the attributes of the account. <br>
	 * <b>Valid Values:</b> <br>
	 * <b>Aggregated Account Type</b> <br>
	 * <b>bank</b>
	 * <ul>
	 * <li>CHECKING</li>
	 * <li>SAVINGS</li>
	 * <li>CD</li>
	 * <li>PPF</li>
	 * <li>RECURRING_DEPOSIT</li>
	 * <li>FSA</li>
	 * <li>MONEY_MARKET</li>
	 * <li>IRA</li>
	 * <li>PREPAID</li>
	 * </ul>
	 * <b>investment (SN 1.0)</b>
	 * <ul>
	 *
	 * <li>BROKERAGE_MARGIN</li>
	 * <li>HSA</li>
	 * <li>IRA</li>
	 * <li>BROKERAGE_CASH</li>
	 * <li>401K</li>
	 * <li>403B</li>
	 * <li>TRUST</li>
	 * <li>ANNUITY</li>
	 * <li>SIMPLE</li>
	 * <li>CUSTODIAL</li>
	 * <li>BROKERAGE_CASH_OPTION</li>
	 * <li>BROKERAGE_MARGIN_OPTION</li>
	 * <li>INDIVIDUAL</li>
	 * <li>CORPORATE</li>
	 * <li>JTTIC</li>
	 * <li>JTWROS</li>
	 * <li>COMMUNITY_PROPERTY</li>
	 * <li>JOINT_BY_ENTIRETY</li>
	 * <li>CONSERVATORSHIP</li>
	 * <li>ROTH</li>
	 * <li>ROTH_CONVERSION</li>
	 * <li>ROLLOVER</li>
	 * <li>EDUCATIONAL</li>
	 * <li>529_PLAN</li>
	 * <li>457_DEFERRED_COMPENSATION</li>
	 * <li>401A</li>
	 * <li>PSP</li>
	 * <li>MPP</li>
	 * <li>STOCK_BASKET</li>
	 * <li>LIVING_TRUST</li>
	 * <li>REVOCABLE_TRUST</li>
	 * <li>IRREVOCABLE_TRUST</li>
	 * <li>CHARITABLE_REMAINDER</li>
	 * <li>CHARITABLE_LEAD</li>
	 * <li>CHARITABLE_GIFT_ACCOUNT</li>
	 * <li>SEP</li>
	 * <li>UTMA</li>
	 * <li>UGMA</li>
	 * <li>ESOPP</li>
	 * <li>ADMINISTRATOR</li>
	 * <li>EXECUTOR</li>
	 * <li>PARTNERSHIP</li>
	 * <li>SOLE_PROPRIETORSHIP</li>
	 * <li>CHURCH</li>
	 * <li>INVESTMENT_CLUB</li>
	 * <li>RESTRICTED_STOCK_AWARD</li>
	 * <li>CMA</li>
	 * <li>EMPLOYEE_STOCK_PURCHASE_PLAN</li>
	 * <li>PERFORMANCE_PLAN</li>
	 * <li>BROKERAGE_LINK_ACCOUNT</li>
	 * <li>MONEY_MARKET</li>
	 * <li>SUPER_ANNUATION</li>
	 * <li>REGISTERED_RETIREMENT_SAVINGS_PLAN</li>
	 * <li>SPOUSAL_RETIREMENT_SAVINGS_PLAN</li>
	 * <li>DEFERRED_PROFIT_SHARING_PLAN</li>
	 * <li>NON_REGISTERED_SAVINGS_PLAN</li>
	 * <li>REGISTERED_EDUCATION_SAVINGS_PLAN</li>
	 * <li>GROUP_RETIREMENT_SAVINGS_PLAN</li>
	 * <li>LOCKED_IN_RETIREMENT_SAVINGS_PLAN</li>
	 * <li>RESTRICTED_LOCKED_IN_SAVINGS_PLAN</li>
	 * <li>LOCKED_IN_RETIREMENT_ACCOUNT</li>
	 * <li>REGISTERED_PENSION_PLAN</li>
	 * <li>TAX_FREE_SAVINGS_ACCOUNT</li>
	 * <li>LIFE_INCOME_FUND</li>
	 * <li>REGISTERED_RETIREMENT_INCOME_FUND</li>
	 * <li>SPOUSAL_RETIREMENT_INCOME_FUND</li>
	 * <li>LOCKED_IN_REGISTERED_INVESTMENT_FUND</li>
	 * <li>PRESCRIBED_REGISTERED_RETIREMENT_INCOME_FUND</li>
	 * <li>GUARANTEED_INVESTMENT_CERTIFICATES</li>
	 * <li>REGISTERED_DISABILITY_SAVINGS_PLAN</li>
	 * <li>OTHER</li>
	 * </ul>
	 * <b>investment (SN 2.0)</b>
	 * <ul>
	 * <li>BROKERAGE_CASH</li>
	 * <li>BROKERAGE_MARGIN</li>
	 * <li>INDIVIDUAL_RETIREMENT_ACCOUNT_IRA</li>
	 * <li>EMPLOYEE_RETIREMENT_ACCOUNT_401K</li>
	 * <li>EMPLOYEE_RETIREMENT_SAVINGS_PLAN_403B</li>
	 * <li>TRUST</li>
	 * <li>ANNUITY</li>
	 * <li>SIMPLE_IRA</li>
	 * <li>CUSTODIAL_ACCOUNT</li>
	 * <li>BROKERAGE_CASH_OPTION</li>
	 * <li>BROKERAGE_MARGIN_OPTION</li>
	 * <li>INDIVIDUAL</li>
	 * <li>CORPORATE_INVESTMENT_ACCOUNT</li>
	 * <li>JOINT_TENANTS_TENANCY_IN_COMMON_JTIC</li>
	 * <li>JOINT_TENANTS_WITH_RIGHTS_OF_SURVIVORSHIP_JTWROS</li>
	 * <li>JOINT_TENANTS_COMMUNITY_PROPERTY</li>
	 * <li>JOINT_TENANTS_TENANTS_BY_ENTIRETY</li>
	 * <li>CONSERVATOR</li>
	 * <li>ROTH_IRA</li>
	 * <li>ROTH_CONVERSION</li>
	 * <li>ROLLOVER_IRA</li>
	 * <li>EDUCATIONAL</li>
	 * <li>EDUCATIONAL_SAVINGS_PLAN_529</li>
	 * <li>DEFERRED_COMPENSATION_PLAN_457</li>
	 * <li>MONEY_PURCHASE_RETIREMENT_PLAN_401A</li>
	 * <li>PROFIT_SHARING_PLAN</li>
	 * <li>MONEY_PURCHASE_PLAN</li>
	 * <li>STOCK_BASKET_ACCOUNT</li>
	 * <li>LIVING_TRUST</li>
	 * <li>REVOCABLE_TRUST</li>
	 * <li>IRREVOCABLE_TRUST</li>
	 * <li>CHARITABLE_REMAINDER_TRUST</li>
	 * <li>CHARITABLE_LEAD_TRUST</li>
	 * <li>CHARITABLE_GIFT_ACCOUNT</li>
	 * <li>SEP_IRA</li>
	 * <li>UNIFORM_TRANSFER_TO_MINORS_ACT_UTMA</li>
	 * <li>UNIFORM_GIFT_TO_MINORS_ACT_UGMA</li>
	 * <li>EMPLOYEE_STOCK_OWNERSHIP_PLAN_ESOP</li>
	 * <li>ADMINISTRATOR</li>
	 * <li>EXECUTOR</li>
	 * <li>PARTNERSHIP</li>
	 * <li>PROPRIETORSHIP</li>
	 * <li>CHURCH_ACCOUNT</li>
	 * <li>INVESTMENT_CLUB</li>
	 * <li>RESTRICTED_STOCK_AWARD</li>
	 * <li>CASH_MANAGEMENT_ACCOUNT</li>
	 * <li>EMPLOYEE_STOCK_PURCHASE_PLAN_ESPP</li>
	 * <li>PERFORMANCE_PLAN</li>
	 * <li>BROKERAGE_LINK_ACCOUNT</li>
	 * <li>MONEY_MARKET_ACCOUNT</li>
	 * <li>SUPERANNUATION</li>
	 * <li>REGISTERED_RETIREMENT_SAVINGS_PLAN_RRSP</li>
	 * <li>SPOUSAL_RETIREMENT_SAVINGS_PLAN_SRSP</li>
	 * <li>DEFERRED_PROFIT_SHARING_PLAN_DPSP</li>
	 * <li>NON_REGISTERED_SAVINGS_PLAN_NRSP</li>
	 * <li>REGISTERED_EDUCATION_SAVINGS_PLAN_RESP</li>
	 * <li>GROUP_RETIREMENT_SAVINGS_PLAN_GRSP</li>
	 * <li>LOCKED_IN_RETIREMENT_SAVINGS_PLAN_LRSP</li>
	 * <li>RESTRICTED_LOCKED_IN_SAVINGS_PLAN_RLSP</li>
	 * <li>LOCKED_IN_RETIREMENT_ACCOUNT_LIRA</li>
	 * <li>REGISTERED_PENSION_PLAN_RPP</li>
	 * <li>TAX_FREE_SAVINGS_ACCOUNT_TFSA</li>
	 * <li>LIFE_INCOME_FUND_LIF</li>
	 * <li>REGISTERED_RETIREMENT_INCOME_FUND_RIF</li>
	 * <li>SPOUSAL_RETIREMENT_INCOME_FUND_SRIF</li>
	 * <li>LOCKED_IN_REGISTERED_INVESTMENT_FUND_LRIF</li>
	 * <li>PRESCRIBED_REGISTERED_RETIREMENT_INCOME_FUND_PRIF</li>
	 * <li>GUARANTEED_INVESTMENT_CERTIFICATES_GIC</li>
	 * <li>REGISTERED_DISABILITY_SAVINGS_PLAN_RDSP</li>
	 * <li>DEFINED_CONTRIBUTION_PLAN</li>
	 * <li>DEFINED_BENEFIT_PLAN</li>
	 * <li>EMPLOYEE_STOCK_OPTION_PLAN</li>
	 * <li>NONQUALIFIED_DEFERRED_COMPENSATION_PLAN_409A</li>
	 * <li>KEOGH_PLAN</li>
	 * <li>EMPLOYEE_RETIREMENT_ACCOUNT_ROTH_401K</li>
	 * <li>DEFERRED_CONTINGENT_CAPITAL_PLAN_DCCP</li>
	 * <li>EMPLOYEE_BENEFIT_PLAN</li>
	 * <li>EMPLOYEE_SAVINGS_PLAN</li>
	 * <li>HEALTH_SAVINGS_ACCOUNT_HSA</li>
	 * <li>COVERDELL_EDUCATION_SAVINGS_ACCOUNT_ESA</li>
	 * <li>TESTAMENTARY_TRUST</li>
	 * <li>ESTATE</li>
	 * <li>GRANTOR_RETAINED_ANNUITY_TRUST_GRAT</li>
	 * <li>ADVISORY_ACCOUNT</li>
	 * <li>NON_PROFIT_ORGANIZATION_501C</li>
	 * <li>HEALTH_REIMBURSEMENT_ARRANGEMENT_HRA</li>
	 * <li>INDIVIDUAL_SAVINGS_ACCOUNT_ISA</li>
	 * <li>CASH_ISA</li>
	 * <li>STOCKS_AND_SHARES_ISA</li>
	 * <li>INNOVATIVE_FINANCE_ISA</li>
	 * <li>JUNIOR_ISA</li>
	 * <li>EMPLOYEES_PROVIDENT_FUND_ORGANIZATION_EPFO</li>
	 * <li>PUBLIC_PROVIDENT_FUND_PPF</li>
	 * <li>EMPLOYEES_PENSION_SCHEME_EPS</li>
	 * <li>NATIONAL_PENSION_SYSTEM_NPS</li>
	 * <li>INDEXED_ANNUITY</li>
	 * <li>ANNUITIZED_ANNUITY</li>
	 * <li>VARIABLE_ANNUITY</li>
	 * <li>ROTH_403B</li>
	 * <li>SPOUSAL_IRA</li>
	 * <li>SPOUSAL_ROTH_IRA</li>
	 * <li>SARSEP_IRA</li>
	 * <li>SUBSTANTIALLY_EQUAL_PERIODIC_PAYMENTS_SEPP</li>
	 * <li>OFFSHORE_TRUST</li>
	 * <li>IRREVOCABLE_LIFE_INSURANCE_TRUST</li>
	 * <li>INTERNATIONAL_TRUST</li>
	 * <li>LIFE_INTEREST_TRUST</li>
	 * <li>EMPLOYEE_BENEFIT_TRUST</li>
	 * <li>PRECIOUS_METAL_ACCOUNT</li>
	 * <li>INVESTMENT_LOAN_ACCOUNT</li>
	 * <li>GRANTOR_RETAINED_INCOME_TRUST</li>
	 * <li>PENSION_PLAN</li>
	 * <li>OTHER</li>
	 * </ul>
	 * 
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * The account number as it appears on the site. (The POST accounts service response return this field as
	 * number)<br>
	 * <b>Additional Details</b>:<b> Bank/ Investment</b>:<br>
	 * The account number for the bank account as it appears at the site.<br>
	 * The account number can be full or partial based on how it is displayed in the account summary page of the site.
	 * In most cases, the site does not display the full account number in the account summary page and additional
	 * navigation is required to aggregate it.<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * The account name as it appears at the site.<br>
	 * (The POST accounts service response return this field as name)<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * The balance in the account that is available for spending. For checking accounts with overdraft, available
	 * balance may include overdraft amount, if end site adds overdraft balance to available balance.<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * GET accounts/latestBalances
	 * 
	 * @return availableBalance
	 */
	public Money getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * The balance in the account that is available at the beginning of the business day; it is equal to the ledger
	 * balance of the account.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return currentBalance
	 */
	public Money getCurrentBalance() {
		return currentBalance;
	}

	/**
	 * The total account value. * <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Bank:</b> available balance or current balance. <br>
	 * <b>Investment:</b> The total balance of all the investment account, as it appears on the FI site. <br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return balance
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * The total account value. * <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Investment:</b> The total balance of all the investment account, as it appears on the FI site. <br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return totalBalance
	 */
	public Money getTotalBalance() {
		return totalBalance;
	}

	/**
	 * The amount that is available for immediate withdrawal or the total amount available to purchase securities in a
	 * brokerage or investment account. <br>
	 * <b>Note:</b> The cash balance field is only applicable to brokerage related accounts.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return cash
	 */
	public Money getCash() {
		return cash;
	}

	/**
	 * The date time the account information was last retrieved from the provider site and updated in the Yodlee
	 * system.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts/latestBalances</li>
	 * </ul>
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * The status of the account balance refresh request.
	 * 
	 * @return refreshStatus
	 */
	public AccountLatestBalanceRefreshStatus getRefreshStatus() {
		return refreshStatus;
	}

	/**
	 * The reason the account balance refresh failed.
	 * 
	 * @return failedReason
	 */
	public AccountLatestBalanceFailedReason getFailedReason() {
		return failedReason;
	}
 
	@Override
	public String toString() {
		return "AccountLatestBalance [container=" + container + ", providerId=" + providerId + ", providerAccountId="
				+ providerAccountId + ", accountId=" + accountId + ", providerName=" + providerName + ", accountType="
				+ accountType + ", accountNumber=" + accountNumber + ", accountName=" + accountName
				+ ", availableBalance=" + availableBalance + ", currentBalance=" + currentBalance + ", balance="
				+ balance + ", totalBalance=" + totalBalance + ", lastUpdated=" + lastUpdated + ", cash=" + cash
				+ ", refreshStatus=" + refreshStatus + ", failedReason=" + failedReason + "]";
	}
		
}
