package com.vaskka.learn.grammar.concurrency;

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
import com.vaskka.learn.grammar.concurrency.*;


class Program {
	@SuppressWarnings(value = {"unchecked"})
	public static void main(String[] argc) {
		Path[] filesPath = {
			//Paths.get("C:/"),
			Paths.get("D:/")
		};
		//声明线程池
		ExecutorService executorService = Executors.newFixedThreadPool(filesPath.length);
		//声明任务清单

		Future<Long>[] results = new Future[filesPath.length];

		//提交任务
		for (int i = 0; i < filesPath.length; i++) {
			Path dir = filesPath[i];
			FileCounterTask task = new FileCounterTask(dir);
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
 
