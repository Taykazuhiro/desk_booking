package br.com.traive.desk_booking.controller;

import br.com.traive.desk_booking.domain.desk.DeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("desk")
public class DeskController {

    @Autowired
    private DeskRepository deskRepository;

}
