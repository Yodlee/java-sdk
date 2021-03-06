/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.transaction.enums;

public enum MeerkatTxnSubType {
	AUTH_HOLD(1),
	AUTH_REQUEST(2),
	OVERDRAFT_CHARGE(3),
	CREDIT_ADJUSTMENT(4),
	PIN_DEBIT(5),
	BANK_DIRECT_DEPOSIT(6),
	DIVIDEND_DEPOSIT(7),
	INTEREST_SAVINGS(8),
	INTEREST_ADJUSTMENT(9),
	ONLINE_PURCHASE(10),
	PURCHASED_WITH_CHECK(11),
	RECURRING_BILLING(12),
	TAX_PAYMENT(13),
	PAYMENT_BY_CHECK(14),
	PAYMENT_PLAN(15),
	FEE_REFUND(16),
	WIRE_TRANSFER_CHARGE(17),
	ACCOUNT_TO_ACCOUNT_TRANSFER(18),
	BANK_TO_BANK_TRANSACTION(19),
	BANK_TO_NON_BANK_ACCOUNT_TRANSFER(20),
	CASH_WITHDRAWAL_AT_FI(21),
	ATM_CASH_WITHDRAWAL(22),
	AUTH_PROCESSING(23),
	AUTH_RELEASE(24),
	PRE_AUTH(25),
	AUTH_COMPLETE(26),
	AUTH_VOID(27),
	BALANCE_ENQUIRY(28),
	ACCOUNT_VERIFICATION(29),
	PRE_AUTH_COMPLETION(30),
	SERVICE_CHARGE(31),
	SERVICE_CHARGE_FEE_REFUND(32),
	RETURNED_CHECK_CHARGE(33),
	RETURNED_CHECK_REIMBURSEMENT(34),
	CASH_ADVANCE(35),
	BILL_PAY_CHARGE(36),
	CHECK_IMAGE_SERVICE_CHARGE(37),
	OVERDRAFT_PROTECTION_CHARGE(38),
	STOP_PAYMENT_CHARGE(39),
	CHECKS_ORDERING_CHARGE(40),
	MONTHLY_MAINTENANCE_CHARGE(41),
	DEBIT_CARD_FEE(42),
	CONVENIENCE_FEE(43),
	PERSONAL_LOAN_CREDIT(44),
	CREDIT_CARD_CREDIT(45),
	AUTO_LOAN(46),
	HOME_LOAN_MORTGAGE(47),
	SHORT_TERM_CREDIT(48),
	SIGNATURE_DEBIT(49),
	CONTACT_LESS_DEBIT(50),
	DEFERRED_DEPOSIT(51),
	DEFERRED_BILL_PAY(52),
	INSTALLMENT_PAYMENT(53),
	RECURRING_SUBSCRIPTION_PAYMENT(54),
	HOLD_CHECK_PAYMENT(55),
	CAPITAL_GAINS_DISTIBUTION(56),
	CG_LONG_TERM_DEPOSIT(57),
	OPEN_SALE_DEPOSIT(58),
	INTEREST__CHECK(59),
	PURCHASE_VOID(60),
	PURCHASE_WITH_CREDIT_CARD(61),
	PURCHASE_WITH_DEBIT_CARD(62),
	CHARGE_A_REPEAT_CUSTOMER(63),
	DOWN_PAYMENT_OR_ANNUITY_PAYMENT_OR_DIRECT_PAYMENT(64),
	FEE_PAYMENT(65),
	FINANCE_CHARGE_REFUND(66),
	TRANSACTION_VOID(67),
	FEE_VOID(68),
	DEBIT_CARD_WITHDRAWAL_AT_STORE(69),
	ELECTRONIC_PAYMENT(71),
	ACH_DEBIT(72),
	ATM_TELLER_DEPOSIT(73),
	POS_DEBIT(74),
	BANK_ADJUSTMENT(75),
	CHARGES_FEES(77),
	INTEREST(78),
	DEPOSITS_CREDITS(79),
	PAYMENT(80),
	PURCHASE(81),
	REFUND(82),
	TRANSFER(83),
	WITHDRAWAL(84),
	OTHER_DEPOSITS(85),
	OTHER_WITHDRAWALS(86),
	ADJUSTMENT(87),
	FINANCE_CHARGE(88),
	OTHER_CHARGES_FEES(90),
	ANNUAL_FEE(91),
	DEPOSIT(92),
	DIRECT_DEPOSIT_SALARY(93),
	INVESTMENT_INCOME_CASH(94),
	SSA(95),
	REWARDS(96),
	CHECK_DEPOSIT(97),
	MOBILE_REMOTE_DEPOSIT(98),
	TELLER_DEPOSIT(99),
	TAX_REFUND(100),
	CREDIT_CARD_PAYMENT(101),
	INSURANCE_PAYMENT(102),
	UTILITIES_PAYMENT(103),
	CHILD_SUPPORT(104),
	LOAN(105),
	PERSONAL_LOAN(106),
	STUDENT_LOAN(107),
	SALES_TAX(108),
	REIMBURSEMENT(109),
	BALANCE_TRANSFER(110),
	WIRE_TRANSFER(111),
	OVERDRAFT_PROTECTION(112),
	DEBIT(113),
	CREDIT(114),
	NSF_FEES(115);

	private long id;

	private MeerkatTxnSubType(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
}
