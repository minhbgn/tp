package pantrypal.general.commands.mealplan;

import pantrypal.general.commands.Command;
import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.PlanPresets;
import pantrypal.mealplan.WeeklySchedule;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Scanner;

public abstract class MealPlanCommand extends Command {

    public MealPlanCommand(String commandInstruction, String commandDescription) {
        super(commandInstruction, commandDescription);
    }

    public MealPlanCommand() {}

    protected static String getMealName(String mealName) {
        return switch (mealName.toUpperCase()) {
        case "BREAKFAST", "LUNCH", "DINNER" -> mealName;
        default -> "NULL";
        };

        //find way to handle NULL case
    }

    protected static boolean validateRecipeSize(RecipeManager recipeManager, int recipeIndex) {
        return recipeManager.getRecipeList().size() > recipeIndex;
    }

    protected static boolean validatePresetsSize(PlanPresets presets) {
        return !presets.getPlans().isEmpty();
    }

    protected static boolean validateWeeklySchedule(WeeklySchedule week, boolean isAddTask) {
        boolean result = isAddTask;
        for (boolean used : week.getUsedDays()) {
            if (isAddTask) {
                result = used & result;
            } else {
                result = used | result;
            }
        }

        return result == !isAddTask;
    }

    @Override
    public abstract void execute(Ui ui, IngredientInventory inventory, ShoppingList list, PlanPresets presets,
                                 RecipeManager recipes, WeeklySchedule week, Scanner in);


}
