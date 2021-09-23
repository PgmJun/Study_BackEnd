package hello.hellospring.repository;

import hello.hellospring.domain.Memmber;

import java.util.List;
import java.util.Optional;

public interface MemmberRepository {
    Memmber save(Memmber memmber);
    Optional<Memmber> findById(Long id);
    Optional<Memmber> findByName(String name);
    List<Memmber> findAll();
}
