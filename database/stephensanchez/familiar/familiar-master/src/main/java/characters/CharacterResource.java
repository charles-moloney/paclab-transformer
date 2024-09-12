package characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Component
@Path("characters")
public class CharacterResource {

    private CharacterService characterService;

    public CharacterResource() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(CharacterAppConfig.class);
        ctx.refresh();
        this.characterService = ctx.getBean(CharacterService.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCharacter(@PathParam("name") String name) {
        Character character = characterService.getCharacter(name);
        // TODO: How do we serialize our model objects?
        if (character != null) {
            return String.format("{name: \"%s\"}", character.getName());
        } else {
            return "";
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createCharacter(@FormParam("name") String name) {
        Character character = characterService.createCharacter(name);
        return String.format("{name: \"%s\"}", character.getName());
    }
}