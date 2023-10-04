package org.example.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static final SessionFactory SESSION;


    static {
        try{
            //SESSION=new Configuration().configure("c:\\config\\hibernate.cfg.xml").buildSessionFactory();
            //alttaki SESSION taniminda tanimlanmis olan root(hibernate.cfg.xml) algilanir.
            //burada configure un icine url yazilip oradan bir session acilabilir.
            SESSION=new Configuration().configure().buildSessionFactory();
        }catch (Exception exception){
            System.out.println("Hibernate baslatilirken hata olustu "+exception);
            throw new ExceptionInInitializerError(exception);
        }
    }
    public static SessionFactory getSessionFactory(){
        return SESSION;
    }
}
