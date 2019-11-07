/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.account;

import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Name;

public class HolderProfile extends AbstractModelComponent {

	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
