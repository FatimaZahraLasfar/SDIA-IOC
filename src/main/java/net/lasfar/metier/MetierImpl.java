package net.lasfar.metier;

import net.lasfar.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("metier")
public class MetierImpl implements IMetier {
    //@Qualifier("d")
    private IDao dao; // Coublage faible

    /**
     * Pour Injecter dans l'attribut dao
     * un objet d'une classe qui implément l'interface IDO
     * au moment de l'instantiation
     */

    public MetierImpl(@Qualifier("d2") IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 12 * Math.PI/2 * Math.cos(t);
        return res;
    }
    /**
    * Pour Injecter dans l'attribut dao
    * un objet d'une classe qui implément l'interface IDO
     * après l'instantiationn
    */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
