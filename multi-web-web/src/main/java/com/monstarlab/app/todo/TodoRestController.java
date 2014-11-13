package com.monstarlab.app.todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.monstarlab.domain.model.Todo;
import com.monstarlab.domain.model.TodoResource;
import com.monstarlab.domain.service.todo.TodoService;

@Controller
@RequestMapping("todos")
public class TodoRestController {
    @Inject
    TodoService todoService;
    @Inject
    Mapper beanMapper;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResource> getTodos() {
        Collection<Todo> todos = todoService.findAll();
        List<TodoResource> todoResources = new ArrayList<>();
        for (Todo todo : todos) {
            todoResources.add(beanMapper.map(todo, TodoResource.class));
        }
        return todoResources;
    }

//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    public TodoResource postTodos(@RequestBody @Validated TodoResource todoResource) {
//        Todo createdTodo = todoService.create(beanMapper.map(todoResource, Todo.class));
//        TodoResource createdTodoResponse = beanMapper.map(createdTodo, TodoResource.class);
//        return createdTodoResponse;
//    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<TodoResource> postTodos(@RequestParam(value = "todoTitle", required = true)String todoTitle){
    	
    	TodoResource todoResource = new TodoResource();
    	todoResource.setTodoTitle(todoTitle);
    	
        todoService.create(beanMapper.map(todoResource, Todo.class));
        return getTodos();
    }

    // (3)
    @RequestMapping(value="{todoId}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public TodoResource getTodo(@PathVariable("todoId") String todoId) {
        Todo todo = todoService.findOne(todoId);
        TodoResource todoResource = beanMapper.map(todo, TodoResource.class);
        return todoResource;
    }

    // (4)
    @RequestMapping(value="{todoId}", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<TodoResource> putTodo(@PathVariable("todoId") String todoId) {
        todoService.finish(todoId);
        return getTodos();
    }

    // (5)
    @RequestMapping(value="{todoId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<TodoResource> deleteTodo(@PathVariable("todoId") String todoId) {
        todoService.delete(todoId);
        return getTodos();
    }

}