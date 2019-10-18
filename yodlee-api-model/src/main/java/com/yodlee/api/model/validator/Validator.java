/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class Validator {

	public static List<Problem> validate(final Object modelComponent) {
		final List<Problem> problems = new ArrayList<>();
		if (modelComponent != null) {
			final Set<ConstraintViolation<Object>> constraintViolations =
					APIModelValidatorFactory.SINGLE_INSTANCE.getValidator().validate(modelComponent);
			if (!constraintViolations.isEmpty()) {
				for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
					Problem problem = new Problem(constraintViolation.getMessage(),
							constraintViolation.getPropertyPath().toString());
					problems.add(problem);
				}
			}
		}
		return problems;
	}

	public enum APIModelValidatorFactory {
		SINGLE_INSTANCE {

			private final transient ValidatorFactory avf = Validation.buildDefaultValidatorFactory();

			@Override
			public javax.validation.Validator getValidator() {
				return avf.getValidator();
			}
		};

		public abstract javax.validation.Validator getValidator();
	}
}
