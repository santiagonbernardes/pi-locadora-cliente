
package br.com.senaigo.locadora.view.componentes;

import br.com.senaigo.locadora.model.Motorista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class JComboBoxModelMotorista implements ComboBoxModel<Motorista>{
    
    private List<Motorista> motoristas;
    private Motorista motoristaSelecionado;
    
    public JComboBoxModelMotorista(List<Motorista> motoristas) {
        this.motoristas = new ArrayList<>();
        this.motoristas.addAll(motoristas);
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        this.motoristaSelecionado = (Motorista) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.motoristaSelecionado;
    }

    @Override
    public int getSize() {
        return this.motoristas.size();
    }

    @Override
    public Motorista getElementAt(int index) {
        return this.motoristas.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {}

    @Override
    public void removeListDataListener(ListDataListener ll) {}
    
}
