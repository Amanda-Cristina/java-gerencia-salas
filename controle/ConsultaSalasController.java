/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controle;

import dao.SalasDAO;
import entidades.Bloco;
import entidades.Salas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Monica
 */
public class ConsultaSalasController implements Initializable {

    @FXML
    private TableView<Salas> tabela;
    @FXML
    private TableColumn<Salas, Integer> coluna1;
    @FXML
    private TableColumn<Salas, String> coluna2;
    @FXML
    private TableColumn<Salas, Integer> coluna3;
    @FXML
    private TableColumn<Salas, String> coluna4;
    
    
    ObservableList<Salas> lista;
    @FXML
    private AnchorPane painelDados;
    @FXML
    private TextField txID;
    @FXML
    private TextField txDescricao;
    @FXML
    private TextField txCapacidade;
    @FXML
    private ChoiceBox<Bloco> txBloco;
    
    SalasDAO banco;
    @FXML
    private Button btSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txBloco.getItems().addAll(Bloco.values());
        banco = new SalasDAO();
        
        lista = FXCollections.observableArrayList(banco.consultarTodos());
                
        coluna1.setCellValueFactory(new PropertyValueFactory<>("id"));
        coluna2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        coluna3.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
        coluna4.setCellValueFactory(new PropertyValueFactory<>("bloco"));
        
        tabela.setItems(lista);
        
    }    

    @FXML
    private void inserir(ActionEvent event) {
        painelDados.setVisible(true);
    }

    @FXML
    private void gravar(ActionEvent event) throws Exception {
        Salas sala = new Salas();
        sala.setId(Integer.parseInt(txID.getText()));
        sala.setDescricao(txDescricao.getText());
        sala.setCapacidade(Integer.parseInt(txCapacidade.getText()));
        sala.setBloco(txBloco.getValue().getDescricao());
        lista.add(sala);
        banco.inserir(sala);
        painelDados.setVisible(false);
    }

    @FXML
    private void sair(ActionEvent event) {
        btSair.getParent().getParent().setVisible(false);
    }
    
}
