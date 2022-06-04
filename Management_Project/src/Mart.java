import java.util.*;

interface Shopping{
	abstract public void Buy(); //물품 구매 메서드
	abstract public void Cart(); //물품 장바구니 메서드
	abstract public void Search(); //물품 검색 메서드
}

public class Mart {
	protected Controller con = new Controller(); //컨트롤러에 있는 메서드 활용을 위해 사용
	protected Product [] cart_info = new Product[10]; //장바구니 배열 생성
	protected Vector<Product> cart_info_Vector = new Vector<Product>(); //장바구니 벡터 생성
	protected int cart_index = 0;
	
	public void Buy(Product p) { //물품 구매 메서드
		if(p.Product_Amount == 0) {
			System.out.println("재고가 없음!!");
			return;
		}else {
			p.Product_Amount--;
			System.out.println(p.Product_Price + "원이 지불되었습니다.");
		}
	}
	public void Cart(Product p) { //장바구니에 담는 메서드
		cart_info_Vector.addElement(p);
		System.out.println("장바구니 담기 성공!!");
	}
	public void Cart_Print() { //장바구니를 출력하는 메서드
		Iterator<Product> it = cart_info_Vector.iterator();
		if(!it.hasNext()) {
			System.out.println("장바구니 비었음!!");
		}else {
			System.out.println("===========출력결과==========");
			while(it.hasNext()) {
				Product p = it.next();
				System.out.println("제품명 : " + p.Product_Name + "    가격 : " + p.Product_Price);
				System.out.println("===========================");
			}
		}
	}

	public void Search() { //고객용 물품 검색 메서드(이름으로)
		Vector<Product> p_search_result = con.ProductSearch(); //제품을 검색해서 제품 정보 가져오기
		Product product_select;
		Scanner sc = new Scanner(System.in);
		String select1;
		int select2, check=0;
		
		System.out.print("제품번호로 선택 : ");
		select1 = sc.next();
		Iterator<Product> it = p_search_result.iterator();
		while(it.hasNext()) {
			Product result = it.next();
			if(result.Product_Num.equals(select1)) {
				check=1;
				System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				System.out.println("| 1.구매  2.장바구니  3.뒤로가기 |");
				System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
				System.out.print("입력 : ");
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
			System.out.println("검색결과 없음!!");
			return;
		}
	}
	public void Mart_main() { //마트 클래스에서 가장 먼저 실행
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
