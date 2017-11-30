package java_11_28;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public class RamdaSupplier {

	public static void main(String[] args) {
		int num1 = 10;
//		num1 = 20;파이널이 되므로 건드릴수 없다.
		Supplier<String> sup = ()->{return  "서플라이 활용";};
		System.out.println(sup.get());
		
		BooleanSupplier bs = () -> {
			if(num1 > 5) return true;
			else return false;
		};
		System.out.println("num1 은 5보다 큰가? " + bs.getAsBoolean());
		
	}

}
