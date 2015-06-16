package org.cloudstone.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class UDPServer {
	protected static DatagramSocket server;
	
	private static boolean mIsRun = true;
	public static void main(String[] args) throws IOException {

		new Thread() {
			@Override
			public void run() {
				try {
					server = new DatagramSocket(5050);
					while(mIsRun) {
						byte[] recvBuf = new byte[100];
						DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
						server.receive(recvPacket);
						String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
						System.out.println(recvStr);
						int port = recvPacket.getPort();
						InetAddress addr = recvPacket.getAddress();
						String sendStr = "Hello ! I'm Server";
						byte[] sendBuf;
						sendBuf = sendStr.getBytes();
						DatagramPacket sendPacket = new DatagramPacket(sendBuf,sendBuf.length, addr, port);
						server.send(sendPacket);
					}
					
				} catch (Exception e) {
					
				} finally {
					server.close();
				}
			}
		}.start();

		while (true) {
			
		}

	}
}