import java.util.*;

interface Shopping{
	abstract public void Buy(); //��ǰ ���� �޼���
	abstract public void Cart(); //��ǰ ��ٱ��� �޼���
	abstract public void Search(); //��ǰ �˻� �޼���
}

public class Mart {
	protected Controller con = new Controller(); //��Ʈ�ѷ��� �ִ� �޼��� Ȱ���� ���� ���
	protected Product [] cart_info = new Product[10]; //��ٱ��� �迭 ����
	protected int cart_index = 0;
	
	public void Buy(Product p) {
		if(p.Product_Amount == 0) {
			System.out.println("��� ����!!");
			return;
		}else {
			p.Product_Amount--;
			System.out.println(p.Product_Price + "���� ���ҵǾ����ϴ�.");
		}
	}
	public void Cart(Product p) { //��ٱ��Ͽ� ��� �޼���
		cart_info[cart_index] = p;
		System.out.println("��ٱ��� ��� ����!!");
		cart_index++;
	}
	public void Cart_Print() { //��ٱ��ϸ� ����ϴ� �޼���
		if(cart_index == 0) {
			System.out.println("��ٱ��� �����!!");
		}else {
			System.out.println("===========��°��==========");
			for(int i=0; i<cart_index; i++) {
				System.out.println("��ǰ�� : " + cart_info[i].Product_Name + "    ���� : " + cart_info[i].Product_Price);
				System.out.println("===========================");
			}
		}
	}
	public void Search() {
		Product p_search = con.ProductSearch(); //��ĳ����, ��ǰ�� �˻��ؼ� ��ǰ ���� ��������
		Scanner sc = new Scanner(System.in);
		int select;
		if(p_search != null) {
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.println("| 1.����  2.��ٱ���  3.�ڷΰ��� |");
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.print("�Է� : ");
			select = sc.nextInt();
			if(select==1) {
				Buy(p_search);
			}else if(select==2) {
				Cart(p_search);
			}else {
				return;
			}
		}else {
			System.out.println("�˻���� ����!!");
			return;
		}
	}
	public void Mart_main() { //�� �޴� Ŭ����
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
