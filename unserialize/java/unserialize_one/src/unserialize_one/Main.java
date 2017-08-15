package unserialize_one;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Main implements Serializable {
	private static final long serialVersionUID = 1L;
	private String command;

	public Main(String input_command) {
		command = input_command;
	}

	private void readObject(ObjectInputStream stream) throws Throwable {
		stream.defaultReadObject();
		Runtime.getRuntime().exec(command);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\foo.ser"));
			in.readObject();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
