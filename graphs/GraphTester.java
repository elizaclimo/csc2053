import java.util.ArrayDeque;
import java.util.Queue;

public class GraphTester {
	
	
	/**
	 * Returns true if a path exists on graph, from startVertex to endVertex; 
	 * otherwise returns false. Uses breadth-first search algorithm.
	 * @param graph
	 * @param startVertex
	 * @param endVertex
	 * @return
	 */
	private static boolean isPathBF(GraphInterface<String> graph,
			String startVertex, 
			String endVertex    ) {
		
		Queue<String> queue = new ArrayDeque<String>();
		Queue<String> vertexQueue = new ArrayDeque<String>();

		boolean found = false;
		String currVertex;      // vertex being processed
		String adjVertex;       // adjacent to currVertex

		graph.clearMarks();
		graph.markVertex(startVertex);
		queue.add(startVertex);

		do
		{
			currVertex = queue.remove();
			// System.out.println(currVertex);
			if (currVertex.equals(endVertex))
				found = true;
			else
			{
				vertexQueue = graph.getToVertices(currVertex); 
				while (!vertexQueue.isEmpty())
				{
					adjVertex = vertexQueue.remove();
					if (!graph.isMarked(adjVertex))
					{
						graph.markVertex(adjVertex);
						queue.add(adjVertex);
					}
				}
			}
		} while (!queue.isEmpty() && !found);

		return found;
	}


	public static void main(String[] args) {

		UndirectedGraph<String> graph = new UndirectedGraph<>();
		
		graph.addVertex("Bob");
		graph.addVertex("Cynthia");
		graph.addVertex("Alex");
		graph.addVertex("Kevin");
		graph.addVertex("George");
		
		//Who are Bob's friends?
		System.out.println("Bob's friends are "+);
		//Who are Alex's friends?
		System.out.println("Alex's friends are "+);
		//Who are George's friends?
		System.out.println("Georges's friends are "+);
		//Are Jack and Cathy indirect friends?
		System.out.println("Are Jack and Cathy indirect friends?: "+);
		//Are Jack and George indirect friends?
		System.out.println("Are Jack and George indirect friends?: "+);

	}

}
