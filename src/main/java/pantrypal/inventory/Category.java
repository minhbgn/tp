package pantrypal.inventory;

public enum Category {
    DAIRY,
    SPICES,
    VEGETABLES,
    FRUITS,
    MEAT,
    GRAINS,
    CONDIMENTS;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static Category parseCategory(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }

        for (Category category : Category.values()) {
            if (category.name().equalsIgnoreCase(text)) {
                return category;
            }
        }

        throw new IllegalArgumentException("Invalid category: " + text + "\nType categoryList for a list of " +
                "valid categories.");
    }

}
