import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import javafx.scene.paint.Stop;

/**
 * @author by wuYang
 * @date 2019/1/22
 * @describe
 */

class Lambda {
    public static void main(String[] args) {
        //实质代码:      test t1 = (string) -> new Person().goWalking(string);
        //实质代码:     System.out.println(t1.run("对象"));
        Person person = new Person();
        test t2 = person::goWalking;

        System.out.println(t2.run("对象"));

        /**
         * 条件：
         * 1，goWalking的参数必须与函数式接口的参数一致，因为函数式接口的参数还需要传入goWalking函数中
         * 2，goWalking的返回值必须与函数式接口的返回值一致，因为goWalking的返回值还要返回给函数式接口的实现
         *
         * 记住：Lambda的方法引用是为了创建一个接口的子类对象
         *
         *
         *
         */
//        Person person = new Person();
//        test t2 = new test() {
//            @Override
//            public String run(String string) {
//                return person.goWalking(string);
//            }
//        };
//        System.out.println(t2.run("对象"));

        test1 t1 = x -> System.out.println("");

        test t = (x) -> new Person().goWalking(x);

//        test t = (x) -> { return new Person().goWalking(x);};


        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> list =  new ArrayList<>();
        list.add("dasf");
        list.add("fads");

// 以前的循环方式
        for (String ele : list) {
            System.out.print(ele + "; ");
        }

// 使用 lambda 表达式以及函数操作(functional operation)
        list.forEach((player) -> System.out.print(player + "; "));

// 在 Java 8 中使用双冒号操作符(double colon operator)
        list.forEach(x -> System.out.println(x));

        list.forEach(System.out::println);

        list.forEach(new Consumer<String>() {//参数列表一致，接口中的抽象方法没有返回值，则引用的方法可以有返回值也可以没有
            @Override
            public void accept(String string) {
                person.goWalking(string);
            }
        });

    }

    private String getH(String s) {
        return s;
    }

    @FunctionalInterface //该接口中只能定义一个方法
    interface test {
        public String run(String string);
    }


   static class Person {
        public String goWalking(String string) {
            return "";
        }
    }

    @FunctionalInterface
    interface test1 {
        public void run(String x);
    }

}
