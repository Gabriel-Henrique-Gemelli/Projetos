package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("OnMenuItemSellerAction");
	}

	@FXML
	public void onMenuItemDepartmentAction() {
		System.out.println("OnMenuItemDepartmentAction");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");

	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
	}

	private synchronized void loadView(String absoluteName) {
	    try {
	        // Carregando o conteúdo do FXML
	        FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
	        Parent newView = loader.load();  // Mudando para Parent para lidar com qualquer tipo de layout

	        // Acessando a cena principal e o AnchorPane onde o conteúdo será inserido
	        Scene mainScene = Main.getMainScene();
	        AnchorPane mainAnchorPane = (AnchorPane) ((ScrollPane) mainScene.getRoot()).getContent();

	        // Limpa o conteúdo anterior e adiciona o novo conteúdo
	          // Remove qualquer conteúdo anterior
	        mainAnchorPane.getChildren().add(newView);  // Adiciona o novo conteúdo carregado

	    } catch (IOException e) {
	        Alerts.showAlert("IO Exception", "Erro carregando a página", e.getMessage(), AlertType.ERROR);
	    }
	}
}
