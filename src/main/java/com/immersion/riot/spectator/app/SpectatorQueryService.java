package com.immersion.riot.spectator.app;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.spectator.infra.SpectatorClient;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpectatorQueryService {
    private final SpectatorClient spectatorClient;

    public SpectatorQueryService(SpectatorClient spectatorClient) {
        this.spectatorClient = spectatorClient;
    }

    public SpectatorQueryResponse getSpectator(String encryptedSummonerId) throws NoDataException {
        SpectatorQueryResponse response = spectatorClient.getSpectator(encryptedSummonerId);

        if (response == null) {
            throw new NoDataException();
        }

        SpectatorQueryResponse spectatorQueryResponse = new SpectatorQueryResponse();


        return response;
    }
}
