![image](https://github.com/jkc-mycode/Management_Project/assets/90839233/a967e7d0-6e41-4957-a7d2-76fcef04036b)


- Product(물품)클래스 : 여러 물품들의 슈퍼클래스  
  └ 공통적으로 가지는 제품번호, 제품명, 가격, 수량 필드  
  └ 초기화시키는 기본 생성자와 객체에 값을 넣는 생성자  
  └ 오버라이딩을 이용해서 객체의 내용을 출력하는 메서드  
- Management_Elec(전자제품)클래스 : 전자제품관련 서브클래스  
  └ super를 이용해서 슈퍼클래스의 필드 및 생성자  
  └ 초기화시키는 기본 생성자와 객체에 값을 넣는 생성자  
- Management_Life(생활용품)클래스 : 생활용품관련 서브클래스  
  └ super를 이용해서 슈퍼클래스의 필드 및 생성자  
  └ 초기화시키는 기본 생성자와 객체에 값을 넣는 생성자  
- Management_Food(식품)클래스 : 식품관련 서브클래스  
  └ super를 이용해서 슈퍼클래스의 필드 및 생성자  
  └ 초기화시키는 기본 생성자와 객체에 값을 넣는 생성자  
- Controller 클래스 : 각 물품들의 등록, 삭제, 수정, 검색, 출력의 기능을 전담하는 클래스  
  └ 전역으로 객체배열을 생성, 그 배열을 컨트롤할 인덱스 필드  
  └ 배열 객체가 비어있는지 가득 찼는지 확인하는 메서드  
  └ 프로그램의 세부 메뉴를 출력하는 메서드  
  └ 객체의 등록, 삭제, 수정, 검색, 출력의 메서드  
  
======================== 추가 및 변경한 클래스 (2단계) ========================  
- Management(관리) 클래스 : Management_Main.class  =>  Management.class 클래스 이름 변경  
- Controller 클래스의 ProductSearch() 메서드 변경  
  └ 반환 값으로 검색해서 찾은 물품의 객체를 반환하도록 변경  
  └ Mart 클래스의 Search() 메서드에서는 물품의 검색뿐만 아니라 정보도 필요하기 때문에 변경  
  └ 그래서 반환 값으로 슈퍼클래스인 Product 타입으로 업캐스팅 사용  
- Mart 클래스 : 물품 구매 및 장바구니 담기 기능이 있는 고객용 클래스 추가  
  └ Controller 클래스의 메서드를 사용하기 위한 Controller 객체  
  └ 장바구니에 담은 물품을 확인하기 위한 Product 타입의 객체 배열  
  └ 물건 검색, 구매, 장바구니, 장바구니 출력 메서드 인터페이스로 구현 (복습삼아 구현)  
- Program_Main 클래스 : 프로그램에서 관리용인지 고객용인지 나누기 위한 클래스 추가  
  └ 프로그램 실행 시 제일 먼저 실행되는 main 메서드 존재  
  
======================== 추가 및 변경한 클래스 (3단계) ========================  
- Controller 클래스 : Collection 활용  
  └ 기존에 배열로 물품의 객체를 저장하는 방식에서 Vector<E>로 저장하는 방식으로 변경  
  └ Vector는 자동으로 사이즈가 늘어나기에 가득 찼는지 확인하는 메서드들 삭제  
  └ 기존의 ProductSearch() 메서드에서 중복된 이름의 물품들이 있으면 하나만 출력됨  
  └ 중복된 이름의 물품들을 전부 출력하기 위해서 Vector에 따로 담아서 출력 및 관리  
  └ ProductSearch() 메서드에서 제품 번호로만 검색하는 방식에서 Mart 클래스에서도 활용하기 위해 번호 또는 이름으로 검색 가능하도록 변경  
  └ Mart 클래스의 고객용 Search()메서드에서도 활용하기 위해서 Vector를 이용해서 객체 정보 반환  
- Mart 클래스 :   
  └ 장바구니 정보를 담는 배열을 삭제하고 Vector형태로 변경  
  └ Search() 메서드에서 제품번호로만 검색하는 것에서 제품 이름  
  └ ProductSearch() 메서드에서 검색결과를 Vector로 가져와서 사용하도록 변경  
  
======================== 추가 및 변경한 클래스 (4단계) ========================  
- Controller 클래스 : 파일 I/O 클래스 사용  
  └ 파일 I/O 패키지 import 추가  
  └ Controller 클래스 직렬화 : Serializable 인터페이스 implements  
  └ init() 메서드 추가 : 프로그램 실행 시 파일에 있는 Collection 정보를 가져옴  
  └ save() 메서드 추가 : 메뉴 조작 시마다 .bin파일에 Collection정보 추가 및 갱신  
  └ Object 입출력 Stream를 사용하는 메서드는 예외처리를 상위 메서드에 throws  
  └ ProductRegister(), ProductDelete(), ProductRevise() 메서드에서 Object 입출력 Stream 사용  
  └ Collection이 비어있는지 확인하는 메서드 제거 (다시 코드를 살펴보니 필요 없기에 삭제)  
- Management 클래스  
  └ 파일 I/O 패키지 import 추가  
  └ Controller 객체를 생성하여 init()메서드 실행  
  └ Management 클래스 직렬화 : Serializable 인터페이스 implements  
- Product 클래스  
  └ 파일 I/O 패키지 import 추가  
  └ Product 클래스 직렬화 : Serializable 인터페이스 implements  
- Mart 클래스  
  └ 파일 I/O 패키지 import 추가  
  └ Mart 클래스 직렬화 : Serializable 인터페이스 implements  
  └ Buy() 메서드에 save() 메서드를 추가로 실행해서 구매 후 변경된 수량을 저장  
- Program_Main 클래스  
  └ 파일 I/O 패키지 import 추가  
  └ Program 클래스 직렬화 : Serializable 인터페이스 implements  
