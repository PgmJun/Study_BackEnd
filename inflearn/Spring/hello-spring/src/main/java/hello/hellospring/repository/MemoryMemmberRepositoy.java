package hello.hellospring.repository;

import hello.hellospring.domain.Memmber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemmberRepositoy implements MemmberRepository{
    public static Map<Long,Memmber> store = new HashMap<>();
    public static Long sequence = 0L;

    @Override
    public Memmber save(Memmber memmber) {
        memmber.setId(++sequence);
        store.put(memmber.getId(),memmber);
        return memmber;
    }

    @Override
    public Optional<Memmber> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Memmber> findByName(String name) {
        return store.values().stream()
                .filter(memmber -> memmber.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Memmber> findAll() {
        return null;
    }
}
