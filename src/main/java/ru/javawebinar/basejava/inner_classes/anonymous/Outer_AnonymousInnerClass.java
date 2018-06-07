package ru.javawebinar.basejava.inner_classes.anonymous;

import java.util.HashMap;
import java.util.Map;

/**
 *    *** Anonymous Inner classes (анонимные классы) ***
 *
 * Анонимные внутренние классы объявляются без указания имени класса.
 * Они могут быть созданы двумя путями:
 *  - как наследник определённого класса;
 *  - как реализация определённого интерфейса.
 *
 * Класс Demo является суперклассом, от которого наследуется анонимный класс, и оба они имеют метод show().
 * В анонимном классе метод show() будет переопределён.
 */
public class Outer_AnonymousInnerClass {
    int a;

    // Анонимный класс наследуется от класса Demo
//    private static Demo demo = new Demo();
    private Demo demo = new Demo() {
        @Override
        public void show() {
            super.show();
            a = 10;
            System.out.println("Метод внутреннего анонимного класса, который наследуется от класса Demo");
            System.out.println("a = " + a);
        }
    };

    // Анонимный класс, который реализует интерфейс Hello
    static Hello h = new Hello() {
        public void show() {
            System.out.println("Метод внутреннего анонимного класса, который реализует интерфейс Hello");
        }
    };

    Map<String, String> map = new HashMap<String, String>() {{
        put("паук", "арахнид");
        put("птица", "архозавр");
        put("кит", "зверь");
    }};

    public static void main(String[] args) {
//        demo.show();
        h.show();
        Outer_AnonymousInnerClass outer_anonymousInnerClass = new Outer_AnonymousInnerClass();
        outer_anonymousInnerClass.demo.show();

        System.out.println("\nВопреки ограничению синтаксиса Java, используя блок инициализации, мы можем элегантно инициализировать коллекцию");
        System.out.println(outer_anonymousInnerClass.map.toString());
    }
}

class Demo {
    public void show() {
        System.out.println("Метод суперкласса");
    }
}

interface Hello {
    void show();
}