package com.assigment2.pojo;

public class Time {
	int hours;
	int minutes;
	
	public void setTime(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}

	public void showTime() {
          System.out.println("hours= "+ hours +", minutes=" + minutes );
	}

	public Time sum(Time time) {
		hours=hours+time.hours;
		minutes=minutes+time.minutes;
		if(minutes>60) {
			hours=hours+minutes/60;
			minutes=minutes%60;
			
			
		}
		Time time1=new Time();
		time1.setTime(hours, minutes);
		
		return time1;
	}

	@Override
	public String toString() {
		return "Time [hours=" + hours + ", minutes=" + minutes + "]";
	}

	
	
}
