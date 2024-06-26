package fr.univavignon.pokedex.api;

public class PokemonTrainerFactoryImplementation implements IPokemonTrainerFactory {

    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;

    public PokemonTrainerFactoryImplementation(final IPokemonMetadataProvider metadataProvider,
                                               final IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public PokemonTrainer createTrainer(final String name, final Team team, final IPokedexFactory pokedexFactory) {

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        PokemonTrainer trainer = new PokemonTrainer(name, team, pokedex);

        return trainer;
    }
}