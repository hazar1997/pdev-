package tn.esprit.spring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListProductDto {
	
	List<ProductWithRatingDto> allpro;
	List<ProductWithRatingDto> mostLikedProduct;
	List<ProductWithRatingDto> elecCateg;
	List<ProductWithRatingDto> tabTelCatg;


}
