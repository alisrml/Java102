package PatikaStore;

import java.util.*;

public class PatikaStore {
    Scanner scanner = new Scanner(System.in);
    private List<Brand> brands;
    private List<Product> products;

    public PatikaStore() {
        brands = new ArrayList<>();
        products = new ArrayList<>();
        initializeBrands();
    }

    private void initializeBrands() {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

        // Sort brands alphabetically
        Collections.sort(brands, Comparator.comparing(Brand::getName));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(p -> p.getId() == productId);
    }

    public List<Product> filterProductsByBrand(int brandId) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().getId() == brandId) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public List<Product> filterProductsByBrandAndId(int brandId, int productId) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getBrand().getId() == brandId && product.getId() == productId) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public void listProducts() {
        System.out.println("Product Listing:\n");
        System.out.format("%-5s %-20s %-20s %-10s\n", "ID", "Ad", "Marka", "Kategori");
        System.out.println("--------------------------------------------");
        for (Product product : products) {
            String category = (product instanceof CellPhone) ? "Telefon" : "Notebook";
            System.out.format("%-5d %-20s %-20s %-10s\n", product.getId(), product.getName(), product.getBrand().getName(), category);
        }
    }

    public void displayMenu() {
        System.out.println("===== PatikaStore Menü =====");
        System.out.println("1. Ürünleri Listele");
        System.out.println("2. Ürün Ekle");
        System.out.println("3. Ürün Sil");
        System.out.println("0. Exit");
        System.out.println("============================");
    }

    public static void main(String[] args) {
        PatikaStore store = new PatikaStore();

        // Test scenarios
        Brand samsung = store.brands.get(0);
        Brand apple = store.brands.get(2);

        CellPhone phone1 = new CellPhone(1, 1000.0, 0.1, 10, "Phone 1", samsung,
                "128 GB", "6.1 inch", 4000, 6, "Black");
        CellPhone phone2 = new CellPhone(2, 1500.0, 0.2, 5, "Phone 2", samsung,
                "64 GB", "6.1 inch", 4000, 6, "Red");
        Notebook notebook1 = new Notebook(3, 2000.0, 0.15, 8, "Notebook 1", apple,
                8, "512 SSD", "14 inch");

        store.addProduct(phone1);
        store.addProduct(phone2);
        store.addProduct(notebook1);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            store.displayMenu();
            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.listProducts();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Ürün detayları:");

                    System.out.print("Ürün ID: ");
                    int productId = scanner.nextInt();

                    System.out.print("Ürün adı: ");
                    String productName = scanner.next();

                    System.out.print("Marka ID: ");
                    int brandId = scanner.nextInt();
                    Brand selectedBrand = null;
                    for (Brand brand : store.brands) {
                        if (brand.getId() == brandId) {
                            selectedBrand = brand;
                            break;
                        }
                    }

                    if (selectedBrand == null) {
                        System.out.println("Hatalı Marka ID");
                        break;
                    }

                    System.out.print("Fiyat:");
                    double unitPrice = scanner.nextDouble();

                    System.out.print("İndirim Oranı:");
                    double discountRate = scanner.nextDouble();

                    System.out.print("Stok:");
                    int stock = scanner.nextInt();

                    System.out.print("Kategori (1: Telefon, 2: Notebook): ");
                    int categoryChoice = scanner.nextInt();

                    Product product;
                    if (categoryChoice == 1) {
                        System.out.print("Hafıza: ");
                        String memory = scanner.next();

                        System.out.print("Ekran Boyutu: ");
                        String screenSize = scanner.next();

                        System.out.print("Batarya: ");
                        int batteryPower = scanner.nextInt();

                        System.out.print("RAM: ");
                        int ram = scanner.nextInt();

                        System.out.print("Renk: ");
                        String color = scanner.next();

                        product = new CellPhone(productId, unitPrice, discountRate, stock, productName, selectedBrand,
                                memory, screenSize, batteryPower, ram, color);
                    } else if (categoryChoice == 2) {
                        System.out.print("RAM: ");
                        int ram = scanner.nextInt();

                        System.out.print("Hafıza: ");
                        String storage = scanner.next();

                        System.out.print("Ekran Boyutu: ");
                        String screenSize = scanner.next();

                        product = new Notebook(productId, unitPrice, discountRate, stock, productName, selectedBrand,
                                ram, storage, screenSize);
                    } else {
                        System.out.println("Hatalı kategori seçimi ürün ekleme başarısız.");
                        break;
                    }

                    store.addProduct(product);
                    System.out.println("Ürün başarıyla eklendi.");
                    break;
                case 3:
                    System.out.print("Silinecek ürün ID:");
                    int productIdToRemove = scanner.nextInt();
                    store.removeProduct(productIdToRemove);
                    System.out.println("Ürün başarıyla silindi.");
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor.");
                    break;
                default:
                    System.out.println("Hatalı seçim tekrar deneyiniz.");
            }

            System.out.println();
        } while (choice != 0);
    }
}
