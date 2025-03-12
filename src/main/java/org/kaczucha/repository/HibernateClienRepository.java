package org.kaczucha.repository;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.kaczucha.repository.entity.Client;

public class HibernateClienRepository implements ClientRepository {
    @Override
    public void save(Client client) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        client.getAccounts().forEach(session::save);
        session.save(client);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Client findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        final Query<Client> query = session.createQuery("FROM Client WHERE email = :mail", Client.class);
        query.setParameter("mail", email);

        Client client = query.uniqueResult();
        session.close();
        return client;
    }
}
