package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl (EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public void save (Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById (int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Transactional
    @Override
    public void deleteInstructorById (int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById (int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }
    @Transactional
    @Override
    public void deleteInstructorDetailById (int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId (int theId) {
        // create query -> pass parameters
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);
        //execute query
        List<Course> courses = query.getResultList();
        //return
        return courses;
    }
}
