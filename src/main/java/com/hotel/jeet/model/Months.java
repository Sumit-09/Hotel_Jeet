/**
 * 
 */
package com.hotel.jeet.model;

/**
 * @author jangfateh.singh
 *
 */
public enum Months {
	JAN(0), FEB(1), MAR(2), APR(3), MAY(4), JUN(5), JUL(6), AUG(7), SEP(8), OCT(9), NOV(10), DEC(11);
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
