package org.example.testovoe.model;

import com.sun.jdi.Bootstrap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.testovoe.dto.UserDto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.cert.Extension;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String avatar;
    private String email;
    private Boolean status ;
    private LocalDateTime timestamp;

    public UserModel(UserDto userDTO) {
        this.setName(userDTO.getName());
        this.setEmail(userDTO.getEmail());
        this.setStatus(userDTO.getStatus());
        this.setAvatar(userDTO.getAvatar());
    }


}
