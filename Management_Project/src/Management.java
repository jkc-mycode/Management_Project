import java.util.*;

public class Management {
	public void Management_main() {
		int select;
		Scanner sc = new Scanner(System.in);
		Controller con = new Controller();
		
		while(true) {
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.println("| 1.���  2.����  3.����  4.�˻�  5.���  6.�ڷΰ��� |");
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.print("�Է� : ");
			select = sc.nextInt();
			
			switch(select) {
			case 1: //��ϸ޴�
				con.ProductRegister();
				break;
			case 2: //�����޴�
				con.ProductDelete();
				break;
			case 3: //�����޴�
				con.ProductRevise();
				break;
			case 4: //�˻��޴�
				con.ProductSearch();
				break;
			case 5: //�˻��޴�
				con.Total_Print();
				break;
			case 6: //�ڷΰ���
				return;
			}
		}
	}
}
