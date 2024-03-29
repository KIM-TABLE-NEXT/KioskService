package kiosk.domain;

public class Menu {
    private String name;
    private String description;

    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void show(){
        System.out.printf("%-20s | %s\n", name, description);
    }
}
