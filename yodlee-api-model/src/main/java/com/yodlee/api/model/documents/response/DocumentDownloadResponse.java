/**
 * Copyright (c) 2019 Yodlee, Inc. All Rights Reserved.
 *
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */
package com.yodlee.api.model.documents.response;

import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yodlee.api.model.AbstractModelComponent;
import com.yodlee.api.model.Response;
import com.yodlee.api.model.documents.DocumentDownload;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"document"})
public class DocumentDownloadResponse extends AbstractModelComponent implements Response {

	@ApiModelProperty(readOnly = true)
	@JsonProperty("document")
	private List<DocumentDownload> downloadDocuments;

	@JsonProperty("document")
	public List<DocumentDownload> getDocumentDownload() {
		return downloadDocuments == null ? null : Collections.unmodifiableList(downloadDocuments);
	}

	@Override
	public String toString() {
		return "DocumentDownloadResponse [downloadDocuments=" + downloadDocuments + "]";
	}
}
