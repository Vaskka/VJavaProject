/*
javac -encoding utf-8 com/vaskka/tool/random/VRandom.java
java com/vaskka/tool/random/VRandom

*/
package com.vaskka.tool.random;

import java.util.*;

class VRandom {


	public static void main(String[] argc) {
		//最大数
		int maxNum = 10;
		int minNum = 0;
		//要产生随机数的数量
		int count = 1;
		boolean isSame = true;

		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("请输入要产生随机数的最小值：");
				minNum = input.nextInt();

				System.out.println("请输入要产生随机数的最大值：");
				maxNum = input.nextInt();

				if (minNum >= maxNum) {
					throw new Exception("输入的随机数最大值小于等于最小值 ");
				}

				System.out.println("请输入要产生随机数的数量：");
				count = input.nextInt();
				if (count < 0) {
					throw new Exception("输入的随机数个数小于0 ");
				}

				System.out.println("请输入产生的随机数是否可以重复（输入“ 1 ”表示可以，其他表示不可以，输入字符串以第一个字符为准）：");
				String b = input.next();
				if (b.charAt(0) != '1') {
					isSame = false;
				}

				if (count > (maxNum - minNum + 1) && (!isSame)) {
					throw new Exception("当随机数不可重复时需要产生的随机数个数过多或随机数范围过小");
				}
				System.out.printf("产生的随机数最大值：%d\n产生的随机数最小值是：%d\n产生的随机数个数是：%d\n",
					maxNum, minNum, count);
				System.out.print("产生的随机数");
				if (!isSame) {
					System.out.print("不");
				}
				System.out.print("可以重复\n");
			}
			catch (InputMismatchException e) {
				System.out.println(e.toString() + "输入的数字格式不正确！请重新输入");
				continue;
			}
			catch (Exception e) {
				System.out.println(e.toString() + "而产生异常！请重新输入");
				continue;
			}

			Random rand = new Random();
			System.out.println("\n结果是：");
			if (isSame){
				for (int i = 0; i < count; i++) {
					int result = rand.nextInt(maxNum) % (maxNum - minNum + 1) + minNum;
					System.out.println(String.valueOf(i + 1) + ". " + result);
				}
			}
			else {
				int[] result = new int[count];

				for (int i = 0; i < count; i++) {
					while (true) {
						boolean c = true;
						//获得随机数
						result[i] = rand.nextInt(maxNum) % (maxNum - minNum + 1) + minNum;
						//检查是否有重复
						for (int j = i - 1; j >= 0; j--) {
							if (result[j] == result[i]) {
								c = false;
								break;
							}
						}

						if (c) {
							break;
						}
					}
					System.out.println(String.valueOf(i + 1) + ". " + result[i]);
				}
			}
		}

	}


}