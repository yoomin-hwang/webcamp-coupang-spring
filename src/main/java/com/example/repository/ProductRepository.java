package com.example.repository;

import com.example.entity.Product;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final SqlSession sqlSession;

    public List<Product> findAll() {
        return sqlSession.selectList("Product.findAll");
    }

    public void add(Product product) {
        sqlSession.insert("Product.add", product);
    }
}
