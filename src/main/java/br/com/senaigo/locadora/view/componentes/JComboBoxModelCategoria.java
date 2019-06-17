package br.com.senaigo.locadora.view.componentes;

import br.com.senaigo.locadora.model.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class JComboBoxModelCategoria implements ComboBoxModel<Categoria>{
    
    private List<Categoria> categorias;
    private Categoria categoriaSelecionada;

    public JComboBoxModelCategoria(List<Categoria> categorias) {
        this.categorias = new ArrayList<>();
        this.categorias.addAll(categorias);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.categoriaSelecionada = (Categoria) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return this.categoriaSelecionada;
    }

    @Override
    public int getSize() {
        return this.categorias.size();
    }

    @Override
    public Categoria getElementAt(int index) {
        return this.categorias.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener ll) {
    }

    @Override
    public void removeListDataListener(ListDataListener ll) {
    }
    
}
