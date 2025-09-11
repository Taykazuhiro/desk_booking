package br.com.traive.desk_booking.controller;

import br.com.traive.desk_booking.domain.booking.CreateBookData;
import br.com.traive.desk_booking.domain.booking.validation.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    @Transactional
    public ResponseEntity create (@RequestBody @Valid CreateBookData data){
        var dto = bookingService.book(data);
        return ResponseEntity.ok(dto);
    }
}
