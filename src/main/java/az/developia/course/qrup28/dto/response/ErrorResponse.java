package az.developia.course.qrup28.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private Integer code;
    private String path;
    private String message;
    private Integer errorCode;
}
