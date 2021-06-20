// Java Program to illustrate Client Side implementation 
// of Simple Calculator using UDP 
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

public class client 
{ 
	public static void main(String args[]) throws IOException 
	{ 
		Scanner sc = new Scanner(System.in); 

		// Creating socket
		DatagramSocket ds = new DatagramSocket(); 

		InetAddress ip = InetAddress.getLocalHost(); 
		byte buf[] = null; 

		
		while (true) 
		{ 
			System.out.print("Enter the equation in the format:"); 
			System.out.println("'operand1 operator operand2'"); 
			String inp = sc.nextLine(); 
			buf = new byte[65535]; 

			// String to byte 
			buf = inp.getBytes(); 

			// datagramPacket for sending the data. 
			DatagramPacket DpSend = 
					new DatagramPacket(buf, buf.length, ip, 7775); 

			// send the data. 
			ds.send(DpSend); 

			
			if (inp.equals("bye")) 
				break; 

			buf = new byte[65535]; 
			DatagramPacket DpReceive = 
								new DatagramPacket(buf, buf.length); 
			ds.receive(DpReceive); 

			System.out.println("Answer = " + 
								new String(buf,0,buf.length)); 
		} 
	} 
} 
