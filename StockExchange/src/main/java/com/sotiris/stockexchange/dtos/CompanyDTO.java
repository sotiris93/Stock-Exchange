package com.sotiris.stockexchange.dtos;

import java.util.List;


public record CompanyDTO(Long id, String name, List<String > owners) {

}
