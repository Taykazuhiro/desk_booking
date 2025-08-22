package br.com.traive.desk_booking.domain.desk;

import jakarta.validation.constraints.NotNull;

public record UpdateDeskData(
        @NotNull
        Long id,
        Integer deskNumber,
        Boolean available
) {
}
