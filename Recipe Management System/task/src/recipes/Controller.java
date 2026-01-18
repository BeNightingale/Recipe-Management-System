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

    @PostMapping(value = "/recipe", consumes =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addRecipe(@RequestBody String recipe) {
        recipeService.updateRecipe(recipe);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/recipe", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recipe> getRecipe() {
        final List<Recipe> recipes = recipeService.getRecipes();
        return ResponseEntity.ok(recipes.getFirst());
    }
}