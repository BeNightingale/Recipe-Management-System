package recipes;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.expression.spel.ast.Identifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class RecipeService {

    private static final Map<Integer, Recipe> recipeMap = new HashMap<>();
    private static final Random random = new Random();

    Identifier addRecipe(String recipe) {
        final Gson gson = new Gson();
        int id = random.nextInt(100000);
        while (recipeMap.containsKey(id)) {
            id = random.nextInt(100000);
        }
        Recipe recipeToProcess = gson.fromJson(recipe, Recipe.class);
        recipeMap.put(id, recipeToProcess);
        return new Identifier(id);
    }

    List<Recipe> getRecipes(Integer id) {
        Recipe recipe = recipeMap.get(id);
        if (recipe == null) {
            return Collections.emptyList();
        }
        return List.of(recipe);
    }

    @AllArgsConstructor
    @Getter
    public static class Identifier {
        long id;
    }
}
