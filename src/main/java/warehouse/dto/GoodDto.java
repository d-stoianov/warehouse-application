package warehouse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GoodDto {
    private String name;
    private double price;
    private int quantity;
    private Long categoryId;
    private Long supplierId;
}
