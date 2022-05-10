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
public class sellsDateDto {
	
	private List year;
	private List<String> month;
	private List totalCost;
	
	}
