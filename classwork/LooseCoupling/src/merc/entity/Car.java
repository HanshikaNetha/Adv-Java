package merc.entity;

public class Car {
	private Engine e;
	public Car() {
		
	}
	public Car(Engine e) {
		this.e=e;
	}
	public Engine getEngine() {
		return e;
	}
	public void setEngine(Engine e) {
		this.e=e;
	}
}
