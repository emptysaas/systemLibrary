package dev.library.library.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_library")
@Data
@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAutor;
    private String nomeLivro;
    private String editora;
    private int anoPublicacao;
    private int numeroPaginas;

}
