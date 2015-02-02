package com.dolan.algorithm;

import java.util.List;

import com.dolan.graph.node.Coordinate;
import com.dolan.graph.node.INode;

public class TravellingSalesmanAlgorithm implements
		ITravellingSalesmanAlgorithm {

	public TravellingSalesmanAlgorithm() {

	}

	@Override
	public void optimisePath(List<INode> path) {
		int currentPathSize = estimatePath(path);
		for (int i = 0; i < path.size(); i++) {
			for (int j = 0; j < path.size(); j++) {
				int pathSize = estimatePath(path);
				if (pathSize > currentPathSize) {
					// swap back
				}
			}
		}
	}

	private int estimateTimeTravel(INode node1, INode node2) {
		Coordinate coordinate1 = node1.getCoordinate();
		Coordinate coordinate2 = node2.getCoordinate();

		int xDifference = Math.abs(coordinate1.x - coordinate2.x);
		int yDifference = Math.abs(coordinate1.y - coordinate2.y);

		return xDifference + yDifference;
	}

	private int estimatePath(List<INode> path) {
		int totalCost = 0;
		for (int i = 0; i < path.size() - 1; i++) {
			totalCost += this.estimateTimeTravel(path.get(i), path.get(i + 1));
		}
		return totalCost;
	}

}