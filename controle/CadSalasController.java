/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controle;

import entidades.Salas;
import dao.SalasDAO;
import entidades.Bloco;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import jpaControllers.exceptions.NonexistentEntityException;

/**
 * FXML Controller class
 *
 * @author Monica
 */
public class CadSalasController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private FlowPane painelInicial;
    @FXML
    private ToggleButton btConsultar;
    @FXML
    private ToggleGroup gbIniciais;
    @FXML
    private ToggleButton btNovo;
    @FXML
    private HBox painelBotoes;
    @FXML
    private AnchorPane painelDados;
    @FXML
    private TextField txCodigo;
    @FXML
    private TextField txDescricao;
    @FXML
    private TextField txCapacidade;
    @FXML
    private ChoiceBox<Bloco> txBloco;

    Salas sala;
    SalasDAO banco;
    ObservableList<Salas> lista;
    @FXML
    private ComboBox<Salas> cbCodigo;
    @FXML
    private Label lblStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txBloco.getItems().addAll(Bloco.values());
        
        banco = new SalasDAO();
        lista = FXCollections.observableArrayList(banco.consultarTodos());
        cbCodigo.setItems(lista);
    }

    @FXML
    private void consultar(ActionEvent event) {
        try {
            //pegar sala selecionada no comboBox  
            sala = cbCodigo.getSelectionModel().getSelectedItem();
            //copiar dados do banco para tela e exibir painel
            txCodigo.setText(String.valueOf(sala.getId()));
            txDescricao.setText(sala.getDescricao());
            txCapacidade.setText(String.valueOf(sala.getCapacidade()));
            txBloco.setValue(buscaBloco(sala.getBloco()));
            habilitarTela(true);
            txDescricao.requestFocus();
        } catch (NumberFormatException e) {
            lblStatus.setText("Código deve ser um número inteiro " + cbCodigo.getSelectionModel().getSelectedItem().getId());
        }

    }

    private Bloco buscaBloco(String bloco) {
        for(Bloco objeto : Bloco.values())
            if(objeto.getDescricao().equals(bloco))
                return objeto;
        return null;
//        return Bloco.valueOf(bloco);
    }

    @FXML
    private void inserir(ActionEvent event) {
        habilitarTela(true);
        sala = new Salas();
    }

    @FXML
    private void gravar(ActionEvent event) {
        sala.setId(Integer.parseInt(txCodigo.getText()));
        sala.setDescricao(txDescricao.getText());
        sala.setCapacidade(Integer.parseInt(txCapacidade.getText()));
        sala.setBloco(txBloco.getValue().getDescricao());
        if (btNovo.isSelected()) {
            try {
                new SalasDAO().inserir(sala);
                lblStatus.setText("Inserção concluída com sucesso!!");
                habilitarTela(false);
            } catch (NumberFormatException e) {
                lblStatus.setText("Capacidade deve ser um número inteiro " + txCapacidade.getText());
            } catch (Exception ex) {
                lblStatus.setText("Erro na inserção: " + ex.getMessage());
            }
        } else {
            try {
                new SalasDAO().editar(sala);
                lblStatus.setText("Alteração concluída com sucesso!!");
                habilitarTela(false);
            } catch (Exception ex) {
                lblStatus.setText("Erro na alteração: " + ex.getMessage());
            }
        }
    }

    private void habilitarTela(boolean acao) {
        txCodigo.setEditable(acao);
        painelDados.setVisible(acao);
        if (acao && btNovo.isSelected()) {
            txCodigo.requestFocus();
        } else if (acao && btConsultar.isSelected()) {
            txCodigo.setEditable(!acao);
            txDescricao.requestFocus();
        } else {
            btNovo.setSelected(acao);
            btConsultar.setSelected(acao);
            cbCodigo.requestFocus();
            limpaCampos();
        }
        
    }

    @FXML
    private void excluir(ActionEvent event) {
        try {
            new SalasDAO().excluir(Integer.parseInt(txCodigo.getText()));
            lblStatus.setText("Exclusão realizada com sucesso!!");
        } catch (NonexistentEntityException ex) {
            lblStatus.setText("Erro na exclusão: " + ex.getMessage());
        }
    }

    @FXML
    private void imprimir(ActionEvent event) {
    }

    @FXML
    private void exportar(ActionEvent event) {
    }

    @FXML
    private void sair(ActionEvent event) {
        root.setVisible(false);
    }

    private void limpaCampos() {
        txCodigo.clear();
        txDescricao.clear();
        txCapacidade.clear();
        txBloco.getSelectionModel().clearSelection();
        lblStatus.setText("");
    }

}
