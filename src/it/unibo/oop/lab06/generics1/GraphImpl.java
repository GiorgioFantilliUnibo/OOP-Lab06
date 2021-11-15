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
	 * {@inheritDocg}
	 */
	@Override
	public void addEdge(Object source, Object target) {
		// TODO Auto-generated method stub
		
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

}
