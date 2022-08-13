import org.junit.Test;
import praktikum.IngredientType;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeEnumContainsAllIngredient() {
        assertThat(IngredientType.values()).containsExactly(IngredientType.SAUCE, IngredientType.FILLING);
    }
}

