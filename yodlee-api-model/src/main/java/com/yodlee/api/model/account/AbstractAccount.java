/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.account;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.AccountDataset;
import com.yodlee.api.model.Money;
import com.yodlee.api.model.account.enums.AccountClassification;
import com.yodlee.api.model.account.enums.FrequencyType;
import com.yodlee.api.model.account.enums.HomeInsuranceType;
import com.yodlee.api.model.account.enums.ItemAccountStatus;
import com.yodlee.api.model.account.enums.LifeInsuranceType;
import com.yodlee.api.model.account.enums.LoanInterestRateType;
import com.yodlee.api.model.account.enums.LoanRepaymentPlanType;
import com.yodlee.api.model.account.enums.PolicyStatus;
import com.yodlee.api.model.account.enums.SourceAccountStatus;
import com.yodlee.api.model.account.enums.UserClassification;
import com.yodlee.api.model.account.enums.ValuationType;
import com.yodlee.api.model.enums.AggregationSource;
import com.yodlee.api.model.enums.Container;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractAccount extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The type of service. E.g., Bank, Credit Card, Investment, Insurance, etc.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("CONTAINER")
	protected Container container;

	@ApiModelProperty(readOnly = true,
					  value = "The primary key of the provider account resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("providerAccountId")
	protected Long providerAccountId;

	@ApiModelProperty(readOnly = true,
					  value = "The account name as it appears at the site.<br>"//
							  + "(The POST accounts service response return this field as name)<br>"//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("accountName")
	protected String accountName;

	@ApiModelProperty(readOnly = true,
					  value = "The status of the account that is updated by the consumer through an application or an API. "
							  + "Valid Values: AccountStatus" //
							  + "<br><b>Additional Details:</b>"
							  + "<br><b>ACTIVE:</b> All the added manual and aggregated accounts status will be made \"ACTIVE\" by default. "
							  + "<br><b>TO_BE_CLOSED:</b> If the aggregated accounts are not found or closed in the data provider site, Yodlee system marks the status as TO_BE_CLOSED"
							  + "<br><b>INACTIVE:</b> Users can update the status as INACTIVE to stop updating and to stop considering the account in other services"
							  + "<br><b>CLOSED:</b> Users can update the status as CLOSED, if the account is closed with the provider. "
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("accountStatus")
	protected ItemAccountStatus accountStatus;

	@ApiModelProperty(readOnly = true,
					  value = "The account number as it appears on the site. (The POST accounts service response return this field as number)<br>"
							  + "<b>Additional Details</b>:<b> Bank/ Loan/ Insurance/ Investment/Bill</b>:<br>"
							  + " The account number for the bank account as it appears at the site.<br>"
							  + "<b>Credit Card</b>: The account number of the card account as it appears at the site,<br>"
							  + "i.e., the card number.The account number can be full or partial based on how it is displayed in the account summary page of the site."
							  + "In most cases, the site does not display the full account number in the account summary page "
							  + "and additional navigation is required to aggregate it.<br>"//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>POST accounts</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("accountNumber")
	protected String accountNumber;

	@ApiModelProperty(readOnly = true,
					  value = "The source through which the account(s) are added in the system.<br>"
							  + "<b>Valid Values</b>: SYSTEM, USER<br>"//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("aggregationSource")
	protected AggregationSource aggregationSource;

	@ApiModelProperty(readOnly = true,
					  value = "The account to be considered as an asset or liability.<br>"//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("isAsset")
	protected Boolean isAsset;

	@ApiModelProperty(readOnly = true,
					  value = "The total account value. " + "<br><b>Additional Details:</b>"
							  + "<br><b>Bank:</b> available balance or current balance."
							  + "<br><b>Credit Card:</b> running Balance."
							  + "<br><b>Investment:</b> The total balance of all the investment account, as it appears on the FI site."
							  + "<br><b>Insurance:</b> CashValue or amountDue" + "<br><b>Loan:</b> principalBalance"
							  + "<br><b>Bill:</b> amountDue<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, loan, bill, otherAssets, otherLiabilities, realEstate<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("balance")
	protected Money balance;

	@ApiModelProperty(readOnly = true,
					  value = "The primary key of the account resource and the unique identifier for the account.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts </li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET investmentOptions</li>"//
							  + "<li>GET accounts/historicalBalances</li>"//
							  + "<li>POST accounts</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("id")
	protected Long id;

	@ApiModelProperty(readOnly = true,
					  value = ""//
							  + "<b>Applicable containers</b>: reward, bank, creditCard, investment, loan, insurance, realEstate, bill, otherLiabilities<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts </li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>POST accounts</ul>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("userClassification")
	protected UserClassification userClassification;

	@ApiModelProperty(readOnly = true,
					  value = "Used to determine  whether an account to be considered in the networth calculation."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank,creditCard,loan,investment,insurance,realEstate,otherAssets,otherLiabilities<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("includeInNetWorth")
	protected Boolean includeInNetWorth;

	@ApiModelProperty(readOnly = true,
					  value = "Identifier of the provider site. The primary key of provider resource. "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("providerId")
	protected String providerId;

	@ApiModelProperty(readOnly = true,
					  value = "Service provider or institution name where the account originates. This belongs to the provider resource."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("providerName")
	protected String providerName;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates if an account is aggregated from a site or it is a "
							  + "manual account i.e. account information manually provided by the user.<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("isManual")
	protected Boolean isManual;

	@ApiModelProperty(readOnly = true,
					  value = "The balance in the account that is available for spending. "
							  + "For checking accounts with overdraft, available balance may include "
							  + "overdraft amount, if end site adds overdraft balance to available balance.<br>"//
							  + "<b>Applicable containers</b>: bank, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
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
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("currentBalance")
	protected Money currentBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The type of account that is aggregated, i.e., savings, checking, credit card, charge, HELOC, etc. "
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
							  + "<b>creditCard</b>"//
							  + "<ul>"//
							  + "<li>OTHER</li>"//
							  + "<li>CREDIT</li>"//
							  + "<li>STORE</li>"//
							  + "<li>CHARGE</li>"//
							  + "<li>OTHER</li>"//
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
							  + "<li>OTHER</li>"//
							  + "</ul>"//
							  + "<b>bill</b>"//
							  + "<ul>"//
							  + "<li>TELEPHONE</li>"//
							  + "<li>UTILITY</li>"//
							  + "<li>CABLE</li>"//
							  + "<li>WIRELESS</li>"//
							  + "<li>BILLS</li>"//
							  + "</ul>"//
							  + "<b>loan</b>"//
							  + "<ul>"//
							  + "<li>MORTGAGE</li>"//
							  + "<li>INSTALLMENT_LOAN</li>"//
							  + "<li>PERSONAL_LOAN</li>"//
							  + "<li>HOME_EQUITY_LINE_OF_CREDIT</li>"//
							  + "<li>LINE_OF_CREDIT</li>"//
							  + "<li>AUTO_LOAN</li>"//
							  + "<li>STUDENT_LOAN</li>"//
							  + "<li>HOME_LOAN</li>"//
							  + "</ul>"//
							  + "<b>insurance</b>"//
							  + "<ul>"//
							  + "<li>AUTO_INSURANCE</li>"//
							  + "<li>HEALTH_INSURANCE</li>"//
							  + "<li>HOME_INSURANCE</li>"//
							  + "<li>LIFE_INSURANCE</li>"//
							  + "<li>ANNUITY</li>"//
							  + "<li>TRAVEL_INSURANCE</li>"//
							  + "<li>INSURANCE</li>"//
							  + "</ul>"//
							  + "<b>realEstate</b>"//
							  + "<ul> " + "<li>REAL_ESTATE</li>"//
							  + "</ul>"//
							  + "<b>reward</b>"//
							  + "<ul>"//
							  + "<li>REWARD_POINTS</li>"//
							  + "</ul>"//
							  + "<b>Manual Account Type</b><br>"//
							  + "<b>bank</b>"//
							  + "<ul>"//
							  + "<li>CHECKING</li>"//
							  + "<li>SAVINGS</li>"//
							  + "<li>CD</li>"//
							  + "<li>PREPAID</li>"//
							  + "</ul>"//
							  + "<b>credit</b>"//
							  + "<ul>  " + "<li>CREDIT</li>"//
							  + "</ul>"//
							  + "<b>loan</b>"//
							  + "<ul>  " + "<li>PERSONAL_LOAN</li>"//
							  + "<li>HOME_LOAN</li>"//
							  + "</ul>"//
							  + "<b>bill</b>"//
							  + "<ul>"//
							  + "<li>BILLS</li>"//
							  + "</ul>"//
							  + "<b>insurance</b>"//
							  + "<ul>"//
							  + "<li>INSURANCE</li>"//
							  + "<li>ANNUITY</li>"//
							  + "</ul>"//
							  + "<b>investment</b>"//
							  + "<ul>"//
							  + "<li>BROKERAGE_CASH</li>"//
							  + "</ul>"//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("accountType")
	protected String accountType;

	@ApiModelProperty(readOnly = true,
					  value = "The name or identification of the account owner, as it appears at the FI site. "
							  + "<br><b>Note:</b> The account holder name can be full or partial based on how it is displayed in the account "
							  + "summary page of the FI site. In most cases, the FI site does not display the full account holder "
							  + "name in the account summary page."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, insurance, loan, bill, reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("displayedName")
	protected String displayedName;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the account is created in the Yodlee system."
							  + "<br><b>Additional Details:</b> It is the date when the user links or aggregates the account(s) that "
							  + "are held with the provider to the Yodlee system."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("createdDate")
	protected String createdDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the due amount has to be paid. " + "<br><b>Additional Details:</b>"
							  + "<br><b>Credit Card:</b> The monthly date by when the minimum payment is due to be paid on the credit card account. "
							  + "<br><b>Loan:</b> The date on or before which the due amount should be paid."
							  + "<br><b>Note:</b> The due date at the account-level can differ from the due date field at the statement-level, as the "
							  + "information in the aggregated card account data provides an up-to-date information to the consumer."
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance, bill<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("dueDate")
	protected String dueDate;

	@ApiModelProperty(readOnly = true,
					  value = "The amount borrowed from the 401k account.<br>"
							  + "<b>Note</b>: The 401k loan field is only applicable to the 401k account type.<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("401kLoan")
	protected Money loan401k;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the contract value of the annuity.<br>"
							  + "<b>Note:</b> The annuity balance field is applicable only to annuities.<br>"//
							  + "<b>Applicable containers</b>: insurance, investment<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("annuityBalance")
	protected Money annuityBalance;

	@ApiModelProperty(readOnly = true,
					  value = "Interest paid from the start of the year to date.<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("interestPaidYTD")
	protected Money interestPaidYTD;

	@ApiModelProperty(readOnly = true,
					  value = "Interest paid in last calendar year.<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("interestPaidLastYear")
	protected Money interestPaidLastYear;

	@ApiModelProperty(readOnly = true,
					  value = "The type of the interest rate, for example, fixed or variable.<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("interestRateType")
	protected LoanInterestRateType interestRateType;

	@ApiModelProperty(readOnly = true,
					  value = "Property or possession offered to support a loan that can be seized on a default.<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("collateral")
	protected String collateral;

	@ApiModelProperty(readOnly = true,
					  value = "Annual percentage yield (APY) is a normalized representation of an interest rate, "
							  + "based on a compounding period of one year. "
							  + "APY generally refers to the rate paid to a depositor by a financial institution on an account.<br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("annualPercentageYield")
	protected Double annualPercentageYield;

	@ApiModelProperty(readOnly = true,
					  value = "The financial cost that the policyholder pays to the insurance company to obtain an insurance cover."
							  + "The premium is paid as a lump sum or in installments during the duration of the policy.<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("premium")
	protected Money premium;

	@ApiModelProperty(readOnly = true,
					  value = "The sum of the future payments due to be paid to the insurance company during a policy year. "
							  + "It is the policy rate minus the payments made till date."
							  + "<br><b>Note:</b> The remaining balance field is applicable only to auto insurance and home insurance.<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("remainingBalance")
	protected Money remainingBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the insurance policy coverage commences.<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("policyEffectiveDate")
	protected String policyEffectiveDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date the insurance policy began.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("policyFromDate")
	protected String policyFromDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date to which the policy exists.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("policyToDate")
	protected String policyToDate;

	@ApiModelProperty(readOnly = true,
					  value = "The death benefit amount on a life insurance policy and annuity. "
							  + "It is usually equal to the face amount of the policy, but sometimes can vary for a whole life and universal life insurance policies."
							  + "<br><b>Note:</b> The death benefit amount field is applicable only to annuities and life insurance.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("deathBenefit")
	protected Money deathBenefit;

	@ApiModelProperty(readOnly = true,
					  value = "The duration for which the policy is valid or in effect. For example, one year, five years, etc.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("policyTerm")
	protected String policyTerm;

	@ApiModelProperty(readOnly = true,
					  value = "The status of the policy.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("policyStatus")
	protected PolicyStatus policyStatus;

	@ApiModelProperty(readOnly = true,
					  value = "The annual percentage rate (APR) is the yearly rate of interest on the credit card account.<br>"
							  + "<b>Additional Details:</b> The yearly percentage rate charged when a balance is held on a credit card. This rate of interest is applied every month on the outstanding credit card balance.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("apr")
	protected Double apr;

	@ApiModelProperty(value = "Annual percentage rate applied to cash withdrawals on the card.<br><br>"//
			+ "<b>Account Type</b>: Aggregated<br>"//
			+ "<b>Applicable containers</b>: creditCard<br>"//
			+ "<b>Endpoints</b>:"//
			+ "<ul><li>GET accounts</li>"//
			+ "<li>GET accounts/{accountId}</li>"//
			+ "<li>GET dataExtracts/userData</li>"//
			+ "</ul>")
	@JsonProperty("cashApr")
	protected Double cashApr;

	@ApiModelProperty(readOnly = true,
					  value = "The amount that is available for an ATM withdrawal, i.e., the cash available after deducting the amount that is already withdrawn from the total cash limit. (totalCashLimit-cashAdvance= availableCash)"
							  + "<br><b>Additional Details:</b> The available cash amount at the account-level can differ from the available cash at the statement-level, as the information in the aggregated card account data provides more up-to-date information.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("availableCash")
	protected Money availableCash;

	@ApiModelProperty(readOnly = true,
					  value = "<br><b>Credit Card:</b> Amount that is available to spend on the credit card. It is usually "
							  + "the Total credit line- Running balance- pending charges. "
							  + "<br><b>Loan:</b> The unused portion of  line of credit, on a revolving loan (such as a home-equity line of credit)."
							  + "<br><b>Additional Details:</b>"
							  + "<br><b>Note:</b> The available credit amount at the account-level can differ from the available credit "
							  + "field at the statement-level, as the information in the aggregated card account data provides more up-to-date information.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("availableCredit")
	protected Money availableCredit;

	@ApiModelProperty(readOnly = true,
					  value = "The amount that is available for immediate withdrawal or the total amount available to purchase securities in a brokerage or investment account."
							  + "<br><b>Note:</b> The cash balance field is only applicable to brokerage related accounts.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("cash")
	protected Money cash;

	@ApiModelProperty(readOnly = true,
					  value = "The amount of cash value available in the consumer's life insurance policy account - except for term "
							  + "insurance policy - for withdrawals, loans, etc. This field is also used to capture the cash value on the home "
							  + "insurance policy.It is the standard that the insurance company generally prefer to reimburse the policyholder for "
							  + "his or her loss, i.e., the cash value is equal to the replacement cost minus depreciation. The cash value is also "
							  + "referred to as surrender value in India for life insurance policies."
							  + "<br><b>Note:</b> The cash value field is applicable to all types of life insurance (except for term life) and home insurance.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("cashValue")
	protected Money cashValue;

	@ApiModelProperty(readOnly = true,
					  value = "The classification of the account such as personal, corporate, etc.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, creditCard, investment, reward, loan, insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("classification")
	protected AccountClassification classification;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the insurance policy expires or matures."
							  + "<br><b>Additional Details:</b> The due date at the account-level can differ from the due date field at the "
							  + "statement-level, as the information in the aggregated card account data provides "
							  + "an up-to-date information to the consumer.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("expirationDate")
	protected String expirationDate;

	@ApiModelProperty(readOnly = true,
					  value = "The amount stated on the face of a consumer's policy that will be paid "
							  + "in the event of his or her death or any other event as stated in the insurance policy. "
							  + "The face amount is also referred to as the sum insured or maturity value in India."
							  + "<br><b>Note:</b> The face amount field is applicable only to life insurance.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("faceAmount")
	protected Money faceAmount;

	@ApiModelProperty(readOnly = true,
					  value = "<br><b>Bank:</b> The interest rate offered by a FI to its depositors on a bank account."
							  + "<br><b>Loan:</b> Interest rate applied on the loan." + "<br><b>Additional Details:</b>"
							  + "<br><b>Note:</b> The Interest Rate field is only applicable for the following account types: savings, checking, money market, and certificate of deposit.<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("interestRate")
	protected Double interestRate;

	@ApiModelProperty(readOnly = true,
					  value = "The last payment made for the account."//
							  + "<br><b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bill<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("lastPayment")
	protected Money lastPayment;

	@ApiModelProperty(readOnly = true,
					  value = "Last/Previous payment amount on the account.  Portion of the principal "
							  + "and interest paid on previous month or period to satisfy a loan."
							  + "<br><b>Additional Details:</b> If the payment is already done for the current billing cycle, then the "
							  + "field indicates the payment of the current billing cycle. "
							  + "If payment is yet to be done for the current billing cycle, then the "
							  + "field indicates the payment that was made for any of the previous billing cycles.<br>"
							  + "<br><b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance, bill<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("lastPaymentAmount")
	protected Money lastPaymentAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the payment for the previous or current billing cycle is done."
							  + "<br><b>Additional Details:</b> If the payment is already done for the current billing cycle, "
							  + "then the field indicates the payment date of the current billing cycle. "
							  + "If payment is yet to be done for the current billing cycle, then the field "
							  + "indicates the date on which the payment was made for any of the previous billing cycles. "
							  + "The last payment date at the account-level can differ from the last payment date at the "
							  + "statement-level, as the information in the aggregated card account data provides an "
							  + "up-to-date information to the consumer.<br>"//
							  + "<br><b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance, bill<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("lastPaymentDate")
	protected String lastPaymentDate;

	@ApiModelProperty(readOnly = true,
					  value = "The date time the account information was last retrieved from the provider site and updated in the Yodlee system.<br>"//
							  + "<br><b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul><li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("lastUpdated")
	protected String lastUpdated;

	@ApiModelProperty(readOnly = true,
					  value = "The amount of borrowed funds used to purchase securities."
							  + "<br><b>Note</b>: Margin balance is displayed only if the brokerage account is approved for margin. "
							  + "The margin balance field is only applicable to brokerage related accounts."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("marginBalance")
	protected Money marginBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The maturity amount on the CD is the amount(principal and interest) paid on or after the maturity date."
							  + "<br><b>Additional Details:</b> The Maturity Amount field is only applicable for the account type CD(Fixed Deposits)."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("maturityAmount")
	protected Money maturityAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The date when a certificate of deposit (CD/FD) matures or the final payment date of a loan "
							  + "at which point the principal amount (including pending interest) is due to be paid."
							  + "<br><b>Additional Details:</b> The date when a certificate of deposit (CD) matures, i.e., the money in the "
							  + "CD can be withdrawn without paying an early withdrawal penalty."
							  + "The final payment date of a loan, i.e., the principal amount (including pending interest) is due to be paid."
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("maturityDate")
	protected String maturityDate;

	@ApiModelProperty(readOnly = true,
					  value = "The amount in the money market fund or its equivalent such as bank deposit programs."
							  + "<br><b>Note:</b> The money market balance field is only applicable to brokerage related accounts."
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("moneyMarketBalance")
	protected Money moneyMarketBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The nickname of the account as provided by the consumer to identify an account. "
							  + "The account nickname can be used instead of the account name." + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("nickname")
	protected String nickname;

	@ApiModelProperty(readOnly = true,
					  value = "The amount that is currently owed on the credit card account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("runningBalance")
	protected Money runningBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The maximum amount that can be withdrawn from an ATM using the credit card. "
							  + "Credit cards issuer allow cardholders to withdraw cash using their cards - the cash limit is a percent of the overall credit limit."
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("totalCashLimit")
	protected Money totalCashLimit;

	@ApiModelProperty(readOnly = true,
					  value = "Total credit line is the amount of money that can be charged to a credit card. "
							  + "If credit limit of $5,000 is issued on a credit card, the total charges on the card cannot exceed this amount."
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("totalCreditLine")
	protected Money totalCreditLine;

	@ApiModelProperty(readOnly = true,
					  value = "The total unvested balance that appears in an investment account."
							  + "Such as the 401k account or the equity award account that includes employer provided funding. "//
							  + "<br><b>Note:</b> The amount the employer contributes is generally subject to vesting and remain "
							  + "unvested for a specific period of time or until fulfillment of certain conditions. "
							  + "The total unvested balance field is only applicable to the retirement related accounts "
							  + "such as 401k, equity awards, etc."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("totalUnvestedBalance")
	protected Money totalUnvestedBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The total vested balance that appears in an investment account. Such as the "
							  + "401k account or the equity award account that includes employer provided funding. "
							  + "<br><b>Note:</b> The amount an employee can claim after he or she leaves the organization. The total "
							  + "vested balance field is only applicable to the retirement related accounts such as 401k, equity awards, etc."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("totalVestedBalance")
	protected Money totalVestedBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The amount a mortgage company holds to pay a consumer's non-mortgage related expenses like insurance and property taxes. "
							  + "<br><b>Additional Details:</b>"//
							  + "<br><b>Note:</b> The escrow balance field is only applicable to the mortgage account type."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("escrowBalance")
	protected Money escrowBalance;

	@ApiModelProperty(readOnly = true,
					  value = "Type of home insurance, like -"//
							  + "<ul><li>HOME_OWNER</li>"//
							  + "<li>RENTAL</li>"//
							  + "<li>RENTER</li>"//
							  + "<li>etc..</li>"//
							  + "</ul>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("homeInsuranceType")
	protected HomeInsuranceType homeInsuranceType;

	@ApiModelProperty(readOnly = true,
					  value = "Type of life insurance."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("lifeInsuranceType")
	protected LifeInsuranceType lifeInsuranceType;

	@ApiModelProperty(readOnly = true,
					  value = "The amount of loan that the lender has provided."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("originalLoanAmount")
	protected Money originalLoanAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The principal or loan balance is the outstanding balance on a loan account, excluding the interest and fees. "
							  + "The principal balance is the original borrowed amount plus any applicable loan fees, minus any principal payments."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("principalBalance")
	protected Money principalBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The number of years for which premium payments have to be made in a policy."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("premiumPaymentTerm")
	protected String premiumPaymentTerm;

	@ApiModelProperty(readOnly = true,
					  value = "The monthly or periodic payment on a loan that is recurring in nature. The recurring payment "
							  + "amount is usually same as the amount due, unless late fees or other charges are added eventually "
							  + "changing the amount due for a particular month."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("recurringPayment")
	protected Money recurringPayment;

	@ApiModelProperty(readOnly = true,
					  value = "The tenure for which the CD account is valid  or in case of loan, the number"
							  + " of years/months over which the loan amount  has to be repaid. "//
							  + "<br><b>Additional Details:</b><br>  "
							  + "Bank: The Term field is only applicable for the account type CD."
							  + "Loan: The period for which the loan agreement is in force. The period, before or at the "
							  + "end of which, the loan should either be repaid or renegotiated for another term."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("term")
	protected String term;

	@ApiModelProperty(readOnly = true,
					  value = "The maximum amount of credit a financial institution extends to a consumer "
							  + "through a line of credit or a revolving loan like HELOC. "//
							  + "<br><b>Additional Details:</b>"//
							  + "<br><b>Note:</b> The credit limit field is applicable only to LOC and HELOC account types."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("totalCreditLimit")
	protected Money totalCreditLimit;

	@ApiModelProperty(readOnly = true,
					  value = "Date on which the user is enrolled on the rewards program."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("enrollmentDate")
	protected String enrollmentDate;

	@ApiModelProperty(readOnly = true,
					  value = "Primary reward unit for this reward program. E.g. miles, points, etc."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("primaryRewardUnit")
	protected String primaryRewardUnit;

	@ApiModelProperty(readOnly = true,
					  value = "Current level of the reward program the user is associated with. E.g. Silver, Jade etc."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("currentLevel")
	protected String currentLevel;

	@ApiModelProperty(readOnly = true,
					  value = "The eligible next level of the rewards program."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("nextLevel")
	protected String nextLevel;

	@ApiModelProperty(readOnly = true,
					  value = "The sum of the current market values of short positions held in a brokerage account."
							  + "<br><b>Note:</b> The short balance balance field is only applicable to brokerage related accounts."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("shortBalance")
	protected Money shortBalance;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the last amount contributed by the employee to the 401k account."
							  + "<br><b>Note:</b> The last employee contribution amount field is derived from the transaction"
							  + " data and not aggregated from the FI site. The field is only applicable to the 401k account type."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("lastEmployeeContributionAmount")
	protected Money lastEmployeeContributionAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the last employee contribution was made to the 401k account."
							  + "<br><b>Note:</b> The last employee contribution date field is derived from the transaction data "
							  + "and not aggregated from the FI site. The field is only applicable to the 401k account type."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("lastEmployeeContributionDate")
	protected String lastEmployeeContributionDate;

	@ApiModelProperty(readOnly = true,
					  value = "The additional description or notes given by the user."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("memo")
	protected String memo;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the loan is disbursed."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("originationDate")
	protected String originationDate;

	@ApiModelProperty(readOnly = true,
					  value = "The overdraft limit for the account."
							  + "<br><b>Note:</b> The overdraft limit is provided only for AUS, INDIA, UK, NZ locales."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("overDraftLimit")
	protected Money overDraftLimit;

	@ApiModelProperty(readOnly = true,
					  value = "The valuation type indicates whether the home value is calculated either manually or by Yodlee Partners."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Manual<br>"//
							  + "<b>Applicable containers</b>: realEstate<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("valuationType")
	protected ValuationType valuationType;

	@ApiModelProperty(readOnly = true,
					  value = "The home value of the real estate account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Manual<br>"//
							  + "<b>Applicable containers</b>: realEstate<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("homeValue")
	protected Money homeValue;

	@ApiModelProperty(readOnly = true,
					  value = "The date on which the home value was estimated."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Manual<br>"//
							  + "<b>Applicable containers</b>: realEstate<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("estimatedDate")
	protected String estimatedDate;

	@ApiModelProperty(readOnly = true,
					  value = "The home address of the real estate account. The address entity for home address consists of state, zip and city only"//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Manual<br>"//
							  + "<b>Applicable containers</b>: realEstate<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("address")
	protected AccountAddress address;

	@ApiModelProperty(readOnly = true,
					  value = "The amount to be paid to close the loan account, i.e., the total amount "
							  + "required to meet a borrower's obligation on a loan."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("loanPayoffAmount")
	protected Money loanPayoffAmount;

	@ApiModelProperty(readOnly = true,
					  value = "The date by which the payoff amount should be paid."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("loanPayByDate")
	protected String loanPayByDate;

	@ApiModelProperty(readOnly = true,
					  value = "Bank and branch identification information.<br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: bank, investment, loan<br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
	)
	@JsonProperty("bankTransferCode")
	protected List<BankTransferCode> bankTransferCode;

	@ApiModelProperty(readOnly = true,
					  value = "Information of different reward balances associated with the account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: reward<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("rewardBalance")
	protected List<RewardBalance> rewardBalance;

	@ApiModelProperty(readOnly = true,
					  value = "The frequency of the billing cycle of the account in case of card "
							  + "and bills. The frequency in which premiums are paid in an "
							  + "insurance policy such as monthly, quarterly, and annually. "
							  + "The frequency in which due amounts are paid in a loan  account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, insurance, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values</b><br>"//
	)
	@JsonProperty("frequency")
	protected FrequencyType frequency;

	@ApiModelProperty(readOnly = true,
					  value = "The amount due to be paid for the account.<br>"//
							  + "<b>Additional Details:</b>"
							  + "<b>Credit Card:</b> The total amount due for the purchase of goods or services that must be paid by the due date.<br>"
							  + "<b>Loan:</b> The amount due to be paid on the due date.<br>"
							  + "<b>Note:</b> The amount due at the account-level can differ from the amount due at the statement-level, as the information in the aggregated card account data provides more up-to-date information.<br>"//
							  + "<b>Applicable containers</b>: creditCard, loan, insurance, bill<br>"//
							  + "<b>Aggregated / Manual</b>: Both <br>"//
							  + "<b>Endpoints</b>:<br>"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("amountDue")
	protected Money amountDue;

	@ApiModelProperty(readOnly = true,
					  value = "The minimum amount due is the lowest amount of money that a consumer is required to pay each month."
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: creditCard, insurance, bill, loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("minimumAmountDue")
	protected Money minimumAmountDue;

	@ApiModelProperty(readOnly = true,
					  value = "Logical grouping of dataset attributes into datasets such as Basic Aggregation Data, Account Profile and Documents."
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: All containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("dataset")
	protected List<AccountDataset> datasets;

	////
	@ApiModelProperty(readOnly = true,
					  value = "The providerAccountIds that share the account with the primary providerAccountId that was created when the user had added the account for the first time."//
							  + "<br><b>Additional Details</b>: This attribute is returned in the response only if the account deduplication feature is enabled and the same account is mapped to more than one provider account IDs indicating the account is owned by more than one user, for example, joint accounts."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: All Containers<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("associatedProviderAccountId")
	protected List<Long> associatedProviderAccountIds;

	@ApiModelProperty(readOnly = true,
					  value = "The loan payoff details such as date by which the payoff amount should be paid, loan payoff amount, and the outstanding balance on the loan account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("loanPayoffDetails")
	protected LoanPayoffDetails loanPayOffDetails;

	@ApiModelProperty(readOnly = true,
					  value = "The coverage-related details of the account."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: insurance,investment<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("coverage")
	protected List<Coverage> coverage;

	@ApiModelProperty(readOnly = true,
					  value = "Indicates the status of the loan account. "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values:</b><br>")
	@JsonProperty("sourceAccountStatus")
	protected SourceAccountStatus sourceAccountStatus;

	@ApiModelProperty(readOnly = true,
					  value = "The type of repayment plan that the borrower prefers to repay the loan. "//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>"//
							  + "<b>Applicable Values:</b><br>")
	@JsonProperty("repaymentPlanType")
	protected LoanRepaymentPlanType repaymentPlanType;

	@ApiModelProperty(readOnly = true,
					  value = "A nonprofit or state organization that works with lender, servicer, school, and the Department of Education to help successfully repay Federal Family Education Loan Program (FFELP) loans. If FFELP student loans default, the guarantor takes ownership of them."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("guarantor")
	protected String guarantor;

	@ApiModelProperty(readOnly = true,
					  value = "The financial institution that provides the loan."//
							  + "<br><br>"//
							  + "<b>Aggregated / Manual</b>: Aggregated<br>"//
							  + "<b>Applicable containers</b>: loan<br>"//
							  + "<b>Endpoints</b>:"//
							  + "<ul>"//
							  + "<li>GET accounts</li>"//
							  + "<li>GET accounts/{accountId}</li>"//
							  + "<li>GET dataExtracts/userData</li>"//
							  + "</ul>")
	@JsonProperty("lender")
	protected String lender;

	/**
	 * The loan payoff details such as date by which the payoff amount should be paid, loan payoff amount, and the
	 * outstanding balance on the loan account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return loanPayOffDetails
	 */
	@JsonProperty("loanPayoffDetails")
	public LoanPayoffDetails getLoanPayOffDetails() {
		return loanPayOffDetails;
	}

	/**
	 * The providerAccountIds that share the account with the primary providerAccountId that was created when the user
	 * had added the account for the first time. <br>
	 * <b>Additional Details</b>: This attribute is returned in the response only if the account deduplication feature
	 * is enabled and the same account is mapped to more than one provider account IDs indicating the account is owned
	 * by more than one user, for example, joint accounts. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: All Containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return associatedProviderAccountId
	 */
	@JsonProperty("associatedProviderAccountId")
	public List<Long> getAssociatedProviderAccountId() {
		return associatedProviderAccountIds == null ? null : Collections.unmodifiableList(associatedProviderAccountIds);
	}

	/**
	 * The date on which the due amount has to be paid. * <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Credit Card:</b> The monthly date by when the minimum payment is due to be paid on the credit card account.
	 * <br>
	 * <b>Loan:</b> The date on or before which the due amount should be paid. <br>
	 * <b>Note:</b> The due date at the account-level can differ from the due date field at the statement-level, as the
	 * information in the aggregated card account data provides an up-to-date information to the consumer. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance, bill<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return dueDate
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * The frequency of the billing cycle of the account in case of card and bills. The frequency in which premiums are
	 * paid in an insurance policy such as monthly, quarterly, and annually. The frequency in which due amounts are paid
	 * in a loan account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: bill, creditCard, insurance, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return frequency
	 */
	public FrequencyType getFrequency() {
		return frequency;
	}

	/**
	 * The amount due to be paid for the account.<br>
	 * <b>Additional Details:</b> <b>Credit Card:</b> The total amount due for the purchase of goods or services that
	 * must be paid by the due date.<br>
	 * <b>Loan:</b> The amount due to be paid on the due date.<br>
	 * <b>Note:</b> The amount due at the account-level can differ from the amount due at the statement-level, as the
	 * information in the aggregated card account data provides more up-to-date information.<br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance, bill<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return amountDue
	 */
	public Money getAmountDue() {
		return amountDue;
	}

	/**
	 * The minimum amount due is the lowest amount of money that a consumer is required to pay each month. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard, insurance, bill, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return minimumAmountDue
	 */
	public Money getMinimumAmountDue() {
		return minimumAmountDue;
	}

	/**
	 * The type of service. E.g., Bank, Credit Card, Investment, Insurance, etc.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return CONTAINER
	 */
	@JsonProperty("CONTAINER")
	public Container getContainer() {
		return container;
	}

	/**
	 * The primary key of the provider account resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return providerAccountId
	 */
	public Long getProviderAccountId() {
		return providerAccountId;
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

	/**
	 * The account number as it appears on the site. (The POST accounts service response return this field as
	 * number)<br>
	 * <b>Additional Details</b>:<b> Bank/ Loan/ Insurance/ Investment/Bill</b>:<br>
	 * The account number for the bank account as it appears at the site.<br>
	 * <b>Credit Card</b>: The account number of the card account as it appears at the site,<br>
	 * i.e., the card number.The account number can be full or partial based on how it is displayed in the account
	 * summary page of the site. In most cases, the site does not display the full account number in the account summary
	 * page and additional navigation is required to aggregate it.<br>
	 * <b>Applicable containers</b>: All Containers<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>POST accounts</li>
	 * </ul>
	 * 
	 * @return accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * The source through which the account(s) are added in the system.<br>
	 * <b>Valid Values</b>: SYSTEM, USER<br>
	 * <b>Applicable containers</b>: All Containers<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return aggregationSource
	 */
	public AggregationSource getAggregationSource() {
		return aggregationSource;
	}

	/**
	 * The account to be considered as an asset or liability.<br>
	 * <b>Applicable containers</b>: All Containers<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return isAsset
	 */
	public Boolean getIsAsset() {
		return isAsset;
	}

	/**
	 * The total account value. * <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Bank:</b> available balance or current balance. <br>
	 * <b>Credit Card:</b> running Balance. <br>
	 * <b>Investment:</b> The total balance of all the investment account, as it appears on the FI site. <br>
	 * <b>Insurance:</b> CashValue or amountDue * <br>
	 * <b>Loan:</b> principalBalance <br>
	 * <b>Bill:</b> amountDue<br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, loan, bill, otherAssets, otherLiabilities,
	 * realEstate<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return balance
	 */
	public Money getBalance() {
		return balance;
	}

	/**
	 * The primary key of the account resource and the unique identifier for the account.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET investmentOptions</li>
	 * <li>GET accounts/historicalBalances</li>
	 * <li>POST accounts
	 * </ul>
	 * 
	 * @return id
	 */
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
	 *
	 * <b>Applicable containers</b>: reward, bank, creditCard, investment, loan, insurance, realEstate, bill,
	 * otherLiabilities<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>POST accounts
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return userClassification
	 */
	public UserClassification getUserClassification() {
		return userClassification;
	}

	/**
	 * Used to determine whether an account to be considered in the networth calculation. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>:
	 * bank,creditCard,loan,investment,insurance,realEstate,otherAssets,otherLiabilities<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return includeInNetWorth
	 */
	public Boolean getIncludeInNetWorth() {
		return includeInNetWorth;
	}

	/**
	 * Service provider or institution name where the account originates. This belongs to the provider resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return providerName
	 */
	public String getProviderName() {
		return providerName;
	}

	/**
	 * Identifier of the provider site. The primary key of provider resource. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * Indicates if an account is aggregated from a site or it is a manual account i.e. account information manually
	 * provided by the user.<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return isManual
	 */
	public boolean getIsManual() {
		return isManual;
	}

	/**
	 * The balance in the account that is available for spending. For checking accounts with overdraft, available
	 * balance may include overdraft amount, if end site adds overdraft balance to available balance.<br>
	 * <b>Applicable containers</b>: bank, investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * GET accounts/{accountId}
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
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return currentBalance
	 */
	public Money getCurrentBalance() {
		return currentBalance;
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
	 * <b>bill</b>
	 * <ul>
	 * <li>TELEPHONE</li>
	 * <li>UTILITY</li>
	 * <li>CABLE</li>
	 * <li>WIRELESS</li>
	 * <li>BILLS</li>
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
	 * <b>bill</b>
	 * <ul>
	 * <li>BILLS</li>
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
	 * The name or identification of the account owner, as it appears at the FI site. <br>
	 * <b>Note:</b> The account holder name can be full or partial based on how it is displayed in the account summary
	 * page of the FI site. In most cases, the FI site does not display the full account holder name in the account
	 * summary page. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, insurance, loan, bill, reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return displayedName
	 */
	public String getDisplayedName() {
		return displayedName;
	}

	/**
	 * The date on which the account is created in the Yodlee system. <br>
	 * <b>Additional Details:</b> It is the date when the user links or aggregates the account(s) that are held with the
	 * provider to the Yodlee system. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * Logical grouping of dataset attributes into datasets such as Basic Aggregation Data, Account Profile and
	 * Documents. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return dataset
	 */
	@JsonProperty("dataset")
	public List<AccountDataset> getDatasets() {
		return datasets == null ? null : Collections.unmodifiableList(datasets);
	}

	/**
	 * The amount borrowed from the 401k account.<br>
	 * <b>Note</b>: The 401k loan field is only applicable to the 401k account type.<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return 401kLoan
	 */
	@JsonProperty("401kLoan")
	public Money getLoan401k() {
		return loan401k;
	}

	/**
	 * Indicates the contract value of the annuity.<br>
	 * <b>Note:</b> The annuity balance field is applicable only to annuities.<br>
	 * <b>Applicable containers</b>: insurance, investment<br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return annuityBalance
	 */
	public Money getAnnuityBalance() {
		return annuityBalance;
	}

	/**
	 * Interest paid from the start of the year to date.<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return interestPaidYTD
	 */
	public Money getInterestPaidYTD() {
		return interestPaidYTD;
	}

	/**
	 * Interest paid in last calendar year.<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return interestPaidLastYear
	 */
	public Money getInterestPaidLastYear() {
		return interestPaidLastYear;
	}

	/**
	 * The type of the interest rate, for example, fixed or variable.<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return interestRateType
	 */
	public LoanInterestRateType getInterestRateType() {
		return interestRateType;
	}

	/**
	 * Property or possession offered to support a loan that can be seized on a default.<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return collateral
	 */
	public String getCollateral() {
		return collateral;
	}

	/**
	 * Annual percentage yield (APY) is a normalized representation of an interest rate, based on a compounding period
	 * of one year. APY generally refers to the rate paid to a depositor by a financial institution on an account.<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return annualPercentageYield
	 */
	public Double getAnnualPercentageYield() {
		return annualPercentageYield;
	}

	/**
	 * The financial cost that the policyholder pays to the insurance company to obtain an insurance cover. The premium
	 * is paid as a lump sum or in installments during the duration of the policy.<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return premium
	 */
	public Money getPremium() {
		return premium;
	}

	/**
	 * The sum of the future payments due to be paid to the insurance company during a policy year. It is the policy
	 * rate minus the payments made till date. <br>
	 * <b>Note:</b> The remaining balance field is applicable only to auto insurance and home insurance.<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return remainingBalance
	 */
	public Money getRemainingBalance() {
		return remainingBalance;
	}

	/**
	 * The date on which the insurance policy coverage commences.<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return policyEffectiveDate
	 */
	public String getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}

	/**
	 * The date the insurance policy began.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return policyFromDate
	 */
	public String getPolicyFromDate() {
		return policyFromDate;
	}

	/**
	 * The date to which the policy exists.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return policyToDate
	 */
	public String getPolicyToDate() {
		return policyToDate;
	}

	/**
	 * The death benefit amount on a life insurance policy and annuity. It is usually equal to the face amount of the
	 * policy, but sometimes can vary for a whole life and universal life insurance policies. <br>
	 * <b>Note:</b> The death benefit amount field is applicable only to annuities and life insurance.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return deathBenefit
	 */
	public Money getDeathBenefit() {
		return deathBenefit;
	}

	/**
	 * The duration for which the policy is valid or in effect. For example, one year, five years, etc.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return policyTerm
	 */
	public String getPolicyTerm() {
		return policyTerm;
	}

	/**
	 * The status of the policy.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return policyStatus
	 */
	public PolicyStatus getPolicyStatus() {
		return policyStatus;
	}

	/**
	 * The annual percentage rate (APR) is the yearly rate of interest on the credit card account.<br>
	 * <b>Additional Details:</b> The yearly percentage rate charged when a balance is held on a credit card. This rate
	 * of interest is applied every month on the outstanding credit card balance.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return apr
	 */
	public Double getApr() {
		return apr;
	}

	/**
	 * Annual percentage rate applied to cash withdrawals on the card.<br>
	 * <br>
	 * <b>Account Type</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * <li>GET dataExtracts/userData</li>
	 * </ul>
	 * 
	 * @return cashApr
	 */
	public Double getCashApr() {
		return cashApr;
	}

	/**
	 * The amount that is available for an ATM withdrawal, i.e., the cash available after deducting the amount that is
	 * already withdrawn from the total cash limit. (totalCashLimit-cashAdvance= availableCash) <br>
	 * <b>Additional Details:</b> The available cash amount at the account-level can differ from the available cash at
	 * the statement-level, as the information in the aggregated card account data provides more up-to-date
	 * information.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return availableCash
	 */
	public Money getAvailableCash() {
		return availableCash;
	}

	/**
	 * <br>
	 * <b>Credit Card:</b> Amount that is available to spend on the credit card. It is usually the Total credit line-
	 * Running balance- pending charges. <br>
	 * <b>Loan:</b> The unused portion of line of credit, on a revolving loan (such as a home-equity line of credit).
	 * <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Note:</b> The available credit amount at the account-level can differ from the available credit field at the
	 * statement-level, as the information in the aggregated card account data provides more up-to-date information.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return availableCredit
	 */
	public Money getAvailableCredit() {
		return availableCredit;
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
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return cash
	 */
	public Money getCash() {
		return cash;
	}

	/**
	 * The amount of cash value available in the consumer's life insurance policy account - except for term insurance
	 * policy - for withdrawals, loans, etc. This field is also used to capture the cash value on the home insurance
	 * policy.It is the standard that the insurance company generally prefer to reimburse the policyholder for his or
	 * her loss, i.e., the cash value is equal to the replacement cost minus depreciation. The cash value is also
	 * referred to as surrender value in India for life insurance policies. <br>
	 * <b>Note:</b> The cash value field is applicable to all types of life insurance (except for term life) and home
	 * insurance.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return cashValue
	 */
	public Money getCashValue() {
		return cashValue;
	}

	/**
	 * The classification of the account such as personal, corporate, etc.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, creditCard, investment, reward, loan, insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return classification
	 */
	public AccountClassification getClassification() {
		return classification;
	}

	/**
	 * The date on which the insurance policy expires or matures. <br>
	 * <b>Additional Details:</b> The due date at the account-level can differ from the due date field at the
	 * statement-level, as the information in the aggregated card account data provides an up-to-date information to the
	 * consumer.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return expirationDate
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * The amount stated on the face of a consumer's policy that will be paid in the event of his or her death or any
	 * other event as stated in the insurance policy. The face amount is also referred to as the sum insured or maturity
	 * value in India. <br>
	 * <b>Note:</b> The face amount field is applicable only to life insurance.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return faceAmount
	 */
	public Money getFaceAmount() {
		return faceAmount;
	}

	/**
	 * <br>
	 * <b>Bank:</b> The interest rate offered by a FI to its depositors on a bank account. <br>
	 * <b>Loan:</b> Interest rate applied on the loan. * <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Note:</b> The Interest Rate field is only applicable for the following account types: savings, checking, money
	 * market, and certificate of deposit.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return interestRate
	 */
	public Double getInterestRate() {
		return interestRate;
	}

	/**
	 * Last/Previous payment amount on the account. Portion of the principal and interest paid on previous month or
	 * period to satisfy a loan. <br>
	 * <b>Additional Details:</b> If the payment is already done for the current billing cycle, then the field indicates
	 * the payment of the current billing cycle. If payment is yet to be done for the current billing cycle, then the
	 * field indicates the payment that was made for any of the previous billing cycles.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance, bill<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lastPaymentAmount
	 */
	public Money getLastPaymentAmount() {
		return lastPaymentAmount;
	}

	/**
	 * The date on which the payment for the previous or current billing cycle is done. <br>
	 * <b>Additional Details:</b> If the payment is already done for the current billing cycle, then the field indicates
	 * the payment date of the current billing cycle. If payment is yet to be done for the current billing cycle, then
	 * the field indicates the date on which the payment was made for any of the previous billing cycles. The last
	 * payment date at the account-level can differ from the last payment date at the statement-level, as the
	 * information in the aggregated card account data provides an up-to-date information to the consumer.<br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard, loan, insurance, bill<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lastPaymentDate
	 */
	public String getLastPaymentDate() {
		return lastPaymentDate;
	}

	/**
	 * The amount of borrowed funds used to purchase securities. <br>
	 * <b>Note</b>: Margin balance is displayed only if the brokerage account is approved for margin. The margin balance
	 * field is only applicable to brokerage related accounts. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return marginBalance
	 */
	public Money getMarginBalance() {
		return marginBalance;
	}

	/**
	 * The maturity amount on the CD is the amount(principal and interest) paid on or after the maturity date. <br>
	 * <b>Additional Details:</b> The Maturity Amount field is only applicable for the account type CD(Fixed Deposits).
	 * <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return maturityAmount
	 */
	public Money getMaturityAmount() {
		return maturityAmount;
	}

	/**
	 * The date when a certificate of deposit (CD/FD) matures or the final payment date of a loan at which point the
	 * principal amount (including pending interest) is due to be paid. <br>
	 * <b>Additional Details:</b> The date when a certificate of deposit (CD) matures, i.e., the money in the CD can be
	 * withdrawn without paying an early withdrawal penalty. The final payment date of a loan, i.e., the principal
	 * amount (including pending interest) is due to be paid. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return maturityDate
	 */
	public String getMaturityDate() {
		return maturityDate;
	}

	/**
	 * The amount in the money market fund or its equivalent such as bank deposit programs. <br>
	 * <b>Note:</b> The money market balance field is only applicable to brokerage related accounts. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return moneyMarketBalance
	 */
	public Money getMoneyMarketBalance() {
		return moneyMarketBalance;
	}

	/**
	 * The nickname of the account as provided by the consumer to identify an account. The account nickname can be used
	 * instead of the account name. * <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * The amount that is currently owed on the credit card account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return runningBalance
	 */
	public Money getRunningBalance() {
		return runningBalance;
	}

	/**
	 * The maximum amount that can be withdrawn from an ATM using the credit card. Credit cards issuer allow cardholders
	 * to withdraw cash using their cards - the cash limit is a percent of the overall credit limit. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return totalCashLimit
	 */
	public Money getTotalCashLimit() {
		return totalCashLimit;
	}

	/**
	 * Total credit line is the amount of money that can be charged to a credit card. If credit limit of $5,000 is
	 * issued on a credit card, the total charges on the card cannot exceed this amount. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: creditCard<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return totalCreditLine
	 */
	public Money getTotalCreditLine() {
		return totalCreditLine;
	}

	/**
	 * The total unvested balance that appears in an investment account. Such as the 401k account or the equity award
	 * account that includes employer provided funding. <br>
	 * <b>Note:</b> The amount the employer contributes is generally subject to vesting and remain unvested for a
	 * specific period of time or until fulfillment of certain conditions. The total unvested balance field is only
	 * applicable to the retirement related accounts such as 401k, equity awards, etc. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return totalUnvestedBalance
	 */
	public Money getTotalUnvestedBalance() {
		return totalUnvestedBalance;
	}

	/**
	 * The total vested balance that appears in an investment account. Such as the 401k account or the equity award
	 * account that includes employer provided funding. <br>
	 * <b>Note:</b> The amount an employee can claim after he or she leaves the organization. The total vested balance
	 * field is only applicable to the retirement related accounts such as 401k, equity awards, etc. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return totalVestedBalance
	 */
	public Money getTotalVestedBalance() {
		return totalVestedBalance;
	}

	/**
	 * The amount a mortgage company holds to pay a consumer's non-mortgage related expenses like insurance and property
	 * taxes. <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Note:</b> The escrow balance field is only applicable to the mortgage account type. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return escrowBalance
	 */
	public Money getEscrowBalance() {
		return escrowBalance;
	}

	/**
	 * Type of home insurance, like -
	 * <ul>
	 * <li>HOME_OWNER</li>
	 * <li>RENTAL</li>
	 * <li>RENTER</li>
	 * <li>etc..</li>
	 * </ul>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return homeInsuranceType
	 */
	public HomeInsuranceType getHomeInsuranceType() {
		return homeInsuranceType;
	}

	/**
	 * Type of life insurance. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return lifeInsuranceType
	 */
	public LifeInsuranceType getLifeInsuranceType() {
		return lifeInsuranceType;
	}

	/**
	 * The amount of loan that the lender has provided. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return originalLoanAmount
	 */
	public Money getOriginalLoanAmount() {
		return originalLoanAmount;
	}

	/**
	 * The principal or loan balance is the outstanding balance on a loan account, excluding the interest and fees. The
	 * principal balance is the original borrowed amount plus any applicable loan fees, minus any principal payments.
	 * <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return principalBalance
	 */
	public Money getPrincipalBalance() {
		return principalBalance;
	}

	/**
	 * The number of years for which premium payments have to be made in a policy. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return premiumPaymentTerm
	 */
	public String getPremiumPaymentTerm() {
		return premiumPaymentTerm;
	}

	/**
	 * The monthly or periodic payment on a loan that is recurring in nature. The recurring payment amount is usually
	 * same as the amount due, unless late fees or other charges are added eventually changing the amount due for a
	 * particular month. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return recurringPayment
	 */
	public Money getRecurringPayment() {
		return recurringPayment;
	}

	/**
	 * The tenure for which the CD account is valid or in case of loan, the number of years/months over which the loan
	 * amount has to be repaid. <br>
	 * <b>Additional Details:</b><br>
	 * Bank: The Term field is only applicable for the account type CD. Loan: The period for which the loan agreement is
	 * in force. The period, before or at the end of which, the loan should either be repaid or renegotiated for another
	 * term. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * The maximum amount of credit a financial institution extends to a consumer through a line of credit or a
	 * revolving loan like HELOC. <br>
	 * <b>Additional Details:</b> <br>
	 * <b>Note:</b> The credit limit field is applicable only to LOC and HELOC account types. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return totalCreditLimit
	 */
	public Money getTotalCreditLimit() {
		return totalCreditLimit;
	}

	/**
	 * Date on which the user is enrolled on the rewards program. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return enrollmentDate
	 */
	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	/**
	 * Primary reward unit for this reward program. E.g. miles, points, etc. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return primaryRewardUnit
	 */
	public String getPrimaryRewardUnit() {
		return primaryRewardUnit;
	}

	/**
	 * Current level of the reward program the user is associated with. E.g. Silver, Jade etc. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return currentLevel
	 */
	public String getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * The eligible next level of the rewards program. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return nextLevel
	 */
	public String getNextLevel() {
		return nextLevel;
	}

	/**
	 * The sum of the current market values of short positions held in a brokerage account. <br>
	 * <b>Note:</b> The short balance balance field is only applicable to brokerage related accounts. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return shortBalance
	 */
	public Money getShortBalance() {
		return shortBalance;
	}

	/**
	 * Indicates the last amount contributed by the employee to the 401k account. <br>
	 * <b>Note:</b> The last employee contribution amount field is derived from the transaction data and not aggregated
	 * from the FI site. The field is only applicable to the 401k account type. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lastEmployeeContributionAmount
	 */
	public Money getLastEmployeeContributionAmount() {
		return lastEmployeeContributionAmount;
	}

	/**
	 * The date on which the last employee contribution was made to the 401k account. <br>
	 * <b>Note:</b> The last employee contribution date field is derived from the transaction data and not aggregated
	 * from the FI site. The field is only applicable to the 401k account type. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lastEmployeeContributionDate
	 */
	public String getLastEmployeeContributionDate() {
		return lastEmployeeContributionDate;
	}

	/**
	 * The additional description or notes given by the user. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: All containers<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * The date on which the loan is disbursed. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Both <br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return originationDate
	 */
	public String getOriginationDate() {
		return originationDate;
	}

	/**
	 * The overdraft Limit for the account. <br>
	 * <b>Note:</b> The overdraft Limit is provided only for AUS, INDIA, UK, NZ locales. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return overDraftLimit
	 */
	public Money getOverDraftLimit() {
		return overDraftLimit;
	}

	/**
	 * The valuation Type indicates whether the home value is calculated either manually or by Yodlee Partners. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Manual<br>
	 * <b>Applicable containers</b>: realEstate<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values</b><br>
	 * 
	 * @return valuationType
	 */
	public ValuationType getValuationType() {
		return valuationType;
	}

	/**
	 * The home value of the real estate account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Manual<br>
	 * <b>Applicable containers</b>: realEstate<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return homeValue
	 */
	public Money getHomeValue() {
		return homeValue;
	}

	/**
	 * The date on which the home value was estimated. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Manual<br>
	 * <b>Applicable containers</b>: realEstate<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return estimatedDate
	 */
	public String getEstimatedDate() {
		return estimatedDate;
	}

	/**
	 * The home address of the real estate account. The address entity for home address consists of state, zip and city
	 * only <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Manual<br>
	 * <b>Applicable containers</b>: realEstate<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return address
	 */
	public AccountAddress getAddress() {
		return address;
	}

	/**
	 * The amount to be paid to close the loan account, i.e., the total amount required to meet a borrower's obligation
	 * on a loan. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return loanPayoffAmount
	 */
	public Money getLoanPayoffAmount() {
		return loanPayoffAmount;
	}

	/**
	 * Bank and branch identification information.<br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bank, investment, loan<br>
	 * <b>Endpoints</b>:<br>
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return bankTransferCode
	 */
	@JsonProperty("bankTransferCode")
	public List<BankTransferCode> getBankTransferCode() {
		return bankTransferCode == null ? null : Collections.unmodifiableList(bankTransferCode);
	}

	/**
	 * Information of different reward balances associated with the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: reward<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return rewardBalance
	 */
	public List<RewardBalance> getRewardBalance() {
		return rewardBalance == null ? null : Collections.unmodifiableList(rewardBalance);
	}

	/**
	 * The date by which the payoff amount should be paid. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return loanPayByDate
	 */
	public String getLoanPayByDate() {
		return loanPayByDate;
	}

	/**
	 * The coverage-related details of the account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: insurance,investment<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return coverage
	 */
	public List<Coverage> getCoverage() {
		return coverage == null ? null : Collections.unmodifiableList(coverage);
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
	 * The last payment made for the account. <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: bill<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lastPayment
	 */
	public Money getLastPayment() {
		return lastPayment;
	}

	/**
	 * Indicates the status of the loan account. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values:</b><br>
	 * 
	 * @return sourceAccountStatus
	 */
	public SourceAccountStatus getSourceAccountStatus() {
		return sourceAccountStatus;
	}

	/**
	 * The type of repayment plan that the borrower prefers to repay the loan. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * <b>Applicable Values:</b><br>
	 * 
	 * @return repaymentPlanType
	 */
	public LoanRepaymentPlanType getRepaymentPlanType() {
		return repaymentPlanType;
	}

	/**
	 * A nonprofit or state organization that works with lender, servicer, school, and the Department of Education to
	 * help successfully repay Federal Family Education Loan Program (FFELP) loans. If FFELP student loans default, the
	 * guarantor takes ownership of them. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return guarantor
	 */
	public String getGuarantor() {
		return guarantor;
	}

	/**
	 * The financial institution that provides the loan. <br>
	 * <br>
	 * <b>Aggregated / Manual</b>: Aggregated<br>
	 * <b>Applicable containers</b>: loan<br>
	 * <b>Endpoints</b>:
	 * <ul>
	 * <li>GET accounts</li>
	 * <li>GET accounts/{accountId}</li>
	 * </ul>
	 * 
	 * @return lender
	 */
	public String getLender() {
		return lender;
	}
}
