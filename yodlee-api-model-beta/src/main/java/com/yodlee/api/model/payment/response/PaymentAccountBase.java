/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.payment.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.enums.ItemAccountStatus;

import io.swagger.annotations.ApiModelProperty;

public class PaymentAccountBase {
	@ApiModelProperty(readOnly = true, value = "The primary key of the account resource and the unique identifier for the account.<br><br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "<li>GET /partner/paymentProcessor/account/balance</li>"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("id")
	protected Long id;
	
	@ApiModelProperty(readOnly = true, value = "The date time the account information was last retrieved from the provider site and updated in the Yodlee system.<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "<li>GET /partner/paymentProcessor/account/balance</li>"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("lastUpdated")
	protected String lastUpdated;

	@ApiModelProperty(readOnly = true, value = "The account name as it appears at the site.<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "<li>GET /partner/paymentProcessor/account/balance</li>"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("accountName")
	protected String accountName;

	@ApiModelProperty(readOnly = true, value = "The type of account that is aggregated, i.e., savings, checking, charge, etc. "
			+ "The account type is derived based on the attributes of the account. <br>" //
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "<li>GET /partner/paymentProcessor/account/balance</li>"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("accountType")
	protected String accountType;

	@ApiModelProperty(readOnly = true, value = "The status of the account that is updated by the user through an application or an API.</li>"
			+ "<ul><li><b>ACTIVE:</b> All the added aggregated accounts status will be made \"ACTIVE\" by default.</li>"
			+ "<li><b>TO_BE_CLOSED:</b> If the aggregated accounts are not found or closed in the data provider site, Yodlee system marks the status as TO_BE_CLOSED.</li>"
			+ "<li><b>INACTIVE:</b> Users can update the status as INACTIVE to stop updating and to stop considering the account in other services.</li>"
			+ "<li><b>CLOSED:</b> Users can update the status as CLOSED, if the account is closed with the provider.</li></ul>"
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET /partner/paymentProcessor/account</li>"//
			+ "<li>GET /partner/paymentProcessor/account/balance</li>"//
			+ "<li>GET /partner/paymentProcessor/account/holder</li>"//
			+ "</ul>")
	@JsonProperty("accountStatus")
	protected ItemAccountStatus accountStatus;
	
	
	public Long getId() {
		return id;
	}

	/**
	 * The date time the account information was last retrieved from the provider site and updated in the Yodlee
	 * system.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lastUpdated
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}
	
	/**
	 * The account name as it appears at the site.<br>
	 * (The POST accounts service response return this field as name)<br>
	 * <b>Applicable containers</b>: All Containers<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return accountName
	 */
	public String getAccountName() {
		return accountName;
	}
	
	/**
	 * The type of account that is aggregated, i.e., savings, checking, credit card, charge, HELOC, etc. The account
	 * type is derived based on the attributes of the account. <br>
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
	 * <b>creditCard</b>
	 * <ul>
	 * <li>OTHER</li>
	 * <li>CREDIT</li>
	 * <li>STORE</li>
	 * <li>CHARGE</li>
	 * <li>OTHER</li>
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
	 * <li>DIGITAL_WALLET</li>
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
	 * <li>DIGITAL_WALLET</li>
	 * <li>OTHER</li>
	 * </ul>
	 * <b>loan</b>
	 * <ul>
	 * <li>MORTGAGE</li>
	 * <li>INSTALLMENT_LOAN</li>
	 * <li>PERSONAL_LOAN</li>
	 * <li>HOME_EQUITY_LINE_OF_CREDIT</li>
	 * <li>LINE_OF_CREDIT</li>
	 * <li>AUTO_LOAN</li>
	 * <li>STUDENT_LOAN</li>
	 * <li>HOME_LOAN</li>
	 * </ul>
	 * <b>insurance</b>
	 * <ul>
	 * <li>AUTO_INSURANCE</li>
	 * <li>HEALTH_INSURANCE</li>
	 * <li>HOME_INSURANCE</li>
	 * <li>LIFE_INSURANCE</li>
	 * <li>ANNUITY</li>
	 * <li>TRAVEL_INSURANCE</li>
	 * <li>INSURANCE</li>
	 * </ul>
	 * <b>realEstate</b>
	 * <ul>
	 *
	 * <li>REAL_ESTATE</li>
	 * </ul>
	 * <b>reward</b>
	 * <ul>
	 * <li>REWARD_POINTS</li>
	 * </ul>
	 * <b>Manual Account Type</b><br>
	 * <b>bank</b>
	 * <ul>
	 * <li>CHECKING</li>
	 * <li>SAVINGS</li>
	 * <li>CD</li>
	 * <li>PREPAID</li>
	 * </ul>
	 * <b>credit</b>
	 * <ul>
	 *
	 * <li>CREDIT</li>
	 * </ul>
	 * <b>loan</b>
	 * <ul>
	 *
	 * <li>PERSONAL_LOAN</li>
	 * <li>HOME_LOAN</li>
	 * </ul>
	 * <b>insurance</b>
	 * <ul>
	 * <li>INSURANCE</li>
	 * <li>ANNUITY</li>
	 * </ul>
	 * <b>investment</b>
	 * <ul>
	 * <li>BROKERAGE_CASH</li>
	 * </ul>
	 * <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	
	/**
	 * The status of the account that is updated by the consumer through an application or an API. Valid Values:
	 * AccountStatus <br>
	 * <b>Additional Details:</b> <br>
	 * <b>ACTIVE:</b> All the added manual and aggregated accounts status will be made \ACTIVE\ by default. <br>
	 * <b>TO_BE_CLOSED:</b> If the aggregated accounts are not found or closed in the data provider site, Yodlee system
	 * marks the status as TO_BE_CLOSED <br>
	 * <b>INACTIVE:</b> Users can update the status as INACTIVE to stop updating and to stop considering the account in
	 * other services <br>
	 * <b>CLOSED:</b> Users can update the status as CLOSED, if the account is closed with the provider. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return accountStatus
	 */
	public ItemAccountStatus getAccountStatus() {
		return accountStatus;
	}
	

}
