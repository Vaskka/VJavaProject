
package com.vaskka.tool.filescounter;

import java.util.concurrent.Callable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryStream;
import java.io.IOException;

//线程任务(记录某一个目录中有多少文件)
public class FilesCounterTask implements Callable<Long> {
	long fileCounts = 0L;

	Path dir;

	public FilesCounterTask(Path dir) {
		this.dir = dir;
	}

	private void doCount(Path parent) {
		if (Files.notExists(parent)) {
			return;
		}

		try (DirectoryStream<Path> children = Files.newDirectoryStream(parent)) {
			for (Path child : children) {
				if (Files.isDirectory(child)) {
					doCount(child);
				}
				else {
					if (Files.isRegularFile(child)) {
						this.fileCounts++;
					}
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}


	}

	@Override
	public Long call() throws Exception {
		System.out.println("Start Counting " + this.dir);
		doCount(this.dir);
		System.out.println("End Counting" + this.dir);
		return this.fileCounts;
	}

}
