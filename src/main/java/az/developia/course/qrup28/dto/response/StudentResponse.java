package az.developia.course.qrup28.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Integer age;
    private SeriesResponse series;
    private SchoolClassResponse schoolClass;
}
