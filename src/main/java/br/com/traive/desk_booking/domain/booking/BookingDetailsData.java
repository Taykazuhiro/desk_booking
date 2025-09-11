package br.com.traive.desk_booking.domain.booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record BookingDetailsData(
        Long idBooking,
        Long idDesk,
        Long idUser,
        LocalDate bookingDate,
        LocalTime startDate,
        LocalTime endDate,
        BookingType bookingType

) {
    public BookingDetailsData(Booking booking) {
    this(booking.getId(), booking.getDesk().getId(), booking.getUsuario().getId(), booking.getBookingDate(), booking.getStartTime(),booking.getEndTime(),booking.getBookingType());
    }
}
