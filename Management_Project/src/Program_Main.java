import java.util.*;
import java.io.*;

public class Program_Main implements Serializable {
	public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException, EOFException {
		int select;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(" =======물품관리 프로그램======");
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.println("| 1.관리자  2.고객  3.종료하기 |");
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.print("입력 : ");
			select = sc.nextInt();
			if(select==1) {
				Management mg = new Management();
				mg.Management_main();
			}else if(select==2) {
				Mart mt = new Mart();
				mt.Mart_main();
			}else if(select==3) {
				System.out.println("프로그램 종료!!");
				return;
			}else {
				System.out.println("잘못된 입력!!");
			}
		}
	}
}
