package kiosk.service;

import kiosk.domain.Menu;
import kiosk.domain.Order;
import kiosk.domain.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class KioskService {
    private Order order = new Order();
    private ArrayList<Menu> category = new ArrayList<Menu>();
    private ArrayList<Product> product = new ArrayList<Product>();
    private ArrayList<Product> categoryProduct = new ArrayList<Product>();
    private int count = 1;
    private double sell;
    public void initMenu() {

        Menu burgers = new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거");
        Menu frozencustard = new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림");
        Menu drinks = new Menu("Drinks", "매장에서 직접 만드는 음료");
        Menu beer = new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주");
        category.add(burgers);
        category.add(frozencustard);
        category.add(drinks);
        category.add(beer);

        Product shackburger = new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, 10.9, "Burgers");
        Product smokeshack = new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9, 12.9, "Burgers");
        Product shroomburger = new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4, "Burgers");
        Product cheeseburger = new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9, 10.9, "Burgers");
        Product hamburger = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 6.9, 9.0, "Burgers");
        product.add(shackburger);
        product.add(smokeshack);
        product.add(shroomburger);
        product.add(cheeseburger);
        product.add(hamburger);

        Product shakes = new Product("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙 & 화이트, 스트로베리, 피넛 버터, 커피", 5.9, "Frozen Custard");
        Product shakeoftheweek = new Product("Shake of the Week", "특별한 커스터드 플레이버", 6.5, "Frozen Custard");
        Product redbeanshake = new Product("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩 된 시즈널 쉐이크", 6.5, "Frozen Custard");
        Product floats = new Product("Floats", "루트 비어, 퍼플 카우, 크림 시클", 5.9, "Frozen Custard");
        Product cupsandcones = new Product("Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", 4.9, 5.9, "Frozen Custard");
        Product concretes = new Product("Concretes", "쉐이크쉑의 쫀득한 커스터드와 다양한 믹스-인의 조합", 5.9, 8.9, "Frozen Custard");
        Product shackattack = new Product("Shack Attack", "초콜렛 퍼지소스, 초콜렛 트러플 쿠키, Lumiere 초콜렛 청크와 스프링클이 들어간 진한 초콜렛 커스터드", 5.9, "Frozen Custard");
        product.add(shakes);
        product.add(shakeoftheweek);
        product.add(redbeanshake);
        product.add(floats);
        product.add(cupsandcones);
        product.add(concretes);
        product.add(shackattack);

        Product shackmadelemonade = new Product("Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드(오리지날/시즈널)", 3.9, "Drinks");
        Product freshbrewedicedtea = new Product("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", 3.4, "Drinks");
        Product fiftyfifty = new Product("Fifty/Fifty", "레몬에이드와 아이스티의 만남", 3.5, "Drinks");
        Product fountainsoda = new Product("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", 2.7, "Drinks");
        Product abitarootbeer = new Product("Abita Root Beer", "청량감 있는 독특한 미국식 무알콜 탄산음료", 4.4, "Drinks");
        Product bottledwater = new Product("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", 1.0, "Drinks");
        product.add(shackmadelemonade);
        product.add(freshbrewedicedtea);
        product.add(fiftyfifty);
        product.add(fountainsoda);
        product.add(abitarootbeer);
        product.add(bottledwater);

        Product shackmeisterale = new Product("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", 9.8, "Beer");
        Product magpiebrewingco = new Product("Magpie Brewing Co.", "설명 없음", 6.8, "Beer");
        product.add(shackmeisterale);
        product.add(magpiebrewingco);
    }


    public void mainMenu() throws InterruptedException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int input = 0;
            int number = 0;
            System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
            System.out.println("[ SHAKESHACK MENU ]");
            for (Menu menu : category) {
                number++;
                System.out.printf("%d. ", number);
                menu.show();
            }
            System.out.println("\n[ ORDER MENU ]");
            System.out.println("5. Order       | 장바구니를 확인 후 주문합니다.");
            System.out.println("6. Cancel      | 진행중인 주문을 취소합니다.");
            input = sc.nextInt();
            switch(input){
                case 0:
                    sellMenu();
                    break;

                case 1: case 2: case 3: case 4:
                    categoryMenu(input, category.get(input - 1).getName());
                    break;

                case 5:
                    orderMenu();
                    break;

                case 6:
                    cancelMenu();
                    break;
            }
        }
    }

    public void sellMenu(){
        int yesno;
        Scanner sc = new Scanner(System.in);
        do {
            clearScreen();

            System.out.println("[ 총 판매상품 목록 현황 ]");
            System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
            order.soldprint();
            System.out.printf("현재까지 총 판매된 금액은 [ W  %s  ] 입니다.\n\n",Math.round(sell*10)/10.0);
            System.out.println("1. 돌아가기\n");
            yesno = sc.nextInt();
        }while(yesno!=1);
        clearScreen();
    }
    public void categoryMenu(int number, String category) throws InterruptedException {
        int input;
        int yesNo;
        int i = 0;
        Scanner sc = new Scanner(System.in);
        if (0 < number && number < 5) { //product
            do {
                i = 0;
                categoryProduct.clear();
                clearScreen();
                System.out.println("\"SHAKESHACK BURGER 에 오신걸 환영합니다.\"");
                System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
                System.out.println("[ " + category + " MENU ]");
                for (Product food : product)
                    if (food.getCategory().equals(category))
                        categoryProduct.add(food);
                for (Product food : categoryProduct) {
                    i++;
                    System.out.printf("%d. ", i);
                    food.show();
                }
                input = sc.nextInt();
            }while (0>input||input>i);
            if(categoryProduct.get(input - 1).getSizeupPrice()!=0){
                do{
                    clearScreen();
                    categoryProduct.get(input - 1).show();
                    System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                    System.out.printf("1. Single(W" + categoryProduct.get(input - 1).getPrice() + ")        2. Double(W"+ categoryProduct.get(input - 1).getSizeupPrice()+")\n");
                    yesNo = sc.nextInt();
                }while(yesNo<1||yesNo>2);
                if(yesNo==2)
                    order.addorder(categoryProduct.get(input - 1),categoryProduct.get(input - 1).getSizeupPrice());
                else
                    order.addorder(categoryProduct.get(input - 1));
            }
            else
                order.addorder(categoryProduct.get(input - 1));
        }
        }


    public void orderMenu() throws InterruptedException {
        int yesNo;
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ ORDERS ]");
        order.show();
        order.total();
        if (order.getTotalPrice() != 0) {
            do {
                clearScreen();
                System.out.println("아래와 같이 주문 하시겠습니까?\n");
                System.out.println("[ ORDERS ]");
                order.show();
                order.total();
                System.out.println("\n1. 주문        2. 메뉴판\n");
                yesNo = sc.nextInt();
                if (yesNo == 1) {
                    clearScreen();
                    System.out.println("주문이 완료되었습니다!\n");
                    System.out.printf("대기번호는 [ " + count++ + " ] 번 입니다.\n");
                    System.out.printf("(3초후 메뉴판으로 돌아갑니다.)");
                    sell += order.getTotalPrice();
                    order.sold();
                    order.cancelorder();
                    Thread.sleep(3000);
                    clearScreen();
                } else if (yesNo == 2)
                    clearScreen();
            } while (yesNo < 1 || yesNo > 2);
        }
        else{
            System.out.println("장바구니가 비었습니다.\n");
            System.out.printf("(3초후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
            clearScreen();
        }

    }

    public void cancelMenu(){
        int yesNo;
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        yesNo = sc.nextInt();
        if (yesNo == 1) {
            order.cancelorder();
            clearScreen();
            System.out.println("진행하던 주문이 취소되었습니다.\n");
        } else {
            clearScreen();
        }
    }

    public static void clearScreen() {
        for (int i = 0; i < 80; i++)
            System.out.println("");
    }
}


