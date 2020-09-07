/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.annotations;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.yodlee.api.model.enums.Container;

public class AllowedContainerValidator implements ConstraintValidator<AllowedContainer, Container> {

	protected List<Container> containers;

	@Override
	public void initialize(AllowedContainer containers) {
		this.containers = Arrays.asList(containers.value());
	}

	@Override
	public boolean isValid(Container container, ConstraintValidatorContext constraintValidatorContext) {
		return containers.contains(container);
	}
}
