package com.css.howlong;

public enum MyDuration {
	
	HOURS(1,""),
	MINUTES(2,""),
	SECONDS(3,""),
	DAYS(4,""),
	WEEKS(5,""),
	MONTHS(6,""),
	YEARS(7,""),
	NOT_FOUND(8,"");
	
	
	private int id;
	private String durationMessage;
	
	private MyDuration(int id, String durationMessage) {
		this.id = id;
		this.durationMessage = durationMessage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDurationMessage() {
		return durationMessage;
	}

	public void setDurationMessage(String durationMessage) {
		this.durationMessage = durationMessage;
	}
	
	
	
	
	
	
	
	
	
}
