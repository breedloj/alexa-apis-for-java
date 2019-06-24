/*
* Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
* except in compliance with the License. A copy of the License is located at
*
* http://aws.amazon.com/apache2.0/
*
* or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
* the specific language governing permissions and limitations under the License.
*/


package com.amazon.ask.model.interfaces.amazonpay.model.request;

import java.util.Objects;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This request object specifies amount and currency authorized/captured.
 */

@JsonDeserialize(builder = Price.Builder.class)
public final class Price extends com.amazon.ask.model.interfaces.amazonpay.model.request.BaseAmazonPayEntity {

  @JsonProperty("amount")
  private String amount = null;

  @JsonProperty("currencyCode")
  private String currencyCode = null;

  public static Builder builder() {
    return new Builder();
  }

  private Price(Builder builder) {
    String discriminatorValue = "Price";

    this.amount = builder.amount;
    this.currencyCode = builder.currencyCode;
    this.type = discriminatorValue;
    this.version = builder.version;
  }

  /**
    * Amount authorized/captured.
  * @return amount
  **/
  public String getAmount() {
    return amount;
  }

  /**
    * Currency code for the amount.
  * @return currencyCode
  **/
  public String getCurrencyCode() {
    return currencyCode;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price interfacesAmazonpayModelRequestPrice = (Price) o;
    return Objects.equals(this.amount, interfacesAmazonpayModelRequestPrice.amount) &&
        Objects.equals(this.currencyCode, interfacesAmazonpayModelRequestPrice.currencyCode) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currencyCode, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Price {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public static class Builder {
    private String amount;
    private String currencyCode;
    private String version;

    private Builder() { }

    @JsonProperty("amount")
    public Builder withAmount(String amount) {
        this.amount = amount;
        return this;
    }


    @JsonProperty("currencyCode")
    public Builder withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }


    @JsonProperty("@version")
    public Builder withVersion(String version) {
        this.version = version;
        return this;
    }


    public Price build() {
      return new Price(this);
    }
  }
}

