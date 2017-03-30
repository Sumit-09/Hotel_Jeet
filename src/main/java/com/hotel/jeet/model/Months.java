/**
 * 
 */
package com.hotel.jeet.model;

/**
 * @author jangfateh.singh
 *
 */
public enum Months {
	Jan(0), Feb(1), Mar(2), Apr(3), May(4), Jun(5), Jul(6), Aug(7), Sep(8), Oct(9), Nov(10), Dec(11);
	int monthNumber;

	Months(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public static String getMonthNameByMonthNumber(int monthNumber){
		String monthName=null;
		for(Months month : Months.values()){
			if(month.getMonthNumber()==monthNumber){
				monthName=month.name();
			}
		}
		return monthName;
	}
}
