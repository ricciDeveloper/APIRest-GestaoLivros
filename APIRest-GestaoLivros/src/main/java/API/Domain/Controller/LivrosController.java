package API.Domain.Controller;

import API.Domain.Model.Livros;
import API.Domain.Service.LivrosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivrosController {
    private final LivrosService livrosService;

    public LivrosController(LivrosService livrosService) {
        this.livrosService = livrosService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Livros> buscarPorId(@PathVariable Long id){
        var livros = livrosService.buscarPorId(id);
        return ResponseEntity.ok(livros);
    }
    @PostMapping
    public ResponseEntity<Livros> registarLivro (@RequestBody Livros livrosParaRegistro){
        var livrosRegistrados = livrosService.registrar(livrosParaRegistro);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(livrosRegistrados.getId())
                .toUri();
        return ResponseEntity.created(location).body(livrosRegistrados);
    }
}
