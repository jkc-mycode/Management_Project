import java.util.*;
import java.io.*;

class Controller implements Serializable {
	protected static Vector<Management_Elec> E_product_Vector = new Vector<Management_Elec>(); //傈磊力前 按眉 氦磐肺 积己
	protected static Vector<Management_Life> L_product_Vector = new Vector<Management_Life>(); //积劝侩前 按眉 氦磐肺 积己
	protected static Vector<Management_Food> F_product_Vector = new Vector<Management_Food>(); //侥前 按眉 氦磐肺 积己
	
	public void init() throws EOFException, FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File("Elec_Product.bin");
		if(f.isFile()) {
			FileInputStream fin = new FileInputStream("Elec_Product.bin");
			if(f.length() != 0) {
				ObjectInputStream in = new ObjectInputStream(fin);
				E_product_Vector = (Vector<Management_Elec>)in.readObject();
				in.close();
			}
		}
		
		File f1 = new File("Life_Product.bin");
		if(f1.isFile()) {
			FileInputStream fin = new FileInputStream("Life_Product.bin");
			if(f1.length() != 0) {
				ObjectInputStream in = new ObjectInputStream(fin);
				L_product_Vector = (Vector<Management_Life>)in.readObject();
				in.close();
			}
		}
		
		File f2 = new File("Food_Product.bin");
		if(f2.isFile()) {
			FileInputStream fin = new FileInputStream("Food_Product.bin");
			if(f2.length() != 0) {
				ObjectInputStream in = new ObjectInputStream(fin);
				F_product_Vector = (Vector<Management_Food>)in.readObject();
				in.close();
			}
		}
	}
	public void save() throws EOFException, FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream fout = new FileOutputStream("Elec_Product.bin");
		ObjectOutputStream out = new ObjectOutputStream(fout);
		out.writeObject(E_product_Vector);
		out.close();
		
		FileOutputStream fout1 = new FileOutputStream("Life_Product.bin");
		ObjectOutputStream out1 = new ObjectOutputStream(fout1);
		out1.writeObject(L_product_Vector);
		out1.close();
		
		FileOutputStream fout2 = new FileOutputStream("Food_Product.bin");
		ObjectOutputStream out2 = new ObjectOutputStream(fout2);
		out2.writeObject(F_product_Vector);
		out2.close();
	}
	public int print_menu() { //窍何 皋春 免仿
		Scanner sc1 = new Scanner(System.in);
		System.out.print("ぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱ\n");
		System.out.println("| 1.傈磊力前  2.积劝侩前  3.侥前  4.第肺啊扁 |");
		System.out.print("ぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱぱ\n");
		System.out.print("涝仿 : ");
		int select = sc1.nextInt();
		return select;
	}
	public void ProductRegister() throws EOFException, FileNotFoundException, IOException, ClassNotFoundException { //力前殿废 皋辑靛
		String num, name, maker, usage, f_day, f_kind; //力前锅龋, 力前疙, 力炼荤, 侩档, 蜡烹扁茄, 辆幅
		int price, amount, guarantee, grade; //荐樊, 前龙焊刘扁埃, 俊呈瘤殿鞭
		int select;
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		select = print_menu();
		if(select == 4) { return; }

		System.out.print("力前锅龋 : ");
		num = sc2.nextLine();
		System.out.print("力前疙 : ");
		name = sc2.nextLine();
		System.out.print("啊拜 : ");
		price = sc2.nextInt();
		System.out.print("荐樊 : ");
		amount = sc2.nextInt();
		if(select == 1) {
			sc2.nextLine();
			System.out.print("力炼荤 : ");
			maker = sc2.nextLine();
			System.out.print("前龙焊刘扁埃(老) : ");
			guarantee = sc2.nextInt();
			System.out.print("俊呈瘤殿鞭 : ");
			grade = sc2.nextInt();
			
			Management_Elec e_pro = new Management_Elec(num, name, price, amount, maker, guarantee, grade);
			E_product_Vector.addElement(e_pro);
			
			save();
			
			int n = E_product_Vector.lastIndexOf(e_pro);
			E_product_Vector.get(n).Info_print();
		}else if(select == 2) {
			sc2.nextLine();
			System.out.print("力炼荤 : ");
			maker = sc2.nextLine();
			System.out.print("侩档 : ");
			usage = sc2.nextLine();
			
			Management_Life l_pro = new Management_Life(num, name, price, amount, maker, usage);
			L_product_Vector.addElement(l_pro);
			
			save();
			
			int n = L_product_Vector.lastIndexOf(l_pro);
			L_product_Vector.get(n).Info_print();
		}else if(select == 3){
			sc2.nextLine();
			System.out.print("力炼荤 : ");
			maker = sc2.nextLine();
			System.out.print("蜡烹扁茄 : ");
			f_day = sc2.nextLine();
			System.out.print("辆幅 : ");
			f_kind = sc2.nextLine();
			
			Management_Food f_pro = new Management_Food(num, name, price, amount, maker, f_day, f_kind);
			F_product_Vector.addElement(f_pro);
			
			save();
			
			int n = F_product_Vector.lastIndexOf(f_pro);
			F_product_Vector.get(n).Info_print();
		}else {
			System.out.println("肋给等 涝仿蔼!!");
			return;
		}
	}
	public void ProductDelete() throws EOFException, FileNotFoundException, IOException, ClassNotFoundException { //力前昏力 皋辑靛
		//绢蠢吧 昏力且瘤 皋春 急琶(胶困摹巩 or if巩) -> 力前锅龋涝仿 -> 昏力
		int select; //皋春急琶 锅龋
		String d_num; //昏力且 力前锅龋
		Scanner sc = new Scanner(System.in);
		select = print_menu();
		if(select == 4) {
			return;
		}
		System.out.print("昏力且 力前锅龋 : ");
		d_num = sc.nextLine();
		
		if(select == 1) {
			//Iterator甫 劝侩茄 傈磊力前 按眉 昏力巩
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("昏力且 单捞磐啊 绝澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Num.equals(d_num)) {
					System.out.println("力前锅龋 "+d_num+"甫(阑) 昏力钦聪促!!");
					it.remove();
					save();
					return;
				}
			}
			System.out.println("茫绰 沥焊啊 绝澜!!");
			return;
		}else if(select == 2) {
			//Iterator甫 劝侩茄 积劝侩前 按眉 昏力巩
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("昏力且 单捞磐啊 绝澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Num.equals(d_num)) {
					System.out.println("力前锅龋 "+d_num+"甫(阑) 昏力钦聪促!!");
					it.remove();
					save();
					return;
				}
			}
			System.out.println("茫绰 沥焊啊 绝澜!!");
			return;
		}else if(select == 3) {
			//Iterator甫 劝侩茄 侥前 按眉 昏力巩
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("昏力且 单捞磐啊 绝澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Num.equals(d_num)) {
					System.out.println("力前锅龋 "+d_num+"甫(阑) 昏力钦聪促!!");
					it.remove();
					save();
					return;
				}
			}
			System.out.println("茫绰 沥焊啊 绝澜!!");
			return;
		}else if(select == 4) {
			return;
		}else {
			System.out.println("肋给等 涝仿蔼!!");
			return;
		}
	}
	public void ProductRevise() throws EOFException, FileNotFoundException, IOException, ClassNotFoundException { //力前荐沥 皋辑靛
		//绢蠢吧 荐沥且瘤 皋春 急琶(胶困摹巩 or if巩) -> 力前锅龋涝仿 -> 促矫涝仿(荐沥) ->荐沥肯丰\
		//氦磐客 Iterator甫 劝侩
		int select;
		String r_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		if(select == 4) {
			return;
		}
		System.out.print("荐沥且 力前锅龋 : ");
		r_num = sc.nextLine();
		if(select==1) {
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("单捞磐啊 厚绢乐澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Num.equals(r_num)) {
					System.out.print("力前锅龋 : ");
					e_pro.Product_Num=sc.nextLine();
					System.out.print("力前疙 : ");
					e_pro.Product_Name = sc.nextLine();
					System.out.print("啊拜 : ");
					e_pro.Product_Price = sc.nextInt();
					System.out.print("荐樊 : ");
					e_pro.Product_Amount = sc.nextInt();
					sc.nextLine();
					System.out.print("力炼荤 : ");
					e_pro.Maker = sc.nextLine();
					System.out.print("前龙焊刘扁埃(老) : ");
					e_pro.Guarantee = sc.nextInt();
					System.out.print("俊呈瘤殿鞭 : ");
					e_pro.Grade = sc.nextInt();
					save();
					return;
				}
			}
			System.out.println("茫绰 沥焊啊 绝澜!!");
			return;
		}else if(select==2) {
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("单捞磐啊 厚绢乐澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Num.equals(r_num)) {
					System.out.print("力前锅龋 : ");
					l_pro.Product_Num=sc.nextLine();
					System.out.print("力前疙 : ");
					l_pro.Product_Name = sc.nextLine();
					System.out.print("啊拜 : ");
					l_pro.Product_Price = sc.nextInt();
					System.out.print("荐樊 : ");
					sc.nextLine();
					System.out.print("力炼荤 : ");
					l_pro.Maker = sc.nextLine();
					System.out.print("侩档 : ");
					l_pro.Usage = sc.nextLine();
					save();
					return;
				}
			}
			System.out.println("茫绰 沥焊啊 绝澜!!");
			return;
		}else if(select==3) {
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("单捞磐啊 厚绢乐澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Num.equals(r_num)) {
					System.out.print("力前锅龋 : ");
					f_pro.Product_Num=sc.nextLine();
					System.out.print("力前疙 : ");
					f_pro.Product_Name = sc.nextLine();
					System.out.print("啊拜 : ");
					f_pro.Product_Price = sc.nextInt();
					System.out.print("荐樊 : ");
					sc.nextLine();
					System.out.print("力炼荤 : ");
					f_pro.Made = sc.nextLine();
					System.out.print("蜡烹扁茄 : ");
					f_pro.F_Day = sc.nextLine();
					System.out.print("辆幅 : ");
					f_pro.F_Kind = sc.nextLine();
					save();
					return;
				}
			}
			System.out.println("茫绰 沥焊啊 绝澜!!");
			return;
		}else if(select==4) {
			return;
		}else {
			System.out.println("肋给等 涝仿蔼!!");
			return;
		}
	}
	public Vector<Product> ProductSearch() { //力前八祸 皋辑靛
		//绢蠢吧 茫阑瘤 皋春 急琶(胶困摹巩 or if巩) -> 力前锅龋涝仿 -> index捞侩秦辑 馆汗巩 -> 八祸肯丰
		//傈眉 免仿档 皋春俊 持扁
		int select, check=0;
		String s_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		if(select == 4) {
			return null;
		}
		System.out.print("八祸且 力前疙 : ");
		s_num = sc.nextLine();
		System.out.println("===========免仿搬苞==========");
		
		if(select==1) {
			//吝汗等 捞抚阑 啊柳 力前捞 乐阑 荐 乐扁俊 氦磐俊 历厘秦辑 府畔窍扁 困秦
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Name.equals(s_num)) {
					check = 1; //八祸俊辑 力前狼 蜡公甫 历厘窍绰 函荐
					e_pro.Info_print();
					temp.addElement(e_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("八祸搬苞 绝澜!!");
				return null;
			}
		}else if(select==2) {
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Life> it = L_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Name.equals(s_num)) {
					check = 1; //八祸俊辑 力前狼 蜡公甫 历厘窍绰 函荐
					l_pro.Info_print();
					temp.addElement(l_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("八祸搬苞 绝澜!!");
				return null;
			}
		}else if(select==3) {
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Food> it = F_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Name.equals(s_num)) {
					check = 1; //八祸俊辑 力前狼 蜡公甫 历厘窍绰 函荐
					f_pro.Info_print();
					temp.addElement(f_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("八祸搬苞 绝澜!!");
				return null;
			}
		}else if(select==4) {
			return null;
		}else {
			System.out.println("肋给等 涝仿蔼!!");
			return null;
		}
	}
	public void Total_Print() { //力前 傈眉免仿 皋辑靛
		int select;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		if(select==1) {
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("免仿且 单捞磐啊 绝澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				e_pro.Info_print();
			}
		}else if(select==2) {
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("免仿且 单捞磐啊 绝澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				l_pro.Info_print();
			}
		}else if(select==3) {
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("免仿且 单捞磐啊 绝澜!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				f_pro.Info_print();
			}
		}else if(select==4) {
			return;
		}else {
			System.out.println("肋给等 涝仿蔼!!");
			return;
		}
	}
}