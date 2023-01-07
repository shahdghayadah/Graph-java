import java.io.File;
		import java.io.FileNotFoundException;
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.HashSet;
		import java.util.Map;
		import java.util.Scanner;
		import java.util.Set;



public class newMai {
	public static void main(String[] args) {

		

	}
	public static <V,E> boolean isCyclic(Graph<V,E> g, Vertex<V> u, Set<Vertex<V>> known) {
		      known.add(u); 
		      for (Edge<E> e : g.outgoingEdges(u)) { 
		          Vertex<V> v = g.opposite(u, e);
		          if(known.contains(v)) {
		        	  return true;
		          }
		          else if (!known.contains(v)&&isCyclic(g, v, known )) {
		        	  return true; 
		            }
		          
		        }
			return false;
		    }
	
	public static int connectedComponents(Graph<String,String> g) {
		Set<Vertex<String>> known2 = new HashSet<>();
		Map<Vertex<String>,Edge<String>> forest = new HashMap<>();
		int counter=0;
		for (Vertex<String> u : g.vertices( )) {

			 if (!known2.contains(u)) {
				 counter++;
				 DFS(g, u, known2, forest);
			 }
		}
		return counter;
		
	}

	public static <V,E> void DFS(Graph<V,E> g, Vertex<V> u,
		      Set<Vertex<V>> known, Map<Vertex<V>,Edge<E>> forest) {
		      known.add(u); 
		      for (Edge<E> e : g.outgoingEdges(u)) { 
		          Vertex<V> v = g.opposite(u, e);
		          if (!known.contains(v)) {
		              forest.put(v, e); 
		              DFS(g, v, known, forest); 
		            }
		        }
		    }
	public static <V> String printPath(Graph<String,String> g,Set<Vertex<String>> known,Vertex<String> vert, Vertex<String> wanted,StringBuilder st) {
		known.add(vert);
		
		for (Edge<String> e : g.outgoingEdges(vert)) {
			 Vertex<String> v =g.opposite(vert, e);
			 if(v==wanted &&!known.contains(v)) {
				 st.append("--> "+wanted.getElement()) ;
			 	return st.toString();
			}else if(v!=wanted &&!known.contains(v)) {
				st.append("--> "+v.getElement());
				return printPath(g,known,v,  wanted,st);
			}
		}
		return null;
		
	}
	public static <V> boolean isDirectly(Graph<String,String> g,Vertex<String> vert, Vertex<String> wanted) {
		
		for (Edge<String> e : g.outgoingEdges(vert)) {
			if(g.opposite(vert, e)==wanted) {
				return true;
			}
		}
		for (Edge<String> e : g.incomingEdges(vert)) {
			if(g.opposite(vert, e)==wanted) {
				return true;
				}
		}
		return false;
		
	}
	
	public static <V> boolean check(Set<Vertex<String>> list, Vertex<String> wanted) {
		if (list.contains(wanted))
			return true;
		else
			return false;
	}
	
			
		}