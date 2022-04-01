package com.yodlee.api.model.consent;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"defaultRenewalDuration", "isReauthorizationRequired"})
public class Renewal {

    @ApiModelProperty(name = "defaultRenewalDuration",
            required = true,
            value = "Shows the duration in days of consent renewal")
    @JsonProperty("defaultRenewalDuration")
    private Long defaultRenewalDuration;

    @ApiModelProperty(name = "isReauthorizationRequired",
            required = true,
            value = "Shows if the consent renewal need reauthorization")
    @JsonProperty("isReauthorizationRequired")
    private Boolean isReauthorizationRequired;

    public Long getDefaultRenewalDuration() {
        return defaultRenewalDuration;
    }

    public void setDefaultRenewalDuration(Long defaultRenewalDuration) {
        this.defaultRenewalDuration = defaultRenewalDuration;
    }

    public Boolean getIsReauthorizationRequired() {
        return isReauthorizationRequired;
    }

    public void setIsReauthorizationRequired(Boolean reauthorizationRequired) {
        isReauthorizationRequired = reauthorizationRequired;
    }

    @Override
    public String toString() {
        return "Renewal{" +
                "defaultRenewalDuration=" + defaultRenewalDuration +
                ", isReauthorizationRequired=" + isReauthorizationRequired +
                '}';
    }
}
