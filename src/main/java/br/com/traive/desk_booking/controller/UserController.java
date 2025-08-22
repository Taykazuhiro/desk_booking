package br.com.traive.desk_booking.controller;

import br.com.traive.desk_booking.domain.user.DataUserDetails;
import br.com.traive.desk_booking.domain.user.DataUserRegister;
import br.com.traive.desk_booking.domain.user.User;
import br.com.traive.desk_booking.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity register (@RequestBody @Valid DataUserRegister data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataUserDetails(user));
    }

}
