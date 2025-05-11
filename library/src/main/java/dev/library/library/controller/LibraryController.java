package dev.library.library.controller;

import dev.library.library.model.Library;
import dev.library.library.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    private LibraryService service;

    public LibraryController(LibraryService service) {
        this.service = service;
    }

    // verbos http

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Library library){
        Library book = service.adicionar(library);
        return ResponseEntity.ok().body("Adicionado com sucesso");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Library>> list(Library library){
        return ResponseEntity.ok().body(service.lista());
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listaId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.listaID(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Library library){
        service.update(id, library);
        return ResponseEntity.ok().body("Atualizado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().body("Deletado com sucesso !");
    }

}