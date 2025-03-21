package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.entities.Person;

public class ViewControler implements Initializable {

	@FXML
	private ComboBox<Person> comboBoxPerson;
	
	@FXML
	private Button btAll;
	
	private ObservableList<Person> obsList;
	
	@FXML
	public void onBtAllAction() {
		for(Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}
	
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();// esse item pega os items de uma ComboBox
		System.out.println(person.toString());
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		List<Person> list = new ArrayList<>();

        list.add(new Person(1, "João", "joao@email.com"));
        list.add(new Person(2, "Maria", "maria@email.com"));
        list.add(new Person(3, "Carlos", "carlos@email.com"));
        list.add(new Person(4, "Ana", "ana@email.com"));
        list.add(new Person(5, "Pedro", "pedro@email.com"));
        obsList = FXCollections.observableArrayList(list);
        comboBoxPerson.setItems(obsList);
	}

}
