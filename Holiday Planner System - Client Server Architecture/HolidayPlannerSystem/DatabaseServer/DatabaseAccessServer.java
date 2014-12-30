import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.rmi.registry.*;

public class DatabaseAccessServer
{
DatabaseAccessImplementation daimpl;
Registry rs;

public DatabaseAccessServer(String host,int port)
{


try
{
daimpl = new DatabaseAccessImplementation();
rs = LocateRegistry.createRegistry(port);
Naming.rebind("//"+host+":"+port+"/DatabaseAccessServer",daimpl);

}catch(Exception e){}

}

public static void main(String[] args) throws Exception
{

DatabaseAccessServer das = new DatabaseAccessServer("localhost",1099);
//change values of host and port whenever needed .. 
}



}