package gamestore.service;

import gamestore.domain.dtos.GameAddDto;
import gamestore.domain.entities.Game;
import gamestore.repository.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

@Service
public class GameServiceImpl implements GameService {

    private ModelMapper modelMapper;
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Game getByTitle(String title) {
        return this.gameRepository.findByTitle(title);
    }

    @Override
    public String addGame(GameAddDto gameAddDto) {
        Validator validator
                = Validation
                .byDefaultProvider()
                .configure()
                .buildValidatorFactory()
                .getValidator();

        Game entity = this.getByTitle(gameAddDto.getTitle());

        if (entity != null) {
            return "This game already exists";
        }

        StringBuilder sb = new StringBuilder();
        if (validator.validate(gameAddDto).size() > 0) {
            for (ConstraintViolation<GameAddDto> violation : validator.validate(gameAddDto) ) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
                return sb.toString().trim();
            }
        }

        Game game = this.modelMapper.map(gameAddDto, Game.class);

        this.gameRepository.saveAndFlush(game);
        sb.append(String.format("Added %s", game.getTitle()));
        return sb.toString().trim();
    }


}
