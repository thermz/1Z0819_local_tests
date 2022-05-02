package me.certtest.excercise;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import static java.util.Objects.isNull;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import static me.certtest.excercise.Utils.uncheck;

/**
 *
 * @author Riccardo
 */
class CustomBufferedWriter extends BufferedWriter {

    public CustomBufferedWriter(Writer out) throws IOException {
	super(out);
	//throw new IOException();
    }

//    public CustomBufferedWriter(Writer out, int sz) {
//	super(out, sz);
//    }
    @Override
    public void close() throws IOException {
	super.close();
	System.out.println("CLOSING");
    }

}

public class IOTests implements Cloneable{
    
    public static void testFilesClass() {
	try {
	    Utils.uncheck(() -> Files.move(Path.of(""), Path.of(""), StandardCopyOption.ATOMIC_MOVE));
	    Files.find(Path.of("."), 1, (p, a) -> p.getFileName().toString().contains("txt"));
	} catch (IOException ex) {
	    Logger.getLogger(IOTests.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public static void testBufferedWriter() {
	String f = "test.txt";

	try (var w = new CustomBufferedWriter(new FileWriter(f)); var s = System.out) {
	    w.newLine();
	    w.append(null);
	    w.flush();

	    s.println("1");
	    s.flush();

	    if (true) {
		throw new IOException();
	    }
	    
	} catch (IOException e) {
	    System.out.println("2");
	} finally {
	    System.out.println("3");
	}

    }

    public static void testPathDir() {
	var f1 = Path.of("templates\\proofs\\aaa\\bbb\\ccc\\dddd");
	var f2 = f1.subpath(2, 6);//.getName(1);
	var f3 = Paths.get("\\aaa\\bbb");

	System.out.println("Subpath is " + f2);
    }

    public static void testReadLines() {
	Path testPath = Path.of("io_test.txt");

	long counter = uncheck(() -> Files.readAllLines(testPath)).stream()
		.filter(s -> s.contains("b"))
		.count();

	var attr = uncheck(() -> Files.readAttributes(testPath, BasicFileAttributes.class));

	System.out.println(counter);
    }

    public static void testInputStream() {
	byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6};
	try (InputStream i = new ByteArrayInputStream(bytes)) {

	} catch (IOException ex) {
	    Logger.getLogger(IOTests.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public static void testConsole() {
	Console c = System.console();
	System.out.println("Enter your name: ");
	String n = c.readLine();
	System.out.println("Welcome " + n);
    }

    static void testFile() {
	Path p = new File("C:\\Users\\Riccardo\\Documents\\\\NetBeansProjects\\CertTest\\asd.txt").toPath();

    }

    public static void main(String[] args) {
//	testFilesClass();
	//testBufferedWriter();
	testPathDir();
//	testReadLines();
//	testOutputStream();
//	testConsole();

//	testFile();
    }

    public static class SimplePOJO implements Serializable {

	private Integer a;
	private final transient String testTransient = "BBBBBB";
	private static String testStatic;

	public SimplePOJO() {
	    this.a = 1;
	    //this.testTransient = "STOCAZZO";
	    testStatic = "AAAAAA";
	    
	}
    } 

    public static void testOutputStream() {
	final String FILE_NAME = "test_output.txt";

	try (var stream
		= uncheck(() -> {
		    return new ObjectOutputStream(new FileOutputStream(FILE_NAME));
		})) {
	    SimplePOJO p = new SimplePOJO();
	    p.testStatic = "hhhhhhh";
	    stream.writeObject(new SimplePOJO());
	    stream.writeObject(new SimplePOJO());
	    stream.writeObject(null);
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
	
	try (var streamRead = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
	    SimplePOJO p = (SimplePOJO) streamRead.readObject();
	    System.out.println("POJO with a and test transient:");
	    System.out.println(p.a);
	    System.out.println(p.testTransient);
	    System.out.println(p.testStatic);

	    p = (SimplePOJO) streamRead.readObject();
	    System.out.println("POJO with a and test transient:");
	    System.out.println(p.a);
	    System.out.println(p.testTransient);
	    System.out.println(p.testStatic);

	    p = (SimplePOJO) null;
	    System.out.println("POJO with a and test transient:");
	    System.out.println("---P is null? ");
	    System.out.println("---P is null? " + isNull(p));

	} catch (EOFException eof) {
	    System.err.println("REACHED EOF");
	    // Può essere catchata se estende IOException
	} catch (Exception ex) {
	    throw new RuntimeException(ex);
	}

    }

}