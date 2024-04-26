package Java_Collecion_Frame_Work;

import java.util.*;

public class ProductManager {
    static ArrayList<Product> arraylistProducts = new ArrayList<>();
    static LinkedList<Product> linkedListProducts = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1/ Quản lí sản phẩm bằng ArrayList ");
        System.out.println("2/ Quản lí sản phẩm bằng LinkedList ");
        System.out.print("Nhập lựa chọn của bạn : ");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose == 1) {
            arraylistProducts.add(new Product(1, "aa", 2));
            arraylistProducts.add(new Product(5, "bb", 3));
            arraylistProducts.add(new Product(3, "cc", 4));
            displayToTheScreenArrayList();
        } else {
            linkedListProducts.add(new Product(1, "aa", 2));
            linkedListProducts.add(new Product(5, "bb", 3));
            linkedListProducts.add(new Product(3, "cc", 4));
            displayToTheScreenLinkedList();
        }


    }

    public static void displayToTheScreenLinkedList() {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("1/ Thêm sản phâm mới");
        System.out.println("2/ Sủa sản phẩm trong danh sách");
        System.out.println("3/ Xoá sản phẩm trong danh sách");
        System.out.println("4/ Hiển thị sản phẩm trong danh sách");
        System.out.println("5/ Tìm kiếm sản phẩm trong danh sách");
        System.out.println("6/ Sắp xếp sản phẩm trong danh sách");
        System.out.println("7/ Thoát");
        int choose;
        do {
            System.out.print("Chọn chức năng muốn thực hiện : ");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 7 || choose <= 0);
        switch (choose) {
            case 1:
                addProductLinkedlist();
                break;
            case 2:
                fixInformationLinkedList();
                break;
            case 3:
                deleteProductLinkedList();
                break;
            case 4:
                displayProductLinkedlist();
                break;
            case 5:
                findProductLinkedList();
                break;
            case 6:
                sortProductsLinkedList();
                break;
            case 7:
                System.exit(0);
                break;
        }
    }

    static void addProductLinkedlist() {
        System.out.print("Nhập mã sản phẩm mới : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm mới : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm mới: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
        String choose = scanner.nextLine();
        if (choose.equals("n") || choose.equals("N")) {
            displayToTheScreenLinkedList();
        } else {
            Product product = new Product(id, name, price);
            linkedListProducts.add(product);
            displayToTheScreenLinkedList();
        }
    }

    static void fixInformationLinkedList() {
        int productNeedToFix = 0;
        boolean check = true;
        do {
            System.out.print("Nhập id sản phẩm muốn sửa : ");
            int fixById = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < linkedListProducts.size(); i++) {
                if (fixById == linkedListProducts.get(i).getId()) {
                    check = false;
                    productNeedToFix = i;
                    break;
                } else {
                    System.out.println("Không tìm thấy sản phẩm .");
                }
            }
        } while (check);
        System.out.print("Nhập mã sản phẩm : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm : ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
        String choose = scanner.nextLine();
        if (choose.equals("n") || choose.equals("N")) {
            displayToTheScreenLinkedList();
        } else {
            linkedListProducts.remove(productNeedToFix);
            Product product = new Product(id, name, price);
            linkedListProducts.add(productNeedToFix, product);
            System.out.println("Sản phẩm sau khi sửa là : " + linkedListProducts.get(productNeedToFix));
            displayToTheScreenLinkedList();
        }
    }

    static void deleteProductLinkedList() {
        boolean check = true;
        do {
            System.out.print("Nhập id sản phẩm muốn xoá : ");
            int deleteById = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < linkedListProducts.size(); i++) {
                if (deleteById == linkedListProducts.get(i).getId()) {
                    check = false;
                    linkedListProducts.remove(i);
                    displayToTheScreenLinkedList();
                    break;
                } else {
                    System.out.println("Không tìm thấy sản phẩm .");
                }
            }
        } while (check);
    }

    static void displayProductLinkedlist() {
        System.out.println(linkedListProducts);
        displayToTheScreenLinkedList();
    }

    static void findProductLinkedList() {
        boolean check = true;
        do {
            System.out.print("Nhập tên sản phẩm muốn tìm : ");
            String findProduct = scanner.nextLine();
            for (Product product : linkedListProducts) {
                if (Objects.equals(findProduct, product.getNameProduct())) {
                    check = false;
                    System.out.println(product);
                    break;
                }
            }
        } while (check);
        displayToTheScreenArrayList();
    }

    static void sortProductsLinkedList() {
        System.out.println("1/ Sắp xếp theo giá trị tăng dần \n2/ Sắp xếp theo giá trị giảm dần");
        int sort = Integer.parseInt(scanner.nextLine());
        if (sort == 1) {
            linkedListProducts.sort((Comparator.comparingInt(Product::getPrice)));
        } else {
            linkedListProducts.sort(((o1, o2) -> o2.getPrice() - o1.getPrice()));
        }
        displayProductLinkedlist();
    }

    public static void displayToTheScreenArrayList() {
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("1/ Thêm sản phâm mới");
        System.out.println("2/ Sủa sản phẩm trong danh sách");
        System.out.println("3/ Xoá sản phẩm trong danh sách");
        System.out.println("4/ Hiển thị sản phẩm trong danh sách");
        System.out.println("5/ Tìm kiếm sản phẩm trong danh sách");
        System.out.println("6/ Sắp xếp sản phẩm trong danh sách");
        System.out.println("7/ Thoát");
        int choose;
        do {
            System.out.print("Chọn chức năng muốn thực hiện : ");
            choose = Integer.parseInt(scanner.nextLine());
        } while (choose > 7 || choose <= 0);
        switch (choose) {
            case 1:
                addProductArrayList();
                break;
            case 2:
                fixInformationArraylist();
                break;
            case 3:
                deleteProductArrayList();
                break;
            case 4:
                displayProductArrayList();
                break;
            case 5:
                findProductArrayList();
                break;
            case 6:
                sortProductsArrayList();
                break;
            case 7:
                System.exit(0);
                break;
        }

    }

    static void addProductArrayList() {
        System.out.print("Nhập mã sản phẩm mới : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm mới : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm mới: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
        String choose = scanner.nextLine();
        if (choose.equals("n") || choose.equals("N")) {
            displayToTheScreenArrayList();
        } else {
            Product product = new Product(id, name, price);
            arraylistProducts.add(product);
            displayToTheScreenArrayList();
        }
    }

    static void fixInformationArraylist() {
        int productNeedToFix = 0;
        boolean check = true;
        do {
            System.out.print("Nhập id sản phẩm muốn sửa : ");
            int fixById = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < arraylistProducts.size(); i++) {
                if (fixById == arraylistProducts.get(i).getId()) {
                    check = false;
                    productNeedToFix = i;
                    break;
                } else {
                    System.out.println("Không tìm thấy sản phẩm .");
                }
            }
        } while (check);
        System.out.print("Nhập mã sản phẩm : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm : ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm : ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Bạn có muốn thêm sản phẩm không ( Y OR N ) : ");
        String choose = scanner.nextLine();
        if (choose.equals("n") || choose.equals("N")) {
            displayToTheScreenArrayList();
        } else {
            arraylistProducts.remove(productNeedToFix);
            Product product = new Product(id, name, price);
            arraylistProducts.add(productNeedToFix, product);
            System.out.println("Sản phẩm sau khi sửa là : " + arraylistProducts.get(productNeedToFix));
            displayToTheScreenArrayList();
        }
    }

    static void deleteProductArrayList() {
        boolean check = true;
        do {
            System.out.print("Nhập id sản phẩm muốn xoá : ");
            int deleteById = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < arraylistProducts.size(); i++) {
                if (deleteById == arraylistProducts.get(i).getId()) {
                    check = false;
                    arraylistProducts.remove(i);
                    displayToTheScreenArrayList();
                    break;
                } else {
                    System.out.println("Không tìm thấy sản phẩm .");
                }
            }
        } while (check);
    }

    static void displayProductArrayList() {
        System.out.println(arraylistProducts);
        displayToTheScreenArrayList();
    }

    static void findProductArrayList() {
        boolean check = true;
        do {
            System.out.print("Nhập tên sản phẩm muốn tìm : ");
            String findProduct = scanner.nextLine();
            for (Product product : arraylistProducts) {
                if (Objects.equals(findProduct, product.getNameProduct())) {
                    check = false;
                    System.out.println(product);
                    break;
                }
            }
        } while (check);
        displayToTheScreenArrayList();
    }

    static void sortProductsArrayList() {
        System.out.println("1/ Sắp xếp theo giá trị tăng dần \n2/ Sắp xếp theo giá trị giảm dần");
        int sort = Integer.parseInt(scanner.nextLine());
        if (sort == 1) {
            arraylistProducts.sort((Comparator.comparingInt(Product::getPrice)));
        } else {
            arraylistProducts.sort(((o1, o2) -> o2.getPrice() - o1.getPrice()));
        }
        displayToTheScreenArrayList();
    }
}
