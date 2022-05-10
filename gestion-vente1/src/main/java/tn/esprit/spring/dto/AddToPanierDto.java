package tn.esprit.spring.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddToPanierDto {
	
	private Integer id;
    private @NonNull Integer productId;
    private @NonNull Integer quantity;


}
