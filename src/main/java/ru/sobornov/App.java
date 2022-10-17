package ru.sobornov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sobornov.model.Item;
import ru.sobornov.model.Person;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author : Sobornov Vladimir
 * @since : 17.10.2022
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Cascade test40", 40);

            Item item = new Item("Test Item", person);
            person.setItems(new ArrayList<>(Collections.singletonList(item)));

            session.persist(person);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();

        }
    }
}
