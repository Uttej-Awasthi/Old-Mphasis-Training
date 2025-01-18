package com;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class CharacterWiseCopyFile {

	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("abc.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("demoinfo.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		int ch;
		while((ch=br.read()) != -1) {
			bw.write(ch);
		}
		bw.flush();
		
		fr.close();
		fw.close();
		System.out.println("File copied...");
	}

}
