package inbody.checkinbody.service;

import inbody.checkinbody.domain.Record;
import inbody.checkinbody.domain.Registry;
import inbody.checkinbody.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class RegistryService {
    RegistryRepository registryRepository;

    @Autowired
    public RegistryService(RegistryRepository registryRepository){
        this.registryRepository = registryRepository;
    }

    //registry를 입력받아서 reigstryDB에 저장
    public void join(Registry registry){
        validateDuplicateMember(registry);
        this.registryRepository.save(registry);
    }

    //입력받은 ID로 RegistryDB에서 해달 Registry를 찾아 리턴
    public Optional<Registry> findById(String id){
        return registryRepository.findById(id);
    }


    //입력받은 PW로 RegistryDB에서 해달 Registry를 찾아 리턴
    public Optional<Registry> findByPw(String pw){
        return registryRepository.findByPw(pw);
    }

    //registry에 저장하기 전에 DB에 registry가 이미 있는지 확인하여 Exception 리턴
    private void validateDuplicateMember(Registry registry){
        registryRepository.findById(registry.getId())
                .ifPresent(registry1 -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });
    }



}
