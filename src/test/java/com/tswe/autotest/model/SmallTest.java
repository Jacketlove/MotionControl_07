package com.tswe.autotest.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SmallTest {
	
	@Test
	public void listRemoveTest(){
		List<String> cmd = Collections.synchronizedList(new LinkedList<String>());
		cmd.add("a");
		cmd.add("c");
		cmd.add("d");
		cmd.add("e");
		cmd.remove(0);
		
		System.out.println(cmd.get(0));
		System.out.println(cmd.get(1));
		System.out.println(cmd.get(2));
		System.out.println(cmd.get(3));
		
	}
}
