package inbody.checkinbody.service;

import inbody.checkinbody.domain.Record;
import inbody.checkinbody.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    //Record를 RecordDB에 등록
    public void join(Record record){
        recordRepository.save(record);
    }

    //id를 통해 해당ID를 가진 회원의 RecordList제공
    public List<Record> findRecords(String id){
        return recordRepository.findById(id);
    }
}
