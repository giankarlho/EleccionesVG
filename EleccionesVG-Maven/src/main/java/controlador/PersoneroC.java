package controlador;

import dao.PersoneroImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Personero;

@Named(value = "personeroC")
@SessionScoped
public class PersoneroC implements Serializable {

    private Personero per;
//    private Personero selectPer;
    private PersoneroImpl dao;
    private List<Personero> listadoPer;
//     private Date fechaFormulario;
//    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");

    public PersoneroC() {
        per = new Personero();
        dao = new PersoneroImpl();

    }

    public void registrar() throws Exception {
        try {
            dao.registrar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Registrado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar(Personero pers) throws Exception{
        try {            
            dao.eliminar(pers);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }


    public void limpiar() {
        per = new Personero();
    }

    public void listar() {
        try {
            listadoPer = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
    
    // métodos generados
    public Personero getPer() {
        return per;
    }

    public void setPer(Personero per) {
        this.per = per;
    }

    public PersoneroImpl getDao() {
        return dao;
    }

    public void setDao(PersoneroImpl dao) {
        this.dao = dao;
    }

    public List<Personero> getListadoPer() {
        return listadoPer;
    }

    public void setListadoPer(List<Personero> listadoPer) {
        this.listadoPer = listadoPer;
    }

//    public Personero getSelectPer() {
//        return selectPer;
//    }
//
//    public void setSelectPer(Personero selectPer) {
//        this.selectPer = selectPer;
//    }

    
}
