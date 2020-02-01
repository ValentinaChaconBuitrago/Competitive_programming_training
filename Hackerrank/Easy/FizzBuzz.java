public static void fizzBuzz(int n) {
        int num = 1;
        while(num <=n){
            if(num%5==0 && num%3==0) System.out.println("FizzBuzz");
            else if(num%3==0)System.out.println("Fizz");
            else if(num%5==0)System.out.println("Buzz");
            else System.out.println(num);
            num++;
        }
}
