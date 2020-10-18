package com.EmployeePayroll;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.Ignore;

import com.EmployeePayroll.JavaWatchService;

@SuppressWarnings("unused")
public class NIOFileAPITest {
	static final String HOME = System.getProperty("user.home");
	public static String PLAY_WITH_NIO = "TempPlayGround";

	@Ignore
	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException {
		// Check File Exists
		Path homePath = Paths.get(HOME);
		assertTrue(Files.exists(homePath));

		// Delete File and Check File Not Exist
		Path playPath = Paths.get(PLAY_WITH_NIO);
		if (Files.exists(playPath))
			Files.delete(playPath);
		assertTrue(Files.notExists(playPath));

		// Create Directory
		Files.createDirectory(playPath);
		assertTrue(Files.exists(playPath));

		// Create File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			assertTrue(Files.exists(playPath));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
		});

		// List Files, Directories as well as Files with Extensions
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);

	}

	@Test
	@Ignore
	public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
		Path dir = Paths.get(HOME + "\\" + PLAY_WITH_NIO);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new JavaWatchService(dir).processEvents();
	}

}/* ... */
/* ... */