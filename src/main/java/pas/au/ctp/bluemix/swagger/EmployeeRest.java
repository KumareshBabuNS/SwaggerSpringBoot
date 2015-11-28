package pas.au.ctp.bluemix.swagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/emps")
public class EmployeeRest
{
    static List<Employee> emps = new ArrayList<Employee>();

    static
    {
        emps.add(new Employee(1, "pas"));
        emps.add(new Employee(2, "lucia"));
    }

    @ApiOperation(value = "listEmps", nickname = "listEmps")
    @RequestMapping(method = RequestMethod.GET, path="/allemps")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public List<Employee> listEmps ()
    {
        return emps;
    }

    @ApiOperation(value = "findEmpById", nickname = "findEmpById")
    @RequestMapping(method=RequestMethod.GET, value="/employee/{empId}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Employee.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Employee findEmpById(@PathVariable String empId)
    {
        return (Employee) emps.get(Integer.parseInt(empId));
    }

}
