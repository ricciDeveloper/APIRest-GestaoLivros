package API.Domain.Service.Impl;

import API.Domain.Model.Livros;
import API.Domain.Repository.LivrosRepository;
import API.Domain.Service.LivrosService;
import org.springframework.stereotype.Service;


import java.util.NoSuchElementException;
@Service
public class LivrosServiceImpl implements LivrosService {
    private final LivrosRepository repository;

    public LivrosServiceImpl(LivrosRepository repository) {
        this.repository = repository;
    }

    @Override
    public Livros buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Livros registrar(Livros livroParaRegistro) {
        return repository.save(livroParaRegistro);
    }


}
