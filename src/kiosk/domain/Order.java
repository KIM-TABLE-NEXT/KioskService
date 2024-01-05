package kiosk.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static kiosk.service.KioskService.clearScreen;

public class Order {
    private ArrayList<Product> shoppingbag = new ArrayList<Product>();
    private ArrayList<Product> sold = new ArrayList<Product>();
    private double totalprice;
    public void addorder(Product product){
        int yesno;
        Scanner sc = new Scanner(System.in);
        do {
            clearScreen();
            product.show();
            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n");
            System.out.println("1. 확인        2. 취소\n");
            yesno = sc.nextInt();
            if(yesno==1) {
                clearScreen();
                shoppingbag.add(product);
                System.out.printf("%s 가 장바구니에 추가되었습니다.\n\n", product.getName());
            }
            else if(yesno==2){
                clearScreen();
            }
        }while(yesno < 1 || yesno > 2);
    }

    public void addorder(Product product, double sizeupPrice){
        int yesno;
        Scanner sc = new Scanner(System.in);
        String name = product.getName() + " (Sizeup)";
        Product sizeUpProduct = new Product(name,product.getDescription(),product.getSizeupPrice(),product.getCategory());
        do {
            clearScreen();
        sizeUpProduct.show();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n");
        System.out.println("1. 확인        2. 취소\n");
        yesno = sc.nextInt();
            if(yesno==1) {
                clearScreen();
                shoppingbag.add(sizeUpProduct);
                System.out.printf("%s 가 장바구니에 추가되었습니다.\n\n", sizeUpProduct.getName());
            }
            else if(yesno==2){
                clearScreen();
            }
        }while(yesno < 1 || yesno > 2);
    }

    public void cancelorder(){
        shoppingbag.clear();
    }

    public void show(){
        Collections.sort(shoppingbag, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getName().compareTo(o2.getName())>0) return 1;
                if(o1.getName().compareTo(o2.getName())<0) return -1;
                return 0;
            }
        });
        int ea = 1;
        for(int i=0; i<shoppingbag.size()-1;i++){
            if(shoppingbag.get(i).getName().equals(shoppingbag.get(i+1).getName()))
                ea++;
            else {
                System.out.printf("%-20s | W %s | %d개 | %s\n", shoppingbag.get(i).getName(), shoppingbag.get(i).getPrice(),ea, shoppingbag.get(i).getDescription());
                ea=1;
            }
        }
        if(ea!=1&&shoppingbag.size()>1)
            System.out.printf("%-20s | W %s | %d개 | %s\n", shoppingbag.get(shoppingbag.size()-2).getName(), shoppingbag.get(shoppingbag.size()-2).getPrice(),ea, shoppingbag.get(shoppingbag.size()-2).getDescription());
        else if(ea==1&&shoppingbag.size()>0)
            System.out.printf("%-20s | W %s | %d개 | %s\n", shoppingbag.get(shoppingbag.size()-1).getName(), shoppingbag.get(shoppingbag.size()-1).getPrice(),ea, shoppingbag.get(shoppingbag.size()-1).getDescription());

    }

    public void sold(){
        for(Product cart : shoppingbag)
            sold.add(cart);
    }

    public void soldprint(){
        Collections.sort(sold, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(o1.getName().compareTo(o2.getName())>0) return 1;
                if(o1.getName().compareTo(o2.getName())<0) return -1;
                return 0;
            }
        });
        int ea = 1;
        for(int i=0; i<sold.size()-1;i++){
            if(sold.get(i).getName().equals(sold.get(i+1).getName()))
                ea++;
            else {
                System.out.printf("%-20s | W %s | %d개 | %s\n", sold.get(i).getName(), sold.get(i).getPrice(),ea, sold.get(i).getDescription());
                ea=1;
            }
        }
        if(ea!=1)
            System.out.printf("%-20s | W %s | %d개 | %s\n", sold.get(sold.size()-2).getName(), sold.get(sold.size()-2).getPrice(),ea, sold.get(sold.size()-2).getDescription());
        else if(ea==1)
            System.out.printf("%-20s | W %s | %d개 | %s\n", sold.get(sold.size()-1).getName(), sold.get(sold.size()-1).getPrice(),ea, sold.get(sold.size()-1).getDescription());
    }

    public void total(){
        totalprice = 0;
        for(Product cart : shoppingbag)
            totalprice += cart.getPrice();
        System.out.println("[ Total ]");
        System.out.printf("W %s \n",Math.round(totalprice*10)/10.0);
    }

    public double getTotalPrice(){return totalprice;}

}



