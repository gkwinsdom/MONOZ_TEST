package com.monstarlab.domain.service.todo;
import java.util.Collection;

import com.monstarlab.domain.model.Todo;

public interface TodoService {
    Collection<Todo> findAll();
    
    Todo findOne(String todoId);

    Todo create(Todo todo);

    Todo finish(String todoId);

    void delete(String todoId);
}