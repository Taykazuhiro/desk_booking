package br.com.traive.desk_booking.domain.booking.validation.business;

import java.time.LocalDate;

public record CancelBookData(
        Long bookingId,
        LocalDate date
) {
}
