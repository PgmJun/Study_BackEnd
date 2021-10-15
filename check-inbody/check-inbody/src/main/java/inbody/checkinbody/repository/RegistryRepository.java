package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Registry;

import java.util.List;
import java.util.Optional;

public interface RegistryRepository {
    Registry save(Registry registry);
    Optional<Registry> findById(String id);
    Optional<Registry> findByPw(String pw);
    List<Registry> findAll();

}
