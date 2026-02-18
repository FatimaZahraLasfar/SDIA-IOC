package net.lasfar.metier;

import net.lasfar.dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao; // Coublage faible

    /**
     * Pour Injecter dans l'attribut dao
     * un objet d'une classe qui implément l'interface IDO
     * au moment de l'instantiation
     */
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public MetierImpl() {
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
