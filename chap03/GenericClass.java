package chap03;

public class GenericClass {
    static class GenericClazz<T> {
        private T xyz;

        GenericClazz(T t) {
            this.xyz = t;
        }

        T getXyz() {
            return  xyz;
        }

        public static void main(String[] args) {
            GenericClazz<String> s = new GenericClazz<>("ABC");
            GenericClazz<Integer> i = new GenericClazz<>(123);

            System.out.println(s.getXyz());
            System.out.println(i.getXyz());
        }
    }
}

//Generic Summary
/*
1. 'T' is a type parameter.
2. Use 'E' for the collection data type.
3. For Map, 'K' is Key and 'V' is value.

public class GenericClass<T> {}
public interface GenericInterface<T> {}

- Multiple type parameter
public class GenericClass<K, V, ...> {}
public interface GenericInterface<K, V, ...> {}

- Generic method
public <T> Clazz<T> genericMethod(T t) {}

- Generic Inheritance
  public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) { ... }

- Wildcard (Bounded Type Parameter)
public class GenericClass<?> : Unbounded Wildcards

//subtype of T
public class GenericClass<? extends T> : Upper Bounded Wildcards

//supertype of T
public class GenericClass<? super T> : Lower Bounded Wildcards

 */
