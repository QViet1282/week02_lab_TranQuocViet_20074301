package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.EmployeeServices;

import java.util.Optional;

@Path("/employees")
public class EmployeeResourses {
    private EmployeeServices employeeServices;
    public EmployeeResourses(){
        employeeServices = new EmployeeServices();
    }
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getEmp(@PathParam("id") long id){
        Optional<Employee> employee = employeeServices.findEmp(id);
        if(employee.isPresent()){
            return Response.ok(employee.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAllEmp(){
        return Response.ok(employeeServices.getAllEmp()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insertEmp(Employee employee){
        if(employeeServices.insertEmp(employee)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmp(@PathParam("id") long id){
        if(employeeServices.deleteEmp(id)){
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
