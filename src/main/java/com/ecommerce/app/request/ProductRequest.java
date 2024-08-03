package com.ecommerce.app.request;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

	@Schema(defaultValue = "chair")
	@NotNull(message = "Product can't be null")
	@NotBlank(message = "Product name should not be Empty")
	private String productName;

	@Schema(defaultValue = "steel meterial")
	@NotNull(message = "productDescription can't be null")
	@NotBlank(message = "productDescription should not be Empty")
	private String productDescription;

	@Schema(defaultValue = "2000.00")
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=4, fraction=2)
	private BigDecimal productPrice;

}
