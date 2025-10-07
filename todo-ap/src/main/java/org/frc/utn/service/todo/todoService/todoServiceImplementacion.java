package main.java.org.frc.utn.service.todo.todoService;

import main.java.org.frc.utn.service.todo.repositorio.todoRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class todoServiceImplementacion implements todoService {

    // @Autowired no es recomendable por que viola encapsulamiento (la mejor es por constructor)
    private final todoRepository todoRepository;

    //public todoServiceImplementacion(todoRepository todoRepository) {
    //    this.todoRepository = todoRepository;
    //}    este constructor es generado por RequiredArgsConstructor
}
