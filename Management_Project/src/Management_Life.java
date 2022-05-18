import java.util.*;

class Management_Life extends Product {
	protected String Maker; //제조사
	protected String Usage; //용도
	
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
		System.out.println("제조사 : "+Maker);
		System.out.println("용도 : "+Usage);
		System.out.println("===========================");
	}
}
