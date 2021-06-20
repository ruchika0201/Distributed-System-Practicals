package rmi;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.*;
public class client {

	
	public static void main(String[] args) throws RemoteException{
		client c = new client();
		c.connectRemote();
		
	}
	
	private void connectRemote() throws RemoteException{
		try {
			Scanner sc = new Scanner(System.in);
			Registry reg = LocateRegistry.getRegistry("localhost", 9998);
			adder ad = (adder)reg.lookup("add server");
			System.out.println("Enter the two numbers:");
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println("Addition is "+ad.add(a, b));
			System.out.println("Multiplication is "+ad.mul(a, b));
			System.out.println("Subtaction is "+ad.sub(a, b));
			System.out.println("Division is "+ad.div(a, b));
		}
		catch(NotBoundException|RemoteException e){
			System.out.println("Exception is" + e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
