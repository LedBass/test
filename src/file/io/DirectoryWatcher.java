package file.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

public class DirectoryWatcher {
	
	public void watchDirectory(WatchKey key, WatchEvent.Kind<Path> eventToWatch, String inputDir) {
		
		for (;;) {
			
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kindOfCurrentEvent = event.kind();
				
				if (kindOfCurrentEvent == StandardWatchEventKinds.OVERFLOW) {
					continue;
				}
				
				@SuppressWarnings("unchecked")
				WatchEvent<Path> eventPath = (WatchEvent<Path>)event;
				if (eventPath.kind() == eventToWatch) {
					Path fileName = eventPath.context();
					
//					Path name = fileName.getFileName();
					
					String fileNameString = fileName.getFileName().toString();
					
					if (fileNameString.endsWith(".dat")) {
						DatFileReader fileReader = new DatFileReader(inputDir + "/" + fileNameString);
						fileReader.readFile();
					}
				}
				
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
		}
	}
	
	public void checkForDirectories(Path directoryToCheck) {
		
		if (Files.notExists(directoryToCheck, LinkOption.NOFOLLOW_LINKS)) {
			Boolean success = (new File(directoryToCheck.toString()).mkdirs());
			if (!success) {
				System.out.println("there's an error while creating the directory " + directoryToCheck);
			}
		}
		
	}
}
