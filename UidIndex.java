import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UidIndex extends LinkedHashMap {
		public Map readData() {
			try {
				FileInputStream dbfiuid=new FileInputStream("C:\\Myproject\\src\\uid.txt");
				ObjectInputStream dboiuid=new ObjectInputStream(dbfiuid);
				return (LinkedHashMap)dboiuid.readObject();

				
			}catch(Exception e) {
				System.out.println("File has no data");
				return new UidIndex();
			}
			
			
		}
		public void writeData() throws IOException {
			FileOutputStream dbfouid=new FileOutputStream("C:\\Myproject\\src\\uid.txt");
			ObjectOutputStream dboouid=new ObjectOutputStream(dbfouid);
			dboouid.writeObject(this);
			dboouid.close();
		}
}
