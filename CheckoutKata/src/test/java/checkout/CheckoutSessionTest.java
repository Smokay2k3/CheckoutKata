package checkout;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import checkout.discounts.DiscountProviderKata;
import checkout.pricing.PriceProviderKata;

public class CheckoutSessionTest {

    private CheckoutSession subject;

    @Before
    public void setup() {
        subject = new CheckoutSession(new DiscountProviderKata(), new PriceProviderKata());
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
        subject.scanItem("A");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(5000l));
    }

    @Test
    public void getTotalReturns3000() {
        // Given
        subject.scanItem("B");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(3000l));
    }

    @Test
    public void getTotalReturns2000() {
        // Given
        subject.scanItem("C");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(2000l));
    }

    @Test
    public void getTotalReturns1500() {
        // Given
        subject.scanItem("D");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(1500l));
    }

    @Test
    public void getTotalReturns11500() {
        // Given
        subject.scanItem("A");
        subject.scanItem("B");
        subject.scanItem("C");
        subject.scanItem("D");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(11500l));
    }

    @Test
    public void getTotalReturns13000() {
        // Given
        subject.scanItem("A");
        subject.scanItem("A");
        subject.scanItem("A");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(13000l));
    }

    @Test
    public void getTotalReturns4500() {
        // Given
        subject.scanItem("B");
        subject.scanItem("B");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(4500l));
    }

    @Test
    public void getTotalReturns9500() {
        // Given
        subject.scanItem("B");
        subject.scanItem("A");
        subject.scanItem("B");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(9500l));
    }

    @Test
    public void getTotalReturns19000() {
        // Given
        subject.scanItem("A");
        subject.scanItem("B");
        subject.scanItem("A");
        subject.scanItem("B");
        subject.scanItem("D");
        subject.scanItem("A");

        // When
        long result = subject.getTotal();

        // Then
        assertThat(result, is(19000l));
    }

}
