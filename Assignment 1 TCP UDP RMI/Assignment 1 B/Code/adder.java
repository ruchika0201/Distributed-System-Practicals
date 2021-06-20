package rmi;
import java.rmi.*;

public interface adder extends Remote
{
   int add (int d1, int d2) throws Exception;
   int sub (int d1, int d2) throws Exception;
   int mul (int d1, int d2) throws Exception;
   int div (int d1, int d2) throws Exception;
} 