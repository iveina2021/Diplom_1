import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTest {

    @Test
    public void ingredientGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Соус традиционный галактический", 15);
        IngredientType actual = ingredient.getType();
        assertThat(actual).isEqualTo(IngredientType.SAUCE);
    }

    @Test
    public void ingredientGetPrice() {
        float price = 4142;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", price);
        float actual = ingredient.getPrice();
        assertThat(actual).isEqualTo(price);
    }

    @Test
    public void ingredientGetName() {
        String name = "Соус традиционный галактический";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, 15);
        String actual = ingredient.getName();
        assertThat(actual).isEqualTo(name);
    }
}