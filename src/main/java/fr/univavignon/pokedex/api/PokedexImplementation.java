package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PokedexImplementation implements IPokedex {

    private List<Pokemon> pokemonList = new ArrayList<>();
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    public PokedexImplementation(final IPokemonMetadataProvider metadataProvider,
                                 final IPokemonFactory pokemonFactory) {
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

    public int addPokemon(final Pokemon pokemon) {
        if (pokemon != null) {
            int currentSize = pokemonList.size();
            boolean isAdded = pokemonList.add(pokemon);

            int newIndex;
            if (isAdded) {
                newIndex = currentSize - 1;
            } else {
                newIndex = -1;
            }
            return newIndex;
        } else {
            return -1;
        }
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
        throw new PokedexException("you use invalid id pokemon");
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