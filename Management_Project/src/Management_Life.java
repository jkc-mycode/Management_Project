import java.util.*;

class Management_Life extends Product {
	protected String Maker; //������
	protected String Usage; //�뵵
	
	public Management_Life() {
		this.Maker = "none";
		this.Usage = "none";
	}
	public Management_Life(String num, String name, int price, int amount, String maker, String usage) {
		super(num, name, price, amount);
		this.Maker = maker;
		this.Usage = usage;
	}

	@Override
	public void Info_print() {
		System.out.println("===========================");
		super.Info_print();
		System.out.println("������ : "+Maker);
		System.out.println("�뵵 : "+Usage);
		System.out.println("===========================");
	}
}
