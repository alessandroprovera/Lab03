package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import it.polito.tdp.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	private Dictionary model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboLanguage;

    @FXML
    private TextArea txtAreaInput;

    @FXML
    private TextArea txtAreaResult;

    @FXML
    private Label txtErrors;

    @FXML
    private Label txtTime;

    @FXML
    void doClearText(ActionEvent event) {
    	this.txtAreaInput.clear();
    	this.txtAreaResult.clear();

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	long inizio = System.nanoTime();
    	this.model.loadDictionary(comboLanguage.getValue());
    	Object array[] = this.model.stampaContaSbagliate(txtAreaInput.getText());
    	this.txtAreaResult.setText((String)array[0]);
    	this.txtErrors.setText("This text contains "+(int)array[1]+" errors");
    	this.txtTime.setText("Tempo trascorso: "+(System.nanoTime()-inizio)/1000000000.0+" seconds");

    }

    public void setModel(Dictionary model) {
		this.model = model;
	}

	@FXML
    void initialize() {
        assert comboLanguage != null : "fx:id=\"comboLanguage\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaInput != null : "fx:id=\"txtAreaInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaResult != null : "fx:id=\"txtAreaResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        this.comboLanguage.getItems().add("English");
        this.comboLanguage.getItems().add("Italian");

    }

}
