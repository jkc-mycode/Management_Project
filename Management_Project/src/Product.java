import java.util.*;

class Product {
	protected String Product_Num; //��ǰ��ȣ
	protected String Product_Name; //��ǰ��
	protected int Product_Price; //��ǰ����
	protected int Product_Amount; //��ǰ����
	
	public Product() { //�⺻������
		this.Product_Num = "none";
		this.Product_Name = "none";
		this.Product_Price = 0;
		this.Product_Amount = 0;
	}
	public Product(String num, String name, int price, int amount) {
		this.Product_Num = num;
		this.Product_Name = name;
		this.Product_Price = price;
		this.Product_Amount = amount;
	}
	
	public void Info_print() {
		System.out.println("��ǰ��ȣ : "+Product_Num);
		System.out.println("��ǰ�� : "+Product_Name);
		System.out.println("���� : "+Product_Price);
		System.out.println("���� : "+Product_Amount);
	}
}
