package jsp_2017_12_01.bean;

public class TestBean {
	/*
		�ڹٺ����� ����� Ŭ���� Ư¡
		-�Ű������� �ִ� �����ڸ޼���� ���� ����.
		-�ʵ�� private��
		-���� ���ʹ� public��
		-id�ʵ�� getId, setIdó�� �ձ��� �빮�ڷ�
		-�Ϲݸ޼���� ������
	*/
	private String id;

	public String getId() {	return id;}
	public void setId(String id) {this.id = id;}
	//�ڹٺ����� ����ϴ� �޼ҵ�� �Ϲ����� �޼ҵ�� ������� �ʴ´�.
	//�ַ� ������ �����ϴ´� �� ������ DB�� ���̺��� ����� �ޱ����Ѱɷ� 
	//���� Ÿ�� �̸����� �����ִ� ��찡 ����.
	//�ڹٺ��� �߰������� �������� jsp�� DB���̿��� �߰�ó���� ���ش�.
}
