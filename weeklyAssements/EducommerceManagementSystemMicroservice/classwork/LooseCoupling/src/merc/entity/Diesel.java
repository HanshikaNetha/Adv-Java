package merc.entity;

public class Diesel implements Engine{
	@Override
	public void run() {
		System.out.println("diesel engine running");
	}
}
