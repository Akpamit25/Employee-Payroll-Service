package com.EmployeePayroll;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class JavaWatchService {
	private WatchService watcher;
	private Map<WatchKey, Path> dirWatchers;

	/* Create a WatchService and registers the given directory */
	public JavaWatchService(Path dir) throws IOException {
		super();
		this.watcher = FileSystems.getDefault().newWatchService();
		this.dirWatchers = new HashMap<WatchKey, Path>();
		scanAndDirectories(dir);
	}

	/* Register the given directory with the WatchService */
	private void registerDirWatchers(Path dir) throws IOException {
		WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);
		dirWatchers.put(key, dir);
	}

	/* Register the given directory and all its sub-directories */
	private void scanAndDirectories(final Path start) throws IOException {
		Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				registerDirWatchers(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	/* Process all events for keys queued to the watcher */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void processEvents() {
		while (true) {
			WatchKey key; // wait for key to be signaled
			try {
				key = watcher.take();
			} catch (InterruptedException e) {
				return;
			}
			Path dir = dirWatchers.get(key);
			if (dir == null)
				continue;
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind kind = event.kind();
				Path name = ((WatchEvent<Path>) event).context();
				Path child = dir.resolve(name);
				System.out.printf("%s: %s\n", event.kind().name(), child);
				// If directory is created, then register it and its all sub-directories
				if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
					try {
						if (Files.isDirectory(child))
							scanAndDirectories(child);
					} catch (IOException e) {
					}
				} else if (kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {
					if (Files.isDirectory(child))
						dirWatchers.remove(key);
				}
				// restart key and remove from set if directory no longer accessible
				boolean valid = key.reset();
				if (!valid) {
					dirWatchers.remove(key);
					if (dirWatchers.isEmpty())
						break; // All directories are inaccessible
				}
			}
		}
	}

}/* ... */
/* ... */