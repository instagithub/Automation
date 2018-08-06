/*package com.pega.cs.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
public class MakeSoftPhoneCall {
	
	public void makeCall(String phNumber) throws InterruptedException {
		String jacobDllVersionToUse = "jacob-1.18-x64.dll";

		Hashtable<String, String> source = new Hashtable<String, String>();
		System.out.println("phNumber 111 :" + phNumber);

		if (phNumber.equals("StartCall")) {
			phNumber = "~";
		} else if (phNumber.equals("Endcall")) {
			phNumber = "$";
		} else {
			phNumber = "$" + phNumber;
		}

		char arraysample[] = phNumber.toCharArray();
		int length = phNumber.length();

		//System.out.println("phNumber 222 :" + phNumber + "  length :  " + length);

		source.put("1", "257");
		source.put("2", "513");
		source.put("3", "769");
		source.put("4", "1025");
		source.put("5", "1281");
		source.put("6", "1537");
		source.put("7", "1793");
		source.put("8", "2049");
		source.put("9", "2305");
		source.put("0", "2817");
		source.put("~", "517"); // start
		source.put("$", "517"); // end

		File file = new File("lib", jacobDllVersionToUse);
		System.out.println("fasdfsdf : " + LibraryLoader.JACOB_DLL_PATH + " #### :  " + file.getAbsolutePath());
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		AutoItX x = new AutoItX();

		x.run("C:\\Program Files (x86)\\Cisco Systems\\Cisco IP Communicator\\communicatork9.exe");
		x.winActivate("Cisco IP Communicator");
		// System.out.println("return val 1 : "+x.winWaitActive("Cisco IP
		// Communicator"));

		for (int i = 0; i < length; i++) {

			System.out.println("Char  : " + arraysample[i] + " ### loop : " + i);
			System.out.println(
					"return val 2  : " + x.controlClick("Cisco IP Communicator", "", source.get(arraysample[i] + "")));
			// x.processWait("Cisco IP Communicator", 1000);
			Thread.sleep(500);

		}

		System.out.println("phNumber 333 :" + phNumber);
	}

}
*/