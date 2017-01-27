package JCP;

import entity.Produkt;
import JCP.util.JsfUtil;
import JCP.util.JsfUtil.PersistAction;
import SBP.ProduktFacade;
import entity.Uzytkownik;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("produktController")
@SessionScoped
public class ProduktController implements Serializable {

    @EJB
    private SBP.ProduktFacade ejbFacade;
    private List<Produkt> items = null;
    private Produkt selected;
    Uzytkownik uzyt = new Uzytkownik();
    public ProduktController() {
    }

    public Produkt getSelected() {
        return selected;
    }

    public void setSelected(Produkt selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProduktFacade getFacade() {
        return ejbFacade;
    }

    public Produkt prepareCreate() {
        selected = new Produkt();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProduktCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProduktUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProduktDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    public void przyjmij(Uzytkownik a)
    {
        
        uzyt =a;
    }
    public List<Produkt> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
public List<Produkt> dupa(Uzytkownik a) {
    
            items = getFacade().pokaz(a);
        
        return items;
}
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Produkt getProdukt(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Produkt> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Produkt> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Produkt.class)
    public static class ProduktControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProduktController controller = (ProduktController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "produktController");
            return controller.getProdukt(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Produkt) {
                Produkt o = (Produkt) object;
                return getStringKey(o.getIDProd());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Produkt.class.getName()});
                return null;
            }
        }

    }

}
