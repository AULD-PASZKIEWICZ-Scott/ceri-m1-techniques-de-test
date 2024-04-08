package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProviderImplementation implements IPokemonMetadataProvider {

    private List<PokemonMetadata> metadataList;
    private static final int SIZE = 151;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 150;

    private void initializeMetadataList() {
        PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        metadataList = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            metadataList.add(null);
        }
        metadataList.set(0, bulbizarre);
        metadataList.set(133, aquali);
    }

    public PokemonMetadataProviderImplementation() {
        initializeMetadataList();
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        if (index < FIRST_INDEX || index > LAST_INDEX) { throw new PokedexException("Index invalide : " + index); }
        return metadataList.stream().filter(metadata -> metadata != null).findFirst().orElseThrow(() -> new PokedexException("Pas de metadata pour cet index : " + index));
    }


}
