package javazon2;

public class Menu {

    private Product menuItems[];

    public Menu() {
        menuItems = new Product[9];

        Product book;
        book = new Product("BK100", "Book", "Java", 12.99);
        menuItems[0] = book;
        book = new Product("BK200", "Book", "VB", 16.99);
        menuItems[1] = book;
        book = new Product("BK300", "Book", "PHP", 15.99);
        menuItems[2] = book;

        Product CD;
        CD = new Product("CD100", "CD", "TOP 10", 20.99);
        menuItems[3] = CD;
        CD = new Product("CD200", "CD", "TOP 20", 22.99);
        menuItems[4] = CD;
        CD = new Product("CD300", "CD", "TOP 100", 24.99);
        menuItems[5] = CD;

        Product game;
        game = new Product("GM100", "Game", "Halo 1", 40.99);
        menuItems[6] = game;
        game = new Product("GM200", "Game", "Halo 2", 42.99);
        menuItems[7] = game;
        game = new Product("GM200", "Game", "Halo 3", 44.99);
        menuItems[8] = game;
    }

    //Method to return a product menu array
    public Product[] getMenu() {
        return menuItems;
    }

    //method to return an array of descriptions
    public String[] getMenuDescriptions() {
        String menuDescription[] = new String[menuItems.length];
        for (int i = 0; i < menuItems.length; i++) {
            menuDescription[i] = menuItems[i].getDescription();
        }
        return menuDescription;
    }

    public String getPrice(int anIndex) {
        Product selectedProduct = menuItems[anIndex];
        return String.valueOf(selectedProduct.getPrice());
    }
}