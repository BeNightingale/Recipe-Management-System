package recipes;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService {

    private static Recipe oldRecipe = new Recipe(
            "Fresh Mint Tea",
            "Light, aromatic and refreshing beverage, ...",
            "boiled water, honey, fresh mint leaves",
            "1) Boil water. 2) Pour boiling hot water into a mug. 3) Add fresh mint leaves. 4) Mix and let the mint leaves seep for 3-5 minutes. 5) Add honey and mix again."
    );

    void updateRecipe(String recipe) {
        final Gson gson = new Gson();
        oldRecipe = gson.fromJson(recipe, Recipe.class);
    }

    List<Recipe> getRecipes() {
        return List.of(oldRecipe);
    }
}
