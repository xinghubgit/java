package list;

public class Fibonacci {
    public static void main(String[] args) {
        String first = "1";
        String second ="1";
        int length = 1000;
        long now = System.currentTimeMillis();

        System.out.println(nthValueLengthGreaterThan(first.toCharArray(), second.toCharArray(), length));
        System.out.println("Cost: " + (System.currentTimeMillis() - now) + " ms");
    }

    public static int nthValueLengthGreaterThan(char[] first, char[] second, int n) {
        int count = 0;
        if (first.length == n) {
            return ++count;
        } else {
            count++;
        }
        if (second.length == n) {
            return ++count;
        } else {
            count++;
        }

        while (true) {
            char[] sum = add(first, second);
            first = second;
            second = sum;
            count++;

            if (sum.length >= n) {
                System.out.println("count : " + count + " sum : " + String.valueOf(sum));
                break;
            }
        }
        return count;
    }



    public static char[] add(char[] num1, char[] num2) {
        if (num1.length > num2.length) {
            char[] tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        int maxLength = num2.length;
        char[] result = new char[maxLength];
        int i = 0, sum = 0, nextValue = 0, radix = 0;

        while (i < num2.length) {
            if (i < num1.length) {
                sum = num1[i] - '0' + num2[i] - '0' + radix;
            } else {
                sum = num2[i] + radix - '0';
            }
            radix = sum / 10;
            nextValue = sum % 10;
            result[i] = (char)(nextValue + '0');
            i++;
        }

        if (radix > 0) {
            char[] bigger = new char[maxLength + 1];
            System.arraycopy(result, 0 , bigger, 0, maxLength);
            bigger[maxLength] = (char) (1 + '0');
            return bigger;
        }
        return result;
    }
}
