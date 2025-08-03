public class PowerOfTwo {
    
    public static boolean isPowertwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // For n = 8 (binary: 1000):
    // n - 1 = 7 (binary: 0111).
    // n & (n - 1) = 1000 & 0111 = 0000 = 0.

    // For a non-power of 2, like n = 6 (binary: 110):
    // n - 1 = 5 (binary: 101).
    // n & (n - 1) = 110 & 101 = 100 = 4 ≠ 0.

    public static void main(String[] args) {
        System.out.println(isPowertwo(17));
    }
}
