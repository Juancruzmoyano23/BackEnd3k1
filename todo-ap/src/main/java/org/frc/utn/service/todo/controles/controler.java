package main.java.org.frc.utn.service.todo.controles;

import lombok.RequiredArgsConstructor;
import main.java.org.frc.utn.service.todo.todoService.toDoService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@RequiredMapping("/api/todo") // 127.0.0.1:8184   o    https://localhost/api/todo   esto es para llegar
public class controler {
    
    private final toDoService toDoService;

    // metodos para obtener info

    @PostMapping // post de lombok
    public ResponseEntity crearTarea(@RequiestBody entidades tarea){

        try {
            this.service.agregarTarea(tarea);
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(httpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("/{id}") // get de lombok
    public ResponseEntity<Entidad> getById(@PathVariable int id){
        try {
            var tarea = this.service.getById(id);
            return new ResponseEntity.ok(tarea)
            
        } catch(illegalAr){
            return new ResponseEntity<>(http)
        }

    }
}
