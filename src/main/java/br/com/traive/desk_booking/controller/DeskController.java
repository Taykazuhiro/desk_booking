package br.com.traive.desk_booking.controller;

import br.com.traive.desk_booking.domain.desk.*;
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
@RequestMapping("desk")
public class DeskController {

    @Autowired
    private DeskRepository deskRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreateDeskData data, UriComponentsBuilder uriComponentsBuilder){
        var desk = new Desk(data);
        deskRepository.save(desk);
        var uri = uriComponentsBuilder.path("/desk/{id}").buildAndExpand(desk.getId()).toUri();
        return ResponseEntity.created(uri).body(new DeskDetailData(desk));
    }

    @GetMapping
    public ResponseEntity<Page<DeskListData>> read(@PageableDefault(size = 10, sort = {"deskNumber"})Pageable pageable){
        var page = deskRepository.findAllByAvailableTrue(pageable).map(DeskListData::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDeskData data){
        var desk = deskRepository.getReferenceById(data.id());
        desk.updateDeskInfo(data);
        return ResponseEntity.ok(new DeskDetailData(desk));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var desk = deskRepository.getReferenceById(id);
        desk.deactive();
        return ResponseEntity.noContent().build();
    }

}
