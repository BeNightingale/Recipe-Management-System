package recipes;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Controller {

    private RecipeService recipeService;

    @PostMapping(value = "/recipe/new", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecipeService.Identifier> addRecipe(@RequestBody String recipe) {
        final RecipeService.Identifier obj = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/recipe/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> getRecipe(@PathVariable Integer id) {
        final List<Recipe> recipes = recipeService.getRecipes(id);
        if (recipes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes.getFirst());
    }
}