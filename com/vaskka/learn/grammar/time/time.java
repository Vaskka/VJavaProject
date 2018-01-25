/*
javac -encoding utf-8 com/vaskka/learn/grammar/time/time.java
java com/vaskka/learn/grammar/time/Program
*/

/**
*@author Vaskka
*<p>
*计算出生日期与今天相距时间 可计算总共的天数 月份数 年数	
*</p>
*/
package com.vaskka.learn.grammar.time;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;


class Program {

	//用户输入的日期
	static int dateNum;
	//年月日
	static int yearNum;
	static int monthNum;
	static int dayNum;

	//当前日期和出生日期
	static LocalDate today;
	static LocalDate bornDate;
	//待求的时间间隔
	static Period periodTime;

	/**
	*<p>打印出生时间</p>
	*@param  void
	*@return void
	*
	*/
	static void showBornDate() {
		System.out.println("出生年份:" + String.valueOf(Program.yearNum));
		System.out.println("出生月份:" + String.valueOf(Program.monthNum));
		System.out.println("出生日期:" + String.valueOf(Program.dayNum));
	}

	/**
	*<p>处理用户输入的字符串</p>
	*@param  rowInput String 用户输入的字符串
	*@return void
	*
	*/
	static void dealInput(String rowInput) throws Exception {

		//处理字符串长度不符合要求的异常
		if (rowInput.toCharArray().length != 8) {
			throw new Exception(", 输入的日期格式异常!");
		}

		try {
			Program.dateNum = Integer.valueOf(rowInput);
		}
		catch (NumberFormatException e) {
			//处理字符串转换int的异常
			System.out.println(e.toString() + "输入的日期格式异常!");
			System.exit(1);
		}

		//将有效的日期字符串转为int
		Program.yearNum  = Integer.valueOf(rowInput.substring(0, 4));
		Program.monthNum = Integer.valueOf(rowInput.substring(4, 6));
		Program.dayNum   = Integer.valueOf(rowInput.substring(6, 8));

		//构造LocalDate
		Program.bornDate = LocalDate.of(Program.yearNum, Program.monthNum, Program.dayNum);

		//处理出生日期在当前日期之后的异常
		if (bornDate.isAfter(Program.today)) {
			throw new Exception("出生日期大于当前日期的异常!");
		}

	}

	/**
	*<p>向控制台打印日期经过的时间</p>
	*能够计算两个LocalDate之间经过的年月日
	*@param void
	*@return void
	*
	*/
	static void showPeriodTime() {
		//计算共经历的天数
		int sumDay = 0;

		//累加完整年的天数
		for (int i = Program.bornDate.getYear(); i < Program.today.getYear() - 1; i++) {
			LocalDate tempDate = LocalDate.of(i, 1, 1);
			//处理闰年
			if (tempDate.isLeapYear()) {
				sumDay += 366;
			}
			else {
				sumDay += 365;
			}
		}

		//计算非整年的月份 从出生的那个月开始记到完整月结束
		int tempMonth = Program.bornDate.getMonthValue();
		for (int i = 0; i < Program.periodTime.getMonths(); i++) {
			
			//按大小平月累加日期
			switch (tempMonth) {
				case 1 :
					sumDay += 31;
					break;
				case 2 :
					if (Program.today.isLeapYear()) {
						sumDay += 29;
					}
					else {
						sumDay += 28;
					}
					break;
				case 3 :
					sumDay += 31;
					break;
				case 4 :
					sumDay += 30;
					break;
				case 5 :
					sumDay += 31;
					break;
				case 6 :
					sumDay += 30;
					break;
				case 7 :
					sumDay += 31;
					break;
				case 8 :
					sumDay += 31;
					break;
				case 9 :
					sumDay += 30;
					break;
				case 10 :
					sumDay += 31;
					break;
				case 11 :
					sumDay += 30;
					break;
				case 12 : 
					sumDay += 31;
					break;
			}
			//处理超过12月的情况
			tempMonth++;
			if (tempMonth == 13) {
				tempMonth = 1;
			}
		}

		//剩下的天数直接相加
		sumDay += Program.periodTime.getDays();

		//向控制台输出
		System.out.println("今天是 " + Program.today.toString());
		System.out.printf("您已经%d岁啦\n", Program.periodTime.getYears());
		System.out.printf("从出生至今已过去%d月（%d天）\n", 
							Program.periodTime.getMonths() + Program.periodTime.getYears() * 12, 
							sumDay);
	}	

	/**
	*<p>处理输出</p>
	*@param  void
	*@return void
	*
	*/
	static void dealOutput() {
		Program.showBornDate();
		
		Program.periodTime = Period.between(Program.bornDate, Program.today);
		Program.showPeriodTime();

	}

	/**
	*<p>应用程序入口</p>
	*@param  argc String 控制台输入的命令行参数
	*@return void
	*
	*/
	public static void main(String[] args) throws Exception {
		//得到当前时间
		Program.today = LocalDate.now();

		Scanner input = new Scanner(System.in);

		System.out.println("请输入出生日期，例如：19910302");

		String rowInput = input.nextLine();

		dealInput(rowInput);
		dealOutput();

	}
}