package jsonprocessing.service;

import jsonprocessing.domain.dtos.CategorySeedDto;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDtos);
}
