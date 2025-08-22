package br.com.traive.desk_booking.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DataUserRegister(

        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password

) {
}
