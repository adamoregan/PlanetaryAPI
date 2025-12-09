package planetaryAPI.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceLayerAOP {
    private static void log(JoinPoint joinPoint) {
        log.info("{} executing {} with arguments {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs()
        );
    }

    @After("execution(* findPlanetById(..)) || execution(* findMoonById(..)) || execution(* findUserByName(..))")
    public void logFindByInRepo(JoinPoint joinPoint) { log(joinPoint); }

    @Before("execution(* deleteById(..))")
    public void logDeleteByIdInRepo(JoinPoint joinPoint) { log(joinPoint); }

    @After("execution(* createPlanet(..)) || execution(* createMoon(..))")
    public void logSaveInRepo(JoinPoint joinPoint) { log(joinPoint); }
}
