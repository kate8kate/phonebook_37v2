package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class ErrorDTO {
    private String timestamp;
    private Integer status;
    private String error;
    private Object message;

private String path;
}
