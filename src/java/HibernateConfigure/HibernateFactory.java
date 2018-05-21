/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HibernateConfigure;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Luiz
 */
public class HibernateFactory {

    private static SessionFactory sessionFactory;

    public static synchronized void initSessionFactory() {
        if (getSessionFactory() != null) {
            throw new IllegalStateException("Hibernate SessionFactory is already initialized");
        }
        try {
            sessionFactory = new Configuration().configure("persistence.xml").buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSession() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException ignored) {
                System.err.println("Couldn't close SessionFactory" + ignored);
            }
        }
    }
}
