package edu.t1.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
    Long id;
    String username;
}
