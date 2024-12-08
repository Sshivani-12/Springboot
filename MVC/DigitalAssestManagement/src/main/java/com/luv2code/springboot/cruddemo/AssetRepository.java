package com.luv2code.springboot.cruddemo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByTagsContaining(String tag);
}
