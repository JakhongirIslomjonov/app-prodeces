package uz.pdp.appcardprocessing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CurrencyRateDTO(@JsonProperty("Rate") double rate) {
}
