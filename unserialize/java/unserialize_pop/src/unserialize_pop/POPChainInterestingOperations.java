package unserialize_pop;

import java.io.Serializable;
import java.lang.reflect.Method;

public class POPChainInterestingOperations implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String iMethodName;
	private final Class[] iParamTypes;
	private final Object[] iArgs;

	public POPChainInterestingOperations(String methodName, Class[] paramTypes, Object[] args) {
		this.iMethodName = methodName;
		this.iParamTypes = paramTypes;
		this.iArgs = args;
	}

	public Object transform(Object input) throws Throwable {
		Class cls = input.getClass();
		Method method = cls.getMethod(this.iMethodName, this.iParamTypes);
		return method.invoke(input, this.iArgs);
	}
}
