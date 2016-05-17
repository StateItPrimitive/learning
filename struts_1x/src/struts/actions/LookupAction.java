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

        if (clientId == null) {
            target = RESOURCE_BUNDLE.getString("forward.lookup.failure");
            ActionErrors actionErrors = new ActionErrors();
            actionErrors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.lookup.unknown", clientId));
            saveErrors(request, actionErrors);
        } else {
            String clientFio = getClientFio(clientId);
            lookupForm.setClientFio(clientFio);

            List<Long> clientAccounts = getClientAccounts(clientId);
            lookupForm.setClientAccounts(clientAccounts);
        }
//        super.execute(mapping, form, request, response)
        return (mapping.findForward(target));
    }

    private List<Long> getClientAccounts(Integer clientId) {
        List<Long> result = new ArrayList<>();
        final Session session = HibernateSessionFactory.getSession();
        try {
            Query query = session.createQuery("from ClientsEntity where id=" + clientId);
            List clientList = query.list();
            if (clientList != null && !clientList.isEmpty()) {
                ClientsEntity client = (ClientsEntity) clientList.get(0);
                for (AccountsEntity account: client.getAccounts()) {
                    result.add(account.getNumber());
                }
            }
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
        } finally {
            session.close();
        }
        return result;
    }
}