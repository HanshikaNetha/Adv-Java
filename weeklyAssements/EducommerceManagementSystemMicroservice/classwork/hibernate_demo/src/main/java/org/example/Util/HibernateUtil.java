package org.example.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Load configuration and build SessionFactory
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();

        } catch (Exception e) {
            System.out.println("SessionFactory creation failed!");
            e.printStackTrace();
        }
    }

    // Public method to return SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
