package CS486AI.A1Q3;

import java.util.LinkedList;

public class Node implements Comparable<Node> {
	private LinkedList<City> nodePath;
	private double totalCost;
	
	public Node(){
		// create a nodePath LL to store cities
		nodePath = new LinkedList<City>();
	}

	public double getTotalCost() {
		return this.totalCost;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public LinkedList<City> getNodePath() {
		return nodePath;
	}

	public LinkedList<Node> generateNeighbours(LinkedList<City> cityList){
		LinkedList<Node> neighbours = new LinkedList<Node>();
		
		for (int i = 0; i < cityList.size(); i++){
			City city = cityList.get(i);
			if (!nodePath.contains(city)){
				Node node = new Node();
				
				for (int j = 0; j < nodePath.size();j++){
					City newCity = nodePath.get(j);
					node.nodePath.add(newCity);
				}
				node.getNodePath().add(city);
				// Update neighbors
				neighbours.add(node);
			}
		}
		return neighbours;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		int result = Double.compare(this.totalCost, o.getTotalCost());
		// remove any negative sign produced by the comparison
		result = result*-1;
		return result;
	}
	




}


