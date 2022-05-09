package me.certtest.excercise;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static me.certtest.excercise.Utils.uncheck;

public class IOUnixTests {

	public static void testFiles(){
		uncheck( () -> {
			Path resourcePath = Path.of("src", "main", "resources");
			Path dirTestTxtFilePath = Path.of("dir", "test.txt");

			Files.copy(
					resourcePath.resolve( Path.of( "test.txt") ),
					resourcePath.resolve(dirTestTxtFilePath), StandardCopyOption.REPLACE_EXISTING);

			Files.createDirectories(resourcePath.resolve("newdir").resolve("nested"));
			Files.copy(
					resourcePath.resolve(dirTestTxtFilePath),
					resourcePath.resolve(dirTestTxtFilePath).resolve( Path.of("../../newdir/anotherTest.txt") ).normalize(),  StandardCopyOption.REPLACE_EXISTING
			);

			Files.move( resourcePath.resolve( Path.of("test.txt") ), resourcePath.resolve(Path.of("newdir", "nested", "moved.txt")), StandardCopyOption.ATOMIC_MOVE );

			Files.move( resourcePath.resolve(Path.of("newdir", "anotherTest.txt")), resourcePath.resolve("test.txt") );

			return null;
		} );


	}

	public static void main(String[] args) {
		testFiles();
	}

}
