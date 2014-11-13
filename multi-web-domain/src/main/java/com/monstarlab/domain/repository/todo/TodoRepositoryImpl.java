package com.monstarlab.domain.repository.todo;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.monstarlab.domain.model.Todo;


@Repository // (1)
public class TodoRepositoryImpl implements TodoRepository {
    private static final Map<String, Todo> TODO_MAP = new ConcurrentHashMap<String, Todo>();

    @Override
    public Todo findOne(String todoId) {
        return TODO_MAP.get(todoId);
    }

    @Override
    public Collection<Todo> findAll() {
        return TODO_MAP.values();
    }

    @Override
    public Todo save(Todo todo) {
        return TODO_MAP.put(todo.getTodoId(), todo);
    }

    @Override
    public void delete(Todo todo) {
        TODO_MAP.remove(todo.getTodoId());
    }

    @Override
    public long countByFinished(boolean finished) {
        long count = 0;
        for (Map.Entry<String, Todo> e : TODO_MAP.entrySet()) {
            Todo todo = e.getValue();
            if (finished == todo.isFinished()) {
                count++;
            }
        }
        return count;
    }
}