import java.util.Arrays;
import java.util.Comparator;

// Product class with essential attributes for search
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
               ", Name: " + productName +
               ", Category: " + category;
    }
}

public class EcommerceSearch {

    /**
     * Performs linear search on an array of products.
     * Time Complexity: O(n)
     */
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null; // not found
    }

    /**
     * Performs binary search on a sorted array of products.
     * Time Complexity: O(log n)
     */
    public static Product binarySearch(Product[] sortedProducts, String targetName) {
        int left = 0;
        int right = sortedProducts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedProducts[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) {
                return sortedProducts[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // not found
    }

    public static void main(String[] args) {
        // Sample product list
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Book", "Education"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Watch", "Accessories")
        };

        String searchName = "Phone";

        // Linear Search Demo
        System.out.println("🔍 Linear Search Result:");
        Product result1 = linearSearch(products, searchName);
        System.out.println(result1 != null ? result1 : "Product not found");

        // Prepare for Binary Search (sort by product name)
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search Demo
        System.out.println("\n🔍 Binary Search Result:");
        Product result2 = binarySearch(sortedProducts, searchName);
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
