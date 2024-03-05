package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata expectedMetadata = new PokemonMetadata(0,null,0,0,0);

        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(expectedMetadata);

        PokemonMetadata actualMetadata = pokemonMetadataProvider.getPokemonMetadata(0);

        assertEquals("Les Metadata retournées doivent correspondre aux Metadata attendues", expectedMetadata, actualMetadata);
    }
}