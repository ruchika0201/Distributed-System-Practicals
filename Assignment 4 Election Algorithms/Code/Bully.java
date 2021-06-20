import java.util.Scanner;

public class Bully {
	static boolean[] state= new boolean[7];
	int coordinator;
	
	public static void up(int up)
	{
		if(state[up]==true)
			System.out.println("process "+up+" is already up");
		else
		{
			state[up]=true;
			System.out.println("Process "+up+" is up");
		}
	}
	public static void down(int d)
	{
		if(!state[d])
			System.out.println("process "+d+" is already down");
		else
		{
			state[d]=false;
			System.out.println("process "+d+" is down");
		}
	}
	
	public static void mess(int m)
	{
		if(!state[m])
			System.out.println("process "+m+" is down");
		else
		{
			System.out.println("Process "+m+" held election");
			for(int i=m;i<6;i++)
				System.out.println("Election message sent from process "+m+" to process "+(i+1));
			
			for(int i=m;i<6;i++)
				if(state[i+1])
					System.out.println("Alive message sent from process "+(i+1)+" to process "+(m));
			for(int i=6;i>=m;i--)
			{
				if(state[i])
				{
					System.out.println("Co-ordinator is:-"+i);
					break;
				}
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,choice;
		for(i=0;i<=6;i++)
			Bully.state[i]=true;
		System.out.println("Processes p0 p1 p2 p3 p4 p5 p6 are up");
		System.out.println("Process 6 is co-ordinator");
		do {
			System.out.println("\nEnter your choice:");
			System.out.println("1.Bring up process");
			System.out.println("2.Bring down process");
			System.out.println("3.Send a message");
			System.out.println("4.Exit");
			Scanner sc = new Scanner(System.in);
			choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("\nEnter the process number: ");
				int up=sc.nextInt();
				Bully.up(up);
				break;
			case 2:
				System.out.println("\nEnter the process number: ");
				int d=sc.nextInt();
				Bully.down(d);
				break;
			case 3:
				System.out.println("\nWho will start election?: ");
				int mess=sc.nextInt();
				Bully.mess(mess);
				break;

			default:
				break;
			}
			
		} while (0<choice&& choice<4);
		

	}

}

/* 0 U 7 P U 7
a3-403-04@a340304-OptiPlex-5060:~/4915cl9/4$ javac Bully.java
a3-403-04@a340304-OptiPlex-5060:~/4915cl9/4$ java Bully 
Processes p0 p1 p2 p3 p4 p5 p6 are up
Process 6 is co-ordinator

Enter your choice:
1.Bring up process
2.Bring down process
3.Send a message
4.Exit
3

Who will start election?: 
3
Process 3 held election
Election message sent from process 3 to process 4
Election message sent from process 3 to process 5
Election message sent from process 3 to process 6
Alive message sent from process 4 to process 3
Alive message sent from process 5 to process 3
Alive message sent from process 6 to process 3
Co-ordinator is:-6

Enter your choice:
1.Bring up process
2.Bring down process
3.Send a message
4.Exit
2

Enter the process number: 
4
process 4 is down

Enter your choice:
1.Bring up process
2.Bring down process
3.Send a message
4.Exit
2

Enter the process number: 
1
process 1 is down

Enter your choice:
1.Bring up process
2.Bring down process
3.Send a message
4.Exit
3

Who will start election?: 
0
Process 0 held election
Election message sent from process 0 to process 1
Election message sent from process 0 to process 2
Election message sent from process 0 to process 3
Election message sent from process 0 to process 4
Election message sent from process 0 to process 5
Election message sent from process 0 to process 6
Alive message sent from process 2 to process 0
Alive message sent from process 3 to process 0
Alive message sent from process 5 to process 0
Alive message sent from process 6 to process 0
Co-ordinator is:-6

Enter your choice:
1.Bring up process
2.Bring down process
3.Send a message
4.Exit
1

Enter the process number: 
4
Process 4 is up

Enter your choice:
1.Bring up process
2.Bring down process
3.Send a message
4.Exit
3

Who will start election?: 
0
Process 0 held election
Election message sent from process 0 to process 1
Election message sent from process 0 to process 2
Election message sent from process 0 to process 3
Election message sent from process 0 to process 4
Election message sent from process 0 to process 5
Election message sent from process 0 to process 6
Alive message sent from process 2 to process 0
Alive message sent from process 3 to process 0
Alive message sent from process 4 to process 0
Alive message sent from process 5 to process 0
Alive message sent from process 6 to process 0
Co-ordinator is:-6

Enter your choice:
1.Bring up process
2.Bring down process
3.Send a message
4.Exit
4
*/
