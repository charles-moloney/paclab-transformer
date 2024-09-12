package characters;

/**
 * Created by stephensanchez on 3/17/15.
 */
public interface CharacterService {

    public Character getCharacter(String name);

    public Character createCharacter(String name);

    public Character updateCharacter(Character character);
}
