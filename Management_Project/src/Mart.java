import java.util.*;

interface Shopping{
	abstract public void Buy(); //물품 구매 메서드
	abstract public void Cart(); //물품 장바구니 메서드
	abstract public void Search(); //물품 검색 메서드
}

public class Mart {
	protected Controller con = new Controller(); //컨트롤러에 있는 메서드 활용을 위해 사용
	protected Product [] cart_info = new Product[10]; //장바구니 배열 생성
	protected int cart_index = 0;
	
	public void Buy(Product p) {
		if(p.Product_Amount == 0) {
			System.out.println("재고가 없음!!");
			return;
		}else {
			p.Product_Amount--;
			System.out.println(p.Product_Price + "원이 지불되었습니다.");
		}
	}
	public void Cart(Product p) { //장바구니에 담는 메서드
		cart_info[cart_index] = p;
		System.out.println("장바구니 담기 성공!!");
		cart_index++;
	}
	public void Cart_Print() { //장바구니를 출력하는 메서드
		if(cart_index == 0) {
			System.out.println("장바구니 비었음!!");
		}else {
			System.out.println("===========출력결과==========");
			for(int i=0; i<cart_index; i++) {
				System.out.println("제품명 : " + cart_info[i].Product_Name + "    가격 : " + cart_info[i].Product_Price);
				System.out.println("===========================");
			}
		}
	}
	public void Search() {
		Product p_search = con.ProductSearch(); //업캐스팅, 제품을 검색해서 제품 정보 가져오기
		Scanner sc = new Scanner(System.in);
		int select;
		if(p_search != null) {
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.println("| 1.구매  2.장바구니  3.뒤로가기 |");
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.print("입력 : ");
			select = sc.nextInt();
			if(select==1) {
				Buy(p_search);
			}else if(select==2) {
				Cart(p_search);
			}else {
				return;
			}
		}else {
			System.out.println("검색결과 없음!!");
			return;
		}
	}
	public void Mart_main() { //고객 메뉴 클래스
		int select;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.println("| 1.검색  2.장바구니  3.뒤로가기 |");
			System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
			System.out.print("입력 : ");
			select = sc.nextInt();
			
			switch(select) {
			case 1: //검색메뉴
				Search();
				break;
			case 2: //장바구니메뉴
				Cart_Print();
				break;
			case 3: //뒤로가기
				return;
			default:
				System.out.println("잘못된 입력값!!");
				return;
			}
		}
	}
}
