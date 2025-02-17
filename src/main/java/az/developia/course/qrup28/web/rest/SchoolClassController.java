package az.developia.course.qrup28.web.rest;


import az.developia.course.qrup28.dto.request.SchoolClassRequest;
import az.developia.course.qrup28.dto.response.SchoolClassResponse;
import az.developia.course.qrup28.service.SchoolClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/classes")
@Validated
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    @GetMapping
    public List<SchoolClassResponse> getAll() {
        return schoolClassService.getAll();
    }

    @GetMapping("/{id}")
    public SchoolClassResponse getById(@PathVariable @Positive Long id) {
        return schoolClassService.getById(id);
    }

    @PostMapping
    public Long add(@RequestBody SchoolClassRequest request) {
        return schoolClassService.add(request);
    }

    @PutMapping("/{id}")
    public SchoolClassResponse update(@PathVariable Long id, @RequestBody SchoolClassRequest request) {
        return schoolClassService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return schoolClassService.delete(id);
    }
}
