package recipes;

import java.util.Arrays;
import java.util.Objects;

public record Recipe(
        String name,
        String description,
        String[] ingredients,
        String[] directions
) {
    @Override
    public String toString() {
        return "Recipe{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", ingredients=" + Arrays.toString(ingredients) +
               ", directions=" + Arrays.toString(directions) +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name) && Objects.equals(description, recipe.description) && Objects.deepEquals(directions, recipe.directions) && Objects.deepEquals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, Arrays.hashCode(ingredients), Arrays.hashCode(directions));
    }
}