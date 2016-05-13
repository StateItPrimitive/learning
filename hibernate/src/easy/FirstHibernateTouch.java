package easy;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sbt-yablokov-mv on 04.05.2016.
 */
public class FirstHibernateTouch {
    static void printAllClientsData()
    {
        final Session session = HibernateSessionFactory.getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Query query = session.createQuery("from " + ClientsEntity.class.getName());
            for (Object clientObject : query.list()) {
                System.out.println();

                ClientsEntity client = (ClientsEntity) clientObject;
                System.out.println("ФИО клиента: " + client.getFio());

                final List<AccountsEntity> accounts = client.getAccounts();
                if (accounts.size() > 0)
                {
                    System.out.println("Счета клиента:");
                    for (AccountsEntity account: accounts)
                    {
                        System.out.println("Номер счета: " + account.getAccountNumber());
                    }
                }
                else {
                    System.out.println("Отсутствуют счета");
                }
            }
        } finally {
            session.close();
        }
    }

    public static void main(final String[] args) throws Exception {
        printAllClientsData();
    }
}
