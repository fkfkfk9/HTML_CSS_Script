package jsp_2017_12_01.bean;

public class TestBean {
	/*
		자바빈으로 사용할 클랫의 특징
		-매개변수가 있는 생성자메서드는 지원 안함.
		-필드는 private로
		-게터 세터는 public로
		-id필드는 getId, setId처럼 앞글자 대문자로
		-일반메서드는 사용안함
	*/
	private String id;

	public String getId() {	return id;}
	public void setId(String id) {this.id = id;}
	//자바빈으로 사용하는 메소드는 일반적인 메소드는 사용하지 않는다.
	//주로 변수를 선언하는대 그 변수는 DB상 테이블의 멤버를 받기위한걸로 
	//같은 타입 이름으로 맞춰주는 경우가 많다.
	//자바빈은 중간기억장소 개념으로 jsp와 DB사이에서 중간처리를 해준다.
}
