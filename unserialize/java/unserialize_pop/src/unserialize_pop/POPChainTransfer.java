package unserialize_pop;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class POPChainTransfer implements Serializable {
	private static final long serialVersionUID = 1L;
	private POPChainInterestingOperations[] popChainInterestingOperations;
	private Object obj;

	public POPChainTransfer(POPChainInterestingOperations[] input_chain, Object input_obj) {
		popChainInterestingOperations = input_chain;
		obj = input_obj;
	}

	public Object transform(Object object) throws Throwable {
		for (int i = 0; i < this.popChainInterestingOperations.length; i++) {
			object = this.popChainInterestingOperations[i].transform(object);
		}
		return object;
	}

	private void readObject(ObjectInputStream stream) throws Throwable {
		stream.defaultReadObject();
		transform(obj);
	}
}
