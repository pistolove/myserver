package com.timer.server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.lib.server.rmi.RmiInterface;
import com.lib.server.rmi.RmiServer;


public class RmiRmoteServer {
	public static void main(String[] args) throws MalformedURLException {
		try {
			System.setProperty("java.rmi.server.hostname", "192.168.134.128");
			Registry registry = LocateRegistry.createRegistry(1099);
			
			RmiInterface server = new RmiServer();
			// 通过名称RMI绑定服务
			registry.rebind("RMI", server);
			
			System.out.println(">>>>>> INFO:远程RMIServer绑定【192.168.134.128】成功！");
		} catch (RemoteException e) {
			System.out.println("创建远程对象发生异常！");
			e.printStackTrace();
		}
	}
}
