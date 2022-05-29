import java.util.*;

class Controller {
	protected static int E_count=-1, L_count=-1, F_count=-1; //제품 객체 배열의 인덱스 번호 초기화
	//protected static Management_Elec [] E_product = new Management_Elec[10]; //전자제품 객체 배열 생성
	protected static Vector<Management_Elec> E_product_Vector = new Vector<Management_Elec>(); //전자제품 객체 벡터로 생성
	//protected static Management_Life [] L_product = new Management_Life[10]; //생활용품 객체 배열 생성
	protected static Vector<Management_Life> L_product_Vector = new Vector<Management_Life>(); //생활용품 객체 벡터로 생성
	//protected static Management_Food [] F_product = new Management_Food[10]; //식품 객체 배열 생성
	protected static Vector<Management_Food> F_product_Vector = new Vector<Management_Food>(); //식품 객체 벡터로 생성
	
	public int Empty_E() { //제품의 벡터가 비었는지 확인
		if(E_product_Vector.size() == 0) {
			return 0;
		}
		return 1;
	}
	public int Empty_L() { //제품의 벡터가 비었는지 확인
		if(L_product_Vector.size() == 0) {
			return 0;
		}
		return 1;
	}
	public int Empty_F() { //제품의 벡터가 비었는지 확인
		if(F_product_Vector.size() == 0) {
			return 0;
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
			
			Management_Elec e_pro = new Management_Elec(num, name, price, amount, maker, guarantee, grade);
			E_product_Vector.addElement(e_pro);
			int n = E_product_Vector.lastIndexOf(e_pro);
			E_product_Vector.get(n).Info_print();
		}else if(select == 2) {
			sc2.nextLine();
			System.out.print("제조사 : ");
			maker = sc2.nextLine();
			System.out.print("용도 : ");
			usage = sc2.nextLine();
			
			Management_Life l_pro = new Management_Life(num, name, price, amount, maker, usage);
			L_product_Vector.addElement(l_pro);
			int n = L_product_Vector.lastIndexOf(l_pro);
			L_product_Vector.get(n).Info_print();
		}else if(select == 3){
			sc2.nextLine();
			System.out.print("제조사 : ");
			maker = sc2.nextLine();
			System.out.print("유통기한 : ");
			f_day = sc2.nextLine();
			System.out.print("종류 : ");
			f_kind = sc2.nextLine();
			
			Management_Food f_pro = new Management_Food(num, name, price, amount, maker, f_day, f_kind);
			F_product_Vector.addElement(f_pro);
			int n = L_product_Vector.lastIndexOf(f_pro);
			F_product_Vector.get(n).Info_print();
			
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
			//Iterator를 활용한 전자제품 객체 삭제문
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("삭제할 데이터가 없음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Num.equals(d_num)) {
					System.out.println("제품번호 "+d_num+"를(을) 삭제합니다!!");
					it.remove();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select == 2) {
			//Iterator를 활용한 생활용품 객체 삭제문
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("삭제할 데이터가 없음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Num.equals(d_num)) {
					System.out.println("제품번호 "+d_num+"를(을) 삭제합니다!!");
					it.remove();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select == 3) {
			//Iterator를 활용한 식품 객체 삭제문
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("삭제할 데이터가 없음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Num.equals(d_num)) {
					System.out.println("제품번호 "+d_num+"를(을) 삭제합니다!!");
					it.remove();
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
		//어느걸 수정할지 메뉴 선택(스위치문 or if문) -> 제품번호입력 -> 다시입력(수정) ->수정완료\
		//벡터와 Iterator를 활용
		int select;
		String r_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("수정할 제품번호 : ");
		r_num = sc.nextLine();
		if(select==1) {
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("데이터가 비어있음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Num.equals(r_num)) {
					System.out.print("제품번호 : ");
					e_pro.Product_Num=sc.nextLine();
					System.out.print("제품명 : ");
					e_pro.Product_Name = sc.nextLine();
					System.out.print("가격 : ");
					e_pro.Product_Price = sc.nextInt();
					System.out.print("수량 : ");
					e_pro.Product_Amount = sc.nextInt();
					sc.nextLine();
					System.out.print("제조사 : ");
					e_pro.Maker = sc.nextLine();
					System.out.print("품질보증기간(일) : ");
					e_pro.Guarantee = sc.nextInt();
					System.out.print("에너지등급 : ");
					e_pro.Grade = sc.nextInt();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select==2) {
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("데이터가 비어있음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Num.equals(r_num)) {
					System.out.print("제품번호 : ");
					l_pro.Product_Num=sc.nextLine();
					System.out.print("제품명 : ");
					l_pro.Product_Name = sc.nextLine();
					System.out.print("가격 : ");
					l_pro.Product_Price = sc.nextInt();
					System.out.print("수량 : ");
					sc.nextLine();
					System.out.print("제조사 : ");
					l_pro.Maker = sc.nextLine();
					System.out.print("용도 : ");
					l_pro.Usage = sc.nextLine();
					return;
				}
			}
			System.out.println("찾는 정보가 없음!!");
			return;
		}else if(select==3) {
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("데이터가 비어있음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Num.equals(r_num)) {
					System.out.print("제품번호 : ");
					f_pro.Product_Num=sc.nextLine();
					System.out.print("제품명 : ");
					f_pro.Product_Name = sc.nextLine();
					System.out.print("가격 : ");
					f_pro.Product_Price = sc.nextInt();
					System.out.print("수량 : ");
					sc.nextLine();
					System.out.print("제조사 : ");
					f_pro.Made = sc.nextLine();
					System.out.print("유통기한 : ");
					f_pro.F_Day = sc.nextLine();
					System.out.print("종류 : ");
					f_pro.F_Kind = sc.nextLine();
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
	public Vector<Product> ProductSearch() { //제품검색 메서드
		//어느걸 찾을지 메뉴 선택(스위치문 or if문) -> 제품번호입력 -> index이용해서 반복문 -> 검색완료
		//전체 출력도 메뉴에 넣기
		int select, check=0;
		String s_num;
		Scanner sc = new Scanner(System.in);
		select=print_menu();
		System.out.print("검색할 제품명 : ");
		s_num = sc.nextLine();
		System.out.println("===========출력결과==========");
		
		if(select==1) {
			//중복된 이름을 가진 제품이 있을 수 있기에 벡터에 저장해서 리턴하기 위해
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				if(e_pro.Product_Name.equals(s_num)) {
					check = 1; //검색에서 제품의 유무를 저장하는 변수
					e_pro.Info_print();
					temp.addElement(e_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("검색결과 없음!!");
				return null;
			}
		}else if(select==2) {
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Life> it = L_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				if(l_pro.Product_Name.equals(s_num)) {
					check = 1; //검색에서 제품의 유무를 저장하는 변수
					l_pro.Info_print();
					temp.addElement(l_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("검색결과 없음!!");
				return null;
			}
		}else if(select==3) {
			Vector<Product> temp = new Vector<Product>(); 
			Iterator<Management_Food> it = F_product_Vector.iterator();
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				if(f_pro.Product_Name.equals(s_num)) {
					check = 1; //검색에서 제품의 유무를 저장하는 변수
					f_pro.Info_print();
					temp.addElement(f_pro);
				}
			}
			if(check == 1) {
				return temp;
			}else {
				System.out.println("검색결과 없음!!");
				return null;
			}
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
			Iterator<Management_Elec> it = E_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("출력할 데이터가 없음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Elec e_pro = it.next();
				e_pro.Info_print();
			}
		}else if(select==2) {
			Iterator<Management_Life> it = L_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("출력할 데이터가 없음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Life l_pro = it.next();
				l_pro.Info_print();
			}
		}else if(select==3) {
			Iterator<Management_Food> it = F_product_Vector.iterator();
			if(!it.hasNext()) {
				System.out.println("출력할 데이터가 없음!!");
				return;
			}
			while(it.hasNext()) {
				Management_Food f_pro = it.next();
				f_pro.Info_print();
			}
		}else if(select==4) {
			return;
		}else {
			System.out.println("잘못된 입력값!!");
			return;
		}
	}
}
