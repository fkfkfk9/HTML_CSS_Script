package java_11_28;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class RamdaFunction {
	static List<Data> list = Arrays.asList(
			new Data("유종현", 4, 3.8),
			new Data("홍길동", 4, 4.5));
	
	public static void main(String[] args) {
		printDataSv(t->t.getSv());
//		printData(t->t.getIv());//인터형 데이터이기 때문에 불러올 수가 없다.
		//어플라이의 리턴값이 스트링이기 때문
		printDataIv(t->t.getIv());
		printDataDv(t->t.getDv());
		System.out.println("리스트안의 이름들의 모든 글자의 수는 : " +
							nameLength(t->t.getSv()));
	}
	/*
		매개변수가 함수적 인터페이스를 타겟타입으로 선언
		입력매개변수를 제공받아 출력(반환값)을 반환하는 기능 입력매개변수를 리턴형으로 매핑
		Data는 매개변수, String는 apply의 리턴타입이다.
	*/
	public static void printDataSv(Function<Data, String> fun) {
		for (Data d : list) {
			System.out.println(fun.apply(d) + "");
		}
		System.out.println();
	}
	public static void printDataIv(ToIntFunction<Data> fun) {
		for (Data d : list) {
			System.out.println(fun.applyAsInt(d) + "");
		}
		System.out.println();
	}
	public static void printDataDv(ToDoubleFunction<Data> fun) {
		for (Data d : list) {
			System.out.println(fun.applyAsDouble(d) + "");
		}
		System.out.println();
	}
	public static int nameLength(Function<Data, String> fun) {
		int count = 0;
		for (Data d : list) {
			count += fun.apply(d).length();
		}
		return count;
	}
	
}

class Data{
	private String sv;
	private int iv;
	private Double dv;
	
	public Data(String sv, int iv, Double dv) {
		this.sv = sv;
		this.iv = iv;
		this.dv = dv;
	}

	public String getSv() {
		return sv;
	}

	public void setSv(String sv) {
		this.sv = sv;
	}

	public int getIv() {
		return iv;
	}

	public void setIv(int iv) {
		this.iv = iv;
	}

	public Double getDv() {
		return dv;
	}

	public void setDv(Double dv) {
		this.dv = dv;
	}
	
}