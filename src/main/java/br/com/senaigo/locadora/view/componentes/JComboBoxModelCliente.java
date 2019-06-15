package br.com.senaigo.locadora.view.componentes;

import br.com.senaigo.locadora.model.Cliente;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class JComboBoxModelCliente implements ComboBoxModel<Cliente>{

    private List<Cliente> clientes;
    private Cliente clienteSelecionado;

    public JComboBoxModelCliente(List<Cliente> clientes) {
        this.clientes = new ArrayList<>();
        this.clientes.addAll(clientes);
    }

    //Métodos da interface ComboBoxModel
    @Override
    public void setSelectedItem(Object anItem) {
        this.clienteSelecionado = (Cliente) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.clienteSelecionado;
    }

    //Métodos da interface ListModel
    @Override
    public int getSize() {
        return this.clientes.size();
    }

    @Override
    public Cliente getElementAt(int index) {
        return clientes.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {}

    @Override
    public void removeListDataListener(ListDataListener l) {}
}
