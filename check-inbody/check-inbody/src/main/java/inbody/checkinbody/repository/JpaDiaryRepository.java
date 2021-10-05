package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Diary;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaDiaryRepository implements DiaryRepository{

    private final EntityManager em;

    @Autowired
    public JpaDiaryRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Diary save(Diary diary) {
        em.persist(diary);
        return diary;
    }

    @Override
    public List<Diary> findById(String id) {
        return em.createQuery("select m from Diary m where id = :id",Diary.class)
                .setParameter("id", id)
                .getResultList();
    }
}
