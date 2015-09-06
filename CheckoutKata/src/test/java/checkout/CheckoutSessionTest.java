package checkout;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CheckoutSessionTest {

    private CheckoutSession subject;

    @Before
    public void setup() {
        subject = new CheckoutSession();
    }

    @Test
    public void getTotalReturns0() {
        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(0l));
    }

    @Test
    public void getTotalReturns5000() {
        // Given
        subject.scanItem(new Item("A", 5000));

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(5000l));
    }

    @Test
    public void getTotalReturns3000() {
        // Given
        subject.scanItem(new Item("B", 3000));

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(3000l));
    }

    @Test
    public void getTotalReturns2000() {
        // Given
        subject.scanItem(new Item("C", 2000));

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(2000l));
    }

    @Test
    public void getTotalReturns1500() {
        // Given
        subject.scanItem(new Item("D", 1500));

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(1500l));
    }

    @Test
    public void getTotalReturns11500() {
        // Given
        subject.scanItem(new Item("A", 5000));
        subject.scanItem(new Item("B", 3000));
        subject.scanItem(new Item("C", 2000));
        subject.scanItem(new Item("D", 1500));

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(11500l));
    }

}
