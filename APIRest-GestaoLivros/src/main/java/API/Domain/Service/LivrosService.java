package API.Domain.Service;

import API.Domain.Model.Livros;
import org.springframework.stereotype.Service;

@Service
public interface LivrosService {
    Livros buscarPorId(Long id);
    Livros registrar(Livros livroParaRegistro);


}
