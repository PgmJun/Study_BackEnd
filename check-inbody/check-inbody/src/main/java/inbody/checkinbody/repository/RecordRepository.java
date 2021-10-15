package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Record;

import java.util.List;

public interface RecordRepository {
        Record save(Record record);
        List<Record> findById(String id);
    }

