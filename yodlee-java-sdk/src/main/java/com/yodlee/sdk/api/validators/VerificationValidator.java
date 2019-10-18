/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.List;
import com.yodlee.api.model.account.enums.BankTransferCodeType;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.api.model.verification.MatchingVerification;
import com.yodlee.api.model.verification.UpdateVerification;
import com.yodlee.api.model.verification.Verification;
import com.yodlee.api.model.verification.VerificationAccount;
import com.yodlee.api.model.verification.VerificationBankTransferCode;
import com.yodlee.api.model.verification.VerificationTransaction;
import com.yodlee.api.model.verification.enums.VerificationType;
import com.yodlee.api.model.verification.request.UpdateVerificationRequest;
import com.yodlee.api.model.verification.request.VerificationMatchingRequest;
import com.yodlee.api.model.verification.request.VerificationRequest;
import com.yodlee.sdk.api.VerificationApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;

public class VerificationValidator {

	private VerificationValidator() {}

	private static final String VERIFICATIONS_VERIFICATION_TYPE_INVALID = "verifications.verificationType.invalid";

	public static void validateGetVerificationDetails(VerificationApi verificationApi, String methodName,
			Long[] providerAccountId, Long[] accountId, VerificationType verificationType) throws ApiException {
		Class<?>[] argTypes = new Class[] {Long[].class, Long[].class, VerificationType.class};
		Object[] argValues = new Object[] {providerAccountId, accountId, verificationType};
		List<Problem> methodProblems = ApiValidator.validate(verificationApi, methodName, argTypes, argValues);
		List<Problem> verificationInputProblems = validateVerificationInput(providerAccountId, accountId);
		List<Problem> contextProblems = ApiValidator.validateUserContext(verificationApi);
		methodProblems.addAll(ApiValidator.validateId(accountId, "verifications.param.accountId.invalid"));
		methodProblems
				.addAll(ApiValidator.validateId(providerAccountId, "verifications.param.providerAccountId.invalid"));
		ApiValidator.collectProblems(methodProblems, contextProblems, verificationInputProblems);
	}

	private static List<Problem> validateVerificationInput(Long[] providerAccountId, Long[] accountId) {
		List<Problem> problems = new ArrayList<>();
		if ((providerAccountId != null && providerAccountId.length > 0)
				|| (accountId != null && accountId.length > 0)) {
			return problems;
		}
		problems.add(new Problem(ApiUtils.getErrorMessage("verifications.param.id.required"), ""));
		return problems;
	}

	private static List<Problem> validateInput(Long providerAccountId, Long accountId) {
		List<Problem> problems = new ArrayList<>();
		if (providerAccountId == null && accountId == null) {
			problems.add(new Problem(ApiUtils.getErrorMessage("verifications.param.id.required"), ""));
		}
		return problems;
	}

	public static void validateInitiateCDVerification(VerificationApi verificationApi, String methodName,
			VerificationRequest verificationParam) throws ApiException {
		Class<?>[] argTypes = new Class[] {VerificationRequest.class};
		Object[] argValues = new Object[] {verificationParam};
		List<Problem> methodProblems = ApiValidator.validate(verificationApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(verificationParam);
		List<Problem> contextProblems = ApiValidator.validateUserContext(verificationApi);
		List<Problem> cdvInputProblems = validateCDVInput(verificationParam);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems, cdvInputProblems);
	}

	public static void validateMatchingVerification(VerificationApi verificationApi, String methodName,
			VerificationMatchingRequest verificationParam) throws ApiException {
		Class<?>[] argTypes = new Class[] {VerificationMatchingRequest.class};
		Object[] argValues = new Object[] {verificationParam};
		List<Problem> methodProblems = ApiValidator.validate(verificationApi, methodName, argTypes, argValues);
		List<Problem> contextProblems = ApiValidator.validateUserContext(verificationApi);
		List<Problem> modelProblems = ApiValidator.validate(verificationParam);
		List<Problem> matchingInputProblems = validateMatchingInput(verificationParam);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems, matchingInputProblems);
	}

	private static List<Problem> validateCDVInput(VerificationRequest verificationParam) {
		List<Problem> problems = new ArrayList<>();
		Verification verification = verificationParam.getVerification();
		VerificationType verType = verification.getVerificationType();
		if (!verType.equals(VerificationType.CHALLENGE_DEPOSIT)) {
			problems.add(new Problem(ApiUtils.getErrorMessage(VERIFICATIONS_VERIFICATION_TYPE_INVALID), ""));
		} else {
			VerificationAccount accountVo = verification.getAccount();
			if (accountVo == null) {
				problems.add(new Problem(ApiUtils.getErrorMessage("verifications.account.details.required"), ""));
			} else {
				VerificationBankTransferCode bankTransferCodeVo = accountVo.getBankTransferCode();
				if (bankTransferCodeVo != null && bankTransferCodeVo.getType() != BankTransferCodeType.ROUTING_NUMBER) {
					problems.add(
							new Problem(ApiUtils.getErrorMessage("verifications.banktransfercode.type.invalid"), ""));
				}
			}
		}
		return problems;
	}

	private static List<Problem> validateMatchingInput(VerificationMatchingRequest verificationParam) {
		List<Problem> problems = new ArrayList<>();
		MatchingVerification verification = verificationParam.getVerification();
		VerificationType verType = verification.getVerificationType();
		if (!verType.equals(VerificationType.MATCHING)) {
			problems.add(new Problem(ApiUtils.getErrorMessage(VERIFICATIONS_VERIFICATION_TYPE_INVALID), ""));
		} else {
			Long accountId = verification.getAccountId();
			Long providerAccountId = verification.getProviderAccountId();
			problems.addAll(validateInput(providerAccountId, accountId));
		}
		return problems;
	}

	public static void validatePerformCDVerification(VerificationApi verificationApi, String methodName,
			UpdateVerificationRequest updateVerificationRequest) throws ApiException {
		Class<?>[] argTypes = new Class[] {UpdateVerificationRequest.class};
		Object[] argValues = new Object[] {updateVerificationRequest};
		List<Problem> methodProblems = ApiValidator.validate(verificationApi, methodName, argTypes, argValues);
		List<Problem> modelProblems = ApiValidator.validate(updateVerificationRequest);
		List<Problem> contextProblems = ApiValidator.validateUserContext(verificationApi);
		List<Problem> validateVerificationRequestProblems =
				validateUpdateVerificationRequest(updateVerificationRequest);
		ApiValidator.collectProblems(methodProblems, modelProblems, contextProblems,
				validateVerificationRequestProblems);
	}

	private static List<Problem>
			validateUpdateVerificationRequest(UpdateVerificationRequest updateVerificationRequest) {
		List<Problem> problems = new ArrayList<>();
		UpdateVerification verification = updateVerificationRequest.getVerification();
		VerificationType verificationType = verification.getVerificationType();
		if (!verificationType.equals(VerificationType.CHALLENGE_DEPOSIT)) {
			problems.add(new Problem(ApiUtils.getErrorMessage(VERIFICATIONS_VERIFICATION_TYPE_INVALID), ""));
		} else {
			List<VerificationTransaction> verificationTransactions = verification.getTransactions();
			if (verificationTransactions != null) {
				for (VerificationTransaction txn : verificationTransactions) {
					if (txn.getAmount() != null) {
						processVerificationTxn(problems, txn);
					}
				}
			}
		}
		return problems;
	}

	private static void processVerificationTxn(List<Problem> problems, VerificationTransaction txn) {
		if (txn.getAmount().getCurrency() == null) {
			String errorMessage = ApiUtils.getErrorMessage("verifications.transaction.currency.required");
			problems.add(new Problem(errorMessage, ""));
		}
		String amount = String.valueOf(txn.getAmount().getAmount().doubleValue());
		if (amount.contains(".")) {
			String amountSplit = amount.substring(amount.indexOf('.') + 1);
			if (amountSplit.length() > 2) {
				String errorMessage = ApiUtils.getErrorMessage("verifications.transaction.amount.invalid.length");
				problems.add(new Problem(errorMessage, ""));
			}
		}
	}
}
