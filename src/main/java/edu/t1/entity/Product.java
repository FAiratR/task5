package edu.t1.entity;

import lombok.*;
import org.springframework.stereotype.Component;
import java.lang.Long;

@Component
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Product {
    Long id;
    Long userId;
    String accNum;
    Long balance;
    TypePruduct type;
}
