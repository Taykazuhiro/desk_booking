package br.com.traive.desk_booking.domain.desk;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

public record CreateDeskData(
        @NotNull
        @Digits(integer = 100, fraction = 0, message = "O valor deve ser um número inteiro")
        Integer deskNumber,
        @NotNull
        Boolean available) {

}
