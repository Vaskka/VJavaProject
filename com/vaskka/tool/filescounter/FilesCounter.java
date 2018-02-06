package com.vaskka.tool.filescounter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.vaskka.tool.filescounter.*;

class FilesCounter {

	@SuppressWarnings(value = {"unchecked"})
	public static void main(String[] argc) {
		//记录用户输入的dir的个数
		int num;

		//记录dir的数组
		Path[] filesPath;
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要叫计算文件数的路径的个数：");
		while (true) {
			try {
				num = input.nextInt();
 				break;
			}
			catch (InputMismatchException e) {
				System.out.println("输入的数字格式不正确，请重新输入...");
				input = new Scanner(System.in);
			}
		}

		//清空缓冲
		input = new Scanner(System.in);

		filesPath = new Path[num];
		for (int i = 0; i < num; i++) {
			System.out.println("请输入第" + Integer.toString(i + 1) + "个路径名");
			String pathsString = input.nextLine();
			filesPath[i] = Paths.get(pathsString);
		}


		//声明线程池
		ExecutorService executorService = Executors.newFixedThreadPool(filesPath.length);
		
		//声明任务清单
		Future<Long>[] results = new Future[filesPath.length];

		//提交任务
		for (int i = 0; i < filesPath.length; i++) {
			Path dir = filesPath[i];
			FilesCounterTask task = new FilesCounterTask(dir);
			results[i] = executorService.submit(task);
		}

		//获得任务结果
		for (int i = 0; i < filesPath.length; i++) {
			long result = 0L;
			try {
				result = results[i].get();
			}
			catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println(filesPath[i].toString() + " Contents " + result + "files.");
		}

		//结束任务
		executorService.shutdownNow();

	}
}
