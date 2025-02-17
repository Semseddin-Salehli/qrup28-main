package az.developia.course.qrup28.web.rest;


import az.developia.course.qrup28.dto.request.StudentRequest;
import az.developia.course.qrup28.dto.response.StudentResponse;
import az.developia.course.qrup28.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<StudentResponse> getStudentList() {
        return studentService.getAll();
    }

    @GetMapping("/class/{classId}")
    public List<StudentResponse> getStudentListByClassId(@PathVariable @Positive Long classId) {
        return studentService.getAllByClassId(classId);
    }

    @PostMapping
    public Long addStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return studentService.add(studentRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable @Positive Long id) {
        return studentService.getById(id);
    }


    @PutMapping
    public StudentResponse updateStudent(@RequestBody @Valid StudentRequest studentRequest,
                                         @RequestParam @Positive Long studentId) {
        return studentService.update(studentRequest, studentId);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponse deleteStudent(@PathVariable @Positive Long studentId) {
        return studentService.delete(studentId);
    }
}
