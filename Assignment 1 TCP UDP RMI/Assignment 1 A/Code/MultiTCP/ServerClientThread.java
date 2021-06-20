import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

class ServerClientThread extends Thread {
  Socket serverClient;
  int clientNo;
  int squre;
  ServerClientThread(Socket inSocket,int counter){
    serverClient = inSocket;
    clientNo=counter;
  }
  public void run(){
    try{
      DataInputStream inStream = new DataInputStream(serverClient.getInputStream());
      DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
      String clientMessage="", serverMessage="";
      while(!clientMessage.equals("bye")){
        clientMessage=inStream.readUTF();
        System.out.println("From Client-" +clientNo+ ": Equation received is :"+clientMessage);
        int result; 
        StringTokenizer st = new StringTokenizer( clientMessage); 

		int oprnd1 = Integer.parseInt(st.nextToken()); 
		String operation = st.nextToken(); 
		int oprnd2 = Integer.parseInt(st.nextToken()); 

		// perform the required operation. 
		if (operation.equals("+")) 
		{ 
			result = oprnd1 + oprnd2; 
		} 

		else if (operation.equals("-")) 
		{ 
			result = oprnd1 - oprnd2; 
		} 
		else if (operation.equals("*")) 
		{ 
			result = oprnd1 * oprnd2; 
		} 
		else
		{ 
			result = oprnd1 / oprnd2; 
		} 
		System.out.println("Sending the result..."); 
        
        
      
        serverMessage="From Server to Client-" + clientNo + " Result of " + clientMessage + " is " +result;
        outStream.writeUTF(serverMessage);
        outStream.flush();
      }
      inStream.close();
      outStream.close();
      serverClient.close();
    }catch(Exception ex){
      System.out.println(ex);
    }finally{
      System.out.println("Client -" + clientNo + " exit!! ");
    }
  }
}
