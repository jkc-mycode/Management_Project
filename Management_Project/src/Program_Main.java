import java.util.*;
import java.io.*;

public class Program_Main implements Serializable {
	public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException, EOFException {
		int select;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(" =======��ǰ���� ���α׷�======");
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.println("| 1.������  2.��  3.�����ϱ� |");
			System.out.print("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�\n");
			System.out.print("�Է� : ");
			select = sc.nextInt();
			if(select==1) {
				Management mg = new Management();
				mg.Management_main();
			}else if(select==2) {
				Mart mt = new Mart();
				mt.Mart_main();
			}else if(select==3) {
				System.out.println("���α׷� ����!!");
				return;
			}else {
				System.out.println("�߸��� �Է�!!");
			}
		}
	}
}
