import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

public interface DatabaseAccessInterface extends Remote 
{

public Connection Connect() throws RemoteException;

public void disConnect(Connection c) throws RemoteException;

public boolean checkValidLogin(String u, String p) throws RemoteException;

public String[] fetchUserData(String u) throws RemoteException;

public String[][] getPackages(boolean nnn,boolean www,boolean sss,boolean eee) throws RemoteException;

public boolean checkUserExists(String u) throws RemoteException;

public void insertUserProfile(String u, String p,String f,String l,String b,String g,String a,String ph,String e) throws RemoteException;

public String[] getHead(String pid) throws RemoteException;

public String[][] getLocation(String pid) throws RemoteException;

public String[] getSidebar(String pid) throws RemoteException;

public void insertFamilyData(String[][]arr) throws RemoteException;

public String[][] getPrevTours(String un) throws RemoteException;

public String[] getReceiptData() throws RemoteException;

public String[][] getMembers() throws RemoteException;

public String[][] fetchBookingData() throws RemoteException;

public String[][] fetchPackageData() throws RemoteException;

}