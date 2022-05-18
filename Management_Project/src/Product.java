import java.util.*;

class Product {
	protected String Product_Num; //제품번호
	protected String Product_Name; //제품명
	protected int Product_Price; //제품가격
	protected int Product_Amount; //제품수량
	
	public Product() { //기본생성자
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
		System.out.println("제품번호 : "+Product_Num);
		System.out.println("제품명 : "+Product_Name);
		System.out.println("가격 : "+Product_Price);
		System.out.println("수량 : "+Product_Amount);
	}
}
