package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Diary;

import java.util.List;

public interface DiaryRepository {
    Diary save(Diary diary);
    List<Diary> findById(String id);
}
