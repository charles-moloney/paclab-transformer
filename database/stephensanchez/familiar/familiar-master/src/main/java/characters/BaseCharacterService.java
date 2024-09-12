package characters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 * Created by stephensanchez on 3/17/15.
 */
public class BaseCharacterService implements CharacterService {

    private EntityManagerFactory entityManagerFactory;

    public BaseCharacterService() {
         this.entityManagerFactory = Persistence.createEntityManagerFactory("CharacterResource");
    }

    @Override
    public Character getCharacter(String name) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        try {
            return (Character) manager.createQuery(
                    "select character from BaseCharacter as character where character.name = " + name).getSingleResult();
        } catch (NoResultException nrex) {
            return null;
        }
    }

    @Override
    public Character createCharacter(String name) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        BaseCharacter character = new BaseCharacter();
        character.setName(name);
        manager.persist(character);
        manager.getTransaction().commit();
        return character;
    }

    @Override
    public Character updateCharacter(Character character) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(character);
        manager.getTransaction().commit();
        return character;
    }
}
