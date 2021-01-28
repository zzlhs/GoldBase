package com.zzl.net;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Net {

	public static void main(String[] args) {
		InetAddress address = InetAddress.getLoopbackAddress();
		
		InetAddress addressLocal = null;
		try {
			addressLocal = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		System.out.println(address);
		System.out.println(address.isLoopbackAddress()); 
		System.out.println(address.isSiteLocalAddress());
		System.out.println(address instanceof Inet4Address);
		
		System.out.println("-------------------------------");
		
		System.out.println(addressLocal);
		System.out.println(addressLocal.isLoopbackAddress()); 
		System.out.println(addressLocal.isSiteLocalAddress());
		System.out.println(addressLocal instanceof Inet4Address);
		
		System.out.println("-------------------------------");

		
		try {
			NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
