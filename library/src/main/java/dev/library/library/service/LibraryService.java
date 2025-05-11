package dev.library.library.service;

import dev.library.library.model.Library;
import dev.library.library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    // CRUD metodos

    public Library adicionar(Library library){
         return this.repository.save(library);
    }

    public List<Library> lista(){
        List<Library> list = this.repository.findAll();
        return list;
    }

    public Library listaID(Long id){
       Library lisbraryId = this.repository.findById(id).get();
       return lisbraryId;
    }

    public Library update(Long id, Library library){
        library.setId(id);
        return this.repository.save(library);
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }



}
