import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMapGraph<V, E> implements Graph<V, E> {

	private boolean isDirected;
	private List<Vertex<V>> vertices = new ArrayList<>();
	private List<Edge<E>> edges = new ArrayList<>();

	/**
	 * Constructs an empty graph. The parameter determines whether this is an
	 * undirected or directed graph.
	 */
	public AdjacencyMapGraph(boolean directed) {
		isDirected = directed;
	}

	@Override
	public int numVertices() {
		// Auto-generated method stub
		return vertices.size();
	}

	@Override
	public int numEdges() {
		// Auto-generated method stub
		return edges.size();
	}

	@Override
	public Iterable<Vertex<V>> vertices() {
		// Auto-generated method stub
		//return (Iterable<Vertex<V>>) vertices.iterator();
		return vertices;
	}

	@Override
	public Iterable<Edge<E>> edges() {
		// Auto-generated method stub
		return edges;
	}

	@Override
	public int outDegree(Vertex<V> v) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerVertex<V> vert = (InnerVertex<V>) v;
		return vert.getOutgoing().size();
	}

	@Override
	public int inDegree(Vertex<V> v) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerVertex<V> vert = (InnerVertex<V>) v;
		return vert.getIncoming().size();
	}

	@Override
	public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerVertex<V> vert = (InnerVertex<V>) v;
		return vert.getOutgoing().values();
	}

	@Override
	public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerVertex<V> vert = (InnerVertex<V>) v;
		return vert.getIncoming().values();
	}

	@Override
	public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerVertex<V> vert = (InnerVertex<V>) u;
		return vert.getOutgoing().get(v);
	}

	@Override
	public Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerEdge<E> edge = (InnerEdge<E>) e;
		return edge.getEndpoints();
	}

	@Override
	public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerEdge<E> edge = (InnerEdge<E>) e;
		Vertex<V>[] endpoints = edge.getEndpoints();
		if (endpoints[0].equals(v))
			return endpoints[1];
		else
			return endpoints[0];
	}

	@Override
	public Vertex<V> insertVertex(V element) {
		// Auto-generated method stub
		InnerVertex<V> v = new InnerVertex<>(element, isDirected);
		vertices.add(v);
		return v;
	}

	@Override
	public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerVertex<V> vert1 = (InnerVertex<V>) u;
		InnerVertex<V> vert2 = (InnerVertex<V>) v; 
		if (getEdge(vert1, vert2) == null) {
			InnerEdge<E> e = new InnerEdge<>(u, v, element);
			vert1.getOutgoing().put(v, e);
			vert2.getIncoming().put(u, e);
			edges.add(e);
			return e;
		}
		return null;
	}

	@Override
	public void removeVertex(Vertex<V> v) throws IllegalArgumentException {
		// Auto-generated method stub
		InnerVertex<V> vert = (InnerVertex<V>) v;
		for (Edge<E> e : vert.getOutgoing().values()) {
			removeEdge(e);
		}
		for (Edge<E> e : vert.getIncoming().values()) {
			removeEdge(e);
		}
		vertices.remove(v);
	}

	@Override
	public void removeEdge(Edge<E> e) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		 InnerEdge<E> edge = (InnerEdge<E>)e;
	
		 edges.remove(edge);
		
		     
	}
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i =0;i<edges.size();i++) {
			InnerEdge<E> edg = (InnerEdge<E>)edges.get(i);
			s.append(edg.getElement()+" " +edg.getEndpoints()[0].getElement() +" from ==> to "+edg.getEndpoints()[1].getElement() +"\n");
		}
		return s.toString();
	}

	// ---------------- nested Vertex class ----------------
	/** A vertex of an adjacency map graph representation. */
	private class InnerVertex<V> implements Vertex<V> {
		private V element;
		private Map<Vertex<V>, Edge<E>> outgoing, incoming;

		/** Constructs a new InnerVertex instance storing the given element. */
		public InnerVertex(V elem, boolean graphIsDirected) {
			element = elem;
			outgoing = new HashMap<>();
			if (graphIsDirected)
				incoming = new HashMap<>();
			else
				incoming = outgoing; // if undirected, alias outgoing map
		}

		/** Returns the element associated with the vertex. */
		public V getElement() {
			return element;
		}

		/** Returns reference to the underlying map of outgoing edges. */
		public Map<Vertex<V>, Edge<E>> getOutgoing() {
			return outgoing;
		}

		/** Returns reference to the underlying map of incoming edges. */
		public Map<Vertex<V>, Edge<E>> getIncoming() {
			return incoming;
		}
	} // ------------ end of InnerVertex class ------------

	// ---------------- nested InnerEdge class ----------------
	/** An edge between two vertices. */
	private class InnerEdge<E> implements Edge<E> {
		private E element;
		private Vertex<V>[] endpoints;

		@SuppressWarnings({ "unchecked" })
		/** Constructs InnerEdge instance from u to v, storing the given element. */
		public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
			element = elem;
			endpoints = (Vertex<V>[]) new Vertex[] { u, v }; // array of length 2
		}

		/** Returns the element associated with the edge. */
		public E getElement() {
			return element;
		}

		/** Returns reference to the endpoint array. */
		public Vertex<V>[] getEndpoints() {
			return endpoints;
		}

	} // ------------ end of InnerEdge class ------------

	

}