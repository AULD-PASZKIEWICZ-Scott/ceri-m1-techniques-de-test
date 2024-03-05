package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);
        pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
    }

    @Test
    public void testSize() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);

        when(pokedex.getPokemons()).thenReturn(pokemons);

        int expectedSize = 2;
        int actualSize = pokemons.size();

        assertEquals(expectedSize,actualSize);
    }

    @Test
    public void testAddPokemon() {
        int expectedIndex = 0;
        when(pokedex.addPokemon(pokemon1)).thenReturn(expectedIndex);

        int actualIndex = pokedex.addPokemon(pokemon1);

        assertEquals("L'index du pokemon ajouté devrait être 0", expectedIndex, actualIndex);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        int pokemonId = 0;
        
        when(pokedex.getPokemon(pokemonId)).thenReturn(pokemon1);

        Pokemon retrievedPokemon = pokedex.getPokemon(pokemonId);

        assertNotNull("Le pokemon récupéré ne devrait pas être null", retrievedPokemon);
        assertEquals("Le pokemon récupéré devrait être Bulbasaur", pokemon1.getName(), retrievedPokemon.getName());
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getIndex);

        when(pokedex.getPokemons(comparator)).thenReturn(pokemons);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(comparator);

        assertNotNull("La liste de pokemons triée ne devrait pas être null", sortedPokemons);
        assertEquals("Le premier pokemon devrait être Bulbasaur", pokemon1.getName(), sortedPokemons.get(0).getName());
        assertEquals("Le deuxième pokemon devrait être Aquali", pokemon2.getName(), sortedPokemons.get(1).getName());
    }
}