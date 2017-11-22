package java_11_22;

import java.util.ArrayList;

public class MarketBasket {
	//제네릭 실습
	//일반클래스 구성(Kitchen, meet등) - 제내릭 클래스 구성(일반클래스를 타입파라미터 용도로 사용) 
	// - 기능담당 클래스 : Basket(제네릭 기능)
	public static void main(String[] args) {
		Basket<Food> bFood = new Basket<Food>();
		Basket<Life> bl = new Basket<Life>();
		Basket<Kitchen> bk = new Basket<Kitchen>();
		Basket<Fruit> bf = new Basket<Fruit>();
		Basket<Meet> bm = new Basket<Meet>();
		Basket<Tea> bt = new Basket<Tea>();//<>안의 내용은 일치해야 오류가 없다.
		
		//bFood.setAdd(new Food());
		//bl.setAdd(new Life());인터페이스 이기 때문에 본인들을 넣어 사용은 불가
		bl.setAdd(new Kitchen());//상속받아 메소드화 한걸 넣어줘야 가능
		bf.setAdd(new Fruit());
		bm.setAdd(new Meet());
		bt.setAdd(new Tea());
		bFood.setAdd(new Meet());//상속받은 클래스를 넣을수도 있다.
		//bm.setAdd(new Food()); 부모를 넣을수는 없다.
		//bFood.setAdd(new Life());상속받지 않는것도 불가능
		System.out.println(bFood);
		System.out.println(bm);
		System.out.println(bl);
	}

}
class Basket<T>{
	ArrayList<T> list = new ArrayList<T>();
	
	void setAdd(T item) {
		list.add(item);
	}
	T itemGet(int index){
		return list.get(index);
	}
	int getSize() {
		return list.size();
	}
	@Override
	public String toString() {
		return list.toString();
	}
}
class DeliverBasket<T extends Food & Life> extends Basket<T>{
	//T를 정의할 때 특정 인터페이스를 상속받는 클래스들만 T에 입력받도록 설정도 가능
	//<? extends T>상한제한 T와 그자손들만 가능
	//<? super T>하한제한 T와 그 조상들만 가능
	//<?>제한없음 모든 타입이 가능
	//static에는 T형을 사용할 수 없다.
	static Market deliver(Basket<? extends Market> Basket){//<? extends T> 사용 예 
		return new Fruit();//아무 의미 없음
	}
}
interface Market{}
interface Food extends Market{}
interface Life extends Market{}
class Kitchen implements Life{public String toString() {return "Kitchen";}}
class Fruit implements Food{public String toString() {return "Fruit";}}
class Meet implements Food{public String toString() {return "Meet";}}
class Tea implements Food{public String toString() {return "Tea";}}
