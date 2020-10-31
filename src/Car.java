
public class Car {

	

		    int speed = 0;

		    int gear = 1;

		 

		    //a class variable

		    static int numberOfCars = 0;

		   

		    public Car(){

		      //code to create car goes here

		    }

		 

		    public static int getNumberOfCars() {

		        return numberOfCars;

		    }

		 

		    public int getSpeed(){

		      return speed;

		    }

		    public int getGear(){

		      return gear;

		    }

		    public void setSpeed(int x){

		      speed = x;

		    }

		    public void setGear(int y){

		      gear = y;

		    }

		  }




