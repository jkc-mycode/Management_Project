import java.util.*;

class Controller {
	protected static int E_count=-1, L_count=-1, F_count=-1; //제품 객체 배열의 인덱스 번호 초기화
	protected static Management_Elec [] E_product = new Management_Elec[10]; //전자제품 객체 배열 생성
	protected static Management_Life [] L_product = new Management_Life[10]; //생활용품 객체 배열 생성
	protected static Management_Food [] F_product = new Management_Food[10]; //식품 객체 배열 생성
	
	public int Full_E() {
		if(E_count>=E_product.length-1) {
			return 1;
		}
		return 0;
	}
	public int Empty_E() { //제품의 배열이 비었는지 확인
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
	public int Empty_L() { //제품의 배열이 비었는지 확인
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
	public int Empty_F() { //제품의 배열이 비었는지 확인
		for(int i=0;i<=F_count;i++) {
			if(!F_product[i].Product_Num.equals("none")) {
				return 0;
			}
		}
		return 1;
	}
	public int print_menu() { //하부 메뉴 출력
		Scanner sc1 = new Scanner(System.in);
		System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		System.out.println("| 1.전자제품  2.생활용품  3.식품  4.뒤로가기 |");
		System.out.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n");
		System.out.print("입력 : ");
		int select = sc1.nextInt();
		return select;
	}
	
	public void ProductRegister() { //제품등록 메서드
		String num, name, maker, usage, f_day, f_kind; //제품번호, 제품명, 제조사, 용도, 유통기한, 종류
		int price, amount, guarantee, grade; //수량, 품질보증기간, 에너지등급
		int select;
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		select = print_menu();
		if(select == 4) { return; }
		
		if(Full_E()==1) {
			System.out.println("공간이 가득 찼음!!");
			return;
		}
		System.out.print("제품번호 : ");
		num = sc2.nextLine();
		System.out.print("제품명 : ");
		name = sc2.nextLine();
		System.out.print("가격 : ");
		price = sc2.nextInt();
		System.out.print("수량 : ");
		amount = sc2.nextInt();
		if(select == 1) {
			sc2.nextLine();
			System.out.print("제조사 : ");
			maker = sc2.nextLine();
			System.out.print("품질보증기간(일) : ");
			guarantee = sc2.nextInt();
			System.out.print("에너지등급 : ");
			grade = sc2.nextInt();
			
			E_product[++E_count] = new Management_Elec(num, name, price, amount, maker, guarantee, grade);
			E_product[E_count].Info_print();
		}else if(select == 2) {
			sc2.nextLine();
			System.out.print("제조사 : ");
			maker = sc2.nextLine();
			System.out.print("용도 : ");
			usage = sc2.nextLine();
			
			L_product[++L_count] = new Management_Life(num, name, price, amount, maker, usage);
			L_product[L_count].Info_print();
		}else if(select == 3){
			sc2.nextLine();
			System.out.print("제조사 : ");
			maker = sc2.nextLine();
			System.out.print("유통기한 : ");
			f_day = sc2.nextLine();
			System.out.print("종류 : ");
			f_kind = sc2.nextLine();
			
			F_product[++F_count] = new Management_Food(num, name, price, amount, maker, f_day, f_kind);
			F_product[F_count].Info_print();
		}else {
			System.out.println("잘못된 입력값!!");
			return;
		}
		
	}
	public void ProductDelete() { //제품삭제 메서드
		//어느걸 삭제할지 메뉴 선택(스위치문 or if문) -> 제품번호입력 -> 삭제
		int select; //메뉴선택 번호
		String d_num; //삭제할 제품번호
		Scanner sc = new Scanner(System.in);
		select = print_menu();
		System.out.print("삭제할 제품번호 : ");
		d_num = sc.nextLine();
		
		if(select == 1) {
			if(Empty_E() == 1) {
				System.out.println("삭제할 데이터가 없음!!");
				return;
			}
			for(int i=0;i<=E_count;i++) { //입력한 제품번호를 찾는 반복문
				if(E_product[i].Product_Num.equals(d_num)) {
					System.out.println("제품번호 "+d_num+"를(을) 삭제합니다!!");
					E_product[i] = new Management_Elec();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select == 2) {
			if(Empty_L() == 1) {
				System.out.println("삭제할 데이터가 없음!!");
				return;
			}
			for(int i=0;i<=L_count;i++) {
				if(L_product[i].Product_Num.equals(d_num)) {
					System.out.println("제품번호 "+d_num+"를(을) 삭제합니다!!");
					L_product[i] = new Management_Life();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select == 3) {
			if(Empty_F() == 1) {
				System.out.println("삭제할 데이터가 없음!!");
				return;
			}
			for(int i=0;i<=F_count;i++) {
				if(F_product[i].Product_Num.equals(d_num)) {
					System.out.println("제품번호 "+d_num+"를(을) 삭제합니다!!");
					F_product[i] = new Management_Food();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select == 4) {
			return;
		}else {
			System.out.println("잘못된 입력값!!");
			return;
		}
	}
	public void ProductRevise() { //제품수정 메서드
		//어느걸 수정할지 메뉴 선택(스위치문 or if문) -> 제품번호입력 -> 다시입력(수정) ->수정완료
		int select;
		String r_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("수정할 제품번호 : ");
		r_num = sc.nextLine();
		if(select==1) {
			if(Empty_E()==1) {
				System.out.println("데이터가 비어있음!!");
				return;
			}
			for(int i=0;i<=E_count;i++) {
				if(E_product[i].Product_Num.equals(r_num)) {
					System.out.print("제품번호 : ");
					E_product[i].Product_Num=sc.nextLine();
					System.out.print("제품명 : ");
					E_product[i].Product_Name = sc.nextLine();
					System.out.print("가격 : ");
					E_product[i].Product_Price = sc.nextInt();
					System.out.print("수량 : ");
					E_product[i].Product_Amount = sc.nextInt();
					sc.nextLine();
					System.out.print("제조사 : ");
					E_product[i].Maker = sc.nextLine();
					System.out.print("품질보증기간(일) : ");
					E_product[i].Guarantee = sc.nextInt();
					System.out.print("에너지등급 : ");
					E_product[i].Grade = sc.nextInt();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select==2) {
			if(Empty_L()==1) {
				System.out.println("데이터가 비어있음!!");
				return;
			}
			for(int i=0;i<=L_count;i++) {
				if(L_product[i].Product_Num.equals(r_num)) {
					System.out.print("제품번호 : ");
					L_product[i].Product_Num=sc.nextLine();
					System.out.print("제품명 : ");
					L_product[i].Product_Name = sc.nextLine();
					System.out.print("가격 : ");
					L_product[i].Product_Price = sc.nextInt();
					System.out.print("수량 : ");
					sc.nextLine();
					System.out.print("제조사 : ");
					L_product[i].Maker = sc.nextLine();
					System.out.print("용도 : ");
					L_product[i].Usage = sc.nextLine();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select==3) {
			if(Empty_F()==1) {
				System.out.println("데이터가 비어있음!!");
				return;
			}
			for(int i=0;i<=F_count;i++) {
				if(F_product[i].Product_Num.equals(r_num)) {
					System.out.print("제품번호 : ");
					F_product[i].Product_Num=sc.nextLine();
					System.out.print("제품명 : ");
					F_product[i].Product_Name = sc.nextLine();
					System.out.print("가격 : ");
					F_product[i].Product_Price = sc.nextInt();
					System.out.print("수량 : ");
					sc.nextLine();
					System.out.print("제조사 : ");
					F_product[i].Made = sc.nextLine();
					System.out.print("유통기한 : ");
					F_product[i].F_Day = sc.nextLine();
					System.out.print("종류 : ");
					F_product[i].F_Kind = sc.nextLine();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select==4) {
			return;
		}else {
			System.out.println("잘못된 입력값!!");
			return;
		}
	}
	public Product ProductSearch() { //제품검색 메서드
		//어느걸 찾을지 메뉴 선택(스위치문 or if문) -> 제품번호입력 -> index이용해서 반복문 -> 검색완료
		//전체 출력도 메뉴에 넣기
		int select;
		String s_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("검색할 제품번호 : ");
		s_num = sc.nextLine();
		System.out.println("===========출력결과==========");
		
		if(select==1) {
			for(int i=0;i<=E_count;i++) {
				if(E_product[i].Product_Num.equals(s_num)) {
					E_product[i].Info_print();
					return E_product[i];
				}
			}
			System.out.println("검색결과 없음!!");
			return null;
		}else if(select==2) {
			for(int i=0;i<=L_count;i++) {
				if(L_product[i].Product_Num.equals(s_num)) {
					L_product[i].Info_print();
					return L_product[i];
				}
			}
			System.out.println("검색결과 없음!!");
			return null;
		}else if(select==3) {
			for(int i=0;i<=F_count;i++) {
				if(F_product[i].Product_Num.equals(s_num)) {
					F_product[i].Info_print();
					return F_product[i];
				}
			}
			System.out.println("검색결과 없음!!");
			return null;
		}else if(select==4) {
			return null;
		}else {
			System.out.println("잘못된 입력값!!");
			return null;
		}
	}
	public void Total_Print() { //제품 전체출력 메서드
		int select;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		if(select==1) {
			if(Empty_E() == 1) {
				System.out.println("출력할 데이터가 없음!!");
				return;
			}
			for(int i=0;i<=E_count;i++) {
				E_product[i].Info_print();
			}
		}else if(select==2) {
			if(Empty_L() == 1) {
				System.out.println("출력할 데이터가 없음!!");
				return;
			}
			for(int i=0;i<=L_count;i++) {
				L_product[i].Info_print();
			}
		}else if(select==3) {
			if(Empty_F() == 1) {
				System.out.println("출력할 데이터가 없음!!");
				return;
			}
			for(int i=0;i<=F_count;i++) {
				F_product[i].Info_print();
			}
		}else if(select==4) {
			return;
		}else {
			System.out.println("잘못된 입력값!!");
			return;
		}
	}
}
