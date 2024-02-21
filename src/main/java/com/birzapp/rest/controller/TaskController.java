package com.birzapp.rest.controller;

import com.birzapp.rest.entity.Task;
import com.birzapp.rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService service;

    public TaskController() {}

    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET(){
        Collection<Task> student = service.findAll();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Task item){
        service.insert(item);
        return new  ResponseEntity<>("Task Register!", HttpStatus.CREATED);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editar_PUT(@PathVariable Long id ,@RequestBody Task itemNew){

        Task itemDB = service.findById(id);

        itemDB.setTitle(itemNew.getTitle());
        itemDB.setDescription(itemNew.getDescription());
        service.insert(itemDB);
        return new  ResponseEntity<>("Task Update!", HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> registrar_DELETE(@PathVariable Long id){
        service.delete(id);
        return new  ResponseEntity<>("Task delete!", HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar_GET(@PathVariable Long id) {
        Task task = service.findById(id);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Task unregistered", HttpStatus.NOT_FOUND);
        }
    }

}
