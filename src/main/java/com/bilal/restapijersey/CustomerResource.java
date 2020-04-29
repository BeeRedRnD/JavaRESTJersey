package com.bilal.restapijersey;

import java.util.Arrays;
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

@Path("customers")
public class CustomerResource 
{
	
	CustomerRepository repo = new CustomerRepository();
	
	//resource to retrive all customers
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Customer> getCustomer()
	{
		System.out.println("getCustomer method is called...");
		
		return repo.getCustomers();
	}
	
	
	//resource to retrieve a specific customer with an id
	@GET
	@Path("customer/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Customer getCustomerSingle(@PathParam("id") int id)
	{
		return repo.getCustomer(id);
	}
	
	
	// resource to create a new customer in the database
	@POST
	@Path("customer")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Customer createCustomer(Customer c)
	{
		System.out.println(c);
		repo.createCustomer(c);
		return c;
	}
	
	// resource to update an existing customer in the database
	@PUT
	@Path("customer")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Customer updateCustomer(Customer c)
	{
		System.out.println(c);
		if(repo.getCustomer(c.getId()) != null)
		{
			System.out.println("update method executed");
			repo.updateCustomer(c);
		}
		else
		{
			System.out.println("add method executed for update");
			repo.createCustomer(c);
		}
		
		return c;
	}
	
	//resource to delete an existing customer in the database
	@DELETE
	@Path("customer/{id}")
	public Customer deleteCustomer(@PathParam("id") int id)
	{
		Customer c = repo.getCustomer(id);
		
		if(c.getId()!=0)
		{
			repo.deleteCustomer(id);
		}
		
		return c;
	}
	

}
