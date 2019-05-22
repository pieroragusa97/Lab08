package it.polito.tdp.dizionariograph;

	import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;

	public class DizionarioGraphController {
		Model model=new Model();

	    @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="txtLettere"
	    private TextField txtLettere; // Value injected by FXMLLoader

	    @FXML // fx:id="txtParola"
	    private TextField txtParola; // Value injected by FXMLLoader

	    @FXML // fx:id="btnGrafo"
	    private Button btnGrafo; // Value injected by FXMLLoader

	    @FXML // fx:id="btnTrova"
	    private Button btnTrova; // Value injected by FXMLLoader

	    @FXML // fx:id="btnGradoMax"
	    private Button btnGradoMax; // Value injected by FXMLLoader

	    @FXML // fx:id="txtResult"
	    private TextArea txtResult; // Value injected by FXMLLoader

	    @FXML // fx:id="btnReset"
	    private Button btnReset; // Value injected by FXMLLoader

	    @FXML
	    void doGradoMax(ActionEvent event) {
           if(btnGradoMax.isArmed())
        	   txtResult.clear();
        	   txtResult.appendText(model.parolaMax()+"  "+model.findMaxDegree());
	    }

	    @FXML
	    void doGrafo(ActionEvent event) {
            if(btnGrafo.isArmed()) {
            	txtResult.clear();
            	Graph<String,DefaultEdge> grafo=model.createGraph(Integer.parseInt(txtLettere.getText()));
                for(String s:grafo.vertexSet())
            	txtResult.appendText(s+"\n");
            }
	    }

	    @FXML
	    void doReset(ActionEvent event) {
           txtResult.clear();
           txtParola.clear();
           txtLettere.clear();
	    }

	    @FXML
	    void doTrova(ActionEvent event) {
            if(btnTrova.isArmed()) {
            	txtResult.clear();
            	if(txtParola.getText().length()!=Integer.parseInt(txtLettere.getText()))
            	   txtResult.appendText("inserimento non valido");
            	else {
            	   txtResult.clear();
            	   List<String> result=model.displayNeighbours(txtParola.getText());
            	   for(String s:result)
            		  txtResult.appendText(s+"\n");
            	}
            }
	    }

	    @FXML // This method is called by the FXMLLoader when initialization is complete
	    void initialize() {
	        assert txtLettere != null : "fx:id=\"txtLettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnGrafo != null : "fx:id=\"btnGrafo\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnTrova != null : "fx:id=\"btnTrova\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnGradoMax != null : "fx:id=\"btnGradoMax\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
	        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

	    }

		public void setModel(Model model) {
			this.model = model;
		}
	    
	}

	

