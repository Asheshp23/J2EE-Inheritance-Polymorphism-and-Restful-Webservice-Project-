/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Employee;
import models.Student;

//import com.google.gson.Gson;
/**
 *
 * @author asheshpatel
 */
@Path("personRepo")
@Produces(MediaType.APPLICATION_JSON)
public class DBHandler {

    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("PersonRepository-warPU");

    /* Create EntityManager */
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    @GET
    @Path("insertStudent/{name}/{address}/{email}/{phone}")
    public List<Student> insertStudent(@PathParam("name") String name, @PathParam("address") String address, @PathParam("email") String email, @PathParam("phone") String phone) {

        transaction.begin();

        Student s = new Student();

        s.setName(name);

        s.setAddress(phone);

        s.setEmail(email);

        s.setPhone(phone);

        em.persist(s);

        transaction.commit();

        List<Student> sList = Arrays.asList(s);

        return sList;
    }

    @GET
    @Path("insertEmp/{name}/{address}/{email}/{phone}")
    public List<Employee> insertEmp(@PathParam("name") String name, @PathParam("address") String address, @PathParam("email") String email, @PathParam("phone") String phone) {

        transaction.begin();

        Employee e = new Employee();

        e.setName(name);

        e.setAddress(phone);

        e.setEmail(email);

        e.setPhone(phone);

        em.persist(e);

        transaction.commit();

        List<Employee> eList = Arrays.asList(e);
            //matchList.add(match);

        return eList;

    }

    @GET
    @Path("viewstudent")
    public List<Student> getstudent() {

        //create an ejbql expression
        String ejbQL = "From Student e";
        //create query
        Query query1 = em.createQuery(ejbQL);

        return query1.getResultList();

    }

    @GET
    @Path("viewemp")
    public List<Employee> getemp() {

        //create an ejbql expression
        String ejbQL = "From Employee e";
        //create query
        Query query1 = em.createQuery(ejbQL);

        return query1.getResultList();

    }

    @GET
    @Path("deleteStd/{id}")
    public List<Student> deleteStudent(@PathParam("id") long id) {

        transaction.begin();

        //create an ejbql expression
        String ejbQL = "delete  From Student e where e.id = ?1";

        Query query = em.createQuery(ejbQL);
        //substitute parameter.
        query.setParameter(1, id);

        query.executeUpdate();
        //execute the query

        transaction.commit();

        return getstudent();
    }

    @GET
    @Path("deleteEmp/{id}")
    public List<Employee> deleteEmp(@PathParam("id") long id) {

        transaction.begin();

        //create an ejbql expression
        String ejbQL = "delete  From Employee e where e.id = ?1";

        Query query = em.createQuery(ejbQL);
        //substitute parameter.
        query.setParameter(1, id);

        query.executeUpdate();
        //execute the query

        transaction.commit();

        return getemp();
    }

    @GET
    @Path("updateStudent/{name}/{address}/{phone}/{id}")
    public List<Student> updatestudent(@PathParam("name") String name, @PathParam("address") String address, @PathParam("phone") String phone, @PathParam("id") long id) {

        transaction.begin();

        //create an ejbql expression
        String ejbQL = "update  Student s SET s.name = ?1 "
                + ", s.address = ?2 ,s.phone = ?3 where s.id = ?4";

        Query query = em.createQuery(ejbQL);

        //substitute parameter.
        query.setParameter(1, name);

        query.setParameter(2, address);

        query.setParameter(3, phone);

        query.setParameter(4, id);

        query.executeUpdate();

        transaction.commit();

        return getstudent();

    }

    @GET
    @Path("updateEmp/{name}/{address}/{phone}/{id}")
    public List<Employee> updateEmp(@PathParam("name") String name, @PathParam("address") String address, @PathParam("phone") String phone, @PathParam("id") long id) {

        transaction.begin();

        //create an ejbql expression
        String ejbQL = "update  Employee e SET e.name = ?1 "
                + ", e.address = ?2 ,e.phone = ?3 where e.id = ?4";

        Query query = em.createQuery(ejbQL);

        //substitute parameter.
        query.setParameter(1, name);

        query.setParameter(2, address);

        query.setParameter(3, phone);

        query.setParameter(4, id);

        query.executeUpdate();

        transaction.commit();

        return getemp();

    }

    @GET
    @Path("findstd/{name}")
    public List<Student> getStdByName(@PathParam("name") String name) {

        //create an ejbql expression
        String ejbQL = "From Student s where s.name like ?1";
        //create query
        Query query = em.createQuery(ejbQL);
        //substitute parameter.
        query.setParameter(1, name);
        //execute the query

        return query.getResultList();
    }

    @GET
    @Path("findemp/{name}")
    public List<Employee> getEmpByName(@PathParam("name") String name) {

        //create an ejbql expression
        String ejbQL = "From Employee e where e.name like ?1";
        //create query
        Query query = em.createQuery(ejbQL);
        //substitute parameter.
        query.setParameter(1, name);
        //execute the query

        return query.getResultList();
    }

}
