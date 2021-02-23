package com.model.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.example.Message;
import com.model.example.Student;
import com.model.service.StudentDaoImp;


@Path("/student")
public class StudentResource {
StudentDaoImp std=new StudentDaoImp();
@GET  
@Produces(MediaType.APPLICATION_JSON)  
public Response getStudentDetails() {
	System.out.println("Get all students");
	List<Student>getAllStudents=std.listAllStudents();
	return Response.status(200).entity(getAllStudents).header("Access-Control-Allow-Origin", "*").build();
}
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createStudent(Student student) {
std.addStudent(student);
return Response.status(200).entity(createStudent(student)).header("Access-Control-Allow-Origin", "*").build();
}
@PUT
@Path("/{Id}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response updateStudent(@PathParam("Id") int id,Student student) {
	std.updateStudent(student);
	return Response.status(200).entity(updateStudent(id,student)).header("Access-Control-Allow-Origin", "*").build();
}
@DELETE
@Path("/{studentId}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteStudents(@PathParam("messageId") int id) {
	std.deleteStudent(id);
}

@GET  
@Path("/{Id}")
 @Produces(MediaType.APPLICATION_JSON)  
public Student getStudent(@PathParam("Id") int Id) {
	 return std.getStudent(Id);
}
}
