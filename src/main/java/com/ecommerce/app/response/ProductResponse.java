package com.ecommerce.app.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

	private Long productId;
	private String productName;
	private String productDescription;
	private BigDecimal productPrice;

}
