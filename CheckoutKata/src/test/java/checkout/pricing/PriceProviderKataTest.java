package checkout.pricing;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PriceProviderKataTest {

    private PriceProviderKata subject;

    @Before
    public void setup() {
        subject = new PriceProviderKata();
    }

    @Test
    public void getPriceForAShouldReturn5000() {
        // When
        long result = subject.getPrice("A");

        // Then
        assertThat(result, is(5000l));
    }

    @Test
    public void getPriceForBShouldReturn3000() {
        // When
        long result = subject.getPrice("B");

        // Then
        assertThat(result, is(3000l));
    }

    @Test
    public void getPriceForAShouldReturn2000() {
        // When
        long result = subject.getPrice("C");

        // Then
        assertThat(result, is(2000l));
    }

    @Test
    public void getPriceForAShouldReturn1500() {
        // When
        long result = subject.getPrice("D");

        // Then
        assertThat(result, is(1500l));
    }
}
