package fr.univavignon.pokedex.api;

public class PokemonFactoryImplementation implements IPokemonFactory{

    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) {
        int iv = 1;
        PokemonMetadata pokemonMetadata = null;
        try {
            PokemonMetadataProviderImplementation metadataProvider = new PokemonMetadataProviderImplementation();
            pokemonMetadata = metadataProvider.getPokemonMetadata(index);
        } catch (PokedexException e) {
            System.err.println("Error in retrieving Pokemon metadata!");
            return null;
        }
        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, iv);
    }
}
