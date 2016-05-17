package struts.beans;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by sbt-yablokov-mv on 16.05.2016.
 */
public class LookupForm extends ActionForm {
    private Integer clientId = null;
    private String clientFio = null;
    private List<Long> clientAccounts = null;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientFio() {
        return clientFio;
    }

    public void setClientFio(String clientFio) {
        this.clientFio = clientFio;
    }

    public List<Long> getClientAccounts() {
        return clientAccounts;
    }

    public void setClientAccounts(List<Long> clientAccounts) {
        this.clientAccounts = clientAccounts;
    }

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors actionErrors = super.validate(mapping, request);
        if (actionErrors == null || actionErrors.isEmpty()) {
            actionErrors = new ActionErrors();
            if (clientId == null) {
                actionErrors.add("clientId", new ActionMessage("errors.lookup.id.required"));
            } else if (clientId.equals(0)) {
                actionErrors.add("clientId", new ActionMessage("errors.lookup.id.unknown"));
            }
        }
        return actionErrors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        super.reset(mapping, request);
        clientId = null;
        clientFio = null;
        if (clientAccounts != null && !clientAccounts.isEmpty()) {
            clientAccounts.clear();
        }
    }
}
