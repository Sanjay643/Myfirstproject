import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NameIndex extends LinkedHashMap{
	public Map readData() {
		try {
			FileInputStream dbfinMap=new FileInputStream("C:\\Myproject\\src\\nMap.txt");
			ObjectInputStream dboinMap=new ObjectInputStream(dbfinMap);
			return (LinkedHashMap)dboinMap.readObject();

			
		}catch(Exception e) {
			System.out.println("File has no data");
			return new NameIndex();
		}
		
	}
	public void writeData() throws IOException {
		FileOutputStream dbfonMap=new FileOutputStream("C:\\Myproject\\src\\nMap.txt");
		ObjectOutputStream dboonMap=new ObjectOutputStream(dbfonMap);
		dboonMap.writeObject(this);
		dboonMap.close();
	}

}
