package ru.psyfabriq.dao;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import ru.psyfabriq.entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentDAOImpl extends AbstractDAO implements StudentDAO<Student, Integer> {

    @Override
    public void persist(Student  entity) {
        try {
            startTransaction();
                session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Student entity) {
        try {
            startTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Student> findById(Integer aLong) {
        Student student = null;
        try {
            startOperation();
            student = session.get(Student.class, aLong);
        } catch (HibernateException e) {
            handleExceptionQuery(e);
        } finally {
            session.close();
        }
        return Optional.ofNullable(student);
    }

    @Override
    public void delete(Student entity) {
        try {
            startTransaction();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = null;
        try {
            startTransaction();
            Query query = session.createQuery("from " + Student.class.getName());
            students = query.list();
            tx.commit();
        } catch (HibernateException e) {
            handleException(e);
        } finally {
            session.close();
        }

        return students;
    }

    @Override
    public void deleteAll() {
        List<Student> studentList = findAll();
        studentList.forEach(item -> {
            delete(item);
        });
    }
}
