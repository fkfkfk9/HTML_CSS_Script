package java_11_14;

import java.util.Vector;

public class PizzaMarket {

	public static void main(String[] args) {
		Customer ct = new Customer();
		Pizza cp = new CheesePizza();//다형성
		Pizza pp = new PepperoniPizza();
		PepperoniPizza pp2 = new PepperoniPizza();
		
		ct.cash = 80000;
		cp.toping();//부모에서 정의한 메소드를 오버라이딩 해놓으면 부모에서 자식을 생성해도
		pp.toping();//사용가능하다 이처럼 부모에서 자식들의 메소드를 한꺼번에 정의해 사용가능		
		ct.sellPizza(new CheesePizza());//부모객체를 매개변수로 해서 자식객체 삽입가능
		ct.sellPizza(pp2);//자식객체를 생성해서 넣어도 가능
		ct.sellPizza(cp);//자식객체를 복사한 부모객체도 사용가능
		ct.order();
	}
}

class Pizza{
	int price;
	String toping;
	
	Pizza(int price){
		this.price = price;
	}
	void toping() {}	
}

class CheesePizza extends Pizza{
	CheesePizza(){	
		super(30000);
		toping = "4가지 치즈만 들어간 피자";
	}
	void toping() {
		System.out.println(toping);
	}	
	public String toString() {
		return "CheesePizza";
	}
}

class PepperoniPizza extends Pizza{	
	PepperoniPizza(){	
		super(25000);
		toping = "페페로니가 들어간 피자";
	}
	void toping() {
		System.out.println(toping);
	}	
	public String toString() {//최상위 객체인 오브젝트의 메소드를 오버라이딩
		return "PepperoniPizza";
	}
}

class Customer{
	int cash;
	Vector<Pizza> orderlist = new Vector<Pizza>();
	//같은 오브젝트 여러개를 저장할 때 배열로 할 수도 있지만 배열은 사이즈가 고정되어
	//몇개의 데이터를 다룰지 모를때는 사용하기 힘들다.
	//하지만 벡트를 사용하면 알아서 오브잭트 배열을 관리해주기 때문에 사이즈 걱정없이 사용가능
	//.add()오브잭트 추가, .remove()오브젝트 제거, .isEmpty()벡터의 데이터가 있는지 체크
	//.get(index)해당 인덱스 데이터를 가져옴, .size()들어가있는 오브젝트 개수반환
	
	void sellPizza(Pizza p) {//다형성 부모의 객체만 넣어놓으면 자식객체 부모객체
		//자식을 복사한 부모객체까지 넣어서 사용할 수 있다.
		if(this.cash < p.price) System.out.println("캐쉬가 부족합니다.");
		else{
			this.cash -= p.price;
			System.out.println(p + " 구매 완료");
			//객체명만 입력시 ToString에서 정의한 리턴값을 제공
			System.out.println("남은 금액 : " + this.cash);
			orderlist.add(p);
		}		
	}
	void order() {
		int sum = 0;
		String str = "";
		for (int i = 0; i < orderlist.size(); i++) {
			sum += orderlist.get(i).price;
			str += orderlist.get(i) + " ";
		}
		System.out.println("총구매한 금액 : " + sum);
		System.out.println("구매한 목록 : " + str);
	}
}

