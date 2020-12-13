package other;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

/**
 *
 */
public class Question10 {
    @Test
    public void test() {
        Set<Number> set = new TreeSet<>();
        set.add(1);
        set.add(1L);
        set.add(1.0);
        System.out.println(set.size());
    }
    /*
    Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.Long
	at java.lang.Long.compareTo(Long.java:50)
	at java.util.TreeMap.put(TreeMap.java:560)
	at java.util.TreeSet.add(TreeSet.java:255)
	at other.Question10.test(Question10.java:17)
	at other.Question10.main(Question10.java:11)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
    */
    @Test
    public void test2() {
        Set<Number> set = new TreeSet<>(new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2) {
                return new Long((n1.longValue())).compareTo(n2.longValue());
            }
        });
        set.add(1);
        set.add(1L);
        set.add(1.0);
        System.out.println(set.size());
    }
}
