package com.jdy.jpatest.repository;

import com.jdy.jpatest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<Item, Long> {

}
