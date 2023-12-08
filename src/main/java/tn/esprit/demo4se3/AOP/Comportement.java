package tn.esprit.demo4se3.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Aspect
@Slf4j
public class Comportement {

    // Cette méthode va etre lancer avant l'exécution
    // de chaque méthode de la couche service
    @Before(value = "execution(* tn.esprit.demo4se3.Services.*.*(..))")
    public void methode1(JoinPoint joinPoint){
        log.info("Bonjour from "+ joinPoint.getSignature().getName());
    }

    // Cette méthode va etre lancer après l'exécution
    // de chaque méthode de la couche service
    @After(value = "execution(* tn.esprit.demo4se3.Services.*.*(..))")
    public void methode2(JoinPoint joinPoint){
        log.info("Bye Bye from "+ joinPoint.getSignature().getName());
    }

    // Cette méthode va etre lancer en // avec l'exécution
    // de chaque méthode de la couche service
    @Around(value = "execution(* tn.esprit.demo4se3.Services.*.*(..))")
    public Object methode3(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t0= System.currentTimeMillis(); // nrecuperi el wa9t 9bal manlanci bil ms
        Object obj=proceedingJoinPoint.proceed(); // lancit el méthode
        long t1= System.currentTimeMillis(); // nrecuperi el wa9t ba3d ma lancit bil ms
        log.info("Le temps d'execution de la méthode "+proceedingJoinPoint.getSignature().getName());
        log.info((t1-t0)+" ms");
        return obj;
    }

}
