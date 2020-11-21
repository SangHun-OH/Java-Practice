import java.io.IOException;

public class FileSystem {
	public static void main(String[] args) throws IOException {
		/*
		CreateTextFile application = new CreateTextFile();
		application.openfile();
		application.addRecords();
		application.closeFile();
		
		
		ReadTextFile application1 = new ReadTextFile();
		application1.openFile();
		application1.readRecords();
		application1.closeFile();
		*/
		CreateSequentialFile application2 = new CreateSequentialFile();
		application2.openFile();
		application2.addRecords();
		application2.closeFile();
		
		ReadSequentialFile application3 = new ReadSequentialFile();
		application3.openFile();
		application3.readRecords();
		application3.closeFile();
	
	}
}
