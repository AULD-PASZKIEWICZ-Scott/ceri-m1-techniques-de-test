package fr.univavignon.pokedex.api;

public class PokedexFactoryImplementation implements IPokedexFactory {

    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {

        PokedexImplementation pokedex = new PokedexImplementation(metadataProvider, pokemonFactory);

        return pokedex;
    }
}