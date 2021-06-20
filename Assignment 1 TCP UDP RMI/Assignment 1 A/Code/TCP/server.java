import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.StringTokenizer; 

public class server 
{ 
	public static void main(String args[]) throws IOException 
	{ 

		// Establishing the socket connection. 
		ServerSocket ss = new ServerSocket(4444); //used at server side, it blocks the console until the client is connected
		Socket s = ss.accept();  // used to communicate client and server. can read and write messages

		// Processing the request. 
		DataInputStream dis = new DataInputStream(s.getInputStream()); 
		DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 

		while (true) 
		{ 
			
			String input = dis.readUTF(); 

			if(input.equals("bye")) 
				break; 

			System.out.println("Equation received:  " + input); 
			int result; 

			// StringTokenizer to break the equation into operand and 
			// operator 
			StringTokenizer st = new StringTokenizer(input); 

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

			// send the result back to the client. 
			dos.writeUTF(Integer.toString(result)); 
		} 
	} 
} 
