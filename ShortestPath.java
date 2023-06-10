package dijkstra.ShortestPath;

// Algoritmo de Dijkstra: caminho mais curto
// aplicado a grafos armazenados em uma matriz de adjac�ncias.

import java.util.*; 
import java.lang.*; 
import java.io.*; 

class ShortestPath { 
	// Uma fun��o utilit�ria para encontrar o v�rtice com valor de dist�ncia m�nima, 
	// a partir de um conjunto de v�rtices ainda n�o inclu�dos na �rvore de caminho mais curto. 
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

	// Uma fun��o utilit�ria para escrever o array de dist�ncias percorridas
	void escrevaSolucao(int dist[]) 
	{ 
		System.out.println("V�rtice \t Distancia a partir da Origem: "); 
		for (int i = 0; i < V; i++) 
			System.out.println(i + " \t " + dist[i]); 
	} 

	// Funcao que implementa Dijkstra's single source shortest path Algorithm
	// algoritmo para um grafo representado usando matriz de adjacencias
	
	void dijkstra(int grafo[][], int origem){ 
		int distancia[] = new int[V]; // A sa�da do array. distancia[i] ser� guardada 
		// a dist�ncia mais curta da origem ate i  

		// sptSet[i] ser� true se o vertice i estiver inclu�do na �rvore de caminho + curto 
		// ou a dist�ncia mais curta da origem (src) at� i est� finalizada 
		Boolean sptSet[] = new Boolean[V]; 

		// Inicialize todas as distancias como INFINITE e stpSet[] como false 
		for (int i = 0; i < V; i++) { 
			distancia[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
		} 

		// Distancia do vertice origem at� a si mesmo � sempre 0 
		distancia[origem] = 0; 

		// Encontre o caminho mais curto para todos os v�rtices 
		for (int count = 0; count < V - 1; count++) { 
			// Escolha o vertice de distancia minima a partir do conjunto de v�rtices 
			// ainda n�o processados. u � sempre igual a origem (src) na primeira itera��o.
			
			int u = minDistancia(distancia, sptSet); 

			// Marque o v�rtice escolhido como  processado 
			sptSet[u] = true; 

			// Atualize o valor dist value do vertice adjacente ao vertice escolhido 
			for (int v = 0; v < V; v++) 

				// Atualize dist[v] somente se n�o esta em sptSet, existe uma aresta de u ate v,
				// and o peso total do caminho da origem at� v passando por u � menor que 
				// o valor atual de dist[v] 
				if (!sptSet[v] && grafo[u][v] != 0 && distancia[u] != Integer.MAX_VALUE && distancia[u] + grafo[u][v] < distancia[v]) 
					distancia[v] = distancia[u] + grafo[u][v]; 
		} 

		// escreva o vetor de distancias construido 
		escrevaSolucao(distancia); 
	} 
 
	public static void main(String[] args) 
	{ 
		/* Vamos criar o grafo do exemplo constru�do acima*/
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
//Este c�digo � uma contribui��o de Aakash Hasija 
