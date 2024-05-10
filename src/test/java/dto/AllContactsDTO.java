package dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class AllContactsDTO {
    List<ContactDTOLombok> contacts;
}
