package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        tempInstructorDetail.getInstructor().setInstuctorDetail(null);
        entityManager.remove(tempInstructorDetail);
    }
}
