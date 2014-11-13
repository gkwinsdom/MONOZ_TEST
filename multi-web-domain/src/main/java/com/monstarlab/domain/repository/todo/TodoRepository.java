package com.monstarlab.domain.repository.todo;
import java.util.Collection;

import com.monstarlab.domain.model.Todo;


public interface TodoRepository {
    Todo findOne(String todoId);

    Collection<Todo> findAll();

    Todo save(Todo todo);

    void delete(Todo todo);

    long countByFinished(boolean finished);
}