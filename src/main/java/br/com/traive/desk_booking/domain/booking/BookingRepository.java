package br.com.traive.desk_booking.domain.booking;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Boolean existsByUsuarioIdAndBookingType(@NotNull Long id, @NotBlank BookingType bookingTypeRequest);
}
