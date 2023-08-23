package com.immersion.riot.spectator.app;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.spectator.infra.SpectatorClient;

import java.util.List;

public class SpectatorQueryService {
    private final SpectatorClient spectatorClient;

    public SpectatorQueryService(SpectatorClient spectatorClient) {
        this.spectatorClient = spectatorClient;
    }

    public SpectatorQueryResponse getSpectator(String encryptedSummonerId) throws NoDataException {
        // Call the Feign client to get the response from Riot's Spectator API
        // The response type is List<String> according to the SpectorClient interface you provided
        List<String> response = spectatorClient.getSpectator(encryptedSummonerId);

        // Check if the response is empty or null
        if (response == null || response.isEmpty()) {
            throw new NoDataException();
        }

        // You can process the response here if needed, and convert it into the appropriate format

        // Create a SpectorQueryResponse object and populate it with the processed data
        SpectatorQueryResponse spectatorQueryResponse = new SpectatorQueryResponse();
        // Populate spectorQueryResponse with data from the response

        return spectatorQueryResponse;
    }
}
