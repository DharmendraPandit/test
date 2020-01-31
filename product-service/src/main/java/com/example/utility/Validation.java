package com.example.utility;

import com.example.exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class Validation {

    public static void validateCategory(String category, String region) {
        if(StringUtils.isEmpty(category) || StringUtils.isEmpty(region)) {
            //log.error("search criteria category/region cannot be empty");
            throw new ProductException(HttpStatus.BAD_REQUEST.value(), ProductMessages.SEARCHING_CRITERIA.getMessage());
        }
    }

    public static void validateGroupBy(String groupBy) {
        boolean isValid = false;
        if(ProductMessages.brand.getMessage().equals(groupBy) || ProductMessages.price.getMessage().equals(groupBy)
                || ProductMessages.color.getMessage().equals(groupBy) || ProductMessages.size.getMessage().equals(groupBy)) {
            isValid = true;
        }

        if(!isValid) {
            //log.error("groupBy is invalid");
            throw new ProductException(HttpStatus.BAD_REQUEST.value(), ProductMessages.GROUPBY_INVALID.getMessage());
        }
    }

}
