package xy.com.ProjectManagment.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataDto {
    private String username;
    private String email;
    private List<String> roles;

}
