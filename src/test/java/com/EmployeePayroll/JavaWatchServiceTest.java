package com.EmployeePayroll;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.EmployeePayroll.JavaWatchService;
import org.junit.Test;
public class JavaWatchServiceTest {



	@Test
	public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
		Path dir = Paths.get(NIOFileAPITest.HOME + "\\" + NIOFileAPITest.PLAY_WITH_NIO);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new JavaWatchService(dir).processEvents();//
	}

}