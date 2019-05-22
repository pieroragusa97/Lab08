package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	Graph<String,DefaultEdge> grafo;
	
	
	public boolean confrontaParole(String s1,String s2) {
		int conta=0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)==s2.charAt(i))
				conta++;
		}
		if(conta==s1.length()-1)
			return true;
		return false;
	}

	public Graph<String,DefaultEdge> createGraph(int numeroLettere) {
	   grafo=new SimpleGraph<>(DefaultEdge.class);
       WordDAO dao=new WordDAO();
       List<String> parole=dao.getAllWordsFixedLength(numeroLettere);
       
       Graphs.addAllVertices(grafo, parole);
       for(String s:parole) {
    	   for(String t:parole) {
    		   if(confrontaParole(s,t)==true)
    			   grafo.addEdge(s, t);
    	   }
       }
       return grafo;
	}

	public List<String> displayNeighbours(String parolaInserita) {
       List<String> vicini=new ArrayList<String>();
       for(String s:grafo.vertexSet()) {
    	   if(confrontaParole(parolaInserita,s)==true) {
    		   vicini.add(s);
    	   }
       }
		return vicini;
	}

	public int findMaxDegree() {
		int gradoMax=0;
		int gradoParziale=0;
		for(String s:grafo.vertexSet()) {
			gradoParziale=this.displayNeighbours(s).size();
			if(gradoParziale>gradoMax)
				gradoMax=gradoParziale;
		}
		return gradoMax;
	}
	
	public String parolaMax() {
		int gradoMax=0;
		int gradoParziale=0;
		String parolaGradomax="";
		for(String s:grafo.vertexSet()) {
			gradoParziale=this.displayNeighbours(s).size();
			if(gradoParziale>gradoMax) {
				gradoMax=gradoParziale;
				parolaGradomax=s;
			}
		}
		
		return parolaGradomax;
	}
}
