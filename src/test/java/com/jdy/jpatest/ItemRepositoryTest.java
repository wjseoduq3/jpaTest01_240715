package com.jdy.jpatest;

import com.jdy.jpatest.entity.Item;
import com.jdy.jpatest.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {

        for(int i=1;i<=10;i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품"+i);
            item.setPrice(10000+i);
            item.setItemDetail("테슽 상품 상세 설명"+i);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());

            Item saveItem = itemRepository.save(item); //insert 문
            System.out.println(saveItem.toString());
        }


    }

    @Test
    @DisplayName("상품명 조회")
    public void findByItemNmTest() {

        Item item = itemRepository.findById(3);
    }


}
