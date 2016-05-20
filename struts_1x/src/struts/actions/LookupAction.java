package struts.actions;

import hibernate.AccountsEntity;
import hibernate.ClientsEntity;
import hibernate.HibernateSessionFactory;
import org.apache.struts.action.*;
import org.hibernate.Query;
import org.hibernate.Session;
import struts.beans.LookupForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LookupAction extends Action {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("resources/struts");

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String target = RESOURCE_BUNDLE.getString("forward.lookup.success");

        Integer clientId = null;
        LookupForm lookupForm = (LookupForm) form;
        if (lookupForm != null) {
            clientId = lookupForm.getClientId();
        }

        if (clientId == null || clientId.equals(0)) {
            target = RESOURCE_BUNDLE.getString("forward.lookup.failure");
            ActionErrors actionErrors = new ActionErrors();
            String actionMessageKey = (clientId == null) ? "errors.lookup.id.required" : "errors.lookup.id.unknown";
            actionErrors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage(actionMessageKey, clientId));
            saveErrors(request, actionErrors);
        } else {
            String clientFio = getClientFio(clientId);
            lookupForm.setClientFio(clientFio);

            List<Long> clientAccounts = getClientAccounts(clientId);
            lookupForm.setClientAccounts(clientAccounts);
        }
        return (mapping.findForward(target));
    }

    private enum QueryType { CREATE_HQL, NAMED_HQL, NAMED_SQL }

    private Query getClientAccountsQuery(Session session, Integer clientId, QueryType queryType) {
        switch (queryType) {
            case CREATE_HQL:
                return session.createQuery("from ClientsEntity where id=" + clientId);
            case NAMED_HQL:
                return session.getNamedQuery("getClientById_hql").setInteger("clientId", clientId);
            case NAMED_SQL:
                return session.getNamedQuery("getClientById_sql").setInteger("clientId", clientId);
            default:
                return null;
        }
    }

    private List<Long> getClientAccounts(Integer clientId) {
        List<Long> result = new ArrayList<>();
        final Session session = HibernateSessionFactory.getSession();
        try {
//            Transaction transaction = session.beginTransaction();
            Query query = getClientAccountsQuery(session, clientId, QueryType.NAMED_SQL);
            List clientList = query.list();
            if (clientList != null && !clientList.isEmpty()) {
                ClientsEntity client = (ClientsEntity) clientList.get(0);
                for (AccountsEntity account : client.getAccounts()) {
                    result.add(account.getNumber());
                }
            }
//            transaction.commit();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    private List<Long> getClientAccounts_usingNamedQuery(Integer clientId) {
        List<Long> result = new ArrayList<>();
        final Session session = HibernateSessionFactory.getSession();
        try {
            Query query = session.getNamedQuery("getClientById_hql").setLong("clientId", clientId);
            List clientList = query.list();
            if (clientList != null && !clientList.isEmpty()) {
                ClientsEntity client = (ClientsEntity) clientList.get(0);
                for (AccountsEntity account: client.getAccounts()) {
                    result.add(account.getNumber());
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    private String getClientFio(Integer clientId) {
        String result = null;
        final Session session = HibernateSessionFactory.getSession();
        try {
            Query query = session.createQuery("from ClientsEntity where id=" + clientId);
            List clientList = query.list();
            if (clientList != null && !clientList.isEmpty()) {
                ClientsEntity client = (ClientsEntity) clientList.get(0);
                result = client.getFio();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            session.close();
        }
        return result;
    }
}