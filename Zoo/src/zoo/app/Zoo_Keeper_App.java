package zoo.app;


import java.util.ArrayList;
import java.util.List;

import zoo.animal.*;

public class Zoo_Keeper_App {

	private static List<Animal> animals = new ArrayList<Animal>();

	public static void main(String[] args) throws Exception {

		try {
			
			Chicken c1 = new Chicken();
			Chicken c2 = new Chicken("12-12-2012", (float) 1.1);
			Chicken c3 = new Chicken("12-12-2012", (float) 1.2, (float) 1.3);
		
			Sparrow s1 = new Sparrow();
			Sparrow s2 = new Sparrow("12-12-2012", (float) 2.1);
			Sparrow s3 = new Sparrow("12-12-2012", (float) 2.2, (float) 2.3);
			
			FlyingFish ff1 = new FlyingFish();
			FlyingFish ff2 = new FlyingFish("12-12-2012", (float) 3.2);
			FlyingFish ff3 = new FlyingFish("12-12-2012", (float) 3.3, (String) "SALT");
			
			Guppy g1 = new Guppy();
			Guppy g2 = new Guppy("12-12-2012", (float) 4.1);
			Guppy g3 = new Guppy("12-12-2012", (float) 4.2, (String) "FRESH");

			animals.add(c1);
			animals.add(c2);
			animals.add(c3);

			animals.add(s1);
			animals.add(s2);
			animals.add(s3);

			animals.add(ff1);
			animals.add(ff2);
			animals.add(ff3);
			
			animals.add(g1);
			animals.add(g2);
			animals.add(g3);

			System.out.println(c1);
			System.out.println(c2);
			System.out.println(c3);
			System.out.println("=================================");
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println("=================================");
			System.out.println(ff1);
			System.out.println(ff2);
			System.out.println(ff3);
			System.out.println("=================================");
			System.out.println(g1);
			System.out.println(g2);
			System.out.println(g3);


			
		} catch (Exception e) {
			System.out.println("The following error has occurred: ");
			System.out.println(e.getMessage());
			
		}
	}

}


//git token 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