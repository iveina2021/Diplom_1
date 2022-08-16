import org.assertj.core.data.Index;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient firstIngredient;

    @Mock
    private Ingredient secondIngredient;

    @Test
    public void burgerSetBuns() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertThat(burger.bun).isEqualTo(bun);
    }

    @Test
    public void burgerAddIngredient() {
        Burger burger = createBurger();

        assertThat(burger.ingredients).containsExactly(firstIngredient, secondIngredient);
    }

    @Test
    public void burgerRemoveIngredient() {
        Burger burger = createBurger();

        burger.removeIngredient(0);

        assertThat(burger.ingredients).doesNotContain(firstIngredient);
    }

    @Test
    public void burgerMoveIngredient() {
        Burger burger = createBurger();

        burger.moveIngredient(0, 1);

        assertThat(burger.ingredients).contains(firstIngredient, Index.atIndex(1));
    }

    @Test
    public void burgerGetPrice() {
        Burger burger = createBurger();
        Mockito.when(bun.getPrice()).thenReturn(2.5f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(1.5f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(0.5f);

        float burgerPrice = burger.getPrice();

        assertThat(burgerPrice).isEqualTo(7);
    }

    @Test
    public void burgerGetReceipt() {
        Burger burger = createBurger();

        Mockito.when(bun.getName()).thenReturn("Краторная булка N-200i");
        Mockito.when(firstIngredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(secondIngredient.getName()).thenReturn("Сыр с астероидной плесенью");

        Mockito.when(bun.getPrice()).thenReturn(2.5f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(1.5f);
        Mockito.when(secondIngredient.getPrice()).thenReturn(0.5f);

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);

        String burgerReceiptActual = burger.getReceipt();

        assertThat(burgerReceiptActual).isEqualTo("(==== Краторная булка N-200i ====)\n" +
                "= sauce Соус Spicy-X =\n" +
                "= filling Сыр с астероидной плесенью =\n" +
                "(==== Краторная булка N-200i ====)\n" +
                "\n" +
                "Price: 7.000000\n");
    }


    private Burger createBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        return burger;
    }
}


