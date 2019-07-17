package gamestore.service;

import gamestore.domain.dtos.GameAddDto;
import gamestore.domain.entities.Game;

public interface GameService {

    Game getByTitle(String title);

    String addGame(GameAddDto gameAddDto);

}
