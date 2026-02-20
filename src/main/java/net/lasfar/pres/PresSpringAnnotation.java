package net.lasfar.pres;

import net.lasfar.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext applicationContext  =
                new AnnotationConfigApplicationContext("net.lasfar");
        IMetier metier  = applicationContext.getBean(IMetier.class);
        System.out.println("Resultat = "+metier.calcul());
    }
}
