package com.sishuok.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileHelper {
	private FileHelper(){}
	
	public static Object readFile(String filePathName){
		ObjectInputStream oin = null;
		try{
			oin = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File(filePathName)
							)
					)
				);
			Object obj = oin.readObject();
			
			return obj;
		}catch(Exception err){
			err.printStackTrace();
		}finally{
			try {
				oin.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void writeFile(String filePathName,Object obj){
		ObjectOutputStream oout = null;
		try{
			oout = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File(filePathName)
							)
					)
				);
			
			oout.writeObject(obj);
		}catch(Exception err){
			err.printStackTrace();
		}finally{
			try {
				oout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
