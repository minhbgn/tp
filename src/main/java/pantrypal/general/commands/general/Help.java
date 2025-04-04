package pantrypal.general.commands.general;

import pantrypal.general.commands.Command;
import pantrypal.general.commands.inventory.AddIngredient;
import pantrypal.general.commands.inventory.ConvertIngredient;
import pantrypal.general.commands.inventory.IncreaseQuantity;
import pantrypal.general.commands.inventory.DecreaseQuantity;
import pantrypal.general.commands.inventory.SetAlert;
import pantrypal.general.commands.inventory.CheckStock;
import pantrypal.general.commands.inventory.ViewIngredientsByCategory;
import pantrypal.general.commands.inventory.ViewLowStock;
import pantrypal.general.commands.mealplan.AddNewDay;
import pantrypal.general.commands.mealplan.RemoveDay;
import pantrypal.general.commands.mealplan.ViewDay;
import pantrypal.general.commands.mealplan.AddNewPlan;
import pantrypal.general.commands.mealplan.RemovePlan;
import pantrypal.general.commands.mealplan.ExecuteDay;
import pantrypal.general.commands.mealplan.ViewPresets;
import pantrypal.general.commands.mealplan.ViewWeek;
import pantrypal.general.commands.mealplan.RemoveRecipeFromPlan;
import pantrypal.general.commands.mealplan.AddRecipeToPlan;
import pantrypal.general.commands.recipe.AddRecipe;
import pantrypal.general.commands.recipe.ListRecipe;
import pantrypal.general.commands.recipe.RemoveRecipe;
import pantrypal.general.commands.recipe.ViewRecipe;
import pantrypal.general.commands.shoppinglist.AddShoppingItem;
import pantrypal.general.commands.shoppinglist.GenerateShoppingList;
import pantrypal.general.commands.shoppinglist.RemoveShoppingItem;
import pantrypal.general.commands.shoppinglist.ViewShoppingList;
import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.PlanPresets;
import pantrypal.mealplan.WeeklySchedule;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Help extends GeneralCommand {
    private static final List<Command> commandList = Arrays.asList(
            new Exit(), new AddIngredient(),
            new IncreaseQuantity(), new DecreaseQuantity(),
            new SetAlert(), new CheckStock(), new ViewLowStock(), new AddShoppingItem(), new ConvertIngredient(),
            new GenerateShoppingList(), new RemoveShoppingItem(), new ViewShoppingList(), new AddRecipe(),
            new ViewIngredientsByCategory(), new ViewRecipe(), new RemoveRecipe(), new ListRecipe(), new AddNewDay(),
            new RemoveDay(), new RemovePlan(), new AddRecipeToPlan(), new RemoveRecipeFromPlan(), new AddNewPlan(),
            new ViewPresets(), new ViewWeek(), new ViewDay(), new ExecuteDay(), new Help(), new UnitList(),
            new CategoryList()
    );

    public Help() {
        super("help","List all commands");
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList list, PlanPresets presets,
                        RecipeManager recipes, WeeklySchedule week, Scanner in) {
        ui.printHelpMessage(commandList.toArray(new Command[0]));
    }
}
