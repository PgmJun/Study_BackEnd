package inbody.checkinbody;


import inbody.checkinbody.repository.*;
import inbody.checkinbody.service.RecordService;
import inbody.checkinbody.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import java.beans.BeanProperty;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }


    @Bean
    RecordService recordService(){
        return new RecordService(recordRepository());
    }

    @Bean
    RecordRepository recordRepository(){
        return new JpaRecordRepository(em);
    }

    @Bean
    RegistryService registryService(){
        return new RegistryService(registryRepository());
    }

    @Bean
    RegistryRepository registryRepository(){
        return new JpaRegistryRepository(em);
    }

    @Bean
    DiaryRepository diaryRepository() {return new JpaDiaryRepository(em); }


}
