package net.lasfar.pres;

import net.lasfar.dao.DaoImpl;
import net.lasfar.metier.MetierImpl;
import net.lasfar.ext.DaoImplV2;

public class Pres1 {
    public static void main(String[] args) {
        //DaoImpl d = new DaoImpl();
        DaoImplV2 d = new DaoImplV2();
        MetierImpl metier = new MetierImpl(d);
        //metier.setDao(d); // Injection des dépendances via le setter
        System.out.printf("Resultat = "+metier.calcul());
    }
}
