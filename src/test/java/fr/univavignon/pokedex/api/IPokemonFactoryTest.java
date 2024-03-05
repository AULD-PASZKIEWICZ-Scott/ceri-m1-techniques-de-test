package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon expectedPokemon = new Pokemon(
            0,              // Index
            "Bulbasaur",    // Nom
            126,            // Attaque
            126,            // Défense
            90,             // Endurance
            613,            // CP
            64,             // HP
            4000,           // Dust
            4,              // Candy
            0.56            // IV
        );
        
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(expectedPokemon);

        Pokemon actualPokemon = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals("The returned Pokemon should match the expected Pokemon", expectedPokemon, actualPokemon);
    }
}