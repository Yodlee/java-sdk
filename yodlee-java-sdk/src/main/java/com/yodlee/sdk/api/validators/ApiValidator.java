/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.sdk.api.validators;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.validator.Problem;
import com.yodlee.api.model.validator.Validator.APIModelValidatorFactory;
import com.yodlee.sdk.api.AbstractApi;
import com.yodlee.sdk.api.exception.ApiException;
import com.yodlee.sdk.api.util.ApiUtils;
import com.yodlee.sdk.context.ContextType;

public class ApiValidator {

	private static final long MAX_ID = 99999999999L;

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiValidator.class);

	private ApiValidator() {}

	public static List<Problem> validate(AbstractModelComponent modelComponent) {
		final List<Problem> problems = new ArrayList<>();
		return modelComponent == null ? problems : modelComponent.validate();
	}

	public static List<Problem> validate(Object o, String methodName, Class<?>[] types, Object... vars) {
		final ExecutableValidator executablesValidator =
				APIModelValidatorFactory.SINGLE_INSTANCE.getValidator().forExecutables();
		final List<Problem> problems = new ArrayList<>();
		try {
			final Set<ConstraintViolation<Object>> violations =
					executablesValidator.validateParameters(o, o.getClass().getMethod(methodName, types), vars);
			for (Iterator<ConstraintViolation<Object>> iterator = violations.iterator(); iterator.hasNext();) {
				ConstraintViolation<Object> constraintViolation = iterator.next();
				Problem problem =
						new Problem(constraintViolation.getMessage(), constraintViolation.getPropertyPath().toString());
				problems.add(problem);
			}
		} catch (NoSuchMethodException | SecurityException e) {
			LOGGER.error("Exception in method validation", e);
		}
		return problems;
	}

	public static List<Problem> validateContextType(ContextType expectedContext, ContextType currentContext) {
		final List<Problem> problems = new ArrayList<>();
		if (expectedContext == ContextType.COBRAND && ContextType.USER == currentContext) {
			return problems;
		}
		if (expectedContext != currentContext) {
			Problem problem = new Problem("Y008 - User specific authentication required.", "");
			problems.add(problem);
		}
		return problems;
	}

	/**
	 * List of Problem
	 * 
	 * @param problemList List of List of Problems
	 * @throws ApiException - {@link ApiException}
	 */
	@SafeVarargs
	public static void collectProblems(List<? extends Problem>... problemList) throws ApiException {
		final List<Problem> problems = new ArrayList<>();
		for (List<? extends Problem> problem : problemList) {
			if (problem != null) {
				problems.addAll(problem);
			}
		}
		if (!problems.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for (Problem problem : problems) {
				sb.append(problem.toString()).append('\n');
			}
			if (sb.length() > 0) {
				String msg = sb.toString();
				LOGGER.error(msg);
			}
			throw new ApiException(problems);
		}
	}

	public static List<Problem> isValidDateRange(Date fromDate, Date toDate, String errMsgKey) {
		List<Problem> problems = new ArrayList<>();
		if (fromDate != null && toDate != null && fromDate.after(toDate)) {
			problems.add(new Problem(ApiUtils.getErrorMessage(errMsgKey), ""));
		}
		return problems;
	}

	public static List<Problem> validateId(Long[] ids, String errorMessage) {
		List<Problem> problems = new ArrayList<>();
		if (ids != null) {
			for (Long id : ids) {
				if (id < 1L || id > MAX_ID) {
					problems.add(new Problem(ApiUtils.getErrorMessage(errorMessage), ""));
					return problems;
				}
			}
		}
		return problems;
	}

	public static List<Problem> validateCobrandContext(AbstractApi api) {
		return validateContextType(ContextType.COBRAND, api.getContext().getContextType());
	}

	public static List<Problem> validateUserContext(AbstractApi api) {
		return validateContextType(ContextType.USER, api.getContext().getContextType());
	}
}
