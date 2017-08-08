package se.munhunger.echo.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;
import se.munhunger.echo.model.Message;
import se.munhunger.echo.util.database.jpa.Database;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcus Münger on 2017-08-07.
 */
@Component
@Api(value = "Echo messages")
@Path("/")
public class Echo
{
    @POST
    @Path("/save/{id}")
    @ApiOperation(value = "Save a message")
    public Response save(@PathParam("id") String id, String object)
    {
        Database.saveObject(new Message(id, object));
        return Response.status(HttpServletResponse.SC_CREATED).build();
    }

    @GET
    @Path("/get/{id}")
    @ApiOperation(value = "Get a message")
    public Response get(@PathParam("id") String id) throws Exception
    {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List db = Database.getObjects("from Message WHERE id = :id", params);
        if(db.isEmpty())
            return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
        else
            return Response.ok(db.get(0)).build();
    }
}
