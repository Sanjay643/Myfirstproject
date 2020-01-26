import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EmailIndex extends LinkedHashMap{
	public Map readData() {
		try {
			FileInputStream dbfieMap=new FileInputStream("C:\\Myproject\\src\\eMap.txt");
			ObjectInputStream dboieMap=new ObjectInputStream(dbfieMap);
			return (LinkedHashMap)dboieMap.readObject();

			
		}catch(Exception e) {
			System.out.println("File has no data");
			return new EmailIndex();
		}
		
	}
	public void writeData() throws IOException {
		FileOutputStream dbfoeMap=new FileOutputStream("C:\\Myproject\\src\\eMap.txt");
		ObjectOutputStream dbooeMap=new ObjectOutputStream(dbfoeMap);
		dbooeMap.writeObject(this);
		dbooeMap.close();
	}

}
