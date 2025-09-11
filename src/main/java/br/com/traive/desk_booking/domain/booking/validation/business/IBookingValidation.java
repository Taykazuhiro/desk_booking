package br.com.traive.desk_booking.domain.booking.validation.business;

import br.com.traive.desk_booking.domain.booking.CreateBookData;

public interface IBookingValidation {

    void validate(CreateBookData data);
}
