package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProviderImplementation implements IPokemonMetadataProvider {

    private List<PokemonMetadata> metadataList;

    public PokemonMetadataProviderImplementation() {
        PokemonMetadata bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata aquali = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        metadataList = new ArrayList<>(151);
        for (int i = 0; i < 151; i++) {
            metadataList.add(null);
        }
        metadataList.set(0, bulbizarre);
        metadataList.set(133, aquali);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(final int index) throws PokedexException {
        if (index < 0 || index > 150) {
            throw new PokedexException("Index invalide : " + index);
        }
        return metadataList.stream().filter(metadata -> metadata != null).findFirst()
                .orElseThrow(() -> new PokedexException("Pas de metadata pour cet index : " + index));
    }

}