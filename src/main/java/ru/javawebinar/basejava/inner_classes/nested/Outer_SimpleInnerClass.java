package ru.javawebinar.basejava.inner_classes.nested;

/**
 *  *** Nested Inner classes (вложенные внутренние классы) ***
 *
 * Вложенный внутренний класс может получить доступ к любому приватному полю или методу экземпляра внешнего класса.
 * Вложенный внутренний класс может иметь любой модификатор доступа (private, package—private, protected, public).
 * Так же как и классы, интерфейсы могут быть вложенными и иметь модификаторы доступа.
 *
 * !!! При этом, вложенный внутренний класс не может содержать в себе статических методов или статических полей.
 * Это связано с тем что, внутренний класс неявно связан с объектом своего внешнего класса,
 * поэтому он не может объявлять никаких статических методов внутри себя.
 *
 * Интерфейсы могут так же быть вложенными, и они имеют некоторые интересные особенности.
 */
public class Outer_SimpleInnerClass {
    private int a;

    // Простой вложенный класс
    class Inner {

//         static int inner_b; //ERROR COMPILATION!!!

        public void show() {
            a = 10;
            System.out.println("Метод внутреннего класса. a = " + a);
        }
    }

    public static void main(String[] args) {
        Outer_SimpleInnerClass.Inner inner = new Outer_SimpleInnerClass().new Inner();
        inner.show();
    }
}