package pantrypal.general.commands.mealplan;

import pantrypal.general.control.Ui;
import pantrypal.inventory.IngredientInventory;
import pantrypal.mealplan.PlanPresets;
import pantrypal.mealplan.WeeklySchedule;
import pantrypal.recipe.RecipeManager;
import pantrypal.shoppinglist.ShoppingList;

import java.util.Scanner;

public class ViewWeek extends MealPlanCommand {


    public ViewWeek() {
        super("addNewDay <plan index> <day index>",
                "Add New Day To Week");
    }

    @Override
    public void execute(Ui ui, IngredientInventory inventory, ShoppingList list, PlanPresets presets,
                        RecipeManager recipes,WeeklySchedule week, Scanner in) {
        if (validateWeeklySchedule(week, false)) {
            week.showWeek();
        } else {
            System.out.println("There are no days in the week to show");
        }
    }
}
