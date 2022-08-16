import org.junit.Test;
import praktikum.Bun;

import static org.assertj.core.api.Assertions.assertThat;

public class BunTest {

    private static final String BUN_NAME = "Краторная булка N-200i";
    private static final float BUN_PRICE = 1255;

    @Test
    public void bunGetName() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        String actual = bun.getName();
        assertThat(actual).isEqualTo(BUN_NAME);
    }

    @Test
    public void bunGetPrice() {
        Bun bun = new Bun(BUN_NAME, BUN_PRICE);
        float actual = bun.getPrice();
        assertThat(actual).isEqualTo(BUN_PRICE);
    }
}
