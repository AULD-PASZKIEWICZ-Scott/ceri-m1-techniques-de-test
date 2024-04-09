package fr.univavignon.pokedex.api;

public class PokemonFactoryImplementation implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) {
        PokemonMetadata pokemonMetadata = null;
        try {
            pokemonMetadata = new PokemonMetadataProviderImplementation().getPokemonMetadata(index);
        } catch (PokedexException e) {
            return null;
        }

        String name = pokemonMetadata.getName();
        int attack = pokemonMetadata.getAttack();
        int defense = pokemonMetadata.getDefense();
        int stamina = pokemonMetadata.getStamina();

        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, 1);
    }
}