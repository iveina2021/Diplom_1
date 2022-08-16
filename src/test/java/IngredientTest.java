import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType ingredientType;
    public String name;
    public float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][]{
                {IngredientType.SAUCE, "Соус традиционный галактический", 15},
                {IngredientType.FILLING, "Сыр с астероидной плесенью", 4142},
        };
    }

    @Test
    public void ingredientGetType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        IngredientType actual = ingredient.getType();

        assertThat(actual).isEqualTo(ingredientType);
    }

    @Test
    public void ingredientGetPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        float actual = ingredient.getPrice();

        assertThat(actual).isEqualTo(price);
    }

    @Test
    public void ingredientGetName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);

        String actual = ingredient.getName();

        assertThat(actual).isEqualTo(name);
    }
}