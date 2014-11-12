package starter;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import file.io.DirectoryWatcher;


public class Starter {

	public static void main(String[] args) {
		DirectoryWatcher directoryWatcher = new DirectoryWatcher();
		
		WatchService watchService;
		try {
			watchService = FileSystems.getDefault().newWatchService();
			
			String inputDirectory = System.getProperty("user.home") + "/data/in";
			String outputDirectory = System.getProperty("user.home") + "/data/out";
			
			Path inputPath = Paths.get(inputDirectory);
			Path outputPath = Paths.get(outputDirectory);
			
			directoryWatcher.checkForDirectories(inputPath);
			directoryWatcher.checkForDirectories(outputPath);
			
			WatchKey key = inputPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			
			WatchEvent.Kind<Path> eventToWatch = StandardWatchEventKinds.ENTRY_CREATE;
			
			directoryWatcher.watchDirectory(key, eventToWatch, inputDirectory);
			
		} catch (IOException e) {
			System.out.println("error while creating the watcher, error: " + e.getMessage());
		}
	}
}
