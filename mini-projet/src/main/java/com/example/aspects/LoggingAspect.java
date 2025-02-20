package com.example.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.services.CustomUtilisateurDetailsService.loadUtilisateurByUtilisateurname(..))")
    public void loadUtilisateurByUtilisateurnamePointcut() {
    }

    @Before("loadUtilisateurByUtilisateurnamePointcut()")
    public void beforeLoadUtilisateur() {
        System.out.println("Tentative de chargement de l'utilisateur...");
    }

    @AfterReturning("loadUtilisateurByUtilisateurnamePointcut()")
    public void afterLoadUtilisateurSuccess() {
        System.out.println("Utilisateur chargé avec succès.");
    }

    @AfterThrowing(pointcut = "loadUtilisateurByUtilisateurnamePointcut()", throwing = "exception")
    public void afterLoadUtilisateurFailure(Exception exception) {
        System.out.println("Échec du chargement de l'utilisateur : " + exception.getMessage());
    }
}
