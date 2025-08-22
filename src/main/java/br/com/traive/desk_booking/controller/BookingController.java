package br.com.traive.desk_booking.controller;

import br.com.traive.desk_booking.domain.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
}
