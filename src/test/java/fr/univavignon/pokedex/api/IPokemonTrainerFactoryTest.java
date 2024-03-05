package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
    }

    @Test
    public void testCreateTrainer() {
        String name = "Sacha";
        Team team = Team.MYSTIC;
        
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        
        when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);

        PokemonTrainer expectedTrainer = new PokemonTrainer(name, team, pokedex);

        when(trainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(expectedTrainer);

        PokemonTrainer actualTrainer = trainerFactory.createTrainer(name, team, pokedexFactory);

        assertNotNull("Le dresseur créé ne devrait pas être null", actualTrainer);
        assertEquals("Le nom du dresseur devrait être 'Sacha'", name, actualTrainer.getName());
        assertEquals("L'équipe du dresseur devrait être 'Team.MYSTIC'", team, actualTrainer.getTeam());
    }
}