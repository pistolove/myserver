package com.lib.server;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lib.server.rmi.RmiConstant;
import com.lib.server.rmi.RmiInterface;

public class RmiClient {
	
	private static final Logger log = LoggerFactory.getLogger(RmiClient.class);
	
	private static final Map<String, Integer> SERVERS = new HashMap<String, Integer>();
	
	private static final RmiClient RMI_CLIENT = new RmiClient();
	
	public static RmiClient getRmiClient() {
		return RMI_CLIENT;
	}
	
	private static String[] servers = new String[] {
		"127.0.0.1;1099"
	};
	
	static {
		for (String server : servers) {
			String[] ip2port = server.split(";");
			SERVERS.put(ip2port[0], Integer.parseInt(ip2port[1]));
		}
	}
	
//	public void update(String key, Object value, int ... time){
//		for (String ip : SERVERS.keySet()) {
//			Integer port = SERVERS.get(ip);
//			int result = 0;
//			try {
//				result = update(ip, port, key, value, time);
//			} catch (Exception e) {
//				result = 1;
//			}
//			
//			if(result==1){
//				log.error("update error");
//			}
//		}
//	}
	
//	private int update(String ip, Integer port, String key, Object value, int[] time) throws RemoteException {
//		int status = 0;
//		int t = 0;
//		if(time != null && time.length > 0) {
//			t = time[0];
//		}
//		
//		Registry registry = LocateRegistry.getRegistry(ip, port);
//		try {
//			RmiInterface rmiService = (RmiInterface) registry.lookup(RmiConstant.REGISTER_SERVER_NAME);
//			status = rmiService.update(key, value, t);
//		} catch (NotBoundException e) {
//			log.error("update error");
//			e.printStackTrace();
//		}
//		return status;
//	}

	public static void main(String[] args) throws NamingException,
			MalformedURLException {
		try {
			Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
			RmiInterface rmiService = (RmiInterface) registry.lookup("RMI");

			int set1 = rmiService.set("Monday", "today is monday");

			System.err.println(set1);
			System.err.println(rmiService.get("Monday"));
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
