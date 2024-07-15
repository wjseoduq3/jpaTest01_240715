package com.jdy.jpatest;

import com.jdy.jpatest.entity.Item;
import com.jdy.jpatest.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    @DisplayName("테스트 상품 조회")
    public  void findByItemNmTest() {

       List<Item> itemList = itemRepository.findByItemNm("테스트 상품");

       for(Item item:itemList) {
           System.out.println(item.toString());
       }

    }

    @Test
    @DisplayName("테스트 상품 상세 조회")
    public void findByItemOrItemDetailTest() {

        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품","테스트 상품 상세 조회");

        for(Item item:itemList) {
            System.out.println(item.toString());
        }

    }

    @Test
    @DisplayName("10002원 이하 상품 조회")
    public void findByPriceLessThanEqualTest() {

        List<Item> itemList = itemRepository.findByPriceLessThanEqual(10002);

        for(Item item:itemList) {
            System.out.println(item.toString());
        }

    }


}
