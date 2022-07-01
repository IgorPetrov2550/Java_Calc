import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        int length = s.length();
        int result1 = m.get(s.charAt(length - 1));
        for (int i = length - 2; i >= 0; i--) {
            if (m.get(s.charAt(i)) < m.get(s.charAt(i + 1)))
                result1 -= m.get(s.charAt(i));
            else
                result1 += m.get(s.charAt(i));
        }
        return result1;
    }
    public static String intToRoman(int num) {

        String roman[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int integer[] =  {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String result2="";
        int i=0;

        while(num>0 && i<integer.length) {
            if(num>=integer[i]) {
                int n= num/integer[i];
                num= num%integer[i];
                while(n-->0) result2+=roman[i];
            }
            i++;
        }

        return result2;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Vvedite primer ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String number1 ="";
        String sign ="";
        String number2 ="";
        int number1Int = 0;
        int number2Int = 0;
        int d = 0;
        int b = 0;
        int l = 0;

        for(int i=0;i<s.length(); i++){
            d = i;
            if (s.charAt(i)==' '){
                break;
            }
            number1 = number1 + s.charAt(i);
        }

        for(int i = d+1;i<s.length(); i++){
            b = i;
            if (s.charAt(i)==' '){
                break;
            }
            sign = sign + s.charAt(i);
        }

        for(int i = b+1;i<s.length(); i++){
            if (s.charAt(i)==' '){
                throw new IOException();
            }
            number2 = number2 + s.charAt(i);
        }

        if ((number1.charAt(0)=='I' || number1.charAt(0)=='V' || number1.charAt(0)=='X') &
            (number2.charAt(0)=='1' || number2.charAt(0)=='2' || number2.charAt(0)=='3' ||
             number2.charAt(0)=='4' || number2.charAt(0)=='5' || number2.charAt(0)=='6' ||
             number2.charAt(0)=='7' || number2.charAt(0)=='8' || number2.charAt(0)=='9')){
            throw new IOException();
        }

        if ((number2.charAt(0)=='I' || number2.charAt(0)=='V' || number2.charAt(0)=='X') &
            (number1.charAt(0)=='1' || number1.charAt(0)=='2' || number1.charAt(0)=='3' ||
             number1.charAt(0)=='4' || number1.charAt(0)=='5' || number1.charAt(0)=='6' ||
             number1.charAt(0)=='7' || number1.charAt(0)=='8' || number1.charAt(0)=='9')){
            throw new IOException();
        }

        if (number1.charAt(0)=='I' || number1.charAt(0)=='V'){
            number1Int = romanToInt(number1);
            number2Int = romanToInt(number2);
            l = 1;
        }else {
            number1Int = Integer.parseInt(number1);
            number2Int = Integer.parseInt(number2);
        }

        if (number1Int >9 || number1Int <1 || number2Int >9 || number2Int<1) {
            System.out.println("Vvesti mojno tol'ko chisla ot 1 do 10");
            throw new IOException();
        }
        int result = 0;
        switch(sign){
            case "+" :
                result = number1Int + number2Int;
                break;
            case "-" :
                result = number1Int - number2Int;
                break;
            case "/" :
                result = number1Int / number2Int;
                break;
            case "*" :
                result = number1Int * number2Int;
                break;
            default:
                throw new IOException();
        }

        if (l == 1 & result <= 0){
            throw new IOException();
        }

        if (l == 0){
            System.out.println(result);
        }else{
            String result2 = intToRoman(result);
            System.out.println(result2);
        }
    }
}



