package driver;
import java.util.Scanner;
import merc.entity.*;
public class DriverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Petrol engine\n2.Diesel Engine");
		System.out.print("Enter ur choice: ");
		int choice=sc.nextInt();
		//eager instantiation
//		Car car=new Car();
		Engine engine=null; 
		switch(choice) {
		case 1:
			//lazy instantiation
			engine=new Petrol();
			break;
		case 2:
			engine=new Diesel();
			break;
		}
		//field injection
//		car.e=engine;
//		car.e.run();
//		System.out.println(car.e.getClass());
		
		//setter injecttion
//		car.setEngine(engine);
//		car.getEngine().run();
//		System.out.println(car.getEngine().getClass());
		
		//constructor injection
		Car car=new Car(engine);
		car.getEngine().run();
		System.out.println(car.getEngine().getClass());
	}

}
