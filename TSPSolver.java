package CS486AI.A1Q3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class TSPSolver {

	private static LinkedList<City> cityList = new LinkedList<City>();
	private static int noOfCities;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//printCity();
		
		loadCity(13,9);
		
		//load36Cities();
		
		AStarSearch aStar = new AStarSearch(cityList);
		Node root = new Node();
		root.getNodePath().add(cityList.getFirst());
		
		Node goal;
		// USE THIS TO GET STATS RESULT
		//Node goal = aStar.TSPSearch2(root);
		
		// USE THIS TO VIEW RESULT
		goal = aStar.TSPsearch(root);
		
		aStar.getSolution(goal);
		System.out.print("\nCities : " + noOfCities + ", ");
		aStar.printCounter();
	}

	@SuppressWarnings("unused")
	private static void load36Cities() {
		// TODO Auto-generated method stub
		try{
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("CS486AI/A1Q3/randTSP/problem36"));
			String output = reader.readLine();
			noOfCities = Integer.parseInt(output);
			
			output  = reader.readLine();
			while( output != null) {
				StringTokenizer defaultTokenizer = new StringTokenizer(output);
				output = reader.readLine();
				String cityName = defaultTokenizer.nextToken();;
				int x,y;
				x = Integer.parseInt(defaultTokenizer.nextToken());
				y = Integer.parseInt(defaultTokenizer.nextToken());
	
				City newCity = new City(cityName, x, y);
				cityList.add(newCity);
			}			
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}


	@SuppressWarnings("unused")
	private static void printCity() {
		// TODO Auto-generated method stub
		for (int i = 0; i < cityList.size(); i++){
			City city = cityList.get(i);
			city.toPrint();
		}
	}

	private static void loadCity(int folder, int instance) {

		// TODO Auto-generated method stub
		try{

			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("CS486AI/A1Q3/randTSP/" + folder + "/instance_" + instance + ".txt"));
			String output = reader.readLine();
			noOfCities = Integer.parseInt(output);
			
			output  = reader.readLine();
			while( output != null) {
				StringTokenizer defaultTokenizer = new StringTokenizer(output);
				output = reader.readLine();
				String cityName = defaultTokenizer.nextToken();;
				int x,y;
				x = Integer.parseInt(defaultTokenizer.nextToken());
				y = Integer.parseInt(defaultTokenizer.nextToken());

				City newCity = new City(cityName, x, y);
				cityList.add(newCity);
			}			
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
