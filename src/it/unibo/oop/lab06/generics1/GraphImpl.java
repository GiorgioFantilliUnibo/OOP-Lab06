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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDocg}
	 */
	@Override
	public Set<N> linkedNodes(Object node) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDocg}
	 */
	@Override
	public List<N> getPath(Object source, Object target) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void nodesExist(final N ... argNodes) {
		for (N node : argNodes) {
			if (!nodes.containsKey(node)) {
				throw new IllegalArgumentException("Node ["+ node +"] does not exist in the graph");
			}
		}
	}
}
