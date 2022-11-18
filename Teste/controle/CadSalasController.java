/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controle;

import bancoDados.Salas;
import bancoDados.SalasDAO;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField txBloco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }

    @FXML
    private void consultar(ActionEvent event) {
        try {
            //pegar código do textfield  e enviar para o método de consulta do banco
            Salas sala = new SalasDAO().consultar(Integer.parseInt(txCodigo.getText()));
            //se existir copiar dados do banco para tela e exibir painel
            txDescricao.setText(sala.getDescricao());
            txCapacidade.setText(String.valueOf(sala.getCapacidade()));
            txBloco.setText(sala.getBloco());
            txDescricao.requestFocus();
            painelDados.setVisible(true);
        } catch (NumberFormatException e) {
            System.out.println("Código deve ser um número inteiro " + txCodigo.getText());
        } catch (NonexistentEntityException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void inserir(ActionEvent event) {
        txDescricao.requestFocus();
        painelDados.setVisible(true);
    }

    @FXML
    private void gravar(ActionEvent event) {
        Salas sala = new Salas();
        sala.setId(Integer.parseInt(txCodigo.getText()));
        sala.setDescricao(txDescricao.getText());
        sala.setCapacidade(Integer.parseInt(txCapacidade.getText()));
        sala.setBloco(txBloco.getText());
        if (btNovo.isSelected()) {
            try {
                new SalasDAO().inserir(sala);
                System.out.println("Inserção concluída com sucesso!!");
            } catch (NumberFormatException e) {
                System.out.println("Capacidade deve ser um número inteiro " + txCapacidade.getText());
            } catch (Exception ex) {
                System.out.println("Erro na inserção: " + ex.getMessage());
            }
        } else {
            try {
                new SalasDAO().editar(sala);
            } catch (Exception ex) {
                System.out.println("Erro na alteraação: " + ex.getMessage());
            }
        }
    }

    @FXML
    private void excluir(ActionEvent event) {
        try {
            new SalasDAO().excluir(Integer.parseInt(txCodigo.getText()));
        } catch (NonexistentEntityException ex) {
            System.out.println("Erro na exclusão: " + ex.getMessage());
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
        Platform.exit();
    }

}
