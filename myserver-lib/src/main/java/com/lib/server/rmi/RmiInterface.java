package com.lib.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {

	public String get(String key) throws RemoteException;

	public void delete(String key) throws RemoteException;

	public int set(String key, Object obj) throws RemoteException;

	public int update(String key, Object value, int ... time);
}
