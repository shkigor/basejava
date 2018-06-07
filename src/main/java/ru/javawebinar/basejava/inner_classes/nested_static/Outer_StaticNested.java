package ru.javawebinar.basejava.inner_classes.nested_static;

/**
 *  *** Static Nested classes or Member of outer class (статические вложенные классы) ***
 *
 *  Статические вложенные классы технически не являются внутренними классами. По сути, они представляют собой члены внешнего класса.
 */
public class Outer_StaticNested {
    // Статический внутренний класс
    static class Inner {
        static {
            System.out.println("Блок статической инициализации");
        }

        public void show() {
            System.out.println("Метод внутреннего статического класса");
        }
    }

    public static void main(String[] args) {
        Outer_StaticNested.Inner inner = new Outer_StaticNested.Inner();
        inner.show();
    }
}
