package com.Interview.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerilizableDriver {
	
	public static final String filePath = "D:\\file.txt";
	
	public static void writeObject() throws FileNotFoundException, IOException{
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
		//out.writeObject(new SerializableClass(1, "Jatin Sokhal"));
		out.close();
	}
	
	public static void readObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInput out = new ObjectInputStream(new FileInputStream(new File(filePath)));
		System.out.println(out.readObject());
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//writeObject();
		readObject();
	}

}

class SerializableClass implements Serializable{

	private static final long serialVersionUID = 1L;

	private int x;
	//private String str;
	private String str2;
	
	public SerializableClass(int x,String str,String str2) {
		this.x = x;
		this.str2 = str;
		this.str2 = str2;
	}
	
	public String toString(){
		return this.x+" :: "+this.str2;
	} 
	
}
