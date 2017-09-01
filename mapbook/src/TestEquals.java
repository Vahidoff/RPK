import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * TestEquals.
 * checking the rules for override the method equals
 */

public class TestEquals {
    /**
     * следующие правила для переопределения этих методов:
     *
     * 1) Рефлексивность: Объект должен равняться себе самому. Для любой ссылки на значение а
     * выражение а.equals(а) должно возвращать true.
     * 2) Симметричность: если a.equals(b) возвращает true, то b.equals(a) должен тоже вернуть true.
     * 3) Транзитивность: если a.equals(b) возвращает true и b.equals(с) тоже возвращает true,
     * то а.equals(с) тоже должен возвращать true.
     * 4) Согласованность (Непротиворечивость): повторный вызов метода equals() должен возвращать одно и тоже
     * значение до тех пор, пока какое-либо значение свойств объекта не будет изменено. То есть, если два
     * объекта равны (неравны) в Java, то они будут равны (неравны) пока их свойства остаются неизменными.
     * 5) Сравнение null: объект должны быть проверен на null. Если объект равен null, то метод должен вернуть
     * false, а не NullPointerException. Например, a.equals(null) должен вернуть false.
     *
     */
    @Test
    /**
     * Test 1.
     * Рефлексивность.
     */
    public void whenEqualsSameObjectShouldTrue() {
        Calendar birthday = new GregorianCalendar(2005, 11, 5);
        UserMap first = new UserMap("Iskandar", 3, birthday);
        UserMap second = first;


        assertThat(first.equals(second), is(true));
        assertThat(first.equals(first), is(true));
    }
    /**
     * Test 2.
     * Симметричность.
     */
    @Test
    public void whenEqualsMirrorShouldTrue() {
        Calendar birthday = new GregorianCalendar(2005, 11, 5);
        UserMap first = new UserMap("Iskandar", 3, birthday);
        UserMap second = new UserMap("Iskandar", 3, birthday);

        assertThat(first.equals(second), is(true));
        assertThat(second.equals(first), is(true));
    }
    /**
     * Test 3.
     * Транзитивность.
     */
    @Test
    public void whenEqualsTransitivityShouldTrue() {
        Calendar birthday = new GregorianCalendar(2005, 11, 5);
        UserMap first = new UserMap("Iskandar", 3, birthday);
        UserMap second = new UserMap("Iskandar", 3, birthday);
        UserMap third = new UserMap("Iskandar", 3, birthday);

        assertThat(first.equals(second), is(true));
        assertThat(second.equals(third), is(true));
        assertThat(first.equals(third), is(true));
    }
    /**
     * Test 4.
     * Согласованность.
     */
    @Test
    public void whenEqualsCoherenceShouldTrue() {
        Calendar birthday = new GregorianCalendar(2005, 11, 5);
        Calendar birthday1= new GregorianCalendar(2007, 8, 30);
        UserMap first = new UserMap("Iskandar", 3, birthday);
        UserMap second = new UserMap("Iskandar", 3, birthday);

        assertThat(first.equals(second), is(true));
        first.setBirthday(birthday1);

        assertThat(first.equals(second), is(false));
    }
    /**
     * Test 4.
     * Сравнение null.
     */
    @Test
    public void whenEqualsNullShouldFalse() {
        Calendar birthday = new GregorianCalendar(2005, 11, 5);
        UserMap first = new UserMap("Iskandar", 3, birthday);
        UserMap second = null;

        assertThat(first.equals(second), is(false));
    }
}
