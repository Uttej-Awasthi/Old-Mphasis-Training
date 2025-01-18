package com;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) throws Exception{
		File ff = new File("D:\\A\\a.txt");	// file path 
		System.out.println(ff.getAbsolutePath());
		System.out.println(ff.getName());
		System.out.println("Read mode "+ff.canRead());
		System.out.println("Writer mode "+ff.canWrite());
		System.out.println("File present "+ff.exists());
		System.out.println(" File or directory"+ff.isDirectory());
		System.out.println("File or directory "+ff.isFile());
	}

}
