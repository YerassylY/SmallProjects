package Utils;

import java.math.BigDecimal;

public class NumberToTextConverter {

    public static void main(String argv[]) {
        Long number = 2323153309121L;
        String s = convertToKaz(BigDecimal.valueOf(number));

        Long n = 7455881921L;
        System.out.println(convertToRus(n));

        Long eng = 87L;
        System.out.println(convertToEnglish(eng));
    }

    private static final String[] kazOnes = {
            "",
            "бір",
            "екі",
            "үш",
            "төрт",
            "бес",
            "алты",
            "жеті",
            "сеҒіз",
            "тоғыз"
    };

    private static final String[] kazTenth = {
            "",
            "он",
            "жиырма",
            "отыз",
            "қырық",
            "елу",
            "алпыс",
            "жетпіс",
            "сексен",
            "тоқсан"
    };

    private static final String[] rusOnes = {
            "",
            "один",
            "два",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять",
            "десять",
            "одиннадцать",
            "двенадцать",
            "тринадцать",
            "четырнадцать",
            "пятнадцать",
            "шестнадцать",
            "семнадцать",
            "восемнадцать",
            "девятнадцать"
    };

    private static final String[] rusTenth = {
            "",
            "",
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"
    };

    private static String[] rusHundreds = {
            "",
            "сто",
            "двести",
            "триста",
            "четыреста",
            "пятьсот",
            "шестьсот",
            "семьсот",
            "восемьсот",
            "девятьсот"
    };

    private static final String[] engslihOnes = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };

    private static final String[] englishTenth = {
            "",        //0
            "",        //1
            "twenty",  //2
            "thirty",  //3
            "forty",   //4
            "fifty",   //5
            "sixty",   //6
            "seventy", //7
            "eighty",  //8
            "ninety",  //9
    };

    public static String convertToKaz(BigDecimal number) {

        long value = number.longValue();

        String result = "";
        char[] num = number.toString().toCharArray();

        int n = num.length;
        while (n > 0) {
            switch (n) {
                case 1:
                    result += kazOnes[(int) value];
                    n--;
                    break;
                case 2:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= (int) Math.pow(10, n - 1);
                    n--;
                    break;
                case 3:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= (int) Math.pow(10, n - 1);
                    n--;
                    break;
                case 4:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " мың ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 5:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 6:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 7:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " миллион ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 8:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 9:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 10:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " миллиард ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 11:
                    result += kazTenth[(int) (value / Math.pow(10, n - 1))] + " ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
                case 12:
                    result += kazOnes[(int) (value / Math.pow(10, n - 1))] + " жүз ";
                    value %= Math.pow(10, n - 1);
                    n--;
                    break;
            }
        }
        return result;
    }

    public static String convertToRus(long number) {

        if (number < 20) {
            return rusOnes[(int) number];
        }

        if (number < 100) {
            return rusTenth[(int) (number / 10)] + " " + convertToRus(number % 10);
        }

        if (number < 1000) {
            return rusHundreds[(int) (number / 100)] + " " + convertToRus(number % 100);
        }

        if (number < 10000) {
            return rusOnes[(int) (number / 1000)] + " тысяча " + convertToRus(number % 1000);
        }

        if (number < 100000) {
            return rusTenth[(int) (number / 10000)] + " " + convertToRus(number % 10000);
        }

        if (number < 1000000) {
            return rusHundreds[(int) (number / 100000)] + " " + convertToRus(number % 100000);
        }

        if (number < 1000000000) {
            return convertToRus(number / 1000000) + " миллионов " + convertToRus(number % 1000000);
        }

        return convertToRus(number / 1000000000) + " миллиардов " + convertToRus(number % 1000000000);
    }

    public static String convertToEnglish(long number) {
        String result = "";

        if (number < 20) {
            return result += engslihOnes[((int) number)];
        } else if (number < 100) {
            return result += englishTenth[((int) number)] + convertToEnglish(number % 10);
        } else return result;
    }
}
