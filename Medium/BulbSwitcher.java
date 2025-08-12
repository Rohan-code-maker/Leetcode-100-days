package Medium;
public class BulbSwitcher {
    public static int bulbSwitch(int n) {
        int count = 0;
        int i=1;
        while(i*i <= n){ //only perfect sqaure numbers are on at last
            count++;
            i++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(bulbSwitch(15));
    }
}
