package api_schicht;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import datenzugriffsschicht.User;
import geschaeftslogik.UserService;
import geschaeftslogik.UserServiceImpl;

/**
 * The class UserResource hands off JSON Objects to the service for authentification.
 * @author Altvatter Robert, Groﬂbeck Thomas
 *
 */
@Path("/users")
public class UserResource {
    
    private final UserService userService;
    
    /**
     * constructs a user resource.
     */
    public UserResource() {
        userService = new UserServiceImpl();
    }
    
    /**
     * constructs a user resource.
     * @param us user resource
     */
    public UserResource(UserService us) {
        this.userService = us;
    }
    
    /**
     * Creates a token for the user.
     * @param user who wants a token
     * @param pwd for mthe user
     * @return service response
     */
    @POST
    @Path("/authenticate/{user}{pwd}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createToken(@PathParam("user")String user, @PathParam("pwd")String pwd) {
        return Response.status(Response.Status.OK)
        .entity(objToJson(userService.createToken(user, pwd)))
        .build();
    }
    
    /**
     * Lists all users.
     * @return service response
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers() {
        return Response.status(Response.Status.OK)
        .entity(objToJson(userService.getUsers()))
        .build();
    }
    
    /**
     * returns one specific user.
     * @param id from the user
     * @return service response
     */
    @GET
    @Path("/{id}") // get
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        return Response.status(Response.Status.OK)
                .entity(objToJson(userService.getUser(Integer.parseInt(id))))
                .build();
    }
    
    /**
     * Updates a user.
     * @param id from the user
     * @param user user
     * @return service response
     */
    @PUT
    @Path("/{id}") // put
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") String id, User user) {
        return Response.status(Response.Status.OK)
                .entity(objToJson(userService.updateUser(Integer.parseInt(id), user)))
                .build();
    }
    
    /**
     * checks if a token is validated.
     * @param token to check
     * @return service response
     */
    @GET
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateToken(@PathParam("token") String token) {
        return Response.status(Response.Status.OK)
                .entity(objToJson(userService.validateToken(token)))
                .build();
    }
    /**
     * Converts a java object to JSON.
     * @param o object to convert
     * @return string with the json representation
     */
    private String objToJson(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(o);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }   
    
}
