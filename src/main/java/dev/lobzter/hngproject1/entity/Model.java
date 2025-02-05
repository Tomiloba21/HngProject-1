package dev.lobzter.hngproject1.entity;


import java.util.ArrayList;
import java.util.List;

public class Model {
    private int number;
    private boolean is_prime;
    private boolean is_perfect;
    private List<String> properties;
    private int digit_sum;
    private String fun_fact;




    public Model() {
        this.properties = new ArrayList<>();
    }

    public Model(int number) {
        this.number = number;
        this.properties = new ArrayList<>();
        setIs_prime(number);
        setIs_perfect(number);
        setDigit_sum(number);
        setProperties();
    }

    public boolean isIs_perfect() {
        return is_perfect;
    }

    public void setIs_perfect(int number) {
        this.is_perfect = isPerfectNumber(number);
    }
    public  boolean isPerfectNumber(int num) {
        if (num < 2) return false;

        int sum = 1;


        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        setIs_prime(number);
        setIs_perfect(number);
        setDigit_sum(number);
        setProperties();
    }

    public boolean isIs_prime() {
        return is_prime;
    }

    public void setIs_prime(int number) {
        this.is_prime = isPrime(number);
    }


    public List<String> getProperties() {
        return properties;
    }

    public void setProperties() {
        this.properties.clear();  // Prevent duplicate values
        this.properties.add(isEven() ? "EVEN" : "ODD");
        if (checkArmstrong()){
            this.properties.add("Armstrong");
        }
    }

    public int getDigit_sum() {
        return digit_sum;
    }

    public void setDigit_sum(int number) {
        int sum = 0;
        int temp = number;
        while (temp != 0) {
            sum += temp % 10;
            temp /= 10;
        }
        this.digit_sum = sum;
    }

    public String getFun_fact() {
        return fun_fact;
    }

    public void setFun_fact(String fun_fact) {
        this.fun_fact = fun_fact;
    }

    private boolean isEven() {
        return number % 2 == 0;
    }

    private boolean checkArmstrong() {
        int temp = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        return sum == number;
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
