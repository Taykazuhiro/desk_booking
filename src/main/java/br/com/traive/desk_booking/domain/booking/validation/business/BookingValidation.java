package br.com.traive.desk_booking.domain.booking.validation.business;

import br.com.traive.desk_booking.domain.booking.BookingRepository;
import br.com.traive.desk_booking.domain.booking.CreateBookData;

import br.com.traive.desk_booking.infra.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Business Rule: Only 1 repeated booking
@Component
public class BookingValidation implements IBookingValidation{
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void validate(CreateBookData data) {
        var bookingTypeRequest = data.bookingType();
        var userBookingList = bookingRepository.existsByUsuarioIdAndBookingType(data.id(),bookingTypeRequest);
        if (userBookingList){
            throw new ValidationException("Você já possui uma reserva fixa. Para fazer nova reserva, cancele a anterior.");

        }
    }
}
