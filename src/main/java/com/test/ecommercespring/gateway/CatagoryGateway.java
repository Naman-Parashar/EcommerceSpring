package com.test.ecommercespring.gateway;

import com.test.ecommercespring.dto.CatagoryDTO;

import java.io.IOException;
import java.util.List;


public interface CatagoryGateway {

    List<CatagoryDTO> getAllCategory() throws IOException;
}
