package DataMPU6050;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
	
	private static InetAddress host;
	private static final int PORT=2019;
	private static float arraydata[]=new float[10];
	
	public static void main(String[]args) {
		try {
			host= InetAddress.getLocalHost();
		}
		catch(UnknownHostException ehEx){
			System.out.println("Cannot find Host information");
			System.exit(1);
		}
			accessServer();
	}
	
	private static void accessServer() {
		Socket socket=null;
		try {
			socket = new Socket(host,PORT);
			System.out.println("Connected!!!");
			DataInputStream is = new DataInputStream(socket.getInputStream());
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			String message, response;
			Scanner sc= new Scanner(System.in);
			response = is.readUTF();
			System.out.println("Server: "+response);
			//input array
			do {
				System.out.println("Information want to send to Server: ");
				message=sc.nextLine();
				
				if(message.equals("data")) {
					System.out.println("Input data: ");
					for(int i=0;i<10;i++) {
						System.out.println("Datum "+ (i+1) +" : ");
						arraydata[i]=sc.nextFloat();
					}
					System.out.println("Client has upload an array of data. Sending to server... ");
					os.writeUTF(message);
					for(int i=0;i<10;i++) {
						os.writeFloat(arraydata[i]);
					}
					System.out.println("Data has been sent!!");
				}
				else if (message.equals("data2")) {
					double arraydata2[]= {0.83 ,0.34 ,0.66 ,1.29 ,1.21 ,1.53 ,1.05 ,1.05 ,0.85 ,0.42 ,0.48 ,0.89 ,1.52 ,1.30 ,0.68 ,0.29 ,0.29 ,0.94 ,1.24 ,1.26 ,1.48 ,0.93 ,0.80 ,0.36 ,0.61 ,0.61 ,0.97 ,1.57 ,1.16 ,0.65 ,0.32 ,1.06 ,1.18 ,1.30 ,1.30 ,1.31 ,0.98 ,0.67 ,0.39 ,0.68 ,1.20 ,1.43 ,0.95 ,0.95 ,0.42 ,0.53 ,1.25 ,1.28 ,1.42 ,1.21 ,0.86 ,0.45 ,0.45 ,0.48 ,0.79 ,1.41 ,1.45 ,0.86 ,0.30 ,0.75 ,1.26 ,1.26 ,1.15 ,1.46 ,1.08 ,0.88 ,0.39 ,0.57 ,0.94 ,1.48 ,1.23 ,1.23 ,0.68 ,0.29 ,0.94 ,1.33 ,1.27 ,1.41 ,0.99 ,0.72 ,0.64 ,1.11 ,1.52 ,1.10 ,0.49 ,0.42 ,1.17 ,1.20 ,1.37 ,1.30 ,0.90 ,0.62 ,0.36 ,0.73 ,1.26 ,1.51 ,0.98 ,0.43 ,0.57 ,1.21 ,1.15 ,1.42 ,1.14 ,0.90 ,0.47 ,0.51 ,0.84 ,1.43 ,1.25 ,0.70 ,0.36 ,0.90 ,1.29 ,1.30 ,1.42 ,0.95 ,0.71 ,0.38 ,0.58 ,1.11 ,1.52 ,1.16 ,0.50 ,0.47 ,1.12 ,1.12 ,1.39 ,0.89 ,0.69 ,0.42 ,0.72 ,1.25 ,1.46 ,0.95 ,0.46 ,0.57 ,1.22 ,1.21 ,1.41 ,1.14 ,0.93 ,0.41 ,0.52 ,0.86 ,1.48 ,1.25 ,0.73 ,0.30 ,0.90 ,1.33 ,1.26 ,1.39 ,1.03 ,0.67 ,0.41 ,0.57 ,1.07 ,1.51 ,1.19 ,0.56 ,0.39 ,1.17 ,1.14 ,1.24 ,1.35 ,0.91 ,0.66 ,0.48 ,0.70 ,1.19 ,1.42 ,0.90 ,0.39 ,1.24 ,1.27 ,1.40 ,1.10 ,0.88 ,0.41 ,0.51 ,0.88 ,1.48 ,1.27 ,0.74 ,0.29 ,0.90 ,1.27 ,1.30 ,1.37 ,1.04 ,0.76 ,0.33 ,0.63 ,0.95 ,1.58 ,1.14 ,0.71 ,0.29 ,1.12 ,1.16 ,1.32 ,1.24 ,1.02 ,0.71 ,0.36 ,0.79 ,1.17 ,1.40 ,0.88 ,0.47 ,0.53 ,1.29 ,1.24 ,1.51 ,1.15 ,0.79 ,0.52 ,0.38 ,0.89 ,1.40 ,0.69 ,0.38 ,0.91 ,1.17 ,1.28 ,1.39 ,1.04 ,0.67 ,0.50 ,0.51 ,0.89 ,1.49 ,1.25 ,0.80 ,0.32 ,1.02 ,1.13 ,1.17 ,1.35 ,1.00 ,0.83 ,0.40 ,0.85 ,1.12 ,1.30 ,0.80 ,0.50 ,0.60 ,1.31 ,1.36 ,1.46 ,1.12 ,0.70 ,0.44 ,0.39 ,0.90 ,1.45 ,1.41 ,0.77 ,0.27 ,0.92 ,1.18 ,1.19 ,1.41 ,1.10 ,0.77 ,0.55 ,0.91 ,1.44 ,1.30 ,0.79 ,0.29 ,0.97 ,1.20 ,1.18 ,1.37 ,1.01 ,0.82 ,0.40 ,0.74 ,1.11 ,1.38 ,0.89 ,0.47 ,0.53 ,1.22 ,1.35 ,1.49 ,1.17 ,0.81 ,0.51 ,0.38 ,0.71 ,1.43 ,1.48 ,0.96 ,0.36 ,0.65 ,1.13 ,1.17 ,1.32 ,1.19 ,0.92 ,0.51 ,0.57 ,0.76 ,1.39 ,1.31 ,0.87 ,0.31 ,0.77 ,1.29 ,1.44 ,1.01 ,0.87 ,0.34 ,0.63 ,1.04 ,1.47 ,1.09 ,0.49 ,0.42 ,1.11 ,1.29 ,1.40 ,1.38 ,0.82 ,0.58 ,0.38 ,0.63 ,1.18 ,1.63 ,1.08 ,0.52 ,0.41 ,1.13 ,1.13 ,1.28 ,1.29 ,0.97 ,0.64 ,0.50 ,0.70 ,1.27 ,1.37 ,0.93 ,0.39 ,0.58 ,1.29 ,1.20 ,1.47 ,1.10 ,0.88 ,0.45 ,0.48 ,0.86 ,1.45 ,1.34 ,0.30 ,0.86 ,1.31 ,1.20 ,1.43 ,1.05 ,0.73 ,0.38 ,0.58 ,0.95 ,1.54 ,1.19 ,0.71 ,0.28 ,1.06 ,1.19 ,1.25 ,1.39 ,0.97 ,0.76 ,0.39 ,0.73 ,1.14 ,1.47 ,0.92 ,0.48 ,0.47 ,1.21 ,1.32 ,1.46 ,1.18 ,0.91 ,0.48 ,0.38 ,0.75 ,1.37 ,1.49 ,0.94 ,0.39 ,0.59 ,1.23 ,1.16 ,1.33 ,1.20 ,0.89 ,0.48 ,0.51 ,1.37 ,1.35 ,0.85 ,0.30 ,0.82 ,1.27 ,1.19 ,1.46 ,0.98 ,0.88 ,0.37 ,0.62 ,1.03 ,1.46 ,1.11 ,0.49 ,0.44 ,1.13 ,1.23 ,1.38 ,1.38 ,0.78 ,0.59 ,0.41 ,0.59 ,1.20 ,1.57 ,1.12 ,0.47 ,0.50 ,1.11 ,1.05 ,1.37 ,1.23 ,0.96 ,0.63 ,0.52 ,0.71 ,1.34 ,1.30 ,0.85 ,0.36 ,0.65 ,1.30 ,1.30 ,1.50 ,0.80 ,0.40 ,0.45 ,0.89 ,1.52 ,1.33 ,0.73 ,0.26 ,0.93 ,1.24 ,1.17 ,1.44 ,1.06 ,0.73 ,0.44 ,0.62 ,0.89 ,1.49 ,1.26 ,0.76 ,0.26 ,1.01 ,1.19 ,1.21 ,1.40 ,0.94 ,0.80 ,0.38 ,0.73 ,1.15 ,1.38 ,0.91 ,0.42 ,0.53 ,1.21 ,1.36 ,1.45 ,1.24 ,0.77 ,0.54 ,0.36 ,0.75 ,1.38 ,1.57 ,0.98 ,0.37 ,1.13 ,1.13 ,1.38 ,1.20 ,0.99 ,0.54 ,0.52 ,0.69 ,1.36 ,1.33 ,0.96 ,0.32 ,0.61 ,1.27 ,1.20 ,1.39 ,1.12 ,0.87 ,0.46 ,0.50 ,0.91 ,1.47 ,1.22 ,0.69 ,0.32 ,0.94 ,1.31 ,1.28 ,1.40 ,0.96 ,0.70 ,0.43 ,0.56 ,1.07 ,1.54 ,1.23 ,0.61 ,0.33 ,1.07 ,1.13 ,1.30 ,1.33 ,0.95 ,0.70 ,0.45 ,0.64 ,1.21 ,0.96 ,0.46 ,0.47 ,1.21 ,1.25 ,1.47 ,1.21 ,0.91 ,0.42 ,0.49 ,0.67 ,1.38 ,1.44 ,0.96 ,0.37 ,0.64 ,1.24 ,1.14 ,1.32 ,1.16 ,0.90 ,0.49 ,0.56 ,0.84 ,1.44 ,1.20 ,0.77 ,0.29 ,0.83 ,1.40 ,1.25 ,1.43 ,1.04 ,0.69 ,0.40 ,0.53 ,1.10 ,1.48 ,1.24 ,0.54 ,0.35 ,1.07 ,1.20 ,1.32 ,1.34 ,0.97 ,0.37 ,0.69 ,1.05 ,1.55 ,1.06 ,0.60 ,0.39 ,1.12 ,1.15 ,1.37 ,1.20 ,1.01 ,0.65 ,0.41 ,0.78 ,1.30 ,1.36 ,0.81 ,0.39 ,0.54 ,1.29 ,1.34 ,1.48 ,1.08 ,0.82 ,0.43 ,0.36 ,0.84 ,1.51 ,1.42 ,0.80 ,0.29 ,0.77 ,1.19 ,1.21 ,1.45 ,1.05 ,0.85 ,0.43 ,0.57 ,0.77 ,1.45 ,1.29 ,0.83 ,0.32 ,0.91 ,1.12 ,1.35 ,1.04 ,0.83 ,0.46 ,0.65 ,1.04 ,1.40 ,1.03 ,0.50 ,0.41 ,1.12 ,1.34 ,1.35 ,1.33 ,0.81 ,0.54 ,0.40 ,0.63 ,1.30 ,1.51 ,0.99 ,0.41 ,0.52 ,1.18 ,1.16 ,1.36 ,1.19 ,0.93 ,0.50 ,0.54 ,0.71 ,1.33 ,1.36 ,1.03 ,0.31 ,0.61 ,1.37 ,1.03 ,1.40 ,1.30 ,0.72 ,0.55 ,0.55 ,0.81 ,1.35 ,1.30 ,0.34 ,0.91 ,1.36 ,1.15 ,1.46 ,1.02 ,0.69 ,0.42 ,0.59 ,0.98 ,1.53 ,1.21 ,0.65 ,0.27 ,1.03 ,1.17 ,1.30 ,1.33 ,1.01 ,0.77 ,0.35 ,0.65 ,1.19 ,1.44 ,1.00 ,0.46 ,0.38 ,1.15 ,1.37 ,1.40 ,1.26 ,0.90 ,0.52 ,0.35 ,0.71 ,1.24 ,1.59 ,1.04 ,0.49 ,0.49 ,1.19 ,1.11 ,1.35 ,1.22 ,1.01 ,0.53 ,0.69 ,1.31 ,1.35 ,0.95 ,0.36 ,0.64 ,1.26 ,1.21 ,1.45 ,1.09 ,0.86 ,0.43 ,0.49 ,0.84 ,1.48 ,1.26 ,0.68 ,0.31 ,0.92 ,1.25 ,1.27 ,1.46 ,0.92 ,0.77 ,0.37 ,0.61 ,0.98 ,1.61 ,1.16 ,0.68 ,0.30 ,1.02 ,1.16 ,1.38 ,1.32 ,1.04 ,0.65 ,0.42 ,0.67 ,1.12 ,1.51 ,1.00 ,0.57 ,0.37 ,1.22 ,1.23 ,1.28 ,0.91 ,0.51 ,0.48 ,0.65 ,1.30 ,1.43 ,1.03 ,0.40 ,0.51 ,1.30 ,1.12 ,1.37 ,1.24 ,0.89 ,0.49 ,0.55 ,0.77 ,1.38 ,1.32 ,0.84 ,0.31 ,0.65 ,1.40 ,1.20 ,1.48 ,1.11 ,0.80 ,0.37 ,0.52 ,0.89 ,1.54 ,1.30 ,0.65 ,0.31 ,0.87 ,1.27 ,1.31 ,1.33 ,1.06 ,0.72 ,0.38 ,0.61 ,0.95 ,1.54 ,1.20 ,0.79 ,1.05 ,1.17 ,1.22 ,1.34 ,0.95 ,0.81 ,0.36 ,0.76 ,1.13 ,1.45 ,0.87 ,0.48 ,0.49 ,1.24 ,1.27 ,1.50 ,1.21 ,0.75 ,0.55 ,0.39 ,0.70 ,1.44 ,1.44 ,0.91 ,0.33 ,0.74 ,1.20 ,1.16 ,1.38 ,1.19 ,0.76 ,0.59 ,0.54 ,0.74 ,1.43 ,1.32 ,0.92 ,0.27 ,0.88 ,1.16 ,1.18 ,1.38 ,1.03 ,0.93 ,0.34 ,0.75 ,1.38 ,0.96 ,0.52 ,0.46 ,1.13 ,1.46 ,1.40 ,1.24 ,0.83 ,0.47 ,0.41 ,0.70 ,1.40 ,1.48 ,1.02 ,0.37 ,0.60 ,1.23 ,1.14 ,1.31 ,1.25 ,0.89 ,0.51 ,0.57 ,0.73 ,1.30 ,1.39 ,0.92 ,0.36 ,0.74 ,1.22 ,1.19 ,1.37 ,1.09 ,0.90 ,0.43 ,0.59 ,1.01 ,1.40 ,1.11 ,0.52 ,0.48 ,0.99 ,1.37 ,1.38 ,1.37 ,0.79 ,0.31 ,0.64 ,1.24 ,1.59 ,1.07 ,0.45 ,0.48 ,1.15 ,1.15 ,1.36 ,1.28 ,0.96 ,0.56 ,0.47 ,0.67 ,1.20 ,1.46 ,1.01 ,0.45 ,0.61 ,1.25 ,1.08 ,1.36 ,1.12 ,0.89 ,0.58 ,0.50 ,0.97 ,1.37 ,1.14 ,0.57 ,0.49 ,0.91 ,1.39 ,1.28 ,1.41 ,0.85 ,0.67 ,0.40 ,0.63 ,1.21 ,1.48 ,1.09 ,0.39 ,0.52 ,1.15 ,1.39 ,1.22 ,0.93 ,0.62 ,0.47 ,0.73 ,1.29 ,1.41 ,0.92 ,0.37 ,0.63 ,1.29 ,1.15 ,1.47 ,1.14 ,0.88 ,0.42 ,0.57 ,0.89 ,1.46 ,1.27 ,0.69 ,0.29 ,0.94 ,1.27 ,1.24 ,1.35 ,1.02 ,0.70 ,0.38 ,0.65 ,1.02 ,1.51 ,1.12 ,0.60 ,0.38 ,1.14 ,1.17 ,1.24 ,1.31 ,0.91 ,0.74 ,0.39 ,0.78 ,1.25 ,1.38 ,0.46 ,0.58 ,1.24 ,1.27 ,1.42 ,1.11 ,0.81 ,0.43 ,0.43 ,0.90 ,1.50 ,1.30 ,0.84 ,0.25 ,0.93 ,1.23 ,1.14 ,1.33 ,1.10 ,0.69 ,0.46 ,0.62 ,1.00 ,1.47 ,1.13 ,0.64 ,0.40 ,1.13 ,1.20 ,1.27 ,1.29 ,0.93 ,0.67 ,0.41 ,0.83 ,1.22 ,1.37 ,0.79 ,0.44 ,0.62 ,1.36 ,1.24 ,1.52 ,1.04 ,0.73 ,0.49 ,0.93 ,1.53 ,1.36 ,0.62 ,0.38 ,1.00 ,1.07 ,1.33 ,1.33 ,1.05 ,0.70 ,0.50 ,0.60 ,0.98 ,1.49 ,1.10 ,0.72 ,0.41 ,1.14 ,1.15 ,1.23 ,1.28 ,0.92 ,0.66 ,0.43 ,0.81 ,1.24 ,1.32 ,0.76 ,0.41 ,0.71 ,1.41 ,1.21 ,1.46 ,1.05 ,0.69 ,0.45 ,0.44 ,1.07 ,1.44 ,1.29 ,0.58 ,0.37 ,1.00 ,1.21 ,1.24 ,1.41 ,0.65 ,0.43 ,0.66 ,0.94 ,1.51 ,1.16 ,0.71 ,0.37 ,1.09 ,1.06 ,1.24 ,1.24 ,0.92 ,0.77 ,0.43 ,0.89 ,1.20 ,1.24 ,0.68 ,0.47 ,0.73 ,1.41 ,1.37 ,1.42 ,1.01 ,0.62 ,0.56 ,0.60 ,1.09 ,1.54 ,1.27 ,0.60 ,0.37 ,1.05 ,1.11 ,1.26 ,1.35 ,1.04 ,0.66 ,0.50 ,0.62 ,0.94 ,1.52 ,1.19 ,0.72 ,0.35 ,1.08 ,1.27 ,1.28 ,0.95 ,0.71 ,0.50 ,0.75 ,1.26 ,1.21 ,0.71 ,0.42 ,0.79 ,1.35 ,1.34 ,1.52 ,0.98 ,0.61 ,0.46 ,0.43 ,0.99 ,1.56 ,1.34 ,0.71 ,0.34 ,0.99 ,1.08 ,1.21 ,1.38 ,1.02 ,0.77 ,0.49 ,0.59 ,0.96 ,1.41 ,1.14 ,0.62 ,0.38 ,1.13 ,1.19 ,1.31 ,1.28 ,0.93 ,0.71 ,0.34 ,0.84 ,1.18 ,0.83 ,0.54 ,0.68 ,1.39 ,1.16 ,1.50 ,1.05 ,0.72 ,0.52 ,0.44 ,0.95 ,1.47 ,1.31 ,0.69 ,0.32 ,0.90 ,1.15 ,1.22 ,1.30 ,1.05 ,0.70 ,0.43 ,0.61 ,1.02 ,1.53 ,1.12 ,0.64 ,0.36 ,1.16 ,1.16 ,1.32 ,1.26 ,1.01 ,0.63 ,0.45 ,0.72 ,1.27 ,1.36 ,0.94 ,0.41 ,0.84 ,1.34 ,1.14 ,1.40 ,1.15 ,0.75 ,0.50 ,0.89 ,1.37 ,1.31 ,0.63 ,0.35 ,1.04 ,1.28 ,1.05 ,1.49 ,0.99 ,0.59 ,0.60 ,0.62 ,1.13 ,1.41 ,0.99 ,0.41 ,0.57 ,1.24 ,1.06 ,1.39 ,1.25 ,0.79 ,0.48 ,0.56 ,0.74 ,1.34 ,1.34 ,0.84 ,0.36 ,0.77 ,1.20 ,1.15 ,1.38 ,1.03 ,0.88 ,0.42 ,0.65 ,1.01 ,1.43 ,1.04 ,0.53 ,0.45 ,1.04 ,1.37 ,1.31 ,0.82 ,0.63 ,0.36 ,0.74 ,1.23 ,1.47 ,0.85 ,0.47 ,0.61 ,1.23 ,1.09 ,1.41 ,1.12 ,0.80 ,0.53 ,0.41 ,0.80 ,1.32 ,1.49 ,0.95 ,0.40 ,0.67 ,1.22 ,1.04 ,1.39 ,1.12 ,0.86 ,0.61 ,0.61 ,1.02 ,1.30 ,1.06 ,0.51 ,0.57 ,1.04 ,1.39 ,1.37 ,1.31 ,0.80 ,0.62 ,0.37 ,0.68 ,1.30 ,1.50 ,1.07 ,0.39 ,1.14 ,1.10 ,1.34 ,1.26 ,0.87 ,0.59 ,0.51 ,0.73 ,1.30 ,1.39 ,0.92 ,0.35 ,0.72 ,1.27 ,1.16 ,1.42 ,1.07 ,0.90 ,0.39 ,0.63 ,0.95 ,1.45 ,1.08 ,0.51 ,0.45 ,1.10 ,1.29 ,1.40 ,1.34 ,0.82 ,0.60 ,0.38 ,0.64 ,1.18 ,1.59 ,1.04 ,0.53 ,0.50 ,1.13 ,1.13 ,1.28 ,1.28 ,0.94 ,0.61 ,0.54 ,0.71 ,1.32 ,0.91 ,0.35 ,0.72 ,1.26 ,1.24 ,1.43 ,1.05 ,0.89 ,0.36 ,0.54 ,0.96 ,1.47 ,1.21 ,0.66 ,0.31 ,1.02 ,1.28 ,1.24 ,1.45 ,0.90 ,0.74 ,0.35 ,0.60 ,1.08 ,1.53 ,1.15 ,0.53 ,0.43 ,1.14 ,1.21 ,1.34 ,1.36 ,0.94 ,0.62 ,0.43 ,0.70 ,1.23 ,1.43 ,0.93 ,0.46 ,0.54 ,1.24 ,1.25 ,1.40 ,1.14 ,0.92 ,0.51 ,0.85 ,1.50 ,1.27 ,0.77 ,0.32 ,0.85 ,1.33 ,1.27 ,1.34 ,1.07 ,0.67 ,0.50 ,0.56 ,1.05 ,1.48 ,1.15 ,0.61 ,0.40 ,1.09 ,1.18 ,1.22 ,1.33 ,0.95 ,0.67 ,0.46 ,0.70 ,1.20 ,1.40 ,0.99 ,0.43 ,0.55 ,1.27 ,1.18 ,1.40 ,1.22 ,0.83 ,0.46 ,0.51 ,0.80 ,1.48 ,1.28 ,0.78 ,0.32 ,0.89 ,1.19 ,1.31 ,1.12 ,0.72 ,0.40 ,0.64 ,0.91 ,1.55 ,1.10 ,0.79 ,0.27 ,1.05 ,1.21 ,1.23 ,1.28 ,1.03 ,0.65 ,0.41 ,0.74 ,1.14 ,1.44 ,0.89 ,0.52 ,0.41 ,1.30 ,1.27 ,1.40 ,1.20 ,0.84 ,0.50 ,0.42 ,0.77 ,1.39 ,1.45 ,0.83 ,0.32 ,0.68 ,1.28 ,1.16 ,1.40 ,1.14 ,0.81 ,0.43 ,0.56 ,0.82 ,1.47 ,1.31 ,0.84 ,0.88 ,1.22 ,1.20 ,1.37 ,1.03 ,0.88 ,0.37 ,0.66 ,1.04 ,1.49 ,0.99 ,0.53 ,0.44 ,1.09 ,1.35 ,1.43 ,1.27 ,0.87 ,0.57 ,0.36 ,0.66 ,1.29 ,1.55 ,1.06 ,0.40 ,0.56 ,1.21 ,1.08 ,1.35 ,1.21 ,0.95 ,0.48 ,0.54 ,0.74 ,1.34 ,1.29 ,0.87 ,0.31 ,0.78 ,1.27 ,1.23 ,1.49 ,0.99 ,0.80 ,0.40 ,0.53 ,1.49 ,1.21 ,0.58 ,0.44 ,1.09 ,1.17 ,1.29 ,1.32 ,0.90 ,0.67 ,0.47 ,0.67 ,1.20 ,1.43 ,1.03 ,0.43 ,0.57 ,1.29 ,1.07 ,1.37 ,1.25 ,0.80 ,0.52 ,0.52 ,0.90 ,1.30 ,1.28 ,0.72 ,0.34 ,0.95 ,1.34 ,1.14 ,1.50 ,0.97 ,0.68 ,0.42 ,0.63 ,1.06 ,1.49 ,1.11 ,0.52 ,0.43 ,1.15 ,1.22 ,1.26 ,1.28 ,0.61 ,0.48 ,0.71 ,1.29 ,1.40 ,0.93 ,0.37 ,0.62 ,1.27 ,1.17 ,1.42 ,1.14 ,0.81 ,0.49 ,0.42 ,0.83 ,1.40 ,1.36 ,0.80 ,0.30 ,0.89 ,1.27 ,1.13 ,1.46 ,1.01 ,0.76 ,0.46 ,0.55 ,1.00 ,1.48 ,1.19 ,0.60 ,0.37 ,1.11 ,1.20 ,1.29 ,1.33 ,0.96 ,0.68 ,0.41 ,0.72 ,1.23 ,1.45 ,0.93 ,0.43 ,0.55 ,1.26 ,1.46 ,1.19 ,0.81 ,0.43 ,0.51 ,0.71 ,1.46 ,1.36 ,0.93 ,0.24 ,0.83 ,1.20 ,1.18 ,1.40 ,1.11 ,0.79 ,0.44 ,0.61 ,0.89 ,1.47 ,1.19 ,0.71 ,0.27 ,1.04 ,1.26 ,1.24 ,1.35 ,1.01 ,0.65 ,0.40 ,0.64 ,1.13 ,1.48 ,1.03 ,0.52 ,0.39 ,1.22 ,1.22 ,1.40 ,1.22 ,0.97 ,0.51 ,0.37 ,0.76 ,1.25 ,1.50 ,0.41 ,0.45 ,1.33 ,1.12 ,1.41 ,1.20 ,0.85 ,0.50 ,0.47 ,0.82 ,1.39 ,1.33 ,0.72 ,0.34 ,0.74 ,1.33 ,1.28 ,1.37 ,1.14 ,0.63 ,0.41 ,0.50 ,0.90 ,1.55 ,1.23 ,0.80 ,0.26 ,0.95 ,1.13 ,1.18 ,1.29 ,1.05 ,0.78 ,0.44 ,0.62 ,1.10 ,1.40 ,1.11 ,0.54 ,0.37 ,1.09 ,1.33 ,1.33 ,1.33 ,0.93 ,0.55 ,0.38 ,1.31 ,1.47 ,0.86 ,0.35 ,0.60 ,1.30 ,1.18 ,1.47 ,1.14 ,0.79 ,0.43 ,0.51 ,0.74 ,1.36 ,1.44 ,0.96 ,0.31 ,0.75 ,1.09 ,1.15 ,1.31 ,1.20 ,0.90 ,0.43 ,0.67 ,0.85 ,1.44 ,1.07 ,0.64 ,0.31 ,1.02 ,1.35 ,1.38 ,1.41 ,0.92 ,0.61 ,0.32 ,0.61 ,1.16 ,1.61 ,1.10 ,0.53 ,0.36 ,1.20 ,1.14 ,1.28 ,1.00 ,0.59 ,0.49 ,0.70 ,1.13 ,1.50 ,1.01 ,0.55 ,0.41 ,1.26 ,1.17 ,1.35 ,1.22 ,0.96 ,0.52 ,0.48 ,0.88 ,1.37 ,1.25 ,0.69 ,0.37 ,0.74 ,1.40 ,1.32 ,1.48 ,1.01 ,0.69 ,0.43 ,0.38 ,1.04 ,1.48 ,1.43 ,0.72 ,0.32 ,0.81 ,1.21 ,1.16 ,1.39 ,1.12 ,0.80 ,0.51 ,0.51 ,0.89 ,1.45 ,1.26 ,0.78 ,0.96 ,1.19 ,1.20 ,1.34 ,0.98 ,0.82 ,0.40 ,0.74 ,1.16 ,1.35 ,0.89 ,0.46 ,0.56 ,1.20 ,1.34 ,1.41 ,1.15 ,0.76 ,0.50 ,0.44 ,0.80 ,1.43 ,1.46 ,0.87 ,0.29 ,0.81 ,1.15 ,1.15 ,1.43 ,1.15 ,0.82 ,0.48 ,0.59 ,0.73 ,1.46 ,1.29 ,0.91 ,0.25 ,0.85 ,1.24 ,1.14 ,1.41 ,1.06 ,0.78 ,0.42 ,0.64 ,1.40 ,1.07 ,0.50 ,0.38 ,1.13 ,1.36 ,1.38 ,1.33 ,0.90 ,0.53 ,0.35 ,0.66 ,1.21 ,1.61 ,1.07 ,0.54 ,0.37 ,1.16 ,1.12 ,1.25 ,1.30 ,0.98 ,0.62 ,0.48 ,0.73 ,1.21 ,1.42 ,0.95 ,0.41 ,0.51 ,1.28 ,1.21 ,1.45 ,1.14 ,0.96 ,0.40 ,0.46 ,0.90 ,1.44 ,1.30 ,0.73 ,0.31 ,0.84 ,1.37 ,1.25 ,1.42 ,1.05 ,0.40 ,0.52 ,0.94 ,1.54 ,1.31 ,0.77 ,0.31 ,0.97 ,1.12 ,1.20 ,1.35 ,1.02 ,0.80 ,0.45 ,0.66 ,1.06 ,1.39 ,0.99 ,0.49 ,0.46 ,1.14 ,1.34 ,1.43 ,1.25 ,0.86 ,0.53 ,0.38 ,0.75 ,1.39 ,1.47 ,0.90 ,0.33 ,0.70 ,1.27 ,1.15 ,1.41 ,1.17 ,0.85 ,0.39 ,0.59 ,0.70 ,1.36 ,1.40 ,0.93 ,0.34 ,0.81 ,1.16 ,1.34 ,1.08 ,0.89 ,0.41 ,0.75 ,0.97 ,1.44 ,0.90 ,0.49 ,0.44 ,1.09 ,1.45 ,1.46 ,1.34 ,0.78 ,0.53 ,0.31 ,0.64 ,1.32 ,1.61 ,1.08 ,0.40 ,0.50 ,1.19 ,1.08 ,1.36 ,1.26 ,1.00 ,0.59 ,0.50 ,0.68 ,1.14 ,1.46 ,1.03 ,0.56 ,0.49 ,1.21 ,1.17 ,1.30 ,1.15 ,0.98 ,0.52 ,0.52 ,0.96 ,1.34 ,0.59 ,0.42 ,0.86 ,1.44 ,1.40 ,1.43 ,0.97 ,0.57 ,0.40 ,0.48 ,1.11 ,1.59 ,1.26 ,0.60 ,0.39 ,1.04 ,1.10 ,1.19 ,1.38 ,1.03 ,0.67 ,0.58 ,0.60 ,0.97 ,1.47 ,1.20 ,0.70 ,0.36 ,1.08 ,1.18 ,1.24 ,1.28 ,1.02 ,0.66 ,0.46 ,0.82 ,1.24 ,1.26 ,0.79 ,0.50 ,0.70 ,1.34 ,1.39 ,1.44 ,1.07 ,0.65 ,0.40 ,0.88 ,1.57 ,1.41 ,0.88 ,0.18 ,0.91 ,1.17 ,1.04 ,1.43 ,1.19 ,0.74 ,0.52 ,0.63 ,0.88 ,1.40 ,1.15 ,0.65 ,0.28 ,1.09 ,1.26 ,1.27 ,1.41 ,0.91 ,0.61 ,0.43 ,0.57 ,1.19 ,1.48 ,1.15 ,0.47 ,0.51 ,1.14 ,1.17 ,1.30 ,1.22 ,0.99 ,0.49 ,0.58 ,0.70 ,1.30 ,1.37 ,0.87 ,0.38 ,0.60 ,1.36 ,1.24 ,1.12 ,0.86 ,0.36 ,0.57 ,0.92 ,1.46 ,1.28 ,0.65 ,0.30 ,0.95 ,1.29 ,1.30 ,1.43 ,0.92 ,0.76 ,0.31 ,0.57 ,1.08 ,1.55 ,1.17 ,0.59 ,0.25 ,1.07 ,1.20 ,1.25 ,1.39 ,0.98 ,0.68 ,0.40 ,0.65 ,1.08 ,1.55 ,0.98 ,0.59 ,0.44 ,1.19 ,1.14 ,1.37 ,1.09 ,0.98 ,0.56 ,0.49 ,0.76 ,1.38 ,1.28 ,0.84 ,0.71 ,1.33 ,1.26 ,1.38 ,1.13 ,0.70 ,0.45 ,0.53 ,0.92 ,1.49 ,1.30 ,0.73 ,0.29 ,1.03 ,1.23 ,1.12 ,1.44 ,0.95 ,0.74 ,0.44 ,0.67 ,1.05 ,1.44 ,1.12 ,0.45 ,0.43 ,1.20 ,1.18 ,1.35 ,1.37 ,0.84 ,0.61 ,0.42 ,0.74 ,1.24 ,1.50 ,0.87 ,0.40 ,0.61 ,1.30 ,1.13 ,1.51 ,1.09 ,0.85 ,0.52 ,0.46 ,1.44 ,1.36 ,0.83 ,0.30 ,0.77 ,1.24 ,1.22 ,1.38 ,1.11 ,0.82 ,0.40 ,0.56 ,0.92 ,1.48 ,1.21 ,0.71 ,0.29 ,0.95 ,1.33 ,1.26 ,1.35 ,1.02 ,0.72 ,0.35 ,0.65 ,1.11 ,1.51 ,1.06 ,0.53 ,0.39 ,1.17 ,1.24 ,1.36 ,1.26 ,0.93 ,0.62 ,0.39 ,0.72 ,1.27 ,1.52 ,0.94 ,0.45 ,0.50 ,1.27 ,1.15 ,1.44 ,1.17 ,0.46 ,0.49 ,0.76 ,1.41 ,1.41 ,0.84 ,0.31 ,0.77 ,1.27 ,1.20 ,1.49 ,1.05 ,0.83 ,0.43 ,0.55 ,0.86 ,1.52 ,1.29 ,0.73 ,0.29 ,0.95 ,1.22 ,1.22 ,1.42 ,0.98 ,0.75 ,0.37 ,0.57 ,1.09 ,1.50 ,1.08 ,0.52 ,0.35 ,1.16 ,1.27 ,1.33 ,1.33 ,0.93 ,0.55 ,0.41 ,0.68 ,1.21 ,1.56 ,1.00 ,0.48 ,0.47 ,1.12 ,1.39 ,1.18 ,0.96 ,0.50 ,0.53 ,0.71 ,1.39 ,1.31 ,0.85 ,0.35 ,0.66 ,1.33 ,1.29 ,1.40 ,1.10 ,0.85 ,0.35 ,0.53 ,0.88 ,1.54 ,1.31 ,0.76 ,0.24 ,0.86 ,1.30 ,1.20 ,1.40 ,1.06 ,0.78 ,0.37 ,0.61 ,0.97 ,1.52 ,1.18 ,0.65 ,0.27 ,1.06 ,1.22 ,1.32 ,1.36 ,0.97 ,0.68 ,0.37 ,0.64 ,1.14 ,1.52 ,0.52 ,0.38 ,1.19 ,1.22 ,1.32 ,1.31 ,0.92 ,0.56 ,0.48 ,0.64 ,1.30 ,1.47 ,1.01 ,0.39 ,0.55 ,1.22 ,1.16 ,1.40 ,1.20 ,0.94 ,0.48 ,0.54 ,0.75 ,1.40 ,1.35 ,0.86 ,0.28 ,0.72 ,1.34 ,1.20 ,1.44 ,1.13 ,0.76 ,0.37 ,0.57 ,0.89 ,1.52 ,1.28 ,0.73 ,0.23 ,0.95 ,1.32 ,1.18 ,1.48 ,1.01 ,0.72 ,0.60 ,1.04 ,1.55 ,1.14 ,0.59 ,0.27 ,1.15 ,1.18 ,1.29 ,1.42 ,0.88 ,0.67 ,0.39 ,0.66 ,1.14 ,1.54 ,1.08 ,0.49 ,0.43 ,1.18 ,1.16 ,1.35 ,1.26 ,0.97 ,0.55 ,0.48 ,0.72 ,1.31 ,1.38 ,0.86 ,0.34 ,0.58 ,1.22 ,1.18 ,1.53 ,1.04 ,0.93 ,0.41 ,0.48 ,0.82 ,1.46 ,1.33 ,0.83 ,0.29 ,0.82 ,1.26 ,1.39 ,1.01 ,0.85 ,0.36 ,0.63 ,0.91 ,1.52 ,1.19 ,0.69 ,0.28 ,1.00 ,1.27 ,1.29 ,1.37 ,1.00 ,0.66 ,0.42 ,0.60 ,1.14 ,1.49 ,1.05 ,0.52 ,0.46 ,1.14 ,1.23 ,1.33 ,1.26 ,0.89 ,0.58 ,0.46 ,0.66 ,1.31 ,1.47 ,1.02 ,0.44 ,0.48 ,1.24 ,1.11 ,1.36 ,1.24 ,0.93 ,0.52 ,0.51 ,0.84 ,1.37 ,1.29 ,0.77 ,0.76 ,1.38 ,1.30 ,1.43 ,1.14 ,0.66 ,0.36 ,0.56 ,0.92 ,1.51 ,1.30 ,0.81 ,0.26 ,1.07 ,1.18 ,1.03 ,1.47 ,0.98 ,0.76 ,0.54 ,0.60 ,1.03 ,1.41 ,1.16 ,0.53 ,0.36 ,1.03 ,1.37 ,1.29 ,1.38 ,0.87 ,0.66 ,0.31 ,0.73 ,1.30 ,1.44 ,0.97 ,0.38 ,0.52 ,1.22 ,1.29 ,1.40 ,1.21 ,0.85 ,0.52 ,0.42 ,1.23 ,1.58 ,1.06 ,0.49 ,0.48 ,1.13 ,1.09 ,1.33 ,1.21 ,1.01 ,0.62 ,0.52 ,0.82 ,1.32 ,1.24 ,0.74 ,0.37 ,0.74 ,1.37 ,1.33 ,1.51 ,0.99 ,0.67 ,0.40 ,0.44 ,1.01 ,1.52 ,1.34 ,0.69 ,0.30 ,0.96 ,1.17 ,1.14 ,1.41 ,1.10 ,0.70 ,0.53 ,0.58 ,0.93 ,1.46 ,1.26 ,0.72 ,0.31 ,1.01 ,1.17 ,1.25 ,1.04 ,0.73 ,0.44 ,0.74 ,1.20 ,1.33 ,0.89 ,0.42 ,0.56 ,1.24 ,1.40 ,1.44 ,1.20 ,0.77 ,0.42 ,0.39 ,0.76 ,1.39 ,1.59 ,0.98 ,0.33 ,0.62 ,1.20 ,1.04 ,1.38 ,1.24 ,0.92 ,0.52 ,0.62 ,0.74 ,1.36 ,1.30 ,0.79 ,0.33 ,0.75 ,1.35 ,1.25 ,1.39 ,1.05 ,0.78 ,0.34 ,0.51 ,1.00 ,1.52 ,1.21 ,0.65 ,1.04 ,1.24 ,1.29 ,1.34 ,0.98 ,0.74 ,0.37 ,0.67 ,1.07 ,1.54 ,1.08 ,0.60 ,0.34 ,1.11 ,1.22 ,1.36 ,1.24 ,0.99 ,0.60 ,0.40 ,0.71 ,1.28 ,1.41 ,0.92 ,0.41 ,0.54 ,1.26 ,1.25 ,1.47 ,1.13 ,0.82 ,0.48 ,0.45 ,0.72 ,1.43 ,1.42 ,0.93 ,0.30 ,0.78 ,1.21 ,1.09 ,1.50 ,1.04 ,0.91 ,0.47 ,0.55 ,0.85 ,1.30 ,0.68 ,0.30 ,0.89 ,1.27 ,1.28 ,1.50 ,0.97 ,0.76 ,0.37 ,0.56 ,1.03 ,1.58 ,1.14 ,0.62 ,0.33 ,1.12 ,1.18 ,1.30 ,1.33 ,0.95 ,0.62 ,0.42 ,0.59 ,1.16 ,1.50 ,1.08 ,0.53 ,0.43 ,1.19 ,1.16 ,1.32 ,1.24 ,0.96 ,0.54 ,0.50 ,0.76 ,1.36 ,1.30 ,0.85 ,0.32 ,0.74 ,1.37 ,1.21 ,1.43 ,1.12 ,0.40 ,0.48 ,0.94 ,1.51 ,1.35 ,0.73 ,0.25 ,0.94 ,1.18 ,1.22 ,1.42 ,0.99 ,0.88 ,0.36 ,0.59 ,1.03 ,1.50 ,1.18 ,0.63 ,0.27 ,0.97 ,1.34 ,1.29 ,1.37 ,0.98 ,0.72 ,0.27 ,0.65 ,1.13 ,1.54 ,1.01 ,0.49 ,0.43 ,1.17 ,1.23 ,1.38 ,1.22 ,0.94 ,0.54 ,0.46 ,0.67 ,1.22 ,1.49 ,1.05 ,0.53 ,0.54 ,1.14 ,1.30 ,1.17 ,0.97 ,0.58 ,0.61 ,0.80 ,1.40 ,1.16 ,0.68 ,0.33 ,0.82 ,1.43 ,1.31 ,1.43 ,1.01 ,0.65 ,0.35 ,0.53 ,1.05 ,1.60 ,1.23 ,0.69 ,0.31 ,1.02 ,1.16 ,1.25 ,1.33 ,1.11 ,0.66 ,0.44 ,0.64 ,0.99 ,1.44 ,1.14 ,0.60 ,0.30 ,1.15 ,1.14 ,1.27 ,1.38 ,0.91 ,0.64 ,0.43 ,0.74 ,1.18 ,1.46 ,0.45 ,0.55 ,1.30 ,1.19 ,1.42 ,1.17 ,0.84 ,0.41 ,0.52 ,0.67 ,1.46 ,1.42 ,0.89 ,0.25 ,0.74 ,1.22 ,1.17 ,1.44 ,1.14 ,0.84 ,0.44 ,0.54 ,0.85 ,1.45 ,1.30 ,0.83 ,0.25 ,0.84 ,1.29 ,1.19 ,1.45 ,1.02 ,0.83 ,0.37 ,0.60 ,0.95 ,1.54 ,1.19 ,0.65 ,0.26 ,1.02 ,1.28 ,1.33 ,1.36 ,1.01 ,0.68 ,0.59 ,1.11 ,1.56 ,1.09 ,0.58 ,0.31 ,1.14 ,1.20 ,1.32 ,1.35 ,0.89 ,0.66 ,0.39 ,0.65 ,1.18 ,1.54 ,1.03 ,0.50 ,0.42 ,1.23 ,1.10 ,1.44 ,1.21 ,0.91 ,0.60 ,0.41 ,0.75 ,1.28 ,1.48 ,0.79 ,0.44 ,0.54 ,1.30 ,1.28 ,1.45 ,1.12 ,0.86 ,0.39 ,0.54 ,0.78 ,1.51 ,1.36 ,0.89 ,0.26 ,0.82 ,1.27 ,1.13 ,1.10 ,0.84 ,0.44 ,0.60 ,0.95 ,1.44 ,1.23 ,0.67 ,0.27 ,0.98 ,1.36 ,1.21 ,1.50 ,0.97 ,0.67 ,0.39 ,0.60 ,1.11 ,1.55 ,1.12 ,0.50 ,0.35 ,1.15 ,1.21 ,1.35 ,1.32 ,0.96 ,0.57 ,0.42 ,0.66 ,1.17 ,1.52 ,1.07 ,0.51 ,0.42 ,1.20 ,1.18 ,1.34 ,1.23 ,0.96 ,0.60 ,0.46 ,0.76 ,1.34 ,1.34 ,0.86 ,0.56 ,1.31 ,1.29 ,1.48 ,1.09 ,0.83 ,0.41 ,0.43 ,0.87 ,1.46 ,1.43 ,0.79 ,0.26 ,0.84 ,1.20 ,1.20 ,1.43 ,1.07 ,0.77 ,0.51 ,0.54 ,0.86 ,1.46 ,1.31 ,0.82 ,0.32 ,0.89 ,1.19 ,1.21 ,1.43 ,0.94 ,0.88 ,0.42 ,0.66 ,1.02 ,1.48 ,0.99 ,0.50 ,0.44 ,1.11 ,1.29 ,1.48 ,1.25 ,0.91 ,0.56 ,0.37 ,1.23 ,1.59 ,1.10 ,0.50 ,0.41 ,1.19 ,1.11 ,1.29 ,1.31 ,0.98 ,0.59 ,0.51 ,0.70 ,1.27 ,1.37 ,0.95 ,0.38 ,0.56 ,1.30 ,1.25 ,1.41 ,1.22 ,0.80 ,0.46 ,0.45 ,0.82 ,1.45 ,1.37 ,0.80 ,0.27 ,0.80 ,1.27 ,1.22 ,1.44 ,1.04 ,0.82 ,0.39 ,0.55 ,0.91 ,1.43 ,1.35 ,0.82 ,0.25 ,0.86 ,1.28 ,1.10 ,1.44 ,0.79 ,0.46 ,0.55 ,1.08 ,1.38 ,1.12 ,0.41 ,0.49 ,1.01 ,1.34 ,1.42 ,1.35 ,0.81 ,0.67 ,0.36 ,0.62 ,1.09 ,1.66 ,1.14 ,0.57 ,0.39 ,1.10 ,1.03 ,1.34 ,1.25 ,0.99 ,0.73 ,0.43 ,0.66 ,1.26 ,1.34 ,0.93 ,0.37 ,0.56 ,1.21 ,1.34 ,1.46 ,1.19 ,0.80 ,0.49 ,0.39 ,0.77 ,1.40 ,1.49 ,0.86 ,0.33 ,1.17 ,1.14 ,1.46 ,1.07 ,0.90 ,0.53 ,0.54 ,0.77 ,1.42 ,1.33 ,0.90 ,0.29 ,0.81 ,1.27 ,1.14 ,1.38 ,1.09 ,0.82 ,0.45 ,0.65 ,1.03 ,1.40 ,1.07 ,0.49 ,0.44 ,1.10 ,1.38 ,1.37 ,1.32 ,0.90 ,0.54 ,0.39 ,0.63 ,1.28 ,1.55 ,1.11 ,0.43 ,0.46 ,1.21 ,1.12 ,1.24 ,1.36 ,0.91 ,0.55 ,0.53 ,0.65 ,1.43 ,0.99 ,0.42 ,0.55 ,1.23 ,1.19 ,1.39 ,1.14 ,0.92 ,0.48 ,0.52 ,0.87 ,1.45 ,1.20 ,0.76 ,0.31 ,0.75 ,1.38 ,1.28 ,1.41 ,1.05 ,0.70 ,0.39 ,0.51 ,1.01 ,1.56 ,1.30 ,0.70 ,0.25 ,1.00 ,1.15 ,1.24 ,1.37 ,1.03 ,0.77 ,0.44 ,0.65 ,0.98 ,1.53 ,1.07 ,0.66 ,0.31 ,1.09 ,1.21 ,1.37 ,1.29 ,0.67 ,0.41 ,0.67 ,1.27 ,1.45 ,1.00 ,0.42 ,0.51 ,1.25 ,1.18 ,1.43 ,1.21 ,0.88 ,0.52 ,0.49 ,0.72 ,1.38 ,1.43 ,0.92 ,0.32 ,0.66 ,1.21 ,1.18 ,1.40 ,1.16 ,0.84 ,0.48 ,0.54 ,0.83 ,1.45 ,1.25 ,0.81 ,0.22 ,0.91 ,1.30 ,1.17 ,1.43 ,1.05 ,0.68 ,0.36 ,0.59 ,0.96 ,1.49 ,1.22 ,0.64 ,0.24 ,1.08 ,1.25 ,1.38 ,0.98 ,0.66 ,0.40 ,0.72 ,1.15 ,1.46 ,0.97 ,0.45 ,0.44 ,1.24 ,1.29 ,1.37 ,1.25 ,0.85 ,0.44 ,0.44 ,0.71 ,1.40 ,1.45 ,0.88 ,0.31 ,0.68 ,1.17 ,1.17 ,1.44 ,1.15 ,0.90 ,0.46 ,0.54 ,0.78 ,1.44 ,1.28 ,0.87 ,0.29 ,0.80 ,1.29 ,1.21 ,1.42 ,1.01 ,0.86 ,0.36 ,0.57 ,1.01 ,1.50 ,0.61 ,0.32 ,0.98 ,1.33 ,1.30 ,1.39 ,0.95 ,0.67 ,0.38 ,0.60 ,1.16 ,1.56 ,1.08 ,0.54 ,0.41 ,1.16 ,1.16 ,1.35 ,1.29 ,0.92 ,0.61 ,0.47 ,0.68 ,1.23 ,1.49 ,0.96 ,0.46 ,0.56 ,1.20 ,1.19 ,1.41 ,1.10 ,0.95 ,0.48 ,0.51 ,0.82 ,1.46 ,1.30 ,0.78 ,0.29 ,0.81 ,1.35 ,1.25 ,1.42 ,1.08 ,0.70 ,0.38 ,0.97 ,1.52 ,1.26 ,0.72 ,0.30 ,1.04 ,1.17 ,1.21 ,1.33 ,1.05 ,0.71 ,0.44 ,0.69 ,1.07 ,1.46 ,1.02 ,0.55 ,0.34 ,1.22 ,1.26 ,1.32 ,1.25 ,0.91 ,0.57 ,0.37 ,0.79 ,1.34 ,1.42 ,0.85 ,0.35 ,0.63 ,1.31 ,1.22 ,1.42 ,1.11 ,0.87 ,0.40 ,0.55 ,0.80 ,1.49 ,1.33 ,0.87 ,0.27 ,0.85 ,1.16 ,1.26 ,1.08 ,0.82 ,0.44 ,0.58 ,0.96 ,1.51 ,1.09 ,0.68 ,0.31 ,1.00 ,1.35 ,1.29 ,1.36 ,0.92 ,0.69 ,0.30 ,0.63 ,1.14 ,1.55 ,1.10 ,0.50 ,0.35 ,1.20 ,1.13 ,1.41 ,1.26 ,0.93 ,0.61 ,0.42 ,0.67 ,1.29 ,1.47 ,0.94 ,0.43 ,0.50 ,1.24 ,1.22 ,1.43 ,1.18 ,0.87 ,0.48 ,0.46 ,0.74 ,1.42 ,1.40 ,0.93 ,0.72 ,1.26 ,1.15 ,1.40 ,1.16 ,0.80 ,0.49 ,0.55 ,0.85 ,1.44 ,1.23 ,0.76 ,0.27 ,0.93 ,1.29 ,1.23 ,1.41 ,1.01 ,0.77 ,0.34 ,0.68 ,1.03 ,1.52 ,1.17 ,0.58 ,0.27 ,1.15 ,1.27 ,1.28 ,1.40 ,0.94 ,0.63 ,0.39 ,0.69 ,1.21 ,1.54 ,0.96 ,0.46 ,0.41 ,1.22 ,1.27 ,1.39 ,1.25 ,0.91 ,0.47 ,0.46 ,0.67 ,1.48 ,0.99 ,0.37 ,0.58 ,1.19 ,1.14 ,1.40 ,1.15 ,0.94 ,0.51 ,0.51 ,0.77 ,1.46 ,1.28 ,0.79 ,0.28 ,0.80 ,1.28 ,1.31 ,1.45 ,1.01 ,0.80 ,0.37 ,0.51 ,0.91 ,1.55 ,1.28 ,0.78 ,0.25 ,0.98 ,1.21 ,1.21 ,1.38 ,1.00 ,0.78 ,0.44 ,0.62 ,1.01 ,1.51 ,1.14 ,0.61 ,0.31 ,1.12 ,1.22 ,1.33 ,1.35 ,0.67 ,0.39 ,0.71 ,1.24 ,1.49 ,0.93 ,0.42 ,0.48 ,1.25 ,1.22 ,1.44 ,1.24 ,0.81 ,0.51 ,0.44 ,0.67 ,1.36 ,1.47 ,1.05 ,0.34 ,0.64 ,1.20 ,1.12 ,1.34 ,1.15 ,1.00 ,0.43 ,0.60 ,0.78 ,1.40 ,1.30 ,0.81 ,0.27 ,0.78 ,1.33 ,1.25 ,1.44 ,1.10 ,0.75 ,0.35 ,0.56 ,0.91 ,1.51 ,1.24 ,0.68 ,0.27 ,1.26 ,1.26 ,1.39 ,0.96 ,0.76 ,0.39 ,0.63 ,1.09 ,1.54 ,1.11 ,0.61 ,0.29 ,1.09 ,1.29 ,1.28 ,1.35 ,0.95 ,0.70 ,0.34 ,0.70 ,1.26 ,1.45 ,0.98 ,0.40 ,0.45 ,1.20 ,1.20 ,1.53 ,1.14 ,0.90 ,0.53 ,0.36 ,0.80 ,1.22 ,1.61 ,0.83 ,0.52 ,0.52 ,1.17 ,1.14 ,1.46 ,1.12 ,0.95 ,0.55 ,0.49 ,0.74 ,1.41 ,0.85 ,0.37 ,0.68 ,1.26 ,1.26 ,1.42 ,1.04 ,0.92 ,0.33 ,0.57 ,0.90 ,1.56 ,1.19 ,0.67 ,0.30 ,0.97 ,1.31 ,1.33 ,1.38 ,0.97 ,0.68 ,0.39 ,0.57 ,1.05 ,1.57 ,1.20 ,0.66 ,0.27 ,1.12 ,1.15 ,1.19 ,1.36 ,1.00 ,0.70 ,0.44 ,0.72 ,1.10 ,1.46 ,0.98 ,0.47 ,0.46 ,1.24 ,1.18 ,1.46 ,1.20 ,0.86 ,0.44 ,0.65 ,1.40 ,1.43 ,0.95 ,0.31 ,0.66 ,1.20 ,1.19 ,1.39 ,1.20 ,0.83 ,0.41 ,0.60 ,0.66 ,1.40 ,1.37 ,0.92 ,0.39 ,0.73 ,1.08 ,1.33 ,1.31 ,1.00 ,1.10 ,0.31 ,0.59 ,0.95 ,1.47 ,1.19 ,0.54 ,0.33 ,0.87 ,1.37 ,1.45 ,1.44 ,0.88 ,0.77 ,0.21 ,0.57 ,1.05 ,1.70 ,1.09 ,0.64 ,0.32 ,1.05 ,1.40 ,1.28 ,0.98 ,0.75 ,0.38 ,0.67 ,0.98 ,1.53 ,1.14 ,0.74 ,0.36 ,1.13 ,1.08 ,1.29 ,1.19 ,1.02 ,0.73 ,0.44 ,0.91 ,1.19 ,1.24 ,0.61 ,0.46 ,0.75 ,1.37 ,1.38 ,1.48 ,1.02 ,0.54 ,0.52 ,0.42 ,0.96 ,1.55 ,1.42 ,0.69 ,0.29 ,0.98 ,1.06 ,1.18 ,1.42 ,1.15 ,0.74 ,0.51 ,0.62 ,0.81 ,1.43 ,1.23 ,0.27 ,0.98 ,1.18 ,1.22 ,1.30 ,1.03 ,0.79 ,0.38 ,0.75 ,1.13 ,1.43 ,0.92 ,0.51 ,0.43 ,1.23 ,1.35 ,1.45 ,1.18 ,0.90 ,0.47 ,0.37 ,0.75 ,1.36 ,1.57 ,0.95 ,0.41 ,0.52 ,1.18 ,1.15 ,1.37 ,1.18 ,0.92 ,0.54 ,0.49 ,0.69 ,1.27 ,1.43 ,1.02 ,0.41 ,0.51 ,1.27 ,1.12 ,1.39 ,1.16 ,0.92 ,0.54 ,0.92 ,1.37 ,1.16 ,0.59 ,0.39 ,0.84 ,1.36 ,1.38 ,1.46 ,0.88 ,0.70 ,0.35 ,0.50 ,1.05 ,1.63 ,1.23 ,0.78 ,0.37 ,0.95 ,1.16 ,1.24 ,1.38 ,1.00 ,0.77 ,0.50 ,0.50 ,0.96 ,1.51 ,1.21 ,0.74 ,0.29 ,0.99 ,1.26 ,1.23 ,1.33 ,1.00 ,0.70 ,0.45 ,0.68 ,1.13 ,1.42 ,1.00 ,0.47 ,0.45 ,1.22 ,1.22 ,1.23 ,0.85 ,0.54 ,0.42 ,0.74 ,1.35 ,1.49 ,0.89 ,0.35 ,0.59 ,1.29 ,1.14 ,1.46 ,1.18 ,0.87 ,0.47 ,0.49 ,0.75 ,1.40 ,1.45 ,0.86 ,0.34 ,0.64 ,1.27 ,1.16 ,1.43 ,1.08 ,0.93 ,0.40 ,0.53 ,0.87 ,1.47 ,1.28 ,0.73 ,0.26 ,0.82 ,1.36 ,1.30 ,1.44 ,1.01 ,0.81 ,0.27 ,0.59 ,0.95 ,1.53 ,1.34 ,0.64 ,1.00 ,1.17 ,1.23 ,1.49 ,0.94 ,0.85 ,0.34 ,0.65 ,0.98 ,1.59 ,1.10 ,0.62 ,0.28 ,1.10 ,1.21 ,1.33 ,1.39 ,0.90 ,0.65 ,0.43 ,0.61 ,1.17 ,1.50 ,1.09 ,0.48 ,0.51 ,1.16 ,1.17 ,1.36 ,1.20 ,0.95 ,0.61 ,0.49 ,0.68 ,1.29 ,1.42 ,0.99 ,0.40 ,0.53 ,1.26 ,1.16 ,1.40 ,1.13 ,0.90 ,0.48 ,0.47 ,1.39 ,1.32 ,0.69 ,0.30 ,0.75 ,1.36 ,1.28 ,1.49 ,1.05 ,0.70 ,0.40 ,0.50 ,0.84 ,1.56 ,1.34 ,0.83 ,0.25 ,0.92 ,1.16 ,1.15 ,1.37 ,1.11 ,0.79 ,0.49 ,0.63 ,0.95 ,1.42 ,1.14 ,0.59 ,0.27 ,1.06 ,1.33 ,1.29 ,1.46 ,0.89 ,0.67 ,0.34 ,0.64 ,1.19 ,1.57 ,1.08 ,0.52 ,0.33 ,1.16 ,1.22 ,1.32 ,1.01 ,0.52 ,0.42 ,0.68 ,1.18 ,1.50 ,1.01 ,0.51 ,0.41 ,1.26 ,1.17 ,1.35 ,1.23 ,0.95 ,0.58 ,0.41 ,0.83 ,1.35 ,1.35 ,0.80 ,0.32 ,0.60 ,1.36 ,1.28 ,1.47 ,1.15 ,0.74 ,0.43 ,0.42 ,0.84 ,1.55 ,1.38 ,0.84 ,0.25 ,0.79 ,1.20 ,1.23 ,1.37 ,1.14 ,0.81 ,0.48 ,0.55 ,0.82 ,1.43 ,1.33 ,0.87 ,0.28 ,1.20 ,1.14 ,1.43 ,1.03 ,0.87 ,0.39 ,0.67 ,1.01 ,1.44 ,1.10 ,0.52 ,0.37 ,1.08 ,1.27 ,1.42 ,1.34 ,0.93 ,0.57 ,0.35 ,0.66 ,1.20 ,1.62 ,1.05 ,0.51 ,0.37 ,1.27 ,1.08 ,1.33 ,1.32 ,0.92 ,0.61 ,0.50 ,0.73 ,1.22 ,1.45 ,0.95 ,0.46 ,0.46 ,1.31 ,1.17 ,1.40 ,1.20 ,0.89 ,0.49 ,0.47 ,0.82 ,1.33 ,0.75 ,0.31 ,0.70 ,1.39 ,1.27 ,1.43 ,1.06 ,0.76 ,0.37 ,0.48 ,0.88 ,1.51 ,1.42 ,0.80 ,0.25 ,0.83 ,1.21 ,1.15 ,1.41 ,1.13 ,0.83 ,0.41 ,0.62 ,0.92 ,1.48 ,1.14 ,0.72 ,0.27 ,0.95 ,1.42 ,1.26 ,1.41 ,0.98 ,0.66 ,0.36 ,0.58 ,1.14 ,1.52 ,1.19 ,0.51 ,0.39 ,1.12 ,1.16 ,1.37 ,1.27 ,0.60 ,0.49 ,0.62 ,1.22 ,1.48 ,1.03 ,0.52 ,0.41 ,1.17 ,1.23 ,1.36 ,1.24 ,0.88 ,0.66 ,0.41 ,0.71 ,1.35 ,1.40 ,0.91 ,0.37 ,0.59 ,1.26 ,1.20 ,1.50 ,1.08 ,0.91 ,0.39 ,0.54 ,0.77 ,1.42 ,1.39 ,0.86 ,0.29 ,0.81 ,1.24 ,1.17 ,1.42 ,1.09 ,0.83 ,0.47 ,0.56 ,0.92 ,1.44 ,1.29 ,0.64 ,0.32 ,0.92 ,1.22 ,1.51 ,0.96 ,0.75 ,0.32 ,0.64 ,1.07 ,1.55 ,1.03 ,0.52 ,0.45 ,1.26 ,1.24 ,1.37 ,1.23 ,0.98 ,0.49 ,0.46 ,0.69 ,1.11 ,1.49 ,1.10 ,0.66 ,0.44 ,1.15 ,1.09 ,1.19 ,1.23 ,0.97 ,0.63 ,0.61 ,0.96 ,1.25 ,1.09 ,0.51 ,0.52 ,0.82 ,1.55 ,1.46 ,1.39 ,0.90 ,0.54 ,0.42 ,0.61 ,1.25 ,1.56 ,0.43 ,0.51 ,1.09 ,1.02 ,1.42 ,1.24 ,0.98 ,0.71 ,0.50 ,0.70 ,0.94 ,1.51 ,1.15 ,0.88 ,0.35 ,1.03 ,1.13 ,1.23 ,1.11 ,1.06 ,0.69 ,0.56 ,0.94 ,1.18 ,1.12 ,0.53 ,0.53 ,0.85 ,1.40 ,1.46 ,1.48 ,0.82 ,0.61 ,0.37 ,0.45 ,1.07 ,1.66 ,1.23 ,0.68 ,0.30 ,1.05 ,1.05 ,1.25 ,1.33 ,1.09 ,0.70 ,0.61 ,0.96 ,1.44 ,1.16 ,0.67 ,0.33 ,1.10 ,1.13 ,1.26 ,1.34 ,0.95 ,0.68 ,0.42 ,0.75 ,1.25 ,1.32 ,0.89 ,0.40 ,0.69 ,1.32 ,1.23 ,1.38 ,1.17 ,0.74 ,0.49 ,0.53 ,0.86 ,1.40 ,1.46 ,0.80 ,0.28 ,0.80 ,1.20 ,1.14 ,1.41 ,1.12 ,0.82 ,0.40 ,0.63 ,0.89 ,1.50 ,1.07 ,0.65 ,0.28 ,0.99 ,1.35 ,1.39 ,1.00 ,0.57 ,0.31 ,0.60 ,1.10 ,1.57 ,1.11 ,0.60 ,0.36 ,1.21 ,1.05 ,1.29 ,1.30 ,0.94 ,0.69 ,0.49 ,0.73 ,1.23 ,1.38 ,0.94 ,0.39 ,0.56 ,1.28 ,1.21 ,1.51 ,1.13 ,0.82 ,0.50 ,0.45 ,0.78 ,1.45 ,1.39 ,0.79 ,0.31 ,0.85 ,1.19 ,1.21 ,1.50 ,1.02 ,0.82 ,0.42 ,0.60 ,0.77 ,1.50 ,1.28 ,0.86 ,0.82 ,1.18 ,1.14 ,1.33 ,1.06 ,0.85 ,0.48 ,0.69 ,1.11 ,1.33 ,0.95 ,0.41 ,0.53 ,1.06 ,1.50 ,1.41 ,1.32 ,0.80 ,0.50 ,0.34 ,0.68 ,1.28 ,1.64 ,1.03 ,0.43 ,0.51 ,1.19 ,1.05 ,1.31 ,1.28 ,0.91 ,0.60 ,0.49 ,0.64 ,1.16 ,1.45 ,1.04 ,0.50 ,0.44 ,1.24 ,1.15 ,1.30 ,1.21 ,0.99 ,0.48 ,0.53 ,1.32 ,1.24 ,0.65 ,0.38 ,0.78 ,1.44 ,1.34 ,1.41 ,0.96 ,0.67 ,0.29 ,0.51 ,1.03 ,1.59 ,1.31 ,0.66 ,0.22 ,1.04 ,1.10 ,1.25 ,1.41 ,1.07 ,0.76 ,0.41 ,0.67 ,0.90 ,1.54 ,1.10 ,0.67 ,0.30 ,1.12 ,1.15 ,1.37 ,1.31 ,0.94 ,0.72 ,0.38 ,0.67 ,1.19 ,1.49 ,0.94 ,0.48 ,0.48 ,1.25 ,1.21 ,1.41 ,1.16 ,0.51 ,0.51 ,0.71 ,1.41 ,1.38 ,0.91 ,0.26 ,0.75 ,1.28 ,1.13 ,1.49 ,1.10 ,0.84 ,0.46 ,0.65 ,0.78 ,1.52 ,1.26 ,0.75 ,0.26 ,0.95 ,1.20 ,1.30 ,1.40 ,1.02 ,0.78 ,0.34 ,0.63 ,0.95 ,1.57 ,1.13 ,0.71 ,0.23 ,1.07 ,1.28 ,1.20 ,1.41 ,0.95 ,0.67 ,0.42 ,0.66 ,1.15 ,1.47 ,1.07 ,0.48 ,0.40 ,1.23 ,1.37 ,1.27 ,0.91 ,0.59 ,0.37 ,0.78 ,1.27 ,1.55 ,0.86 ,0.43 ,0.52 ,1.25 ,1.19 ,1.49 ,1.11 ,0.96 ,0.40 ,0.48 ,0.75 ,1.39 ,1.39 ,0.87 ,0.38 ,0.61 ,1.24 ,1.23 ,1.33 ,1.14 ,0.83 ,0.46 ,0.51 ,0.88 ,1.54 ,1.13 ,0.81 ,0.32 ,0.89 ,1.30 ,1.33 ,1.33 ,1.01 ,0.71 ,0.45 ,0.58 ,1.04 ,1.19 ,0.67 ,0.37 ,1.10 ,1.11 ,1.22 ,1.24 ,1.04 ,0.71 ,0.50 ,0.82 ,1.24 ,1.26 ,0.75 ,0.43 ,0.61 ,1.40 ,1.38 ,1.43 ,1.11 ,0.64 ,0.40 ,0.44 ,0.90 ,1.51 ,1.34 ,0.75 ,0.26 ,1.01 ,1.13 ,1.19 ,1.38 ,1.10 ,0.70 ,0.51 ,0.66 ,0.85 ,1.44 ,1.24 ,0.80 ,0.29 ,1.02 ,1.17 ,1.14 ,1.40 ,0.96 ,0.87 ,0.82 ,1.11 ,1.31 ,0.79 ,0.48 ,0.57 ,1.31 ,1.31 ,1.54 ,1.12 ,0.70 ,0.54 ,0.34 ,0.82 ,1.43 ,1.57 ,0.88 ,0.30 ,0.71 ,1.08 ,1.21 ,1.35 ,1.24 ,0.90 ,0.43 ,0.64 ,0.62 ,1.36 ,1.32 ,1.03 ,0.26 ,0.76 ,1.20 ,1.11 ,1.37 ,1.07 ,0.96 ,0.39 ,0.65 ,0.96 ,1.42 ,1.06 ,0.62 ,0.37 ,0.99 ,1.40 ,1.34 ,0.88 ,0.62 ,0.34 ,0.60 ,1.23 ,1.51 ,1.11 ,0.42 ,0.45 ,1.16 ,1.18 ,1.29 ,1.28 ,0.94 ,0.58 ,0.52 ,0.60 ,1.21 ,1.43 ,1.05 ,0.42 ,0.53 ,1.19 ,1.11 ,1.38 ,1.22 ,0.93 ,0.55 ,0.54 ,0.80 ,1.36 ,1.28 ,0.70 ,0.38 ,0.76 ,1.37 ,1.30 ,1.45 ,1.02 ,0.68 ,0.37 ,0.56 ,0.89 ,1.59 ,1.29 ,0.20 ,1.01 ,1.15 ,1.15 ,1.41 ,1.06 ,0.80 ,0.42 ,0.67 ,0.99 ,1.52 ,1.03 ,0.58 ,0.32 ,1.10 ,1.32 ,1.41 ,1.32 ,0.90 ,0.59 ,0.37 ,0.62 ,1.24 ,1.54 ,1.06 ,0.48 ,0.46 ,1.17 ,1.16 ,1.36 ,1.25 ,1.00 ,0.50 ,0.52 ,0.70 ,1.19 ,1.44 ,1.05 ,0.53 ,0.50 ,1.20 ,1.10 ,1.39 ,1.16 ,1.00 ,0.55 ,0.89 ,1.37 ,1.26 ,0.66 ,0.34 ,0.69 ,1.41 ,1.32 ,1.47 ,1.04 ,0.67 ,0.37 ,0.43 ,1.02 ,1.54 ,1.36 ,0.66 ,0.26 ,1.04 ,1.07 ,1.21 ,1.47 ,0.98 ,0.75 ,0.42 ,0.61 ,0.82 ,1.49 ,1.26 ,0.77 ,0.34 ,0.97 ,1.10 ,1.20 ,1.35 ,1.01 ,0.78 ,0.48 ,0.73 ,1.18 ,1.30 ,0.80 ,0.44 ,0.61 ,1.21 ,1.45 ,1.42 ,0.72 ,0.46 ,0.41 ,0.73 ,1.40 ,1.53 ,1.03 ,0.32 ,0.63 ,1.19 ,0.97 ,1.38 ,1.27 ,0.91 ,0.58 ,0.65 ,0.73 ,1.33 ,1.22 ,0.80 ,0.27 ,0.87 ,1.32 ,1.28 ,1.47 ,1.05 ,0.78 ,0.31 ,0.55 ,0.92 ,1.53 ,1.36 ,0.76 ,0.22 ,1.06 ,1.13 ,1.08 ,1.44 ,1.05 ,0.76 ,0.47 ,0.68 ,1.03 ,1.44 ,1.05 ,0.53 ,1.09 ,1.38 ,1.34 ,1.33 ,0.92 ,0.57 ,0.34 ,0.70 ,1.33 ,1.50 ,1.02 ,0.35 ,0.52 ,1.25 ,1.11 ,1.41 ,1.28 ,0.86 ,0.50 ,0.54 ,0.59 ,1.34 ,1.44 ,1.07 ,0.42 ,0.55 ,1.16 ,1.18 ,1.28 ,1.24 ,0.95 ,0.43 ,0.64 ,0.76 ,1.42 ,1.19 ,0.76 ,0.34 ,0.81 ,1.33 ,1.35 ,1.48 ,0.99 ,0.74 ,0.35 ,0.56 ,0.87 ,1.31 ,0.78 ,0.21 ,0.97 ,1.15 ,1.18 ,1.44 ,1.04 ,0.80 ,0.46 ,0.62 ,1.03 ,1.47 ,1.05 ,0.56 ,0.28 ,1.03 ,1.34 ,1.38 ,1.39 ,0.83 ,0.66 ,0.30 ,0.65 ,1.15 ,1.64 ,1.09 ,0.53 ,0.34 ,1.18 ,1.05 ,1.38 ,1.28 ,0.96 ,0.71 ,0.37 ,0.79 ,1.11 ,1.53 ,0.95 ,0.52 ,0.38 ,1.27 ,1.17 ,1.44 ,1.17 ,0.54 ,0.37 ,0.82 ,1.31 ,1.42 ,0.80 ,0.40 ,0.59 ,1.31 ,1.29 ,1.46 ,1.10 };
					int size = arraydata2.length;
					System.out.println(size);
					os.writeUTF(message);
					os.writeInt(size);
					for(int i=0; i<size;i++) {
						os.writeDouble(arraydata2[i]);
					}					
				}
				else {
					System.out.println("Client: "+message);
					os.writeUTF(message);
				}
				
			}
			while(!message.equals("CLOSE"));
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("Can not connect to Server");
		}
		finally {
			try {
				System.out.println("*Connection has been released*");
				socket.close();
			}
			catch(IOException e) {
				System.out.println("Still connected.");
				System.exit(1);
			}
		}
	}
	
	
}