package br.com.traive.desk_booking.domain.booking.validation.business;

import br.com.traive.desk_booking.domain.booking.CreateBookData;
import br.com.traive.desk_booking.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//Business Rule: User cannot cancel the reservation less than 1 day in advance
@Component
public class UpdateValidation implements IBookingValidation{
    @Override
    public void validate(CreateBookData data) {
        var bookingDate = data.bookingDate();
        var today = LocalDate.now();
        if (bookingDate.isBefore(today) || bookingDate.isEqual(today) ){
            throw new ValidationException("Não é possível alterar reservas em menos de 1 dia");
        }
    }
}
