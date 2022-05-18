import java.util.*;

public class Management {
	public void Management_main() {
		int select;
		Scanner sc = new Scanner(System.in);
		Controller con = new Controller();
		
		while(true) {
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.println("| 1.등록  2.삭제  3.수정  4.검색  5.출력  6.뒤로가기 |");
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.print("입력 : ");
			select = sc.nextInt();
			
			switch(select) {
			case 1: //등록메뉴
				con.ProductRegister();
				break;
			case 2: //삭제메뉴
				con.ProductDelete();
				break;
			case 3: //수정메뉴
				con.ProductRevise();
				break;
			case 4: //검색메뉴
				con.ProductSearch();
				break;
			case 5: //검색메뉴
				con.Total_Print();
				break;
			case 6: //뒤로가기
				return;
			}
		}
	}
}
