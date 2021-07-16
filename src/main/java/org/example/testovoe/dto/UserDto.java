package org.example.testovoe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.testovoe.model.UserModel;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "не может быть пустым")
    private String name;
    @URL
    private String avatar;
    @Email(message = "имеет неверное значение")
    private String email;
    private Boolean status;

    public UserDto(UserModel user) {
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setStatus(user.getStatus());
        this.setAvatar(user.getAvatar());
    }
}

