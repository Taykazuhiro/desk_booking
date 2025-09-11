package br.com.traive.desk_booking.domain.booking;

import java.time.LocalDate;
import java.time.LocalTime;


public record CreateBookData(
        Long id,
        Long idDesk,
        Long idUsuario,
        LocalDate bookingDate,
        LocalTime startTime,
        LocalTime endTime,
        BookingType bookingType
) {
}
