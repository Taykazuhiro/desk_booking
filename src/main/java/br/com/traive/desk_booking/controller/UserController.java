package br.com.traive.desk_booking.controller;

import br.com.traive.desk_booking.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity create (@RequestBody @Valid DataUserRegister data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        userRepository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataUserDetails(user));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var user = userRepository.getReferenceById(id);
        user.deactivate();
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<ActiveUserList>> read(@PageableDefault(size = 10, sort = {"name"})Pageable pageable){
        var page = userRepository.findAllByActiveTrue(pageable).map(ActiveUserList::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateUserData data){
        var user = userRepository.getReferenceById(data.id());
        user.updateInfo(data);
        return ResponseEntity.ok(new DataUserDetails(user));
    }

}
