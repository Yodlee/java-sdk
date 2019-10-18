/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Yodlee, Inc. Use is subject to license terms.
 */
package com.yodlee.api.model.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"simple", "original", "consumer"})
public class Description extends AbstractModelComponent {

	@ApiModelProperty(readOnly = true,
					  value = "The transaction description that appears at the FI site may not be self-explanatory, i.e., the source, purpose of the transaction may not be evident. Yodlee attempts to simplify and make the transaction meaningful to the consumer, and this simplified transaction description is provided in the simple description field."
							  + "Note: The simple description field is available only in the United States, Canada, United Kingdom, and India."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, insurance, loan<br>"//
	)
	@JsonProperty("simple")
	private String simple;

	@ApiModelProperty(readOnly = true,
					  value = "Original transaction description as it appears at the FI site."//
							  + "<br><br>"//
							  + "<b>Applicable containers</b>: bill, creditCard, insurance, loan<br>"//
	)
	@JsonProperty("original")
	private String original;

	@ApiModelProperty(value = "The description of the transaction as defined by the consumer. The consumer can define or provide more details of the transaction in this field."//
			+ "<br><br>"//
			+ "<b>Applicable containers</b>: bill, creditCard, insurance, loan<br>"//
	)
	@JsonProperty("consumer")
	private String consumer;

	/**
	 * The transaction description that appears at the FI site may not be self-explanatory, i.e., the source, purpose of
	 * the transaction may not be evident. Yodlee attempts to simplify and make the transaction meaningful to the
	 * consumer, and this simplified transaction description is provided in the simple description field. Note: The
	 * simple description field is available only in the United States, Canada, United Kingdom, and India. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, insurance, loan<br>
	 * 
	 * @return simple
	 */
	public String getSimple() {
		return simple;
	}

	public void setSimple(String simple) {
		this.simple = simple;
	}

	/**
	 * Original transaction description as it appears at the FI site. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, insurance, loan<br>
	 * 
	 * @return original
	 */
	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	/**
	 * The description of the transaction as defined by the consumer. The consumer can define or provide more details of
	 * the transaction in this field. <br>
	 * <br>
	 * <b>Applicable containers</b>: bill, creditCard, insurance, loan<br>
	 * 
	 * @return consumer
	 */
	public String getConsumer() {
		return consumer;
	}

	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	@Override
	public String toString() {
		return "Description [simple=" + simple + ", original=" + original + ", consumer=" + consumer + "]";
	}
}
