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

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import datenzugriffsschicht.User;
import geschaeftslogik.UserService;
import geschaeftslogik.UserServiceImpl;

@Path("/users")
public class UserResource {
    
    private final UserService userService;
    
    public UserResource(){
        userService = new UserServiceImpl();
    }
    
    public UserResource(UserService us){
        this.userService = us;
    }
    
    @POST
    @Path("/authenticate/{user}{pwd}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createToken(@PathParam("user")String user,@PathParam("pwd")String pwd){
        
        return Response.status(Response.Status.OK)
                .entity(objToJson(userService.createToken(user, pwd)))
                .build();
    }
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUsers(){
        return null;
    }
    @GET
    @Path("/{id}") // get
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id){
        return null;
    }
    @PUT
    @Path("/{id}") // put
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") String id, User us){
        return null;
    }
    @GET
    @Path("/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateToken(@PathParam("token") String token){
        return null;
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
