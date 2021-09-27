package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    @Autowired
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public List<Member> findRecord() {
        return em.createQuery("select m from Member m",Member.class).getResultList();
    }
}
