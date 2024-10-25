package uz.pdp.appcardprocessing.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record LoginDTO(@NotNull @Email(message = " Please , provide  email") String email,
                       @NotNull @Size(message = "Password length must be at least 8!", min = 8) @NotBlank String password) implements Serializable {
}