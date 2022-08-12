public class Program {

    public static int digitsSum(int number) {
        if (number < 0) {
            number *= (-1);
        }
        if (number == 0) {
            return 0;
        }
        return (number % 10 + digitsSum(number / 10));
    }


    public static void main(String[] args){
        
        System.out.println(digitsSum(-1010));
    }
}