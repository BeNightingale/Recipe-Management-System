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

    private static Map<Integer, Recipe> recipeMap = new HashMap<>();

    Identifier addRecipe(String recipe) {
        final Gson gson = new Gson();
        Random r = new Random();
        int id = r.nextInt(100000);
        // int id = (int) Math.round(Math.random());
        while (recipeMap.containsKey(id)) {
            // id = (int) Math.round(Math.random());
            id = r.nextInt(100000);
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
    static
    class Identifier {
        long id;
    }
}
