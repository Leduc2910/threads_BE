package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Vui lòng nhập tài khoản")
    private String username;
    @NotEmpty(message = "Vui lòng nhập mật khẩu")
    @Size(min = 6, message = "Mật khẩu phải từ 6 kí tự trở lên")
    private String password;
    @NotEmpty(message = "Vui lòng nhập tên hiển thị")
    private String name;
    @NotNull(message = "Vui lòng nhập ngày sinh")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthday;
    private String description = "";
    private int status = 0;
    private final LocalDateTime create_at = LocalDateTime.now();
    private String avatar = "avatar-default.png";
}
