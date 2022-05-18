import java.util.*;

class Management_Food extends Product {
	protected String Made; //생산지
	protected String F_Day; //유통기한
	protected String F_Kind; //종류
	
	public Management_Food() {
		this.Made = "none";
		this.F_Day = "none";
		this.F_Kind = "none";
	}
	public Management_Food(String num, String name, int price, int amount, String made, String f_day, String f_kind) {
		super(num, name, price, amount);
		this.Made = made;
		this.F_Day = f_day;
		this.F_Kind = f_kind;
	}
	
	@Override
	public void Info_print() {
		System.out.println("===========================");
		super.Info_print();
		System.out.println("제조사 : "+Made);
		System.out.println("유통기한 : "+F_Day);
		System.out.println("종류 : "+F_Kind);
		System.out.println("===========================");
	}
}
