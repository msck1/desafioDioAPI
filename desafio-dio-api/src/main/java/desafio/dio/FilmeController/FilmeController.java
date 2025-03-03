package desafio.dio.FilmeController;

import desafio.dio.Entity.Filme;
import desafio.dio.Repository.FilmeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> getAllFilmes() {
        return filmeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado com id " + id));
        return ResponseEntity.ok(filme);
    }

    @PostMapping
    public Filme createFilme(@Valid @RequestBody Filme filme) {
        return filmeRepository.save(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable Long id, @Valid @RequestBody Filme filmeDetails) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado com id " + id));
        filme.setTitulo(filmeDetails.getTitulo());
        filme.setDiretor(filmeDetails.getDiretor());
        filme.setAno(filmeDetails.getAno());
        return ResponseEntity.ok(filmeRepository.save(filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado com id " + id));
        filmeRepository.delete(filme);
        return ResponseEntity.noContent().build();
    }
}