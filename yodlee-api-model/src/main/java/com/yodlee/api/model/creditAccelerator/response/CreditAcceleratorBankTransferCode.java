/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See LICENSE file in the project root for license information.
 */
package com.yodlee.api.model.creditAccelerator.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.account.enums.BankTransferCodeType;

@JsonPropertyOrder({"id", "type", "sourceType"})
public class CreditAcceleratorBankTransferCode   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("type")
  private BankTransferCodeType type = null;
  
  @JsonProperty("sourceType")
  private String sourceType;
  
  @JsonProperty("sourceType")
  public String getSourceType() {
		return sourceType;
	}

  public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

  /**
   * The FI&#39;s branch identification number.Additional Details: The routing number of the bank account in the United States. For non-United States accounts, it is the IFSC code (India), BSB number (Australia), and sort code (United Kingdom). &lt;br&gt;&lt;b&gt;Account Type&lt;/b&gt;: Aggregated&lt;br&gt;&lt;b&gt;Applicable containers&lt;/b&gt;: bank, investment&lt;br&gt;&lt;b&gt;Endpoints&lt;/b&gt;:&lt;br&gt;&lt;ul&gt;&lt;li&gt;GET accounts&lt;/li&gt;&lt;li&gt;GET accounts/{accountId}&lt;/li&gt;&lt;/ul&gt;
   * @return id
   **/
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  /**
   * The bank transfer code type varies depending on the region of the account origination. &lt;br&gt;&lt;b&gt;Account Type&lt;/b&gt;: Aggregated&lt;br&gt;&lt;b&gt;Applicable containers&lt;/b&gt;: bank, investment&lt;br&gt;&lt;b&gt;Endpoints&lt;/b&gt;:&lt;br&gt;&lt;ul&gt;&lt;li&gt;GET accounts&lt;/li&gt;&lt;li&gt;GET accounts/{accountId}&lt;/li&gt;&lt;/ul&gt;&lt;b&gt;Applicable Values&lt;/b&gt;&lt;br&gt; * BSB: BSB is a Bank-State-Branch number used to identify the branch in Australia and is required for performing transfers.&lt;br&gt; * IFSC: IFSC is Indian Financial System Code. It is an alphanumeric code that is used to identify the particular branch in India and is required for electronic funds settlement.&lt;br&gt; * ROUTING_NUMBER: Bank routing number or routing transit number (RTN) is a nine digit number used in US to identify financial institution in a transaction. Most common transaction types where routing numbers are used are ACH and wire transfers.&lt;br&gt; * SORT_CODE: The sort code is a six-digit number used in UK to identify both the bank and the branch where the account is held.&lt;br&gt;
   * @return type
   **/
  @JsonProperty("type")
  public BankTransferCodeType getType() {
    return type;
  }

}

