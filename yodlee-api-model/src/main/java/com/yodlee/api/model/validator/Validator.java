/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
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
