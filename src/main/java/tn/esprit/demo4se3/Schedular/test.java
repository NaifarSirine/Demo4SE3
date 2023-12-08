package tn.esprit.demo4se3.Schedular;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.demo4se3.DAO.Entities.Bloc;
import tn.esprit.demo4se3.Services.IBlocService;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class test {
    IBlocService iBlocService;

    @Scheduled(fixedRate = 30000) //30 secondes
    public void methode1(){
        List<Bloc> blocs= iBlocService.findAll();
        for (Bloc b: blocs) {
            log.info(b.getIdBloc()+"");
        }
    }

    @Scheduled(cron = "*/30 * * * * *") //x:x:30 secondes
    public void methode2(){
        List<Bloc> blocs= iBlocService.findAll();
        for (Bloc b: blocs) {
            log.info(b.getIdBloc()+"");
        }
    }
}
