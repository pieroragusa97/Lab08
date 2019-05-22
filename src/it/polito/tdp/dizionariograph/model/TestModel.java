package it.polito.tdp.dizionariograph.model;

import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		Graph<String,DefaultEdge> grafo=model.createGraph(4);
		Set<String> parole=grafo.vertexSet();
		System.out.println(String.format("**Grafo creato**\n"));
		System.out.println("parole con 4 lettere:" + parole + "\n");
		
		List<String> vicini = model.displayNeighbours("casa");
		System.out.println("Neighbours di casa: " + vicini + "\n");
		
		System.out.println("Cerco il vertice con grado massimo...");
		System.out.println(model.findMaxDegree());
		System.out.println("vertice con il grado massimo....");
		System.out.println(model.parolaMax());
	}

}
