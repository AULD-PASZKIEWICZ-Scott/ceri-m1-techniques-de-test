package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokedexImplementation implements IPokedex {

    private List<Pokemon> pokemonList = new ArrayList<>();
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    public PokedexImplementation(final IPokemonMetadataProvider metadataProvider, final IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemonList.size();
    }

    @Override
    public Pokemon createPokemon(final int index, final int cp, final int hp, final int dust, final int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public int addPokemon(final Pokemon pokemon) {
        return pokemon != null ? pokemonList.size() + (pokemonList.add(pokemon) ? 1 : 0) - 1 : -1;
    }

    @Override
    public List<Pokemon> getPokemons(final Comparator<Pokemon> comparator) {
        return pokemonList.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public Pokemon getPokemon(final int id) throws PokedexException {
        return id >= 0 && id < pokemonList.size() ? pokemonList.get(id) : throwInvalidPokemonIdException();
    }

    private Pokemon throwInvalidPokemonIdException() throws PokedexException {
        throw new PokedexException("Invalid pokemon ID!");
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemonList);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

}
