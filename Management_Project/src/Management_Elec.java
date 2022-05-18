import java.util.*;

class Management_Elec extends Product {
	protected String Maker; //제조사
	protected int Guarantee; //품질보증기간
	protected int Grade; //에너지등급
	
	public Management_Elec() {
		this.Maker = "none";
		this.Guarantee = 0;
		this.Grade = 0;
	}
	public Management_Elec(String num, String name, int price, int amount, String maker, int guarantee, int grade) {
		super(num, name, price, amount);
		this.Maker = maker;
		this.Guarantee = guarantee;
		this.Grade = grade;
	}
	
	@Override
	public void Info_print() {
		System.out.println("===========================");
		super.Info_print();
		System.out.println("제조사 : "+Maker);
		System.out.println("품질보증기간(일) : "+Guarantee);
		System.out.println("에너지등급 : "+Grade);
		System.out.println("===========================");
	}
}
