import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Towers x = new Towers();
		ArrayList<Integer> ad;
		
	
		Scanner keyboard = new Scanner(System.in);
		boolean z=false;
		while(z==false) {
		System.out.print("How many rings do you want");
		int rings=keyboard.nextInt();
		x.setTower(rings);
		System.out.print("Do you want the computer to play?");
		Boolean d = keyboard.nextBoolean();
		
		boolean n = false;
		
		if (d == true) {
			System.out.println(x);
			while (n == false) {
				
				if (x.getCount() % 2 == 1) {
					x.makeMove(0, 1, true);
					System.out.println(x);
					if (x.isSolved() == true) {
						n=true;
						System.out.println("done");
						break;
					}
					pause();
					x.makeMove(0, 2, true);
					System.out.println(x);
					if (x.isSolved() == true) {
						n=true;
						System.out.println("done");
						break;
					}
					pause();
					x.makeMove(1, 2, true);
					System.out.println(x);
					if (x.isSolved() == true) {
						n=true;
						System.out.println("done");
						break;
					}
					pause();
				}

				else {
					x.makeMove(0, 2, true);
					System.out.println(x);
					if (x.isSolved() == true) {
						n=true;
						System.out.println("done");
						break;
					}
					pause();
					x.makeMove(0, 1, true);
					System.out.println(x);
					if (x.isSolved() == true) {
						n=true;
						
						System.out.println("done");
						break;
					}
					pause();
					x.makeMove(1, 2, true);
					System.out.println(x);
					if (x.isSolved() == true) {
						n=true;
						System.out.println("done");
						break;
					}
					pause();
				}
				if (x.isSolved() == true) {
					n=true;
					System.out.println("done");
				}
				

			}
			x.reset();
			
		}
		else {
			System.out.println(x);
			while(x.isSolved()==false) {
			System.out.println("Enter the tower of which you want to remove from");
			int move1=keyboard.nextInt();
			System.out.println("Enter the tower of which you want to add to");
			int move2=keyboard.nextInt();
			if(x.makeMove(move1, move2, false)==false)
				System.out.println("Invalid move, move again");
			else
				x.makeMove(move1, move2, false);
			System.out.println(x);
			}
			if(x.isSolved())
			System.out.println("you win!");
			x.reset();
		}
		System.out.println("Do you want to play again?");
		Boolean e= keyboard.nextBoolean();
		if(e==false)
			break;

	}
	}
	public static void pause()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}