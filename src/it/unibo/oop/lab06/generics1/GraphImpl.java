package it.unibo.oop.lab06.generics1;

import java.util.*;


/**
 * {@inheritDocg}
 */
public class GraphImpl<N> implements Graph<N> {

	private final Map<N, Set<N>> nodes = new HashMap<>();
	
	/**
	 * {@inheritDocg}
	 */
	@Override
	public void addNode(final N node) {
		if (node != null) {
			nodes.putIfAbsent(node, new HashSet<N>());
		}
	}

	/**
     * Adds an edge: nothing happens if source or target are null.
     * 
     * @param source
     *            starting node
     * @param target
     *            ending node
     * @throws IllegalArgumentException
     * 			  if source or target does not exist in the graph
     */
	@Override
	public void addEdge(final N source, final N target) {
		if (source != null && target != null) {
			nodesExist(source, target);
			nodes.get(source).add(target);
		}
	}

	/**
	 * {@inheritDocg}
	 */
	@Override
	public Set<N> nodeSet() {
		return new HashSet<N>(nodes.keySet());
	}

	/**
     * Returns all the nodes directly targeted from a node.
     * 
     * @param node
     *            the node
     * @return all the nodes directly targeted from the passed node
     * @throws IllegalArgumentException
     * 			  if node do not exist in the graph
     */
	@Override
	public Set<N> linkedNodes(final N node) {
		nodesExist(node);
		return new HashSet<N>(nodes.get(node));
	}

	/**
	 * {@inheritDocg}
	 */
	@Override
	public List<N> getPath(final N source, final N target) {
		nodesExist(source, target);
		
		
		return null;
	}
	
	@SafeVarargs
	private void nodesExist(final N ... argNodes) {
		for (N node : argNodes) {
			if (!nodes.containsKey(node)) {
				throw new IllegalArgumentException("Node ["+ node +"] does not exist in the graph");
			}
		}
	}
	
	private int nNodes() {
		return nodes.size();
	}
	
	/**
	 * Statement of the nodes during the BFS search
	 */
	private enum Color {
		WHITE, GREY, BLACK;
	}
	
	/**
	 * Temporary support structure for the BFS search
	 */
	private class BFS<N> {
		
		private Map<N, Color> nodesState;
		private Map<N, Integer> distance;
		private Map<N, N> parent;
		
		/**
		 * @param n
		 * 		   number of nodes in the graph
		 */
		public BFS(final int n) {
			this.nodesState = new Color[n];
			this.distance = new int[n];
			this.parent = new Vector(n);
		}
		
	}
}
