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
}