package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class UserDTOLombok {
    private String username;
    private String password;

}
