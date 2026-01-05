package fr.kevin.cap_enterprise.service;

import fr.kevin.cap_enterprise.entity.Genre;
import fr.kevin.cap_enterprise.repository.GenreRepository;
import fr.kevin.cap_enterprise.service.interfaces.DAOEntityInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService implements DAOEntityInterface<Genre> {

    private GenreRepository genreRepository;

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> findAllSorted() {
        return genreRepository.findAllByOrderByNameAsc();
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
