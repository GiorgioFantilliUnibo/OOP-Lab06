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
	
	private enum Color {
		WHITE, GREY, BLACK;
	}
	
	private class BFS {
		
	}
}
