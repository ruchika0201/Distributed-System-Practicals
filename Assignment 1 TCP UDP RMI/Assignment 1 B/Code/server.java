package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject
implements adder{

	protected server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int add(int d1, int d2) throws Exception {
		// TODO Auto-generated method stub
		return d1+d2;
		
	}
	@Override
	public int sub(int d1, int d2) throws Exception {
		// TODO Auto-generated method stub
		return d1-d2;
	}

	@Override
	public int mul(int d1, int d2) throws Exception {
		// TODO Auto-generated method stub
		return d1*d2;
	}

	@Override
	public int div(int d1, int d2) throws Exception {
		// TODO Auto-generated method stub
		return d1/d2;
	}
	public static void main(String[] args) throws RemoteException{
		try {
			Registry reg = LocateRegistry.createRegistry(9998);
			reg.rebind("add server", new server());
			System.out.println("Server is ready!");
		}
		catch(RemoteException e)
		{
			System.out.println("Exception "+ e);
		}
	}

	
}	
