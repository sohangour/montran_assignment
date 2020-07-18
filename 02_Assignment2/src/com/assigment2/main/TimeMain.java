package com.assigment2.main;

import com.assigment2.pojo.Time;

public class TimeMain {

	public static void main(String[] args) {
		Time time1=new Time();
		Time time2=new Time();
		Time time3=new Time();
		time1.setTime(12, 50);
		System.out.println("Time object 1 value:");
		time1.showTime();
		System.out.println("******************************************");
		time2.setTime(13, 52);
		System.out.println("Time object 2 value:");
		time2.showTime();
		System.out.println("******************************************");
		time3= time2.sum(time1);
		
		System.out.println("Time object 3:");
		time3.showTime();
	}

	

}
