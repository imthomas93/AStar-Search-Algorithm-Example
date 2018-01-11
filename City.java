package CS486AI.A1Q3;

public class City {
	private String cityName;
	private int x;
	private int y;
	
	public static double traversalCost(City a, City b){
		double x = a.getX() - b.getX();
		double y = a.getY() - b.getY();
		double cost =  Math.sqrt(x*x + y*y);
		return cost;
	}
	
	public String getName() {
		return cityName;
	}

	public City(String cityName, int x, int y){
		this.cityName = cityName;
		this.x = x;
		this.y = y;
	}
	
	public void setName(String cityName) {
		this.cityName = cityName;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void toPrint(){
		System.out.println(this.cityName + " " + this.x + " " + this.y);
	}
		
}
