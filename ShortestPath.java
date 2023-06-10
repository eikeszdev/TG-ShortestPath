package dijkstra.ShortestPath;

// Algoritmo de Dijkstra: caminho mais curto
// aplicado a grafos armazenados em uma matriz de adjacências.

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class ShortestPath { 
	// Uma função utilitária para encontrar o vértice com valor de distância mínima, 
	// a partir de um conjunto de vértices ainda não incluídos na árvore de caminho mais curto. 
	static final int V = 9; 
	
	int minDistancia(int dist[], Boolean sptSet[]) 
	{ 
		// Inicialize o valor min  
		int min = Integer.MAX_VALUE, min_index = -1; 

		for (int v = 0; v < V; v++) 
			if (sptSet[v] == false && dist[v] <= min) { 
				min = dist[v]; 
				min_index = v; 
			} 
		return min_index; 
	} 

	// Uma função utilitária para escrever o array de distâncias percorridas
	void escrevaSolucao(int dist[]) 
	{ 
		System.out.println("Vértice \t Distancia a partir da Origem: "); 
		for (int i = 0; i < V; i++) 
			System.out.println(i + " \t " + dist[i]); 
	} 

	// Funcao que implementa Dijkstra's single source shortest path Algorithm
	// algoritmo para um grafo representado usando matriz de adjacencias
	
	void dijkstra(int grafo[][], int origem){ 
		int distancia[] = new int[V]; // A saída do array. distancia[i] será guardada 
		// a distância mais curta da origem ate i  

		// sptSet[i] será true se o vertice i estiver incluído na árvore de caminho + curto 
		// ou a distância mais curta da origem (src) até i está finalizada 
		Boolean sptSet[] = new Boolean[V]; 

		// Inicialize todas as distancias como INFINITE e stpSet[] como false 
		for (int i = 0; i < V; i++) { 
			distancia[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
		} 

		// Distancia do vertice origem até a si mesmo é sempre 0 
		distancia[origem] = 0; 

		// Encontre o caminho mais curto para todos os vértices 
		for (int count = 0; count < V - 1; count++) { 
			// Escolha o vertice de distancia minima a partir do conjunto de vértices 
			// ainda não processados. u é sempre igual a origem (src) na primeira iteração.
			
			int u = minDistancia(distancia, sptSet); 

			// Marque o vértice escolhido como  processado 
			sptSet[u] = true; 

			// Atualize o valor dist value do vertice adjacente ao vertice escolhido 
			for (int v = 0; v < V; v++) 

				// Atualize dist[v] somente se não esta em sptSet, existe uma aresta de u ate v,
				// and o peso total do caminho da origem até v passando por u é menor que 
				// o valor atual de dist[v] 
				if (!sptSet[v] && grafo[u][v] != 0 && distancia[u] != Integer.MAX_VALUE && distancia[u] + grafo[u][v] < distancia[v]) 
					distancia[v] = distancia[u] + grafo[u][v]; 
		} 

		// escreva o vetor de distancias construido 
		escrevaSolucao(distancia); 
	} 
 
	public static void main(String[] args) 
	{ 
		/* Vamos criar o grafo do exemplo construído acima*/
		int grafo[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
									{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
									{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
									{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
									{ 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
									{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
									{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
									{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
									{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 

		//System.out.println("Integer.MAX_VALUE: 2147483647" +Integer.MAX_VALUE);							
		ShortestPath t = new ShortestPath(); 
		t.dijkstra(grafo, 0); 
	} 
} 
//Este código é uma contribuição de Aakash Hasija 
