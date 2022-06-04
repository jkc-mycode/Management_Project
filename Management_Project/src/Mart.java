import java.util.*;

interface Shopping{
	abstract public void Buy(); //��ǰ ���� �޼���
	abstract public void Cart(); //��ǰ ��ٱ��� �޼���
	abstract public void Search(); //��ǰ �˻� �޼���
}

public class Mart {
	protected Controller con = new Controller(); //��Ʈ�ѷ��� �ִ� �޼��� Ȱ���� ���� ���
	protected Product [] cart_info = new Product[10]; //��ٱ��� �迭 ����
	protected Vector<Product> cart_info_Vector = new Vector<Product>(); //��ٱ��� ���� ����
	protected int cart_index = 0;
	
	public void Buy(Product p) { //��ǰ ���� �޼���
		if(p.Product_Amount == 0) {
			System.out.println("��� ����!!");
			return;
		}else {
			p.Product_Amount--;
			System.out.println(p.Product_Price + "���� ���ҵǾ����ϴ�.");
		}
	}
	public void Cart(Product p) { //��ٱ��Ͽ� ��� �޼���
		cart_info_Vector.addElement(p);
		System.out.println("��ٱ��� ��� ����!!");
	}
	public void Cart_Print() { //��ٱ��ϸ� ����ϴ� �޼���
		Iterator<Product> it = cart_info_Vector.iterator();
		if(!it.hasNext()) {
			System.out.println("��ٱ��� �����!!");
		}else {
			System.out.println("===========��°��==========");
			while(it.hasNext()) {
				Product p = it.next();
				System.out.println("��ǰ�� : " + p.Product_Name + "    ���� : " + p.Product_Price);
				System.out.println("===========================");
			}
		}
	}

	public void Search() { //���� ��ǰ �˻� �޼���(�̸�����)
		Vector<Product> p_search_result = con.ProductSearch(); //��ǰ�� �˻��ؼ� ��ǰ ���� ��������
		Product product_select;
		Scanner sc = new Scanner(System.in);
		String select1;
		int select2, check=0;
		
		System.out.print("��ǰ��ȣ�� ���� : ");
		select1 = sc.next();
		Iterator<Product> it = p_search_result.iterator();
		while(it.hasNext()) {
			Product result = it.next();
			if(result.Product_Num.equals(select1)) {
				check=1;
				System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
				System.out.println("| 1.����  2.��ٱ���  3.�ڷΰ��� |");
				System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
				System.out.print("�Է� : ");
				select2 = sc.nextInt();
				if(select2==1) {
					Buy(result);
				}else if(select2==2) {
					Cart(result);
				}else {
					return;
				}
			}
		}
		if(check == 0) {
			System.out.println("�˻���� ����!!");
			return;
		}
	}
	public void Mart_main() { //��Ʈ Ŭ�������� ���� ���� ����
		int select;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.println("| 1.�˻�  2.��ٱ���  3.�ڷΰ��� |");
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.print("�Է� : ");
			select = sc.nextInt();
			
			switch(select) {
			case 1: //�˻��޴�
				Search();
				break;
			case 2: //��ٱ��ϸ޴�
				Cart_Print();
				break;
			case 3: //�ڷΰ���
				return;
			default:
				System.out.println("�߸��� �Է°�!!");
				return;
			}
		}
	}
}
