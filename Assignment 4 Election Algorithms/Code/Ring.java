import java.util.Scanner;

class Process
{
	int processId;
	boolean active;
	public Process(int processId) {
		this.processId=processId;
		this.active=true;
	}
}

public class Ring {
	private Scanner consoleInput;
	private Process[] process;
	private int NosofProcess;

	public Ring() {
		consoleInput= new Scanner(System.in);
	}

	public void getInput() {
		System.out.println("Enter the number of processes : ");
		NosofProcess=consoleInput.nextInt();
		process= new Process[NosofProcess];
		for(int i=0;i<NosofProcess;i++) {
			System.out.println("Enter the pid for process "+ (i+1) +" : ");
			int pid= consoleInput.nextInt();
			process[i]= new Process(pid);
		}
		sortProcess();
		putOutput();
	}

	public void sortProcess()
	{
		for(int i=0;i<NosofProcess-1;i++) {
			for(int j = 0; j < (NosofProcess - 1 - i); j++) {
				if(process[j].processId > process[j+1].processId) {
					int temp = process[j].processId;
					process[j].processId = process[j+1].processId;
					process[j+1].processId = temp;
				}
			}
		}
	}

	public void putOutput() {
        System.out.println("\n--------------------------\n~ Status for processes ~\n--------------------------");
		for(int i = 0; i < NosofProcess; i++) {
			System.out.print("Process " + process[i].processId+" - active : "+process[i].active);
			System.out.print("\n");
		}
		System.out.print("--------------------------\n");
	}

    public int getMax() {
        int max = 0, indexofMax = 0;
        for(int i = 0; i < NosofProcess; i++) {
            if(process[i].active && max <= process[i].processId) {
                max = process[i].processId;
                indexofMax = i;
            }
        }
        return indexofMax;
    }

    public void conductElection() {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("------------------------------------\nProcess "+process[getMax()].processId+" becomes Coordinator\n------------------------------------");

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Process "+ process[getMax()].processId+" has Resigned\n------------------------------------\n");
        process[getMax()].active=false;
        
        while(true)
        {
            int initProcess, i, flag = 0;
            System.out.println("~ Conduct an Election: yes or exit ~");
            String choice= consoleInput.next();
            choice = choice.toLowerCase();
            if(choice.equals("yes")) {
                do {
		            putOutput();
                    System.out.println("Enter the process to lead Election : ");
                    initProcess=consoleInput.nextInt();
                    for(i=0;i<NosofProcess;i++) {
                        if(process[i].processId==initProcess) {
                            initProcess=i;
                            flag = 1;
                            break;
                        }
                    }
                    if(process[i].active) {
                        break;
                    }
                    else
                        System.out.println("Warning: Process has either Resigned or Not Registered yet!");
                }while(true);
                
                int prev=initProcess;
                int next=prev+1;
                while(true)
                {
                    if(process[next].active) {
                        System.out.println("Process "+process[prev].processId+" sends message to Process "+process[next].processId);
                        prev=next;
                    }
                    next = (next + 1) % NosofProcess;
                    if(next == initProcess)
                        break;
                }
                NosofProcess--;
                System.out.println("------------------------------------\nProcess "+process[getMax()].processId+" becomes Coordinator\n------------------------------------");
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("Process "+ process[getMax()].processId+" has Resigned\n------------------------------------\n");
                process[getMax()].active=false;
                
                if(NosofProcess == 0) {
                    System.out.println("No Process!");
                    System.exit(0);
                }
            }
            else
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Ring ringelection= new Ring();
        ringelection.getInput();
        ringelection.conductElection();
    }
}


