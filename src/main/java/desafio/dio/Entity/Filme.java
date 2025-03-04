package desafio.dio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @NotBlank(message = "O diretor é obrigatório")
    private String diretor;

    @Positive(message = "O ano deve ser um valor positivo")
    private int ano;

    // Construtores, Getters e Setters

    public Filme() {
    }

    public Filme(String titulo, String diretor, int ano) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}