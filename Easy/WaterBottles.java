package Easy;
class WaterBottles {
    public static int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange) {
            return numBottles;
        } else {
            int sum = numBottles;
            while (numBottles >= numExchange) {
                int newBottles = numBottles / numExchange;
                int remainingBottles = numBottles % numExchange;
                sum += newBottles;
                numBottles = newBottles + remainingBottles;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));
    }
}