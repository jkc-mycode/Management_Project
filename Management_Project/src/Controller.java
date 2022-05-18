import java.util.*;

class Controller {
	protected static int E_count=-1, L_count=-1, F_count=-1; //��ǰ ��ü �迭�� �ε��� ��ȣ �ʱ�ȭ
	protected static Management_Elec [] E_product = new Management_Elec[10]; //������ǰ ��ü �迭 ����
	protected static Management_Life [] L_product = new Management_Life[10]; //��Ȱ��ǰ ��ü �迭 ����
	protected static Management_Food [] F_product = new Management_Food[10]; //��ǰ ��ü �迭 ����
	
	public int Full_E() {
		if(E_count>=E_product.length-1) {
			return 1;
		}
		return 0;
	}
	public int Empty_E() { //��ǰ�� �迭�� ������� Ȯ��
		for(int i=0;i<=E_count;i++) {
			if(!E_product[i].Product_Num.equals("none")) {
				return 0;
			}
		}
		return 1;
	}
	public int Full_L() {
		if(L_count>=L_product.length-1) {
			return 1;
		}
		return 0;
	}
	public int Empty_L() { //��ǰ�� �迭�� ������� Ȯ��
		for(int i=0;i<=L_count;i++) {
			if(!L_product[i].Product_Num.equals("none")) {
				return 0;
			}
		}
		return 1;
	}
	public int Full_F() {
		if(F_count>=F_product.length-1) {
			return 1;
		}
		return 0;
	}
	public int Empty_F() { //��ǰ�� �迭�� ������� Ȯ��
		for(int i=0;i<=F_count;i++) {
			if(!F_product[i].Product_Num.equals("none")) {
				return 0;
			}
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
		
		if(Full_E()==1) {
			System.out.println("������ ���� á��!!");
			return;
		}
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
			
			E_product[++E_count] = new Management_Elec(num, name, price, amount, maker, guarantee, grade);
			E_product[E_count].Info_print();
		}else if(select == 2) {
			sc2.nextLine();
			System.out.print("������ : ");
			maker = sc2.nextLine();
			System.out.print("�뵵 : ");
			usage = sc2.nextLine();
			
			L_product[++L_count] = new Management_Life(num, name, price, amount, maker, usage);
			L_product[L_count].Info_print();
		}else if(select == 3){
			sc2.nextLine();
			System.out.print("������ : ");
			maker = sc2.nextLine();
			System.out.print("������� : ");
			f_day = sc2.nextLine();
			System.out.print("���� : ");
			f_kind = sc2.nextLine();
			
			F_product[++F_count] = new Management_Food(num, name, price, amount, maker, f_day, f_kind);
			F_product[F_count].Info_print();
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
			if(Empty_E() == 1) {
				System.out.println("������ �����Ͱ� ����!!");
				return;
			}
			for(int i=0;i<=E_count;i++) { //�Է��� ��ǰ��ȣ�� ã�� �ݺ���
				if(E_product[i].Product_Num.equals(d_num)) {
					System.out.println("��ǰ��ȣ "+d_num+"��(��) �����մϴ�!!");
					E_product[i] = new Management_Elec();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select == 2) {
			if(Empty_L() == 1) {
				System.out.println("������ �����Ͱ� ����!!");
				return;
			}
			for(int i=0;i<=L_count;i++) {
				if(L_product[i].Product_Num.equals(d_num)) {
					System.out.println("��ǰ��ȣ "+d_num+"��(��) �����մϴ�!!");
					L_product[i] = new Management_Life();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select == 3) {
			if(Empty_F() == 1) {
				System.out.println("������ �����Ͱ� ����!!");
				return;
			}
			for(int i=0;i<=F_count;i++) {
				if(F_product[i].Product_Num.equals(d_num)) {
					System.out.println("��ǰ��ȣ "+d_num+"��(��) �����մϴ�!!");
					F_product[i] = new Management_Food();
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
		//����� �������� �޴� ����(����ġ�� or if��) -> ��ǰ��ȣ�Է� -> �ٽ��Է�(����) ->�����Ϸ�
		int select;
		String r_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("������ ��ǰ��ȣ : ");
		r_num = sc.nextLine();
		if(select==1) {
			if(Empty_E()==1) {
				System.out.println("�����Ͱ� �������!!");
				return;
			}
			for(int i=0;i<=E_count;i++) {
				if(E_product[i].Product_Num.equals(r_num)) {
					System.out.print("��ǰ��ȣ : ");
					E_product[i].Product_Num=sc.nextLine();
					System.out.print("��ǰ�� : ");
					E_product[i].Product_Name = sc.nextLine();
					System.out.print("���� : ");
					E_product[i].Product_Price = sc.nextInt();
					System.out.print("���� : ");
					E_product[i].Product_Amount = sc.nextInt();
					sc.nextLine();
					System.out.print("������ : ");
					E_product[i].Maker = sc.nextLine();
					System.out.print("ǰ�������Ⱓ(��) : ");
					E_product[i].Guarantee = sc.nextInt();
					System.out.print("��������� : ");
					E_product[i].Grade = sc.nextInt();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select==2) {
			if(Empty_L()==1) {
				System.out.println("�����Ͱ� �������!!");
				return;
			}
			for(int i=0;i<=L_count;i++) {
				if(L_product[i].Product_Num.equals(r_num)) {
					System.out.print("��ǰ��ȣ : ");
					L_product[i].Product_Num=sc.nextLine();
					System.out.print("��ǰ�� : ");
					L_product[i].Product_Name = sc.nextLine();
					System.out.print("���� : ");
					L_product[i].Product_Price = sc.nextInt();
					System.out.print("���� : ");
					sc.nextLine();
					System.out.print("������ : ");
					L_product[i].Maker = sc.nextLine();
					System.out.print("�뵵 : ");
					L_product[i].Usage = sc.nextLine();
					return;
				}
			}
			System.out.println("ã�� ������ ����!!");
			return;
		}else if(select==3) {
			if(Empty_F()==1) {
				System.out.println("�����Ͱ� �������!!");
				return;
			}
			for(int i=0;i<=F_count;i++) {
				if(F_product[i].Product_Num.equals(r_num)) {
					System.out.print("��ǰ��ȣ : ");
					F_product[i].Product_Num=sc.nextLine();
					System.out.print("��ǰ�� : ");
					F_product[i].Product_Name = sc.nextLine();
					System.out.print("���� : ");
					F_product[i].Product_Price = sc.nextInt();
					System.out.print("���� : ");
					sc.nextLine();
					System.out.print("������ : ");
					F_product[i].Made = sc.nextLine();
					System.out.print("������� : ");
					F_product[i].F_Day = sc.nextLine();
					System.out.print("���� : ");
					F_product[i].F_Kind = sc.nextLine();
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
	public Product ProductSearch() { //��ǰ�˻� �޼���
		//����� ã���� �޴� ����(����ġ�� or if��) -> ��ǰ��ȣ�Է� -> index�̿��ؼ� �ݺ��� -> �˻��Ϸ�
		//��ü ��µ� �޴��� �ֱ�
		int select;
		String s_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("�˻��� ��ǰ��ȣ : ");
		s_num = sc.nextLine();
		System.out.println("===========��°��==========");
		
		if(select==1) {
			for(int i=0;i<=E_count;i++) {
				if(E_product[i].Product_Num.equals(s_num)) {
					E_product[i].Info_print();
					return E_product[i];
				}
			}
			System.out.println("�˻���� ����!!");
			return null;
		}else if(select==2) {
			for(int i=0;i<=L_count;i++) {
				if(L_product[i].Product_Num.equals(s_num)) {
					L_product[i].Info_print();
					return L_product[i];
				}
			}
			System.out.println("�˻���� ����!!");
			return null;
		}else if(select==3) {
			for(int i=0;i<=F_count;i++) {
				if(F_product[i].Product_Num.equals(s_num)) {
					F_product[i].Info_print();
					return F_product[i];
				}
			}
			System.out.println("�˻���� ����!!");
			return null;
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
			if(Empty_E() == 1) {
				System.out.println("����� �����Ͱ� ����!!");
				return;
			}
			for(int i=0;i<=E_count;i++) {
				E_product[i].Info_print();
			}
		}else if(select==2) {
			if(Empty_L() == 1) {
				System.out.println("����� �����Ͱ� ����!!");
				return;
			}
			for(int i=0;i<=L_count;i++) {
				L_product[i].Info_print();
			}
		}else if(select==3) {
			if(Empty_F() == 1) {
				System.out.println("����� �����Ͱ� ����!!");
				return;
			}
			for(int i=0;i<=F_count;i++) {
				F_product[i].Info_print();
			}
		}else if(select==4) {
			return;
		}else {
			System.out.println("�߸��� �Է°�!!");
			return;
		}
	}
}
