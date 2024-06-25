package br.com.projetospringboot3.cruddemo.dao;

import br.com.projetospringboot3.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student targetStudent) {
        entityManager.persist(targetStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName DESC", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String targetLastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:param_lastName", Student.class);
        query.setParameter("param_lastName", targetLastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student targetStudent) {
        entityManager.merge(targetStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student targetStudent = entityManager.find(Student.class, id);
        entityManager.remove(targetStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int totalRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return totalRowsDeleted;
    }
}
