package unserialize_pop;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class POPChainStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\foo.ser"));
			in.readObject();
			
		} catch (Exception ex){
		    ex.printStackTrace();
		}
	}

}
