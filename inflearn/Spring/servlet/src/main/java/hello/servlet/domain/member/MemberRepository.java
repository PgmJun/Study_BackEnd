package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {
    private static Map<Long, hello.servlet.domain.member.Member> store=new HashMap<>();
    private static long sequence=0L;

    //singleton으로 만들것임.
    private static final MemberRepository instance=new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    //singleton이니까 private 지정자
    private MemberRepository(){
    }

    public hello.servlet.domain.member.Member save(hello.servlet.domain.member.Member member){
        member.setId((++sequence));
        store.put(member.getId(), member);
        return member;
    }

    public hello.servlet.domain.member.Member findById(Long id){
        return store.get(id);
    }

    public List<hello.servlet.domain.member.Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
