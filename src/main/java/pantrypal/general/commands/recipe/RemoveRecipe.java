package pantrypal.general.commands.recipe;

import pantrypal.general.commands.Command;
import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.PlanPresets;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Scanner;

public class RemoveRecipe extends Command {
    private String recipeName;

    public RemoveRecipe() {
        super("removeRecipe <name>", "Removes a recipe");
    }

    public RemoveRecipe(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList shoppingList, PlanPresets planPresets, RecipeManager recipeManager, Scanner in) {
        recipeManager.removeRecipe(recipeName);
        System.out.println(recipeName + " Recipe removed");
    }
}
