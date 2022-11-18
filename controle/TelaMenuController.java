/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Monica
 */
public class TelaMenuController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private Menu mCadastros;
    @FXML
    private MenuItem mCadSalas;
    @FXML
    private Menu mConsultas;
    @FXML
    private MenuItem mConsSalas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chamaCadSalas(ActionEvent event) throws IOException {
        Parent painel = FXMLLoader.load(getClass().getClassLoader().getResource("./visao/CadSalas.fxml"));
        root.setCenter(painel);
    }

    @FXML
    private void chamaConsSalas(ActionEvent event) throws IOException {
        Parent painel = FXMLLoader.load(getClass().getClassLoader().getResource("./visao/ConsultaSalas.fxml"));
        root.setCenter(painel);
    }

    @FXML
    private void sobre(ActionEvent event) {
    }
    
}
