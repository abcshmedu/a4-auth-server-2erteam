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

@Path("/users")
public class UserResource {
    @POST
    @Path("/authenticate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createToken(){
        return null;
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
    
    
}
