package br.com.milton.control;

import br.com.milton.dao.ClienteDao;
import br.com.milton.model.Cliente;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author nilson
 */
@ManagedBean(name = "clienteMB")
@ViewScoped
public class ClienteMB implements Serializable{
    private List<Cliente> clientes;
    private Cliente cliente;
    private int etapa=0;

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }

    public List<Cliente> getClientes() {
        if (clientes==null){
            refresh();
        }
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void refresh(){
        setClientes(new ClienteDao().getAll(Cliente.class));
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void novo(){
        setCliente(new Cliente());
        etapa=1;
    }
    
    public void salvar(){
        if (getCliente()==null){return;}
        if (getCliente().getNome()==null || "".equals(getCliente().getNome().trim())){
            PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados inválidos!","Nome é obrigatório"));
            return;
        }
        if (getCliente().getEndereco()==null || "".equals(getCliente().getEndereco().trim())){
            PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados inválidos!","Endereço é obrigatório"));
            return;
        }
        new ClienteDao().save(getCliente());
        refresh();
        setEtapa(0);
    }

    public void editar(){
        setEtapa(1);
    } 
    
    public void excluir(){
        if (getCliente()==null){return;}
        if (getCliente().getId()==0){return;}
        new ClienteDao().delete(Cliente.class,getCliente().getId());
        refresh();
        setEtapa(0);
    }
}
