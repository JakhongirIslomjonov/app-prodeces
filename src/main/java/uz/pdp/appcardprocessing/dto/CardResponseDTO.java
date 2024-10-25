package uz.pdp.appcardprocessing.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import uz.pdp.appcardprocessing.entity.enums.CardStatus;
import uz.pdp.appcardprocessing.entity.enums.Currency;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.appcardprocessing.entity.Card}
 */
public record CardResponseDTO(Long userUser_id, @NotNull(message = "status can not be  null") CardStatus status,
                              @NotNull @Max(10000) @Positive Long inital_amount,
                              Currency currency) implements Serializable {
}