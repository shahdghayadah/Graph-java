
public class Main {
	public static void main(String[] args) {
		 
		AdjacencyMapGraph <Airport,Flight>  graph = new AdjacencyMapGraph<>(true);
		
		////////////
		Vertex SFO =    graph.insertVertex(new Airport("SFO") );
		Vertex LAX =	graph.insertVertex(new Airport("LAX") );
		Vertex ORD =	graph.insertVertex(new Airport("ORD") );
		Vertex DFW =	graph.insertVertex(new Airport("DFW") );
		Vertex JFK =	graph.insertVertex(new Airport("JFK") );
		Vertex BOS =	graph.insertVertex(new Airport("BOS") );
		Vertex MIA =	graph.insertVertex(new Airport("MIA") );
		///////////
		Edge g=	graph.insertEdge(JFK, SFO, new Flight("SW 45"));
		graph.insertEdge(LAX, ORD, new Flight("UA 120"));
		graph.insertEdge(ORD, DFW, new Flight("UA 877"));
		graph.insertEdge(DFW, ORD, new Flight("DL 335"));
		graph.insertEdge(DFW, LAX, new Flight("AA 49"));
		graph.insertEdge(MIA, LAX, new Flight("AA 411"));
		
		graph.insertEdge(MIA, DFW, new Flight("AA 523"));
		graph.insertEdge(JFK, DFW, new Flight("AA 1387"));
		graph.insertEdge(BOS, JFK, new Flight("NW 35"));
		graph.insertEdge(BOS, MIA, new Flight("DL 247"));
		graph.insertEdge(JFK, MIA, new Flight("AA 903"));
		
		graph.removeEdge(g);
		
		System.out.println(graph.toString());
	}

}