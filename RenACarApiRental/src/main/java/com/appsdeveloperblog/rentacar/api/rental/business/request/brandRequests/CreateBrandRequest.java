package com.appsdeveloperblog.rentacar.api.rental.business.request.brandRequests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateBrandRequest {
	
	@NotNull
	@Size(min=2,max=15)
	private String brandName;
	
}
