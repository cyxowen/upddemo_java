package org.cloudstone.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPClient {
	protected static DatagramSocket client;

	public static void main(String[] args) throws IOException {
		new Thread() {
			public void run() {
				try {
					while(true) {
					client = new DatagramSocket();
					String sendStr = "Hello! I'm Client";
					byte[] sendBuf;
					sendBuf = sendStr.getBytes();
					InetAddress addr = InetAddress.getByName("192.168.0.112");
					int port = 5050;
					DatagramPacket sendPacket = new DatagramPacket(sendBuf,sendBuf.length, addr, port);
					client.send(sendPacket);
					
//					byte[] recvBuf = new byte[100];
//					DatagramPacket recvPacket = new DatagramPacket(recvBuf,
//							recvBuf.length);
//					client.receive(recvPacket);
//					String recvStr = new String(recvPacket.getData(), 0,
//							recvPacket.getLength());
//					System.out.println(" ’µΩ:" + recvStr);
						Thread.sleep(1000);
					}

				} catch (Exception e) {

				} finally {
					client.close();
				}
			};
		}.start();
		while(true) {
			
		}
	}
}