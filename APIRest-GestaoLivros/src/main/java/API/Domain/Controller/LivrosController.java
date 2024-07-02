package API.Domain.Controller;

import API.Domain.Model.Livros;
import API.Domain.Service.LivrosService;
import org.apache.coyote.Response;
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
    @GetMapping
    public ResponseEntity<Iterable<Livros>> buscarTodos(){
        return ResponseEntity.ok(livrosService.buscarTodos());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livros> atualizar(@PathVariable Long id, @RequestBody Livros livros){
        livrosService.atualizar(id, livros);
        return ResponseEntity.ok(livros);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livrosService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
