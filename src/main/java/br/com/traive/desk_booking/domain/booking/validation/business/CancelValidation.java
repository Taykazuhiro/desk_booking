package br.com.traive.desk_booking.domain.booking.validation.business;

import br.com.traive.desk_booking.infra.exception.ValidationException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//Business Rule: User cannot cancel the reservation less than 1 day in advance
@Component
public class CancelValidation implements IBookingCancelling{

    @Override
    public void validate(CancelBookData data) {
        var bookingDate = data.date();
        var today = LocalDate.now();
        if (bookingDate.isBefore(today) || bookingDate.isEqual(today) ){
            throw new ValidationException("Não é possível cancelar reservas em menos de 1 dia");
        }
    }
}
