package br.com.senaigo.locadora.view.componentes;

import br.com.senaigo.locadora.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class JComboBoxModelVeiculo implements ComboBoxModel<Veiculo>{
    
    private List<Veiculo> veiculos;
    private Veiculo veiculoSelecionado;
    
    public JComboBoxModelVeiculo(List<Veiculo> veiculos) {
        this.veiculos = new ArrayList<>();
        this.veiculos.addAll(veiculos);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.veiculoSelecionado = (Veiculo) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.veiculoSelecionado;
    }

    @Override
    public int getSize() {
        return this.veiculos.size();
    }

    @Override
    public Veiculo getElementAt(int index) {
        return veiculos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {}

    @Override
    public void removeListDataListener(ListDataListener ll) {}
    
}
