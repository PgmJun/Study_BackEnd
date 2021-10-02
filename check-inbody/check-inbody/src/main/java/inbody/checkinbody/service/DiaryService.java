package inbody.checkinbody.service;

import inbody.checkinbody.domain.Diary;
import inbody.checkinbody.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryService (DiaryRepository diaryRepository){
        this.diaryRepository = diaryRepository;
    }

    //Diary DB에 저장
    public void join(Diary diary){
        diaryRepository.save(diary);
    }
    //id를 통해 해당 ID를 가진 회원의 DiaryList 제공
    public List<Diary> findDiary(String id){
        return diaryRepository.findById(id);
    }
}
