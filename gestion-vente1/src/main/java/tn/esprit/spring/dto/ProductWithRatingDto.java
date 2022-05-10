package tn.esprit.spring.dto;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithRatingDto {
			
	BigInteger prod_id;
	String description;
	String imageUrl;
	String name;
	double price;
	String categorie;
	BigInteger nbrRating;
	BigDecimal rating;

}
