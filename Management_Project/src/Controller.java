import java.util.*;

class Controller {
	protected static int E_count=-1, L_count=-1, F_count=-1; //��ǰ ��ü �迭�� �ε��� ��ȣ �ʱ�ȭ
	//protected static Management_Elec [] E_product = new Management_Elec[10]; //������ǰ ��ü �迭 ����
	protected static Vector<Management_Elec> E_product_Vector = new Vector<Management_Elec>(); //������ǰ ��ü ���ͷ� ����
	//protected static Management_Life [] L_product = new Management_Life[10]; //��Ȱ��ǰ ��ü �迭 ����
	protected static Vector<Management_Life> L_product_Vector = new Vector<Management_Life>(); //��Ȱ��ǰ ��ü ���ͷ� ����
	//protected static Management_Food [] F_product = new Management_Food[10]; //��ǰ ��ü �迭 ����
	protected static Vector<Management_Food> F_product_Vector = new Vector<Management_Food>(); //��ǰ ��ü ���ͷ� ����
	
	public int Empty_E() { //��ǰ�� ���Ͱ� ������� Ȯ��
		if(E_product_Vector.size() == 0) {
			return 0;
		}
		return 1;
	}
	public int Empty_L() { //��ǰ�� ���Ͱ� ������� Ȯ��
		if(L_product_Vector.size() == 0) {
			return 0;
		}
		return 1;
	}
	public int Empty_F() { //��ǰ�� ���Ͱ� ������� Ȯ��
		if(F_product_Vector.size() == 0) {
			return 0;
		}
		return 1;
	}
	
	public int print_menu() { //�Ϻ� �޴� ���
		Scanner sc1 = new Scanner(System.in);
		System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
		System.out.println("| 1.������ǰ  2.��Ȱ��ǰ  3.��ǰ  4.�ڷΰ��� |");
		System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
		System.out.print("�Է� : ");
		int select = sc1.nextInt();
		return select;
	}
	
	public void ProductRegister() { //��ǰ��� �޼���
		String num, name, maker, usage, f_day, f_kind; //��ǰ��ȣ, ��ǰ��, ������, �뵵, �������, ����
		int price, amount, guarantee, grade; //����, ǰ�������Ⱓ, ���������
		int select;
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		select = print_menu();
		if(select == 4) { return; }

		System.out.print("��ǰ��ȣ : ");
		num = sc2.nextLine();
		System.out.print("��ǰ�� : ");
		name = sc2.nextLine();
		System.out.print("���� : ");
		price = sc2.nextInt();
		System.out.print("���� : ");
		amount = sc2.nextInt();
		if(select == 1) {
			sc2.nextLine();
			System.out.print("������ : ");
			maker = sc2.nextLine();
			System.out.print("ǰ�������Ⱓ(��) : ");
			guarantee = sc2.nextInt();
			System.out.print("��������� : ");
			grade = sc2.nextInt();
			
			Management_Elec e_pro = new Management_Elec(num, name, price, amount, maker, guarantee, grade);
			E_product_Vector.addElement(e_pro);
			int n = E_product_Vector.lastIndexOf(e_pro);
			E_product_Vector.get(n).Info_print();
		}else if(select == 2) {
			sc2.nextLine();
			System.out.print("������ : ");
			maker = sc2.nextLine();
			System.out.print("�뵵 : ");
			usage = sc2.nextLine();
			
			Management_Life l_pro = new Management_Life(num, name, price, amount, maker, usage);
			L_product_Vector.addElement(l_pro);
			int n = L_product_Vector.lastIndexOf(l_pro);
			L_product_Vector.get(n).Info_print();
		}else if(select == 3){
			sc2.nextLine();
			System.out.print("������ : ");
			maker = sc2.nextLine();
			System.out.print("������� : ");
			f_day = sc2.nextLine();
			System.out.print("���� : ");
			f_kind = sc2.nextLine();
			
			Management_Food f_pro = new Management_Food(num, name, price, amount, maker, f_day, f_kind);
			F_product_Vector.addElement(f_pro);
			int n = L_product_Vector.lastIndexOf(f_pro);
			F_product_Vector.get(n).Info_print();
			
		}else {
			System.out.println("�߸��� �Է°�!!");
			return;
		}
		
	}
	public void ProductDelete() { //��ǰ���� �޼���
		//����� �������� �޴� ����(����ġ�� or if��) -> ��ǰ��ȣ�Է� -> ����
		int select; //�޴����� ��ȣ
		String d_num; //������ ��ǰ��ȣ
		Scanner sc = new Scanner(System.in);
		select = print_menu();
		System.out.print("������ ��ǰ��ȣ : ");
		d_num = sc.nextLine();
		
		if(select == 1) {
			//Iterator�� Ȱ���� ������ǰ ��ü ������
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("������ �����Ͱ� ����!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Num.equals(d_num)) {
					System.out.println("��ǰ��ȣ "+d_num+"��(��) �����մϴ�!!");
					it.remove();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select == 2) {
			//Iterator�� Ȱ���� ��Ȱ��ǰ ��ü ������
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("������ �����Ͱ� ����!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Num.equals(d_num)) {
					System.out.println("��ǰ��ȣ "+d_num+"��(��) �����մϴ�!!");
					it.remove();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select == 3) {
			//Iterator�� Ȱ���� ��ǰ ��ü ������
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("������ �����Ͱ� ����!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Num.equals(d_num)) {
					System.out.println("��ǰ��ȣ "+d_num+"��(��) �����մϴ�!!");
					it.remove();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select == 4) {
			return;
		}else {
			System.out.println("�߸��� �Է°�!!");
			return;
		}
	}
	public void ProductRevise() { //��ǰ���� �޼���
		//����� �������� �޴� ����(����ġ�� or if��) -> ��ǰ��ȣ�Է� -> �ٽ��Է�(����) ->�����Ϸ�\
		//���Ϳ� Iterator�� Ȱ��
		int select;
		String r_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("������ ��ǰ��ȣ : ");
		r_num = sc.nextLine();
		if(select==1) {
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("�����Ͱ� �������!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Num.equals(r_num)) {
					System.out.print("��ǰ��ȣ : ");
					e_pro.Product_Num=sc.nextLine();
					System.out.print("��ǰ�� : ");
					e_pro.Product_Name = sc.nextLine();
					System.out.print("���� : ");
					e_pro.Product_Price = sc.nextInt();
					System.out.print("���� : ");
					e_pro.Product_Amount = sc.nextInt();
					sc.nextLine();
					System.out.print("������ : ");
					e_pro.Maker = sc.nextLine();
					System.out.print("ǰ�������Ⱓ(��) : ");
					e_pro.Guarantee = sc.nextInt();
					System.out.print("��������� : ");
					e_pro.Grade = sc.nextInt();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select==2) {
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("�����Ͱ� �������!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Num.equals(r_num)) {
					System.out.print("��ǰ��ȣ : ");
					l_pro.Product_Num=sc.nextLine();
					System.out.print("��ǰ�� : ");
					l_pro.Product_Name = sc.nextLine();
					System.out.print("���� : ");
					l_pro.Product_Price = sc.nextInt();
					System.out.print("���� : ");
					sc.nextLine();
					System.out.print("������ : ");
					l_pro.Maker = sc.nextLine();
					System.out.print("�뵵 : ");
					l_pro.Usage = sc.nextLine();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select==3) {
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("�����Ͱ� �������!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Num.equals(r_num)) {
					System.out.print("��ǰ��ȣ : ");
					f_pro.Product_Num=sc.nextLine();
					System.out.print("��ǰ�� : ");
					f_pro.Product_Name = sc.nextLine();
					System.out.print("���� : ");
					f_pro.Product_Price = sc.nextInt();
					System.out.print("���� : ");
					sc.nextLine();
					System.out.print("������ : ");
					f_pro.Made = sc.nextLine();
					System.out.print("������� : ");
					f_pro.F_Day = sc.nextLine();
					System.out.print("���� : ");
					f_pro.F_Kind = sc.nextLine();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select==4) {
			return;
		}else {
			System.out.println("�߸��� �Է°�!!");
			return;
		}
	}
	public Vector<Product> ProductSearch() { //��ǰ�˻� �޼���
		//����� ã���� �޴� ����(����ġ�� or if��) -> ��ǰ��ȣ�Է� -> index�̿��ؼ� �ݺ��� -> �˻��Ϸ�
		//��ü ��µ� �޴��� �ֱ�
		int select, check=0;
		String s_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("�˻��� ��ǰ�� : ");
		s_num = sc.nextLine();
		System.out.println("===========��°��==========");
		
		if(select==1) {
			//�ߺ��� �̸��� ���� ��ǰ�� ���� �� �ֱ⿡ ���Ϳ� �����ؼ� �����ϱ� ����
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Name.equals(s_num)) {
					check = 1; //�˻����� ��ǰ�� ������ �����ϴ� ����
					e_pro.Info_print();
					temp.addElement(e_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("�˻���� ����!!");
				return null;
			}
		}else if(select==2) {
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Life> it = L_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Name.equals(s_num)) {
					check = 1; //�˻����� ��ǰ�� ������ �����ϴ� ����
					l_pro.Info_print();
					temp.addElement(l_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("�˻���� ����!!");
				return null;
			}
		}else if(select==3) {
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Food> it = F_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Name.equals(s_num)) {
					check = 1; //�˻����� ��ǰ�� ������ �����ϴ� ����
					f_pro.Info_print();
					temp.addElement(f_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("�˻���� ����!!");
				return null;
			}
		}else if(select==4) {
			return null;
		}else {
			System.out.println("�߸��� �Է°�!!");
			return null;
		}
	}
	public void Total_Print() { //��ǰ ��ü��� �޼���
		int select;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		if(select==1) {
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("����� �����Ͱ� ����!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				e_pro.Info_print();
			}
		}else if(select==2) {
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("����� �����Ͱ� ����!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				l_pro.Info_print();
			}
		}else if(select==3) {
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("����� �����Ͱ� ����!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				f_pro.Info_print();
			}
		}else if(select==4) {
			return;
		}else {
			System.out.println("�߸��� �Է°�!!");
			return;
		}
	}
}
