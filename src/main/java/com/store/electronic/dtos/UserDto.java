package com.store.electronic.dtos;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {

    private String userId;

    @Size(min = 3, max = 20, message = "Invalid Name")
    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid Email")
//    @Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$",message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @Size(min = 4, max = 6, message = "Invalid Gender")
    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "About is required")
    private String about;

    private String imageName;

    private Set<RoleDto> roles = new HashSet<>();
}
