package com.jy.designpattern.demo.singletonpattern;

/**
 * 欧几里德算法
 */
public class EuclideanAlgorithm {

    private static final String datasource = "123456";

    public static void main(String[] rgstring) throws Exception {
        long result = gcd(2753,-15);
        System.out.println(result);
//        System.out.println(2%5);
        Result r = new Result();
        exgcd(17, 3120, r);
        System.out.println(r);
    }

    /**
     * 欧几里德算法实现
     * */
    public static int gcd(int a,int b){
        if(b==0) {
            return a;
        }
        return gcd(b,a%b);
    }


    /**
     * 欧几里德算法扩展实现
     * */
    public static int exgcd(int a,int b,Result result){
        if(b==0)
        {
            result.x=1;
            result.y=0;
            return a;
        }
        int r=exgcd(b,a%b,result);
        int t=result.x;
        result.x=result.y;
        result.y=t-a/b*result.y;
        return r;
    }

    static class Result {
        public int x;
        public int y;

        @Override
        public String toString() {
            return "Result{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
