package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Record;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaRecordRepository implements RecordRepository{

    //JPA사용을 위해 필요
    private final EntityManager em;

    public JpaRecordRepository(EntityManager em) {
        this.em = em;
    }

    //record를 입력받아 DB에 주입
    @Override
    public Record save(Record record) {
        em.persist(record);
        return record;
    }

    //ID를 통해 recordDB에 해당 아이디로 저장되어 있는 데이터를 LIST로 제공
    @Override
    public List<Record> findById(String id) {
        return em.createQuery("select m from Record m where id = :id",Record.class)
                .setParameter("id", id)
                .getResultList();
    }
}
