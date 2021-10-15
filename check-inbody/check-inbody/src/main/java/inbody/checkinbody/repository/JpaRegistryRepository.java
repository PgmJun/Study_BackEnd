package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Registry;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaRegistryRepository implements RegistryRepository{

    private final EntityManager em;

    public JpaRegistryRepository(EntityManager em) {
        this.em = em;
    }

    //registry를 입력받아 registryDB에 주입
    @Override
    public Registry save(Registry registry) {
        em.persist(registry);
        return registry;
    }

    //입력받은 ID를 가진 회원의 Registry제공
    @Override
    public Optional<Registry> findById(String id) {
        Registry result = em.find(Registry.class,id);
        return Optional.ofNullable(result);
    }
    //입력받은 PW를 가진 회원의 Registry제공
    @Override
    public Optional<Registry> findByPw(String pw) {
        Registry result = em.find(Registry.class,pw);
        return Optional.ofNullable(result);
    }

    //모든 회원의 registry를 List<Registry>형태로 제공
    @Override
    public List<Registry> findAll() {
        return em.createQuery("select m.id from registry m",Registry.class).getResultList();
    }
}
