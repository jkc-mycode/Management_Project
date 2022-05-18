import java.util.*;

class Management_Elec extends Product {
	protected String Maker; //������
	protected int Guarantee; //ǰ�������Ⱓ
	protected int Grade; //���������
	
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
		System.out.println("������ : "+Maker);
		System.out.println("ǰ�������Ⱓ(��) : "+Guarantee);
		System.out.println("��������� : "+Grade);
		System.out.println("===========================");
	}
}
