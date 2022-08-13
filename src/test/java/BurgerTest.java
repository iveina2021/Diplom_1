import org.assertj.core.data.Index;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.assertj.core.api.Assertions.assertThat;

public class BurgerTest {

    @Test
    public void burgerSetBuns() {
        Burger burger = new Burger();
        Bun bun = new Bun("Краторная булка N-200i", 1255);

        burger.setBuns(bun);

        assertThat(burger.bun).isEqualTo(bun);
    }

    @Test
    public void burgerAddIngredient() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Ingredient secondsIngredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);

        Burger burger = createBurger(bun, firstIngredient, secondsIngredient);

        assertThat(burger.ingredients).containsExactly(firstIngredient, secondsIngredient);
    }

    @Test
    public void burgerRemoveIngredient() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Ingredient secondsIngredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);

        Burger burger = createBurger(bun, firstIngredient, secondsIngredient);

        burger.removeIngredient(0);

        assertThat(burger.ingredients).doesNotContain(firstIngredient);
    }

    @Test
    public void burgerMoveIngredient() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Ingredient secondsIngredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);

        Burger burger = createBurger(bun, firstIngredient, secondsIngredient);

        burger.moveIngredient(0, 1);

        assertThat(burger.ingredients).contains(firstIngredient, Index.atIndex(1));
    }

    @Test
    public void burgerGetPrice() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Ingredient secondsIngredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);

        Burger burger = createBurger(bun, firstIngredient, secondsIngredient);

        float burgerPrice = burger.getPrice();

        assertThat(burgerPrice).isEqualTo(6742);
    }

    @Test
    public void burgerGetReceipt() {
        Bun bun = new Bun("Краторная булка N-200i", 1255);
        Ingredient firstIngredient = new Ingredient(IngredientType.SAUCE, "Соус Spicy-X", 90);
        Ingredient secondsIngredient = new Ingredient(IngredientType.FILLING, "Сыр с астероидной плесенью", 4142);

        Burger burger = createBurger(bun, firstIngredient, secondsIngredient);

        String burgerReceiptActual = burger.getReceipt();

        assertThat(burgerReceiptActual).isEqualTo("(==== Краторная булка N-200i ====)\n" +
                "= sauce Соус Spicy-X =\n" +
                "= filling Сыр с астероидной плесенью =\n" +
                "(==== Краторная булка N-200i ====)\n" +
                "\n" +
                "Price: 6742.000000\n");
    }


    public Burger createBurger(Bun bun, Ingredient firstIngredient, Ingredient secondIngredient) {
        Burger burger = new Burger();
        burger.setBuns(bun);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        return burger;
    }
}


