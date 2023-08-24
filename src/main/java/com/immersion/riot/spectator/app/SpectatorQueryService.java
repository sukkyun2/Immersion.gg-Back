package com.immersion.riot.spectator.app;

import com.immersion.riot.common.app.NoDataException;
import com.immersion.riot.spectator.infra.SpectatorClient;
import com.immersion.riot.spectator.infra.SpectatorQueryResponse;
import org.springframework.stereotype.Service;

@Service
public class SpectatorQueryService {
    private final SpectatorClient spectatorClient;

    public SpectatorQueryService(SpectatorClient spectatorClient) {
        this.spectatorClient = spectatorClient;
    }

    public SpectatorDTO getSpectator(String encryptedSummonerId) throws NoDataException {
        SpectatorQueryResponse response = spectatorClient.getSpectator(encryptedSummonerId);

        if (response == null) {
            throw new NoDataException();
        }

        SpectatorDTO spectatorDTO = new SpectatorDTO();
        spectatorDTO.setGameId(response.getGameId());
        spectatorDTO.setMapId(response.getMapId());
        spectatorDTO.setGameMode(response.getGameMode());
        spectatorDTO.setGameType(response.getGameType());
        spectatorDTO.setGameQueueConfigId(response.getGameQueueConfigId());
        for (SpectatorDTO.CurrentGameParticipant participants: spectatorDTO.getParticipants()
             ) {
            spectatorDTO.setParticipants(response.getParticipants());
        }

        spectatorDTO.setPlatformId(response.getPlatformId());
        spectatorDTO.setGameStartTime(response.getGameStartTime());
        spectatorDTO.setGameLength(response.getGameLength());


        return spectatorDTO;
    }
}
