package org.vicary;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void findBlockByColor_expectOptionalEmpty_NullBlocks() {
        //given
        String givenColor = "red";
        List<Block> givenBlocks = null;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(Optional.empty(), wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectOptionalEmpty_EmptyBlocks() {
        //given
        String givenColor = "red";
        List<Block> givenBlocks = Collections.emptyList();

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(Optional.empty(), wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectDoesNotThrow_BlockColorIsNull() {
        //given
        String givenColor = "red";
        Block b1 = new BlockImpl(null, "");
        List<Block> givenBlocks = List.of(b1);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertDoesNotThrow(() -> wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectDoesNotThrow_GivenColorIsNull() {
        //given
        String givenColor = null;
        Block b1 = new BlockImpl("red", "");
        List<Block> givenBlocks = List.of(b1);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertDoesNotThrow(() -> wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectEquals_OnlyBlocks() {
        //given
        String givenColor = "red";
        Block b1 = new BlockImpl("1", "");
        Block b2 = new BlockImpl("2", "");
        Block b3 = new BlockImpl("3", "");
        Block b4 = new BlockImpl("4", "");
        Block b5 = new BlockImpl("red", "");
        Block b6 = new BlockImpl("6", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        Optional<Block> expectedBlock = Optional.of(b5);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedBlock, wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectOptionalEmpty_OnlyBlocks() {
        //given
        String givenColor = "red";
        Block b1 = new BlockImpl("1", "");
        Block b2 = new BlockImpl("2", "");
        Block b3 = new BlockImpl("3", "");
        Block b4 = new BlockImpl("4", "");
        Block b5 = new BlockImpl("5", "");
        Block b6 = new BlockImpl("6", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(Optional.empty(), wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectEquals_OnlyCompositeBlocks() {
        //given
        String givenColor = "red";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "1", "");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "2", "");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "3", "");
        Block b4 = new CompositeBlockImpl(Collections.emptyList(), "red", "");
        Block b5 = new CompositeBlockImpl(Collections.emptyList(), "5", "");
        Block b6 = new CompositeBlockImpl(Collections.emptyList(), "6", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        Optional<Block> expectedBlock = Optional.of(b4);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedBlock, wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectOptionalEmpty_OnlyCompositeBlocks() {
        //given
        String givenColor = "red";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "1", "");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "2", "");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "3", "");
        Block b4 = new CompositeBlockImpl(Collections.emptyList(), "4", "");
        Block b5 = new CompositeBlockImpl(Collections.emptyList(), "5", "");
        Block b6 = new CompositeBlockImpl(Collections.emptyList(), "6", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(Optional.empty(), wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectEquals_BlocksAndCompositeBlocks() {
        //given
        String givenColor = "red";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "1", "");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "2", "");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "3", "");

        Block b4 = new BlockImpl("4", "");
        Block b5 = new BlockImpl("red", "");
        Block b6 = new BlockImpl("6", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        Optional<Block> expectedBlock = Optional.of(b5);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedBlock, wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectOptionalEmpty_BlocksAndCompositeBlocks() {
        //given
        String givenColor = "red";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "1", "");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "2", "");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "3", "");

        Block b4 = new BlockImpl("4", "");
        Block b5 = new BlockImpl("5", "");
        Block b6 = new BlockImpl("6", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(Optional.empty(), wall.findBlockByColor(givenColor));
    }


    @Test
    void findBlockByColor_expectEquals_CompositeBlocksWithListOfBlocks() {
        //given
        String givenColor = "red";

        Block b1 = new BlockImpl("1", "");
        Block b2 = new BlockImpl("2", "");
        Block b3 = new BlockImpl("3", "");
        List<Block> l1 = List.of(b1, b2, b3);

        Block b4 = new BlockImpl("4", "");
        Block b5 = new BlockImpl("5", "");
        Block b6 = new BlockImpl("6", "");
        List<Block> l2 = List.of(b4, b5, b6);

        Block b7 = new BlockImpl("7", "");
        Block b8 = new BlockImpl("red", "");
        Block b9 = new BlockImpl("9", "");
        List<Block> l3 = List.of(b7, b8, b9);


        Block c1 = new CompositeBlockImpl(l1, "10", "");
        Block c2 = new CompositeBlockImpl(l2, "11", "");
        Block c3 = new CompositeBlockImpl(l3, "12", "");


        List<Block> givenBlocks = List.of(c1, c2, c3);
        Optional<Block> expectedBlock = Optional.of(b8);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedBlock, wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectOptionalEmpty_CompositeBlocksWithListOfBlocks() {
        //given
        String givenColor = "red";

        Block b1 = new BlockImpl("1", "");
        Block b2 = new BlockImpl("2", "");
        Block b3 = new BlockImpl("3", "");
        List<Block> l1 = List.of(b1, b2, b3);

        Block b4 = new BlockImpl("4", "");
        Block b5 = new BlockImpl("5", "");
        Block b6 = new BlockImpl("6", "");
        List<Block> l2 = List.of(b4, b5, b6);

        Block b7 = new BlockImpl("7", "");
        Block b8 = new BlockImpl("8", "");
        Block b9 = new BlockImpl("9", "");
        List<Block> l3 = List.of(b7, b8, b9);


        Block c1 = new CompositeBlockImpl(l1, "10", "");
        Block c2 = new CompositeBlockImpl(l2, "11", "");
        Block c3 = new CompositeBlockImpl(l3, "12", "");
        List<Block> givenBlocks = List.of(c1, c2, c3);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(Optional.empty(), wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectEquals_CompositeBlocksWithListOfCompositeBlocks() {
        //given
        String givenColor = "red";
        Block c1 = new CompositeBlockImpl(Collections.emptyList(), "1", "");

        List<Block> l1 = List.of(c1);
        Block c2 = new CompositeBlockImpl(l1, "red", "");

        List<Block> l2 = List.of(c2);
        Block c3 = new CompositeBlockImpl(l2, "3", "");

        List<Block> l3 = List.of(c3);
        Block c4 = new CompositeBlockImpl(l3, "4", "");

        List<Block> l4 = List.of(c4);
        Block c5 = new CompositeBlockImpl(l4, "5", "");

        List<Block> l5 = List.of(c5);
        Block c6 = new CompositeBlockImpl(l5, "6", "");

        List<Block> givenBlocks = List.of(c6);
        Optional<Block> expectedBlock = Optional.of(c2);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedBlock, wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlockByColor_expectOptionalEmpty_CompositeBlocksWithListOfCompositeBlocks() {
        //given
        String givenColor = "red";
        Block c1 = new CompositeBlockImpl(Collections.emptyList(), "1", "");

        List<Block> l1 = List.of(c1);
        Block c2 = new CompositeBlockImpl(l1, "2", "");

        List<Block> l2 = List.of(c2);
        Block c3 = new CompositeBlockImpl(l2, "3", "");

        List<Block> l3 = List.of(c3);
        Block c4 = new CompositeBlockImpl(l3, "4", "");

        List<Block> l4 = List.of(c4);
        Block c5 = new CompositeBlockImpl(l4, "5", "");

        List<Block> l5 = List.of(c5);
        Block c6 = new CompositeBlockImpl(l5, "6", "");

        List<Block> givenBlocks = List.of(c6);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(Optional.empty(), wall.findBlockByColor(givenColor));
    }

    @Test
    void findBlocksByMaterial_expectDoesNotThrow_NullBlocks() {
        //given
        String givenMaterial = "steel";
        List<Block> givenBlocks = null;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertDoesNotThrow(() -> wall.findBlocksByMaterial(givenMaterial));
    }

    @Test
    void findBlocksByMaterial_expectEmptyList_EmptyBlocks() {
        //given
        String givenMaterial = "steel";
        List<Block> givenBlocks = Collections.emptyList();
        int expectedListSize = 0;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //then
        assertEquals(expectedListSize, actualList.size());
    }

    @Test
    void findBlocksByMaterial_expectDoesNotThrow_BlockMaterialIsNull() {
        //given
        String givenMaterial = "steel";
        Block b1 = new BlockImpl("", null);
        List<Block> givenBlocks = List.of(b1);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertDoesNotThrow(() -> wall.findBlockByColor(givenMaterial));
    }

    @Test
    void findBlocksByMaterial_expectDoesNotThrow_GivenMaterialIsNull() {
        //given
        String givenMaterial = null;
        Block b1 = new BlockImpl("", "1");
        List<Block> givenBlocks = List.of(b1);

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertDoesNotThrow(() -> wall.findBlocksByMaterial(givenMaterial));
    }

    @Test
    void findBlocksByMaterial_expectEquals_OnlyBlocks() {
        //given
        String givenMaterial = "steel";
        Block b1 = new BlockImpl("", "1");
        Block b2 = new BlockImpl("", "steel");
        Block b3 = new BlockImpl("", "3");
        Block b4 = new BlockImpl("", "4");
        Block b5 = new BlockImpl("", "steel");
        Block b6 = new BlockImpl("", "6");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedListSize = 2;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //then
        assertEquals(expectedListSize, actualList.size());
        assertTrue(actualList.stream().allMatch(block -> block.material().equals(givenMaterial)));
    }

    @Test
    void findBlocksByMaterial_expectEmptyList_OnlyBlocks() {
        //given
        String givenMaterial = "steel";
        Block b1 = new BlockImpl("", "1");
        Block b2 = new BlockImpl("", "2");
        Block b3 = new BlockImpl("", "3");
        Block b4 = new BlockImpl("", "4");
        Block b5 = new BlockImpl("", "5");
        Block b6 = new BlockImpl("", "6");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedListSize = 0;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //then
        assertEquals(expectedListSize, actualList.size());
    }

    @Test
    void findBlocksByMaterial_expectEquals_OnlyCompositeBlocks() {
        //given
        String givenMaterial = "steel";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "", "steel");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "", "2");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "", "3");
        Block b4 = new CompositeBlockImpl(Collections.emptyList(), "", "steel");
        Block b5 = new CompositeBlockImpl(Collections.emptyList(), "", "steel");
        Block b6 = new CompositeBlockImpl(Collections.emptyList(), "", "steel");
        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedListSize = 4;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //when
        //then
        assertEquals(expectedListSize, actualList.size());
        assertTrue(actualList.stream().allMatch(block -> block.material().equals(givenMaterial)));
    }

    @Test
    void findBlocksByMaterial_expectEmptyList_OnlyCompositeBlocks() {
        //given
        String givenMaterial = "steel";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "", "1");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "", "2");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "", "3");
        Block b4 = new CompositeBlockImpl(Collections.emptyList(), "", "4");
        Block b5 = new CompositeBlockImpl(Collections.emptyList(), "", "5");
        Block b6 = new CompositeBlockImpl(Collections.emptyList(), "", "6");
        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedListSize = 0;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //when
        //then
        assertEquals(expectedListSize, actualList.size());
    }

    @Test
    void findBlocksByMaterial_expectEquals_BlocksAndCompositeBlocks() {
        //given
        String givenMaterial = "steel";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "", "1");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "", "2");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "", "steel");

        Block b4 = new BlockImpl("", "4");
        Block b5 = new BlockImpl("", "steel");
        Block b6 = new BlockImpl("", "steel");
        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedListSize = 3;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //when
        //then
        assertEquals(expectedListSize, actualList.size());
        assertTrue(actualList.stream().allMatch(block -> block.material().equals(givenMaterial)));
    }

    @Test
    void findBlocksByMaterial_expectEmptyList_BlocksAndCompositeBlocks() {
        //given
        String givenMaterial = "steel";
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "", "1");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "", "2");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "", "3");

        Block b4 = new BlockImpl("", "4");
        Block b5 = new BlockImpl("", "5");
        Block b6 = new BlockImpl("", "6");
        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedListSize = 0;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //when
        //then
        assertEquals(expectedListSize, actualList.size());
    }

    @Test
    void findBlocksByMaterial_expectEquals_CompositeBlocksWithListOfBlocks() {
        //given
        String givenMaterial = "steel";

        Block b1 = new BlockImpl("", "1");
        Block b2 = new BlockImpl("", "steel");
        Block b3 = new BlockImpl("", "3");
        List<Block> l1 = List.of(b1, b2, b3);

        Block b4 = new BlockImpl("", "steel");
        Block b5 = new BlockImpl("", "5");
        Block b6 = new BlockImpl("", "steel");
        List<Block> l2 = List.of(b4, b5, b6);

        Block b7 = new BlockImpl("", "7");
        Block b8 = new BlockImpl("", "8");
        Block b9 = new BlockImpl("", "9");
        List<Block> l3 = List.of(b7, b8, b9);


        Block c1 = new CompositeBlockImpl(l1, "", "steel");
        Block c2 = new CompositeBlockImpl(l2, "", "11");
        Block c3 = new CompositeBlockImpl(l3, "", "steel");


        List<Block> givenBlocks = List.of(c1, c2, c3);
        int expectedListSize = 5;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //then
        assertEquals(expectedListSize, actualList.size());
        assertTrue(actualList.stream().allMatch(block -> block.material().equals(givenMaterial)));
    }

    @Test
    void findBlocksByMaterial_expectEmptyList_CompositeBlocksWithListOfBlocks() {
        //given
        String givenMaterial = "steel";

        Block b1 = new BlockImpl("", "1");
        Block b2 = new BlockImpl("", "2");
        Block b3 = new BlockImpl("", "3");
        List<Block> l1 = List.of(b1, b2, b3);

        Block b4 = new BlockImpl("", "4");
        Block b5 = new BlockImpl("", "5");
        Block b6 = new BlockImpl("", "6");
        List<Block> l2 = List.of(b4, b5, b6);

        Block b7 = new BlockImpl("", "7");
        Block b8 = new BlockImpl("", "8");
        Block b9 = new BlockImpl("", "9");
        List<Block> l3 = List.of(b7, b8, b9);


        Block c1 = new CompositeBlockImpl(l1, "", "10");
        Block c2 = new CompositeBlockImpl(l2, "", "11");
        Block c3 = new CompositeBlockImpl(l3, "", "12");

        List<Block> givenBlocks = List.of(c1, c2, c3);
        int expectedListSize = 0;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //then
        assertEquals(expectedListSize, actualList.size());
    }

    @Test
    void findBlocksByMaterial_expectEquals_CompositeBlocksWithListOfCompositeBlocks() {
        //given
        String givenMaterial = "steel";
        Block c1 = new CompositeBlockImpl(Collections.emptyList(), "", "steel");

        List<Block> l1 = List.of(c1);
        Block c2 = new CompositeBlockImpl(l1, "", "2");

        List<Block> l2 = List.of(c2);
        Block c3 = new CompositeBlockImpl(l2, "", "steel");

        List<Block> l3 = List.of(c3);
        Block c4 = new CompositeBlockImpl(l3, "", "steel");

        List<Block> l4 = List.of(c4);
        Block c5 = new CompositeBlockImpl(l4, "", "5");

        List<Block> l5 = List.of(c5);
        Block c6 = new CompositeBlockImpl(l5, "", "steel");

        List<Block> givenBlocks = List.of(c6);
        int expectedListSize = 4;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //then
        assertEquals(expectedListSize, actualList.size());
        assertTrue(actualList.stream().allMatch(block -> block.material().equals(givenMaterial)));
    }

    @Test
    void findBlocksByMaterial_expectEmptyList_CompositeBlocksWithListOfCompositeBlocks() {
        //given
        String givenMaterial = "steel";
        Block c1 = new CompositeBlockImpl(Collections.emptyList(), "", "1");

        List<Block> l1 = List.of(c1);
        Block c2 = new CompositeBlockImpl(l1, "", "2");

        List<Block> l2 = List.of(c2);
        Block c3 = new CompositeBlockImpl(l2, "", "3");

        List<Block> l3 = List.of(c3);
        Block c4 = new CompositeBlockImpl(l3, "", "4");

        List<Block> l4 = List.of(c4);
        Block c5 = new CompositeBlockImpl(l4, "", "5");

        List<Block> l5 = List.of(c5);
        Block c6 = new CompositeBlockImpl(l5, "", "6");

        List<Block> givenBlocks = List.of(c6);
        int expectedListSize = 0;

        //when
        Structure wall = new Wall(givenBlocks);
        List<Block> actualList = wall.findBlocksByMaterial(givenMaterial);

        //then
        assertEquals(expectedListSize, actualList.size());
    }

    @Test
    void count_expectDoesNotThrow_NullBlocks() {
        //given
        List<Block> givenBlocks = null;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertDoesNotThrow(wall::count);
    }

    @Test
    void count_expectEquals_EmptyBlocks() {
        //given
        List<Block> givenBlocks = Collections.emptyList();
        int expectedAmount = 0;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedAmount, wall.count());
    }

    @Test
    void count_expectEquals_OnlyBlocks() {
        //given
        Block b1 = new BlockImpl("", "");
        Block b2 = new BlockImpl("", "");
        Block b3 = new BlockImpl("", "");
        Block b4 = new BlockImpl("", "");
        Block b5 = new BlockImpl("", "");
        Block b6 = new BlockImpl("", "");
        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedAmount = 6;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedAmount, wall.count());
    }

    @Test
    void count_expectEquals_OnlyCompositeBlocks() {
        //given
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "", "");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "", "");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "", "");
        Block b4 = new CompositeBlockImpl(Collections.emptyList(), "", "");
        Block b5 = new CompositeBlockImpl(Collections.emptyList(), "", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5);
        int expectedAmount = 5;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedAmount, wall.count());
    }

    @Test
    void count_expectEquals_BlocksAndCompositeBlocks() {
        //given
        Block b1 = new CompositeBlockImpl(Collections.emptyList(), "", "");
        Block b2 = new CompositeBlockImpl(Collections.emptyList(), "", "");
        Block b3 = new CompositeBlockImpl(Collections.emptyList(), "", "");

        Block b4 = new BlockImpl("", "");
        Block b5 = new BlockImpl("", "");
        Block b6 = new BlockImpl("", "");

        List<Block> givenBlocks = List.of(b1, b2, b3, b4, b5, b6);
        int expectedAmount = 6;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedAmount, wall.count());
    }

    @Test
    void count_expectEquals_CompositeBlocksWithListOfBlocks() {
        //given
        Block b1 = new BlockImpl("1", "");
        Block b2 = new BlockImpl("2", "");
        Block b3 = new BlockImpl("3", "");
        List<Block> l1 = List.of(b1, b2, b3);

        Block b4 = new BlockImpl("4", "");
        Block b5 = new BlockImpl("5", "");
        Block b6 = new BlockImpl("6", "");
        List<Block> l2 = List.of(b4, b5, b6);

        Block b7 = new BlockImpl("7", "");
        Block b8 = new BlockImpl("red", "");
        Block b9 = new BlockImpl("9", "");
        List<Block> l3 = List.of(b7, b8, b9);


        Block c1 = new CompositeBlockImpl(l1, "10", "");
        Block c2 = new CompositeBlockImpl(l2, "11", "");
        Block c3 = new CompositeBlockImpl(l3, "12", "");

        List<Block> givenBlocks = List.of(c1, c2, c3);
        int expectedAmount = 12;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedAmount, wall.count());
    }

    @Test
    void count_expectEquals_CompositeBlocksWithListOfCompositeBlocks() {
        //given
        Block c1 = new CompositeBlockImpl(Collections.emptyList(), "1", "");

        List<Block> l1 = List.of(c1);
        Block c2 = new CompositeBlockImpl(l1, "red", "");

        List<Block> l2 = List.of(c2);
        Block c3 = new CompositeBlockImpl(l2, "3", "");

        List<Block> l3 = List.of(c3);
        Block c4 = new CompositeBlockImpl(l3, "4", "");

        List<Block> l4 = List.of(c4);
        Block c5 = new CompositeBlockImpl(l4, "5", "");

        List<Block> l5 = List.of(c5);
        Block c6 = new CompositeBlockImpl(l5, "6", "");

        List<Block> givenBlocks = List.of(c6);
        int expectedAmount = 6;

        //when
        //then
        Structure wall = new Wall(givenBlocks);
        assertEquals(expectedAmount, wall.count());
    }
}