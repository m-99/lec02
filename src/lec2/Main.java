package lec2;

public class Main {

	public static void main(String[] args) {

		double milesToTravel = 2.0;

		double uberBasePrice = 2.00;
		double lyftBasePrice = 2.00;
		double uberRate = 1.24;
		double lyftRate = 1.22;
		double uberServiceFee = 1.15;
		double lyftServiceFee = 1.70;

		// TODO #1: move this calculation to an `estimateRidePrice` method
		double uberPrice = uberBasePrice + uberServiceFee + uberRate * milesToTravel;
		double lyftPrice = lyftBasePrice + lyftServiceFee + lyftRate * milesToTravel;

		double difference;

		if (uberPrice > lyftPrice) {
			difference = uberPrice - lyftPrice;
			System.out.printf("You should take a Lyft. You saved $%.2f!\n", difference);
		} else if (lyftPrice > uberPrice) {
			difference = lyftPrice - uberPrice;
			System.out.printf("You should take a Uber. You saved $%.2f!\n", difference);
		} else {
			System.out.println("You can take either an Uber or a Lyft.");
		}

		// TODO #2: create and populate an array

	}
}
